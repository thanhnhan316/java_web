package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.LichSuMuaAdminBean;
import bean.LichSuMuaHangBean;

public class LichSuMuaAdminDao {
	public List<LichSuMuaAdminBean> getLichSuMuaHang()throws Exception{
		List<LichSuMuaAdminBean> list = new ArrayList<LichSuMuaAdminBean>();
		String sql = "SELECT ChiTietHoaDon.MaHoaDon,MaChiTietHD,tensach,SoLuongMua,anh,tacgia,gia,NgayMua "
						+ "FROM dbo.hoadon "
						+ "INNER JOIN dbo.ChiTietHoaDon ON hoadon.MaHoaDon=ChiTietHoaDon.MaHoaDon "
						+ "INNER JOIN sach ON ChiTietHoaDon.MaSach=sach.masach WHERE damua = 1 ORDER BY ChiTietHoaDon.MaHoaDon DESC";
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
	           
	            list.add(new LichSuMuaAdminBean(maHD,maCTHD,tensach,Soluongmua,anhsach,tacgia,giasach,ngaymua));
	        }
	        System.out.println("da luu hoa don");
	        resultSet.close();
	        dc.cn.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return list;
	}
	
	public void xacNhanMuaAll() throws Exception{
	
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "UPDATE hoadon set damua = N'True'";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
			
		cmd.executeUpdate();
			
	}
	
	public boolean xacNhanMua(String cthd) throws Exception{
		
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "update hoadon"
				+ "set damua = N'True'"
				+ "from hoadon inner join chitiethoadon"
				+ "on (hoadon.mahoadon = chitiethoadon.mahoadon)"
				+ "where chitiethoadon.machitiethd = ?";
		try {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.executeQuery();
			cmd.setString(1, cthd);
			cmd.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
