package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DangNhapBo;

/**
 * Servlet implementation class registerAdmin
 */
@WebServlet("/registerAdmin")
public class registerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String convertHashToString(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
		    request.setCharacterEncoding("utf-8");
		    
		    String tenDangNhap = request.getParameter("txttendn");
		    String matKhau = request.getParameter("txtpassword");
		    Long quyen = Long.parseLong(request.getParameter("txtquyen"));
		    
		    if(request.getParameter("btnregister") != null) {
		    	DangNhapBo dnBo = new DangNhapBo();
		    	if(dnBo.checkLoginAdmin(tenDangNhap)) {
		    		if(dnBo.insertAdmin(tenDangNhap, convertHashToString(matKhau),quyen)) {
			    		request.setAttribute("ktdk", (long) 1);
			    	}else {
			    		request.setAttribute("ktdk", (long) 0);
			    	}
		    	}else {
		    		request.setAttribute("ktdk", (long) 2);
		    	}
		    	  
			    RequestDispatcher rd = request.getRequestDispatcher("HtsachAdmin");
			    rd.forward(request, response);
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
