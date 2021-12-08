package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DangNhapBean;
import bean.KhachHangBean;
import bean.SachBean;

public class DangNhapDao {
	public static List<DangNhapBean> lst = new ArrayList();
	public List<DangNhapBean> listAccount()throws Exception{
		DungChung dc= new DungChung();
     	dc.ketNoi();
     	
     	String sql = "SELECT * FROM DangNhap";
     	PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		//B3: Duyet qua cac du lieu lay ve de luu vao 1 mang
		try {
			while(rs.next()) {
				String tenDN = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				Long quyen = rs.getLong("Quyen");

				
				lst.add(new DangNhapBean(tenDN, matKhau, quyen));
				
			}
			
			//Dong ket noi
			rs.close();
//			dc.cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lst;
	}
	public List<DangNhapBean> listAccount(long quyen)throws Exception{
		List<DangNhapBean> ds = new ArrayList();
		DungChung dc= new DungChung();
     	dc.ketNoi();
     	
     	String sql = "SELECT * FROM DangNhap WHERE Quyen= "+quyen+"";
     	PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		//B3: Duyet qua cac du lieu lay ve de luu vao 1 mang
		try {
			while(rs.next()) {
				String tenDN = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				quyen = rs.getLong("Quyen");
				
				ds.add(new DangNhapBean(tenDN, matKhau, quyen));
				
			}
			
			//Dong ket noi
			rs.close();
//			dc.cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Chay vao day");
		return ds;
	}
	
	
	public DangNhapBean getAdmin(String un, String pass) throws Exception{
		DungChung dc= new DungChung();
     	dc.ketNoi();
     	
     	String sql = "SELECT * FROM DangNhap where TenDangNhap = ? and MatKhau = ?";
     	PreparedStatement cmd = dc.cn.prepareStatement(sql);
     	
     	cmd.setString(1, un);
     	cmd.setString(2, pass);
     	ResultSet rs = cmd.executeQuery();
     	
     	if(rs.next()==false)
     		return null;
     	else {
     		String tenDangNhap =rs.getString("TenDangNhap");
     		String matKhau=rs.getString("MatKhau");
     		Long quyen=rs.getLong("Quyen");
     		DangNhapBean dn = new DangNhapBean( tenDangNhap,matKhau, quyen);
     		return dn;
     	}
     	
	}
	
	public boolean insertAdmin(String un, String pass, long quyen) throws Exception{
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		String sql = "INSERT INTO DangNhap(TenDangNhap, MatKhau, Quyen) values(?,?,?)";
		try {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			
			cmd.setString(1, un);
			cmd.setString(2, pass);
			cmd.setLong(3, quyen);
			cmd.executeUpdate();     
			dc.cn.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkLoginAdmin(String un) throws Exception{
		DungChung dc = new DungChung();
		dc.ketNoi();
		boolean checkLogin = false;
		String sql = "SELECT * FROM DangNhap WHERE TenDangNhap = ?";
		
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, un);
		ResultSet rs = cmd.executeQuery();
		
		if (rs.next() == false) {
			checkLogin = true;
		}
		
		return checkLogin;
	}
}
