package bo;

import java.util.ArrayList;

import bean.SinhVienbean;
import dao.SinhViendao;

public class SinhVienbo {
	SinhViendao svDao = new SinhViendao();
	public ArrayList<SinhVienbean> getSv(){
		return svDao.getSv();
	}
	
	public ArrayList<SinhVienbean> timMaLop(ArrayList<SinhVienbean> list, String maLop){
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for (SinhVienbean sv: list) {
			if(sv.getMaLop().equals(maLop)) {
				tam.add(sv);
			}
			
		}
		return tam;
	}

	public ArrayList<SinhVienbean> tim(ArrayList<SinhVienbean> list, String key){
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for (SinhVienbean sv: list) {
			if(sv.getMaLop().contains(key) || sv.getHoTen().contains(key)) {
				tam.add(sv);
			}
			
		}
		return tam;
	}
}
