package bean;

public class LoaiBeanAdmin {
	private String maLoai;
	private String tenLoai;
	public LoaiBeanAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiBeanAdmin(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
}
