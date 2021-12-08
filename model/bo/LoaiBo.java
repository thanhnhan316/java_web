package bo;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class LoaiBo {
	LoaiDao lDao = new LoaiDao();
	
	public ArrayList<LoaiBean> getLoaiSach() throws Exception{
		return lDao.getLoai();
	}
}
