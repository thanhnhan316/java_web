package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.AdminBean;

public class AdminDao {
	public AdminBean getAdmin(String tk, String mk) throws Exception {
		//b1: ket noi
     	DungChung dc= new DungChung();
     	dc.ketNoi();
     	//B2: Lay du lieu ve
     	String sql="SELECT * FROM DangNhap where TenDangNhap=? and MatKhau=?";
     	PreparedStatement cmd= dc.cn.prepareStatement(sql);
     	
     	cmd.setString(1, tk);
     	cmd.setString(2, mk);
     	ResultSet rs= cmd.executeQuery();		
     		
 		if(rs.next()==false)
     		return null;
     	else {
     		String tendn = rs.getString("TenDangNhap");
     		String mkhau = rs.getString("MatKhau");
     		int quyen = rs.getInt("Quyen");
     		AdminBean admin = new AdminBean(tendn,mkhau,quyen);
     		return admin;
     	}
	}
}
