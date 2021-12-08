package bo;

import bean.KhachHangBean;
import dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khDao = new KhachHangDao();
	public KhachHangBean ktdn(String tk, String mk) throws Exception{
		
		return khDao.getKhachHang(tk, mk);
	}
	public boolean inserKH(String hoten,String diachi,String sodt,String email 
			,String tendn,String pass) throws Exception{
		return khDao.insertKH(hoten, diachi, sodt, email, tendn, pass);
	}
	public boolean ktLogin(String tendangnhap) throws Exception{
		return khDao.checkLogin(tendangnhap);
	}
}
