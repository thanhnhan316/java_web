package dao;

import java.util.ArrayList;

import bean.SinhVienbean;

public class SinhViendao {
	public ArrayList<SinhVienbean> getSv(){
		ArrayList<SinhVienbean> list = new ArrayList<SinhVienbean>();
		list.add(new SinhVienbean("Sv1", "Nguyen Van Minh Nhat1", 10.0, "K42C"));
		list.add(new SinhVienbean("Sv2", "Nguyen Van Minh Nhat2", 8.5, "K42D"));
		list.add(new SinhVienbean("Sv3", "Nguyen Van Minh Nhat3", 7.0, "K42A"));
		list.add(new SinhVienbean("Sv4", "Nguyen Van Minh Nhat4", 6.5, "K42B"));
		list.add(new SinhVienbean("Sv5", "Nguyen Van Minh Nhat5", 10.0, "K42E"));
		list.add(new SinhVienbean("Sv6", "Nguyen Van Minh Nhat6", 9.0, "K42C"));
		list.add(new SinhVienbean("Sv7", "Nguyen Van Minh Nhat7", 7.5, "K42B"));
		return list;
	}
}
