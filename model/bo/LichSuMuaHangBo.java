package bo;

import java.util.List;
import bean.LichSuMuaHangBean;
import dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {
	LichSuMuaHangDao lichSuMuaHangDao = new LichSuMuaHangDao();
	public List<LichSuMuaHangBean> getLichSuMuaHang(Long makh)throws Exception {
		return lichSuMuaHangDao.getLichSuMuaHang(makh);
	}
}
