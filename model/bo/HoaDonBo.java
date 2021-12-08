package bo;

import dao.HoaDonDao;


public class HoaDonBo {
	HoaDonDao hoaDonDao = new HoaDonDao();
	public boolean insertHoaDon(Long makh,boolean damua) throws Exception {
		return hoaDonDao.insertHoaDon(makh, damua);
	}
	
	public Long getMaHoaDon() throws Exception{
		return hoaDonDao.getMaHoaDon();
	}
}
