package bo;

import java.util.ArrayList;

import bean.GioHangBean;
import bean.SachBean;
import dao.GioHangDao;

public class GioHangBo {
	public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
	GioHangDao gioHangDao = new GioHangDao();
	
	public void insertChiTietHoaDon(Long mahoadong)throws Exception {
		for (GioHangBean gioHang : ds) {
			gioHangDao.insertGioHang(gioHang.getMaSach(), gioHang.getSlMua(), mahoadong);
		}
	}
	
	
	public void themSach(String masach, String tensach, String tacgia, long gia, long slmua) {
		for (GioHangBean gh : ds) {
			if(gh.getMaSach().equals(masach)) {
				gh.setSlMua(gh.getSlMua() + slmua);
				return;
			}
		}
		ds.add(new GioHangBean(masach,tensach,tacgia,gia,slmua));	
	}
	public void xoa(String masach) {
		for (GioHangBean gh : ds) {
			if (gh.getMaSach().equals(masach)) {
				ds.remove(gh);
				break;
			}
		}
	}
	
	public void deleteAll() {
		ds.clear();
	}
	public Long tongTien() {
		long tong = 0;
		for (GioHangBean gh: ds) 
			tong += gh.getThanhTien();
		return tong;
		
	}
	public void update(String masach, long soluong) {
		for (GioHangBean gh : ds) {
			if (gh.getMaSach().equals(masach)) {
				gh.setSlMua(soluong);
				break;
			}
		}
	}

	public String getImage(String masach) {
		SachBo sbo = new SachBo();
		SachBean sbean = null;
		try {
			sbean = sbo.timKiemMaSach(masach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sbean.getAnh();
	}
	
	public int getSize() {
		return ds.size();
	}
}
