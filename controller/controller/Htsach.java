package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiBean;
import bean.SachBean;
import bo.LoaiBo;
import bo.SachBo;

/**
 * Servlet implementation class Htsach
 */
@WebServlet("/Htsach")
public class Htsach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Htsach() {
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
			
			String ml =request.getParameter("ml");
			String timSach = request.getParameter("txtname");
			SachBo sachBo = new SachBo();
			LoaiBo lBo = new LoaiBo();
			
			ArrayList<SachBean> sBean = sachBo.getSach();
			ArrayList<LoaiBean> lBean = lBo.getLoaiSach();
			
		
			if(ml == null && timSach == null) {
				request.setAttribute("sBean", sBean);
				request.setAttribute("lBean", lBean);
				RequestDispatcher rDispatcher =request.getRequestDispatcher("menu.jsp");
				rDispatcher.forward(request, response);
			}else if(ml!=null){
				request.setAttribute("sBean", sachBo.timLoaiSach(sBean,ml));
				request.setAttribute("lBean", lBean);
				RequestDispatcher rDispatcher =request.getRequestDispatcher("menu.jsp");
				rDispatcher.forward(request, response);
			}else if(timSach!=null) {
				request.setAttribute("sBean", sachBo.timSach(sBean, timSach));
				request.setAttribute("lBean", lBean);
				RequestDispatcher rDispatcher =request.getRequestDispatcher("menu.jsp");
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
