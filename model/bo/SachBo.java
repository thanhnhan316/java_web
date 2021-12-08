package bo;

import java.util.ArrayList;

import bean.SachBean;
import dao.SachDao;

public class SachBo {
	SachDao sachDao = new SachDao();
	
	public ArrayList<SachBean> getSach() throws Exception{
		return sachDao.getSach();
	}
	
	public ArrayList<SachBean> timLoaiSach(ArrayList<SachBean> list,String maSach){
		ArrayList<SachBean> lst = new ArrayList<>();
		for(SachBean sBean : list) {
			if(sBean.getMaLoai().equals(maSach)) {
				lst.add(sBean);
			}
		}
		return lst;
	}
	
	public ArrayList<SachBean> timSach(ArrayList<SachBean> list, String key){
		ArrayList<SachBean> lst = new ArrayList<>();
		
		for(SachBean sBean: list) {
			if(sBean.getTacGia().toLowerCase().contains(key) ||
					sBean.getTenSach().toLowerCase().contains(key)) {
				lst.add(sBean);
			}
		}
		return lst;
	}
	
	public SachBean timKiemMaSach(String key) throws Exception {
		ArrayList<SachBean> lst= getSach();
		for(SachBean sach : lst) {
			if(sach.getMaSach().equals(key)) {
				return sach;
			}
		}
		return null;
	}
	
//	public int demSach(ArrayList<SachBean> list, String maLoai){
//		int count = 0;
//		for(SachBean sBean: list) {
//			if(sBean.getMaLoai().equals(maLoai) ) {
//				count++;
//			}
//		}
//		return count;
//	}
}
