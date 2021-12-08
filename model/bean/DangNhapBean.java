package bean;

public class DangNhapBean {
	String tenDangNhap;
	String matKhau;
	long quyen;
	public DangNhapBean(String tenDangNhap, String matKhau, long quyen) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	

	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public long getQuyen() {
		return quyen;
	}
	public void setQuyen(long quyen) {
		this.quyen = quyen;
	}
	
	

}
