package bo;

import java.util.List;

import bean.LichSuMuaAdminBean;
import dao.LichSuMuaAdminDao;

public class LichSuMuaAdminBo {
	LichSuMuaAdminDao lichSuMuaHangDao = new LichSuMuaAdminDao();
	public List<LichSuMuaAdminBean> getLichSuMuaKH()throws Exception {
		return lichSuMuaHangDao.getLichSuMuaHang();
	}
	
	public void xacNhanMuaAll() throws Exception{
		lichSuMuaHangDao.xacNhanMuaAll();
	}
	
	public boolean xacNhanMua(String cthd) throws Exception{
		return lichSuMuaHangDao.xacNhanMua(cthd);
	}
}
