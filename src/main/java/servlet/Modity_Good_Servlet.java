package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.good;
import service.Good_Service;

@WebServlet(name = "modify_good",value = "/modify_good")
public class Modity_Good_Servlet extends HttpServlet{
	private static final long serialVersionUID = 4711148067902677815L;
	Good_Service gService=new Good_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            int goodid= Integer.valueOf(request.getParameter("GoodID"));
            good g = gService.getGoodByGoodId(goodid);
            
            String d=gService.getdate();
			if(d!=null) {
				g.setGoodUpdateTime(d);
			}else {
				request.setAttribute("msg", "系统时间获取错误，添加失败！");
	            request.getRequestDispatcher("add_good.jsp").forward(request, response);
			}
            
            for(FileItem item:list) {
                if(item.isFormField()) {
                    switch(item.getFieldName()) {
                        case "GoodName":
                        	String nString=item.getString("utf-8");
                        	if(g.getGoodName().equals(nString))
                        			break;
                        	if(gService.select_good(g.getID(), nString)==null) {
                        		g.setGoodName(nString);
                        		break;
                        	}else {
                        		request.setAttribute("msg", "商品名字重复，修改失败！");
                	            request.getRequestDispatcher("modify_good.jsp").forward(request, response);
							}
                            break;
                        case "GoodPrice":
                            g.setGoodPrice(Float.parseFloat(item.getString("utf-8")));
                            break;
                        case "GoodIntrodution":
                        	g.setGoodIntrodution(item.getString("utf-8"));
                            break;
                        case "GoodStock":
                            g.setGoodStock(Integer.parseInt(item.getString("utf-8")));
                            break;
                    }
                }else {
                    if(item.getInputStream().available()<=0)continue;
                    String path = this.getServletContext().getRealPath(g.getGoodImage());
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    while( (in.read(buffer))>0 ) {
                        out.write(buffer);
                    }
                    in.close();
                    out.close();
                    item.delete();
                }
            }
            gService.update_good(g);
            request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
