package bo;

import java.util.ArrayList;

import bean.GioHangBean;
import bean.SachBeanAdmin;
import dao.SachDaoAdmin;

public class SachBoAdmin {
	SachDaoAdmin sachDao = new SachDaoAdmin();
	public ArrayList<SachBeanAdmin> ds = new ArrayList<>();

	public ArrayList<SachBeanAdmin> getSach() throws Exception{
		return sachDao.getSach();
	}
	
	public ArrayList<SachBeanAdmin> timLoaiSach(ArrayList<SachBeanAdmin> list,String maSach){
		ArrayList<SachBeanAdmin> lst = new ArrayList<>();
		for(SachBeanAdmin sBean : list) {
			if(sBean.getMaLoai().equals(maSach)) {
				lst.add(sBean);
			}
		}
		return lst;
	}
	
	public ArrayList<SachBeanAdmin> timSach(ArrayList<SachBeanAdmin> list, String key){
		ArrayList<SachBeanAdmin> lst = new ArrayList<>();
		
		for(SachBeanAdmin sBean: list) {
			if(sBean.getTacGia().toLowerCase().contains(key) ||
					sBean.getTenSach().toLowerCase().contains(key)) {
				lst.add(sBean);
			}
		}
		return lst;
	}
	
	public SachBeanAdmin timKiemMaSach(String key) {
		return sachDao.findMaSach(key);
	}
	
	public boolean saveSach(String ms, String ts, String tg, long gia,String img,long soTap, long soLuong, String ml) throws Exception{
		return sachDao.save(ms, ts, tg, gia, img, soTap, soLuong, ml);
	}
	
	public boolean update(String ms, String ts, String tg, long gia,String img, String ml) throws Exception{
		return sachDao.update(ms, ts, tg, gia, img, ml);
	}
	
	public boolean delete(String ms) throws Exception{
		
		return sachDao.delete(ms);
	}

}
