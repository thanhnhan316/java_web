package bean;

import java.time.LocalDateTime;


public class HoaDon {
	private Long maHoadon;
	private Long makh;
	private LocalDateTime ngayMua;
	private boolean damua;
	
	
	public HoaDon(Long maHoadon, Long makh, LocalDateTime ngayMua, boolean damua) {
		super();
		this.maHoadon = maHoadon;
		this.makh = makh;
		this.ngayMua = ngayMua;
		this.damua = damua;
	}


	public Long getMaHoadon() {
		return maHoadon;
	}


	public void setMaHoadon(Long maHoadon) {
		this.maHoadon = maHoadon;
	}


	public Long getMakh() {
		return makh;
	}


	public void setMakh(Long makh) {
		this.makh = makh;
	}


	public LocalDateTime getNgayMua() {
		return ngayMua;
	}


	public void setNgayMua(LocalDateTime ngayMua) {
		this.ngayMua = ngayMua;
	}


	public boolean isDamua() {
		return damua;
	}


	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	
}
