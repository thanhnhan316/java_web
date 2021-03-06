package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.SachBeanAdmin;
import bo.SachBoAdmin;
import dao.SachDaoAdmin;

/**
 * Servlet implementation class EditSachAdmin
 */
@WebServlet("/EditSachAdmin")
public class EditSachAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSachAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	    
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String dirUrl1 = request.getServletContext().getRealPath("/image_sach") +  File.separator;
		 response.getWriter().println(dirUrl1);
		
		
		String action = request.getParameter("action");
//		SachDaoAdmin sd = new SachDaoAdmin();
		SachBoAdmin sbo = new SachBoAdmin();
		SachBeanAdmin sb = new SachBeanAdmin();
		String maSach = "";
		String ts = "";
		String tg = "";
		Long gia = (long) 0;
		String anh = "";
		Long soLuong = (long)0;
		Long soTap = (long) 0;
		String date = "";
		String ml = "";
		
		String fileName = null;
		String fileImg = "";
		String linkImg = "";
		
		if(action == null || action.equals("")) {
			request.getRequestDispatcher("HtsachAdmin").forward(request, response);
			return;
		}
		switch(action) {
		case "AddOrEdit":
			maSach  = request.getParameter("ms");

			sb = sbo.timKiemMaSach(maSach);
			if(sb == null) {
				request.setAttribute("sachbeanadmin", new SachBeanAdmin());
			}
			request.setAttribute("sachbeanadmin", sb);
			request.setAttribute("ACTION", "SaveOrUpdate");
			request.getRequestDispatcher("addfile.jsp").forward(request, response);
		break;
		case "SaveOrUpdate":
			try {
				
				HashMap<String, String> fields = new HashMap<String, String>();
				List<FileItem> fileItems = upload.parseRequest(request);
				//L???y v??? c??c ?????i t?????ng g???i l??n
				//duy???t qua c??c ?????i t?????ng g???i l??n t??? client g???m file v?? c??c control
				for (FileItem fileItem : fileItems) 
				{
				 if (!fileItem.isFormField()) 
				 {//N???u ko ph???i c??c control=>upfile l??n
					// x??? l?? file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) 
					{
				           //L???y ???????ng d???n hi???n t???i, ch??? ?? x??? l?? tr??n dirUrl ????? c?? ???????ng d???n ????ng
						String dirUrl = request.getServletContext().getRealPath("/image_sach") +  File.separator ;
						File dir = new File(dirUrl);
						if (!dir.exists()) 
						{
							//n???u ko c?? th?? m???c th?? t???o ra
							dir.mkdir();
						}
			           fileImg = dirUrl + File.separator + nameimg;
			           linkImg = "image_sach/"+ nameimg;
			           System.out.println(linkImg);
			           File file = new File(fileImg);//t???o file
			           try 
			           {
			              fileItem.write(file);//l??u file
			              System.out.println("UPLOAD TH??NH C??NG...!");
			              System.out.println("???????ng d???n l??u file l??: "+dirUrl);
			              
			           } catch (Exception e) 
			           {
			        	   e.printStackTrace();
			           }			
					}
				 }
				else//Neu la control
				{
					String tentk=fileItem.getFieldName();
					if(tentk.equals("txttensach"))
						response.getWriter().println(fileItem.getString());
					if(tentk.equals("txttacgia"))
						response.getWriter().println(fileItem.getString());
					if(tentk.equals("txtgia"))
						response.getWriter().println(fileItem.getString());
					if(tentk.equals("txtsoluong"))
						response.getWriter().println(fileItem.getString());
					if(tentk.equals("txtsotap"))
						response.getWriter().println(fileItem.getString());
					if(tentk.equals("txtmaloai"))
						response.getWriter().println(fileItem.getString());
					if(tentk.equals("txtfile"))
						response.getWriter().println(fileItem.getString());
					fields.put(tentk, fileItem.getString());
				}
			}
				

				System.out.println("Kh??ng t??m th???y");
				maSach = fields.get("txtmasach");
				System.out.println("ms: " + maSach);
				ts = fields.get("txttensach");
				tg = fields.get("txttacgia");
				gia =Long.parseLong(fields.get("txtgia")) ;
				soTap = Long.parseLong(fields.get("txtsotap"));
				soLuong = Long.parseLong(fields.get("txtsoluong"));
				ml = fields.get("txtmaloai");
				sbo.saveSach(maSach, ts, tg, gia, linkImg, soTap, soLuong, ml);
				request.setAttribute("checksave", (long) 1);
				System.out.println("???? l??u s??ch k ???nh");
				request.getRequestDispatcher("HtsachAdmin").forward(request, response);	
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			String ms =  request.getParameter("ms");
			System.out.print(ms);
			try 
			{
				if(sbo.delete(ms) == true) 
					//request.getRequestDispatcher("HtsachAdmin").forward(request, response);
				response.sendRedirect("HtsachAdmin");
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			//request.getRequestDispatcher("HtsachAdmin").forward(request, response);	
			break;
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
