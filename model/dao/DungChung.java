	package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public  Connection cn;
	public  void ketNoi() throws Exception{
		 //B1: Xac dinh hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da XDHCSDL ");
		cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-9GIEK94\\NHAN05122000;databaseName=QlSach;user=sa; password=123");
		System.out.println("Da ket noi");
	}
}
