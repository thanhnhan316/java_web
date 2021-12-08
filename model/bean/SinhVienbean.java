package bean;

public class SinhVienbean {
	private String maSv;
	private String hoTen;
	private Double dtb;
	private String maLop;
	public SinhVienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVienbean(String maSv, String hoTen, Double dtb, String maLop) {
		super();
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.dtb = dtb;
		this.maLop = maLop;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Double getDtb() {
		return dtb;
	}
	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	public boolean ketQua() {
		return dtb >=5 ? true : false;
	}
}
