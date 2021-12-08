package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	public List<LichSuMuaHangBean> getLichSuMuaHang(Long makh)throws Exception{
		List<LichSuMuaHangBean> list = new ArrayList<LichSuMuaHangBean>();
		String sql = "SELECT ChiTietHoaDon.MaHoaDon,MaChiTietHD,tensach,SoLuongMua,anh,tacgia,gia,NgayMua "
						+ "FROM dbo.hoadon "
						+ "INNER JOIN dbo.ChiTietHoaDon ON hoadon.MaHoaDon=ChiTietHoaDon.MaHoaDon "
						+ "INNER JOIN sach ON ChiTietHoaDon.MaSach=sach.masach WHERE makh ="
						+makh+" ORDER BY ChiTietHoaDon.MaHoaDon DESC";
		DungChung dc = new DungChung();
		dc.ketNoi();
		try {
		
	        Statement st =dc.cn.createStatement();
	        ResultSet resultSet = st.executeQuery(sql);
	        while (resultSet.next()) {
	        	 Long maHD = resultSet.getLong("MaHoaDon");
	        	 Long maCTHD = resultSet.getLong("MaChiTietHD");
	        	 String tensach= resultSet.getString("tensach");
	        	 Long Soluongmua = resultSet.getLong("SoLuongMua");
	        	 String anhsach =resultSet.getString("anh");
	        	 String tacgia = resultSet.getString("tacgia");
	        	 Long giasach = resultSet.getLong("gia");
	        	 Timestamp ngaymua = resultSet.getTimestamp("NgayMua");
	           
	            list.add(new LichSuMuaHangBean(maHD,maCTHD,tensach,Soluongmua,anhsach,tacgia,giasach,ngaymua));
	        }
	        resultSet.close();
	        dc.cn.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return list;
	}
}
