package bean;

import java.sql.Timestamp;


public class LichSuMuaHangBean {
	private Long maHD;
	private Long maCTHD;
	private String tensach;
	private Long Soluongmua;
	private String anhsach;
	private String tacgia;
	private Long giasach;
	private Timestamp ngaymua;
	
	
	public LichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LichSuMuaHangBean(Long maHD, Long maCTHD, String tensach, Long soluongmua, String anhsach, String tacgia,
			Long giasach, Timestamp ngaymua) {
		super();
		this.maHD = maHD;
		this.maCTHD = maCTHD;
		this.tensach = tensach;
		Soluongmua = soluongmua;
		this.anhsach = anhsach;
		this.tacgia = tacgia;
		this.giasach = giasach;
		this.ngaymua = ngaymua;
	}


	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public Timestamp getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Timestamp ngaymua) {
		this.ngaymua = ngaymua;
	}

	public Long getMaHD() {
		return maHD;
	}

	public void setMaHD(Long maHD) {
		this.maHD = maHD;
	}

	public Long getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(Long maCTHD) {
		this.maCTHD = maCTHD;
	}
	public Long getSoluongmua() {
		return Soluongmua;
	}
	public void setSoluongmua(Long soluongmua) {
		Soluongmua = soluongmua;
	}
	public String getAnhsach() {
		return anhsach;
	}
	public void setAnhsach(String anhsach) {
		this.anhsach = anhsach;
	}

	public String getTacgia() {
		return tacgia;
	}


	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}


	public Long getGiasach() {
		return giasach;
	}


	public void setGiasach(Long giasach) {
		this.giasach = giasach;
	}
	
	
	
}
