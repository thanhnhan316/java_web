package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bean.SachBeanAdmin;

public class SachDaoAdmin { 
	public  ArrayList<SachBeanAdmin> ds = new ArrayList<>();
	public ArrayList<SachBeanAdmin> getSach() throws Exception{
		// B1: Ket noi
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		// B2: lay du lieu ve
		String sql = "SELECT * FROM sach";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
	
		//B3: Duyet qua cac du lieu lay ve de luu vao 1 mang
		try {
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				String tacGia = rs.getString("tacgia");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh"); 
				Long soLuong = rs.getLong("soluong");
				Long soTap = rs.getLong("sotap");
				Date date = rs.getDate("NgayNhap");
				String maLoai = rs.getString("maloai");
				
				ds.add(new SachBeanAdmin(maSach, tenSach, tacGia, gia, anh, soLuong, soTap, date, maLoai));
				
			}
		
			//Dong ket noi
			rs.close();
//			dc.cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	public SachBeanAdmin findMaSach(String maSach){
//		for(SachBeanAdmin sb: ds) {
//			if(sb.getMaSach().equals(maSach))
//				return sb;
//		}
		return null;
      

	}
	

	
//	public int update(SachBeanAdmin sb) {
//		for (int i = 0; i < ds.size(); i++) {
//			if(ds.get(i).getMaSach().equals(sb.getMaSach())) {
//				ds.set(i, sb);
//				return i;
//			}
//		}
//		return -1;
//	}
	
	public boolean update(String ms, String ts, String tg, long gia,String img, String ml) throws Exception{
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		String sql = "UPDATE sach SET tensach=?,tacgia=?,gia=?,anh=? WHERE masach=? and maloai=?";
		try {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			
			cmd.setString(1, ms);
			cmd.setString(2, ts);
			cmd.setString(3, tg);
			cmd.setLong(4, gia);
			cmd.setString(5, img);
			cmd.setString(6, ml);
			cmd.executeUpdate();
			dc.cn.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
//	public int save(SachBeanAdmin sb) {
//		ds.add(sb);
//		return 1;
//	}
	
	public boolean save(String ms, String ts, String tg, long gia,String img,long soTap, long soLuong, String ml) throws Exception{
		DungChung dc = new DungChung();
		dc.ketNoi();
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		 LocalDate today = LocalDate.now();
		 Date ddd = Date.valueOf(today);
		String sql = "INSERT INTO sach(masach, tensach, soluong, gia, maloai, sotap, anh, tacgia, NgayNhap) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			cmd.setString(2, ts);
			cmd.setLong(3, soLuong);
			cmd.setLong(4, gia);
			cmd.setString(5, ml);
			cmd.setLong(6, soTap);			
			cmd.setString(7, img);
			cmd.setString(8, tg);
			cmd.setDate(9, ddd);	
			
			cmd.executeUpdate();
			System.out.println("Có thật là lưu chư?");	
			dc.cn.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete (String ms) throws Exception{
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "DELETE sach where masach=?";
		
		try {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			
			cmd.setString(1, ms);
			cmd.executeUpdate();
			
			dc.cn.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
