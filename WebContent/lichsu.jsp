<%@page import="bean.LichSuMuaHangBean"%>
<%@page import="bo.LoaiBo"%>
<%@page import="bean.KhachHangBean"%>
<%@page import="bean.SachBean"%>
<%@page import="bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="bean.GioHangBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%int count = 0;
	if(session.getAttribute("soluongsp")!=null){
		count = (int)session.getAttribute("soluongsp");
	}
	%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="Htsach">Trang chủ</a></li>
      <li><a href="giohang">Giỏ hàng (<%=count %>)</a></li>
     <!--  <li><a href="thanhtoan">Thanh toán</a></li> -->
      <li><a href="lichsu">Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <%
				if(request.getParameter("dangxuat")!=null){
					session.setAttribute("khachhang", null);
				}
				KhachHangBean khachHang = (KhachHangBean) session.getAttribute("khachhang");
				if (khachHang != null) {
				%>
				<li style="color: white; margin-top: 17px"> Xin chào: <%=khachHang.getHoTen()%></li>
				<li><a class="nav-link disabled" href="Htsach?dangxuat=oke"
					style="color: white;"> Đăng xuất</a></li>
				<%
				} else {
				%><li><a class="nav-link disabled" href=""
					style="color: white;" data-toggle="modal" data-target="#myModal">
						<i class="fa fa-user-circle" aria-hidden="true"></i> Đăng nhập
				</a></li>
				<li><a class="nav-link disabled" href="" style="color: white;"
				data-toggle="modal" data-target="#myModalregister" >
						<i class="fa fa-user-plus" aria-hidden="true"></i> Đăng ký
				</a></li>
				<%
				if (request.getAttribute("kt") != null && request.getAttribute("kt").toString().equals("0")) {
				%>
				<script>
					alert('Dang nhap sai');
				</script>
				<%
					}
				}
				%>
				
    </ul>
</div>
</nav>
	<%
		Long ktra = (long)0;
		if(request.getAttribute("ketquadangki") !=null){
			ktra = (long)request.getAttribute("ketquadangki");
			if(ktra == 1){%>
				<script>
					alert('Đăng kí thành công');
				</script>
			<%}else if(ktra == 0) {%>
				<script>
					alert('Đăng kí thất bại');
				</script>
			<%}else if(ktra == 2) {%>
				<script>
					alert('Đăng kí thất bại,tên đăng nhập đã tồn tại');
				</script>
			<%}
		}
	%>
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng nhập hệ thống</h4>
        </div>
        <div class="modal-body">
          <form method="post" action="checklogin">
             <label> Tên đăng nhập: </label>
              <input name="txtun" type="text" class="form-control">
             <label> Mật khẩu: </label>
             <input name="txtpass" type="password" class="form-control">
             <input name="but1" type="submit" value="Đăng nhập" class="btn-primary">
         </form>
        </div>
        </div>
    </div>
    
  </div>
  
   
  <!-- Modal -->
	<div class="modal fade" id="myModalregister" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Đăng ký </h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<form method="post" action="register">
						<label> Tên đăng nhập: </label> 
						<input name="txttendn" type="text" class="form-control">
						<label> Họ và tên: </label> 
						<input name="txthoten" type="text" class="form-control">
						<label> Địa chỉ: </label> 
						<input name="txtdiachi" type="text" class="form-control">
						<label> Số điện thoại: </label> 
						<input name="txtsodienthoai" type="text" class="form-control">
						<label> Email: </label> 
						<input name="txtemail" type="text" class="form-control">
						<label> Mật khẩu: </label> 
						<input name="txtpassword" type="password" class="form-control">
						<div style="text-align: center;">
							<input name="btnregister" type="submit" value="Đăng ký"
								class="btn-primary" style="margin-top: 10px">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
  
  
     <%
		Long checkdangky = (long)0;
		if(request.getAttribute("checkxacnhan") !=null){
			checkdangky = (long)request.getAttribute("checkxacnhan");
		 if(checkdangky == 0) {%>
				<script>
					alert('Đăng nhập thất bại');
				</script>
			<%}else if(checkdangky == 2) {%>
				<script>
					alert('Vui lòng đăng nhập tài khoản');
				</script>
			<%}else if(checkdangky == 3){%>
				<script>
					alert('Bạn chưa mua sp nào cả');
				</script>
			<%}
		}
	%>
	
		<%	DecimalFormat formatter = new DecimalFormat("###,###,###");
		List<LichSuMuaHangBean> list = null;
		if(request.getAttribute("lichsumua")!=null){
			list =(ArrayList<LichSuMuaHangBean>) request.getAttribute("lichsumua");
		}
	%>
	<div
		style="cursor: pointer; width: auto; border-bottom: #d6d6d6 1px dotted;">
	</div>
	<div
		style="cursor: pointer; width: auto; border-bottom: #d6d6d6 1px dotted;">
	<%if(list!=null){
		for(LichSuMuaHangBean lsmh : list){%>
			
	
		<table style="padding-top: 1px;border-bottom: #d6d6d6 1px dotted;">
			<tbody>
				<tr >
					<td valign="top" width="50px" height="60px" style="padding: 10px;"><img
						src="<%=lsmh.getAnhsach() %>" style="width: 110px; height: 130px">
					</td>
					<td valign="top" style="border-left: #d6d6d6 1px dotted;padding: 5px;width: 520px">
						<span style="color: black;">Mã hóa đơn : <%=lsmh.getMaHD() %></b></span><br>
						<span style="color: black;">Mã chi tiết hóa đơn : <%=lsmh.getMaCTHD()%> </span><br>
						<span style="color: black;"><%=lsmh.getTensach() %></b>
							<%=lsmh.getTacgia() %> </span> <br>
							Giá: <span><%=lsmh.getGiasach() %> $ </span></b><br>
						<span style="color: black;">Số lượng : <%=lsmh.getSoluongmua() %></b></span><br>
						<span style="color: black;">Ngày mua: <%=lsmh.getNgaymua() %></b></span><br>		
					</td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
			</tbody>
		</table>
		<%	}%>
	</div>
		
	<%}else{ %>
		<div style="text-align: center; margin-bottom: 130px; margin-top: 130px">
			<span style="margin-top: 180px; font-weight: 900; font-size: 25px; color: #d7d7c1">
			BẠN CHƯA ĐĂNG NHẬP TÀI KHOẢN
			</span>
		</div>
	<%}
	%>
		
</body>
</html>

