package entity;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class email {
	
	public static Session createSession() {
		
		//	账号信息
		String username = "17819857749@163.com";//	邮箱发送账号
		String password = "FUGLDBUBVNTSWPHH";//	邮箱授权码
		
		//	创建一个配置文件，并保存
		Properties props = System.getProperties();
		
		//	SMTP服务器连接信息
        //  126——smtp.126.com
        //  163——smtp.163.com
        //  qqsmtp.qq.com"
		props.setProperty("mail.smtp.host", "smtp.163.com");//	SMTP主机名
 
        //  126——25
        //  163——645 
		props.setProperty("mail.smtp.port", "465");//	主机端口号
		props.put("mail.smtp.ssl.enable", true);
		props.put("mail.smtp.auth", "true");//	是否需要用户认证
		//props.put("mail.smtp.starttls.enale", "true");//	启用TlS加密
		
		Session session = Session.getDefaultInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username,password);
			}
		});
		return session;
 
	}

}
