package bean;

import java.sql.Date;

public class SachBeanAdmin {
	 String maSach;
	 String tenSach;
	 String tacGia;
	 Long gia;
	 String anh;
	 Long soLuong;
	 Long soTap;
	 Date date;
	 String maLoai;
	public SachBeanAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SachBeanAdmin(String maSach, String tenSach, String tacGia, Long gia, String anh, Long soLuong, Long soTap,
			Date date, String maLoai) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.anh = anh;
		this.soLuong = soLuong;
		this.soTap = soTap;
		this.date = date;
		this.maLoai = maLoai;
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
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public Long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}

	public Long getSoTap() {
		return soTap;
	}

	public void setSoTap(Long soTap) {
		this.soTap = soTap;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
