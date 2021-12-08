package bean;

import bo.SachBo;
public class GioHangBean {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private Long gia;
	private Long slMua;
	private Long thanhTien;
	public GioHangBean(String maSach, String tenSach, String tacGia, Long gia, Long slMua) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.slMua = slMua;
		this.thanhTien = slMua * gia;
	}
	public GioHangBean() {
		super();
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSlMua() {
		return slMua;
	}
	public void setSlMua(Long slMua) {
		this.slMua = slMua;
	}
	public Long getThanhTien() {
		return slMua * gia;
	}
	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getImage() {
		SachBo bSachbo = new SachBo();
		SachBean sach = new SachBean();
		try {
			sach = bSachbo.timKiemMaSach(maSach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sach.getAnh();
	}
}
