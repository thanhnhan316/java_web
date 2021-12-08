package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DangNhapBean;
import bean.KhachHangBean;
import bean.LichSuMuaAdminBean;
import bo.LichSuMuaAdminBo;
import bo.LichSuMuaHangBo;

/**
 * Servlet implementation class lichsuAdmin
 */
@WebServlet("/lichsuAdmin")
public class lichsuAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuAdmin() {
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
		    LichSuMuaAdminBo ls = new LichSuMuaAdminBo();
		    List<LichSuMuaAdminBean> lsmh = ls.getLichSuMuaKH();
		    
		    
		    	request.setAttribute("lichsuadmin", lsmh);
		    	 RequestDispatcher rDispatcher =request.getRequestDispatcher("lichsu_admin.jsp");
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
