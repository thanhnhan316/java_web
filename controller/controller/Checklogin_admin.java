package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bean.KhachHangBean;
import bo.AdminBo;
import bo.KhachHangBo;

/**
 * Servlet implementation class Checklogin_admin
 */
@WebServlet("/Checklogin_admin")
public class Checklogin_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checklogin_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tendangnhap=request.getParameter("txtdnadmin");
			String password=request.getParameter("txtpassadmin");
			HttpSession session = request.getSession();		
			if(request.getParameter("btndnadmin")!=null) {
				AdminBo adminBo = new AdminBo();
				AdminBean adminBean = adminBo.ktDangNhap(tendangnhap, password);
			 	if(adminBean != null){
					session.setAttribute("admin", adminBean);
					request.setAttribute("ktra", (long)1);		
					RequestDispatcher rDispatcher = request.getRequestDispatcher("HtsachAdmin");
					rDispatcher.forward(request, response);
				}
				else{
					request.setAttribute("ktra", (long)0);
				}			 	
			}
			RequestDispatcher rDispatcher = request.getRequestDispatcher("dangnhap_admin.jsp");
			rDispatcher.forward(request, response);
		}catch (Exception e) {
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
