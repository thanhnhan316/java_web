package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.GioHangBo;
import bo.HoaDonBo;

/**
 * Servlet implementation class thanhtoan
 */
@WebServlet("/thanhtoan")
public class thanhtoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GioHangBo gioHangbo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HoaDonBo hoaDonBo = new HoaDonBo();
			HttpSession session = request.getSession();
			gioHangbo = (GioHangBo) session.getAttribute("giohangbo");
			Long maKh=null;
			if(session.getAttribute("khachhang")!=null) {
				KhachHangBean hang= (KhachHangBean) session.getAttribute("khachhang");
				if(hang!=null){
					maKh = hang.getMaKh();
					if(gioHangbo!=null && gioHangbo.ds.size()>0) {
						if(hoaDonBo.insertHoaDon(maKh, true)) {
							request.setAttribute("checkxacnhan", (long)1);
							gioHangbo.insertChiTietHoaDon(hoaDonBo.getMaHoaDon());
							gioHangbo.ds.clear();
							session.setAttribute("giohangbo",gioHangbo);
							RequestDispatcher rDispatcher =request.getRequestDispatcher("Htsach");
							rDispatcher.forward(request, response);
						}else {
							request.setAttribute("checkxacnhan", (long)0);
							RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang");
							rDispatcher.forward(request, response);
						}
					}else {
						request.setAttribute("checkxacnhan", (long)3);
						RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang");
						rDispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("checkxacnhan", (long)2);
					RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang");
					rDispatcher.forward(request, response);
				}
				
			}else {
				request.setAttribute("checkxacnhan", (long)2);
				RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang");
				rDispatcher.forward(request, response);
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
