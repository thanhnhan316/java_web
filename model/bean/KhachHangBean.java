package bean;

public class KhachHangBean {
	private Long maKh;
	private String hoTen;
	private String diaChi;
	private String matKhau;
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangBean(Long maKh, String hoTen, String diaChi, String matKhau) {
		super();
		this.maKh = maKh;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
	}
	public Long getMaKh() {
		return maKh;
	}
	public void setMaKh(Long maKh) {
		this.maKh = maKh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
}
