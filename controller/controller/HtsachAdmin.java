package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SachBeanAdmin;
import bo.LoaiBoAdmin;
import bo.SachBoAdmin;

/**
 * Servlet implementation class HtsachAdmin
 */
@WebServlet("/HtsachAdmin")
public class HtsachAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtsachAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			SachBoAdmin sachBo = new SachBoAdmin();
			
			LoaiBoAdmin lBo = new LoaiBoAdmin();
			request.setAttribute("dsLoai", lBo.getLoaiSach());
			ArrayList<SachBeanAdmin> sBean = sachBo.getSach();
			
			String ml =request.getParameter("ml");
			String timSach = request.getParameter("txtname");
			

			if(ml == null && timSach == null) {
				request.setAttribute("sBean", sBean);
				RequestDispatcher rDispatcher =request.getRequestDispatcher("menu_admin.jsp");
				rDispatcher.forward(request, response);
			}else if(ml!=null){
				request.setAttribute("sBean", sachBo.timLoaiSach(sBean,ml));
				RequestDispatcher rDispatcher =request.getRequestDispatcher("menu_admin.jsp");
				rDispatcher.forward(request, response);
			}else if(timSach!=null) {
				request.setAttribute("sBean", sachBo.timSach(sBean, timSach));
				RequestDispatcher rDispatcher =request.getRequestDispatcher("menu_admin.jsp");
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
