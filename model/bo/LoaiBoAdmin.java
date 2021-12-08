package bo;

import java.util.ArrayList;


import bean.LoaiBeanAdmin;
import dao.LoaiDaoAdmin;

public class LoaiBoAdmin {
LoaiDaoAdmin lDao = new LoaiDaoAdmin();
	
	public ArrayList<LoaiBeanAdmin> getLoaiSach() throws Exception{
		return lDao.getLoai();
	}
}
