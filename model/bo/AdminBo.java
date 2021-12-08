package bo;

import bean.AdminBean;
import dao.AdminDao;

public class AdminBo {
	AdminDao admindao = new AdminDao();
	public AdminBean ktDangNhap(String tk,String mk) throws Exception {
		return admindao.getAdmin(tk, mk);
	}
}
