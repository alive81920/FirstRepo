import dao.Impl.CustomerImpl;
import entity.customer;

public class test {
	public static void main(String[] args) {
		entity.customer userCustomer=new customer();
		userCustomer.SetName("张三");
		userCustomer.SetPwd("123456");
		userCustomer.SetEmail("111@qq,com");
		userCustomer.SetAdress("南华商业街");
		userCustomer.SetPhone("17189263392");
		
		dao.Impl.CustomerImpl n=new CustomerImpl();
		if (n.register(userCustomer)) {
			System.out.println("注册成功！");
		}
		else {
			System.out.println("注册失败！");
		}
		
		
	}
}
