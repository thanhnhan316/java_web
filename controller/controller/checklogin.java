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
import bo.KhachHangBo;

/**
 * Servlet implementation class checklogin
 */
@WebServlet("/checklogin")
public class checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checklogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tendangnhap=request.getParameter("txtun");
			String password=request.getParameter("txtpass");
			HttpSession session = request.getSession();
			if(request.getParameter("but1")!=null) {
				KhachHangBo khachHangBo = new KhachHangBo();
			 	KhachHangBean kh = khachHangBo.ktdn(tendangnhap, password);
			 	if(kh != null){
					session.setAttribute("khachhang", kh);
					request.setAttribute("kt", (long)1);
					
				}
				else{
					request.setAttribute("kt", (long)0);
				}
			 	RequestDispatcher rDispatcher =request.getRequestDispatcher("Htsach");
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
