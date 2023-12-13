package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.good;
import entity.store;
import service.Good_Service;

@WebServlet(name="add_good",value = "/add_good")
public class Add_Good_Servlet extends HttpServlet{
	private static final long serialVersionUID = -807880568644158385L;
	private Good_Service gService=new Good_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        String fileName =null;
        try {
            List<FileItem> list = upload.parseRequest(request);
            good g = new good();
            
            store s=(store) request.getSession().getAttribute("user");
            g.setID(s.getID());
            g.setGoodNum(0);
            String d=gService.getdate();
			if(d!=null) {
				g.setGoodCreateTime(d);
				g.setGoodUpdateTime(d);
			}else {
				request.setAttribute("msg", "系统时间获取错误，添加失败！");
	            request.getRequestDispatcher("add_good.jsp").forward(request, response);
			}
            for(FileItem item:list) {
                if(item.isFormField()) {
                    switch(item.getFieldName()) {
                        case "GoodName":
                            g.setGoodName(item.getString("utf-8"));
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
                    fileName = item.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("."));
                    fileName = "/"+ new Date().getTime() + fileName;
                    String path = this.getServletContext().getRealPath("/picture")+fileName;
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    while( (in.read(buffer))>0 ) {
                        out.write(buffer);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    g.setGoodImage("/picture"+fileName);
                }
            }
            good temp0=gService.select_good(g.getID(), g.getGoodName());
            if(temp0==null) {
            	if(gService.add_good(g)) {
            		request.setAttribute("msg", "添加成功！");
            		request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
            	}else {
            		request.setAttribute("msg", "添加失败！");
            		gService.deletefilepicture("/picture"+fileName);
    	            request.getRequestDispatcher("add_good.jsp").forward(request, response);
				}            	
            }else {
            	request.setAttribute("msg", "该商品名字已经存在！请添加不同名字的商品！需要修改商品信息请去‘查看全部商品’修改相关信息！");
	            request.getRequestDispatcher("add_good.jsp").forward(request, response);
			}
            
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
}
