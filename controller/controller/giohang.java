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
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
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
		    
			String masach = request.getParameter("ms");
			String tensach = request.getParameter("ts");
			String tacgia = request.getParameter("tg");
			String gia = request.getParameter("gia");
			
			String xoa = request.getParameter("xoaall");
			
			HttpSession session = request.getSession();
			GioHangBo gioHangbo =(GioHangBo) session.getAttribute("giohangbo");
		    	
		    if(gioHangbo==null){
		    	gioHangbo = new GioHangBo();
		    }
		    if(masach!=null) {
		    	gioHangbo.themSach(masach, tensach, tacgia, Long.parseLong(gia), (long) 1);
		    	session.setAttribute("giohangbo",gioHangbo);
				request.setAttribute("listgh", gioHangbo.ds);
				session.setAttribute("soluongsp", gioHangbo.getSize());
				request.setAttribute("tongtien", gioHangbo.tongTien());
				RequestDispatcher rDispatcher =request.getRequestDispatcher("Htsach");
				rDispatcher.forward(request, response);
		    }
		    else if(xoa!=null) {
		    	gioHangbo.deleteAll();
		    	session.setAttribute("giohangbo",gioHangbo);
				request.setAttribute("listgh", gioHangbo.ds);
				request.setAttribute("tongtien", gioHangbo.tongTien());
				session.setAttribute("soluongsp", gioHangbo.getSize());
				RequestDispatcher rDispatcher =request.getRequestDispatcher("Htsach");
				rDispatcher.forward(request, response);
		    }
		    
		    
		    else {
		  	    	
		    	session.setAttribute("giohangbo",gioHangbo);
				request.setAttribute("listgh", gioHangbo.ds);
				request.setAttribute("tongtien", gioHangbo.tongTien());
				session.setAttribute("soluongsp", gioHangbo.getSize());
				RequestDispatcher rDispatcher =request.getRequestDispatcher("giohang.jsp");
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
