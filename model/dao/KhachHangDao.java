package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.KhachHangBean;

public class KhachHangDao {
	public KhachHangBean getKhachHang(String un, String pass) throws Exception{
		 //b1: ket noi
     	DungChung dc= new DungChung();
     	dc.ketNoi();
     	//B2: Lay du lieu ve
     	String sql="SELECT * FROM KhachHang where tendn=? and pass=?";
     	PreparedStatement cmd= dc.cn.prepareStatement(sql);//ném câu lệnh sql này vào trong SQL
     	//Truyen 01 tham so:un, pass  vao cmd
     	
     	cmd.setString(1, un);
     	cmd.setString(2, pass);
     	ResultSet rs= cmd.executeQuery(); // execute query và nhận kết quả trả về
     	
     	    // Nếu rs.next == false => return null
     		// ngược lại tạo một khách hàng
     		if(rs.next()==false)
         		return null;
         	else {
         		Long makh=rs.getLong("makh");
         		String hoten=rs.getString("hoten");
         		String diachi=rs.getString("diachi");
         		String matkhau=rs.getString("pass");
         		KhachHangBean kh= new KhachHangBean(makh, hoten, diachi, matkhau);
         		return kh;
         	}
     		
	}
	public boolean insertKH(String hoten,String diachi,String sodt,String email 
			,String tendn,String pass) throws Exception{
		String sqlString = "INSERT INTO dbo.KhachHang (hoten,diachi,sodt,email,tendn,pass)"
		+ " values(?,?,?,?,?,?)";
		DungChung dc= new DungChung();
		dc.ketNoi();
		try {
			System.out.println("đã vào được, cb add khach hang vao database");
			
			PreparedStatement st =dc.cn.prepareStatement(sqlString);
			st.setString(1, hoten);
			st.setString(2, diachi);
			st.setString(3, sodt);
			st.setString(4, email);
			st.setString(5, tendn);
			st.setString(6, pass);
			st.executeUpdate();     
			dc.cn.close();
			return true;
		
			} catch (SQLException e) {
		e.printStackTrace();
		return false;
		}
	}
	public boolean checkLogin(String tendangnhap) throws Exception{
		String sqlString = "Select * from dbo.KhachHang where tendn=?";
		boolean checktendangnhap = false;
		DungChung dc= new DungChung();
		dc.ketNoi();
		try {
			
            PreparedStatement st =dc.cn.prepareStatement(sqlString);
            st.setString(1, tendangnhap);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next() == false) {
            	checktendangnhap = true;
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return checktendangnhap;
	}
}
