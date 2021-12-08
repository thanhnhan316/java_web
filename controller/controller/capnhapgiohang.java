package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GioHangBo;

/**
 * Servlet implementation class capnhapgiohang
 */
@WebServlet("/capnhapgiohang")
public class capnhapgiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public capnhapgiohang() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masach = request.getParameter("masach");
		
		HttpSession session = request.getSession();
		GioHangBo gioHangbo =(GioHangBo) session.getAttribute("giohangbo");
		
		if(request.getParameter("update")!=null) {
			long soluong = Long.parseLong(request.getParameter("soluong"));
			gioHangbo.update(masach, soluong);
			 session.setAttribute("giohangbo", gioHangbo);
			 RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang");
		     rDispatcher.forward(request, response);
		}
		else if(request.getParameter("delete")!=null){
			gioHangbo.xoa(masach);
			session.setAttribute("giohangbo", gioHangbo);
			 RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang");
			rDispatcher.forward(request, response);
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
