package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class HoaDonDao {
	public boolean insertHoaDon(Long makh,boolean damua) throws Exception {
		String sqlString = "INSERT INTO dbo.hoadon (makh,NgayMua,damua)"
				+ " values(?,?,?)";
		DungChung dc = new DungChung();
		dc.ketNoi();
		try {

			Calendar cal = Calendar.getInstance(); 
			
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
            PreparedStatement st =dc.cn.prepareStatement(sqlString);
            st.setLong(1, makh);
            st.setTimestamp(2, timestamp);
            st.setBoolean(3, damua);
           
            st.executeUpdate();     
            dc.cn.close();
            return true;
           
        } catch (SQLException e) {
            e.printStackTrace();
            return false;//SELECT TOP 1 * FROM table_Name ORDER BY unique_column DESC
        }
	}
	public Long getMaHoaDon() throws Exception {
		String sql = "SELECT TOP 1 * FROM dbo.hoadon ORDER BY MaHoaDon DESC";
		Long mahoadonLong= null;
		DungChung dc = new DungChung();
		dc.ketNoi();
		try {	   

			Statement st =dc.cn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            
            while(resultSet.next()) {
            	mahoadonLong = resultSet.getLong("MaHoaDon");
            }
            resultSet.close();
            dc.cn.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahoadonLong;
	}
}
