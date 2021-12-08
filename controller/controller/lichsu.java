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
import bo.LichSuMuaHangBo;

/**
 * Servlet implementation class lichsu
 */
@WebServlet("/lichsu")
public class lichsu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
		    request.setCharacterEncoding("utf-8");
		    HttpSession session = request.getSession();
		    LichSuMuaHangBo ls = new  LichSuMuaHangBo();
		    KhachHangBean khachHang = (KhachHangBean) session.getAttribute("khachhang");
		    if(khachHang !=null) {
		    	request.setAttribute("lichsumua", ls.getLichSuMuaHang(khachHang.getMaKh()));
		    	
		    }else {
		    	request.setAttribute("lichsumua", null);
		    }
		    RequestDispatcher rDispatcher =request.getRequestDispatcher("lichsu.jsp");
			rDispatcher.forward(request, response);
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
