package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.SachBean;

public class SachDao {
	public ArrayList<SachBean> getSach() throws Exception{
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
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
				String maLoai = rs.getString("maloai");
				
				ds.add(new SachBean(maSach, tenSach, tacGia,gia, anh, maLoai));
				
			}
			
			//Dong ket noi
			rs.close();
//			dc.cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ds;
		
	}
}
