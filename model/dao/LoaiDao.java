package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.LoaiBean;

public class LoaiDao {
	public ArrayList<LoaiBean> getLoai() throws Exception{
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
		
		// B1: Ket noi
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		
		// B2: lay du lieu ve
		String sql = "SELECT * FROM Loai";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		//B3: Duyet qua cac du lieu lay ve de luu vao 1 mang
		while(rs.next()) {
			String maLoai = rs.getString("maLoai");
			String tenLoai = rs.getString("tenLoai");
			
			ds.add(new LoaiBean(maLoai, tenLoai));
		}
		
		//Dong ket noi
		rs.close();
		dc.cn.close();
		
		
    	return ds;
	}
}
