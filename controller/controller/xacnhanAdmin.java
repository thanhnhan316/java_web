package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.LichSuMuaAdminBo;

/**
 * Servlet implementation class xacnhanAdmin
 */
@WebServlet("/xacnhanAdmin")
public class xacnhanAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LichSuMuaAdminBo ls = new LichSuMuaAdminBo();
			String mct =  request.getParameter("mct");
			System.out.println(request.getParameter("xacnhan"));
			System.out.println(mct);
//			if (request.getParameter("xacnhan") != null) {
//					ls.xacNhanMua(mct);
//					RequestDispatcher rDispatcher = request.getRequestDispatcher("lichsuAdmin");
//					rDispatcher.forward(request, response);
//
//			}
			if (request.getParameter("xacnhanall") != null) {
				ls.xacNhanMuaAll();
				request.setAttribute("lsk", ls.getLichSuMuaKH());
				System.out.println(ls.getLichSuMuaKH().size());
				RequestDispatcher rDispatcher = request.getRequestDispatcher("lichsuAdmin");
				rDispatcher.forward(request, response);
			}
			RequestDispatcher rDispatcher = request.getRequestDispatcher("HtsachAdmin");
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
