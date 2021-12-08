package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GioHangDao {
	public boolean insertGioHang(String masach,Long soluongmua,Long mahoadon) throws Exception{
		String sqlString = "INSERT INTO dbo.ChiTietHoaDon (MaSach,SoLuongMua,MaHoaDon)"
				+ " values(?,?,?)";
		DungChung dc = new DungChung();
		dc.ketNoi();
		try {
			
            PreparedStatement st =dc.cn.prepareStatement(sqlString);
            st.setString(1, masach);
            st.setLong(2, soluongmua);
            st.setLong(3, mahoadon);
           
            st.executeUpdate();     
            dc.cn.close();
            return true;
           
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
}
