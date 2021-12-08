package bo;

import java.util.List;

import bean.DangNhapBean;
import dao.DangNhapDao;

public class DangNhapBo {
	DangNhapDao dnDao = new DangNhapDao();
	
	public List<DangNhapBean> listAccount() throws Exception{
		return dnDao.listAccount();
	}
	public List<DangNhapBean> listAccount(long quyen) throws Exception{
		return dnDao.listAccount(quyen);
	}
	
	
	public DangNhapBean ktdn(String tk, String mk) throws Exception{
		return dnDao.getAdmin(tk, mk);
	}
	
	public boolean insertAdmin(String tk, String mk, long quyen) throws Exception{
		return dnDao.insertAdmin(tk, mk, quyen);
	}
	
	public boolean checkLoginAdmin(String un) throws Exception{
		return dnDao.checkLoginAdmin(un);
	}
}
