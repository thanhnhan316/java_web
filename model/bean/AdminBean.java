package bean;

public class AdminBean {
	private String tenDn;
	private String matKhau;
	private int quyen;
	
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminBean(String tenDn, String matKhau, int quyen) {
		super();
		this.tenDn = tenDn;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public String getTenDn() {
		return tenDn;
	}

	public void setTenDn(String tenDn) {
		this.tenDn = tenDn;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
	
	
}
