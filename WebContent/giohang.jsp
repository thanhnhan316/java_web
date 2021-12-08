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
	
	
		<% DecimalFormat formatter = new DecimalFormat("###,###,###"); %>
	<%	
		List<GioHangBean> listgiohang = new ArrayList<>();
		Long tongtien =(long) 0;
		if(request.getAttribute("listgh")!=null) {
			listgiohang = (ArrayList<GioHangBean>)request.getAttribute("listgh");
			tongtien = (long)request.getAttribute("tongtien");
		}
		if(listgiohang.size()>0){
	%>
	<div
		style="cursor: pointer; width: auto; border-bottom: #d6d6d6 1px dotted;">
		
		<%
		for (GioHangBean gh : listgiohang) {
		%>
		<table style="padding-top: 1px; margin-left: 400px" align = "center", >
			<tbody>
				<tr>
					<td valign="top" width="50px" height="60px" style= "margin-top: 10px"><img
						src="<%=gh.getImage() %>" style="width: 100px; height: 120px">
					</td>
					<td valign="top"><span style="color: black;","><b><%=gh.getTenSach()%> <br> Giá: <span>
						<%= formatter.format(gh.getGia() * gh.getSlMua())+ " $"%></span>
					</b>
					<form action="capnhapgiohang?masach=<%=gh.getMaSach()%>" method="post">
					<input  name="soluong" type="text" style="width: 25px" value="<%=gh.getSlMua() %>">
						&nbsp; 
						<input type="submit" value="Cập nhật" name="update">
						<input type="submit" value="Trả lại" name="delete">
					
					</form>
					
					</td>
					
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
			</tbody>
		</table>
		
		<%
		}
		%>

	</div>
	<table style="width: 100%",>
		<tbody >
			<tr>
				<td valign="top"><span style="font-weight: bold; color: black ;margin-left: 450px">Tổng
						cộng: <%=formatter.format(tongtien)+" $"%>
				</span></td>
			</tr>
		</tbody>
	</table>
	<%
	} else {
	%>
	<div
		style="text-align: center; margin-bottom: 130px; margin-top: 130px">
		<span
			style="margin-top: 180px; font-size: 25px">GIỎ
			HÀNG TRỐNG</span>
	</div>
	<%
	}
	%>
	<div
		style="cursor: pointer; width: auto; border-bottom: #d6d6d6 1px dotted;">
	</div>
	<div style="padding-left: 10px; margin-top: 20px; text-align: center;">
		<a class="btn btn-primary" href="giohang?xoaall=oke" role="button">Trả lại toàn bộ</a> 
			<a class="btn btn-primary" href="Htsach" role="button">Tiếp tục mua</a>
			 <a class="btn btn-primary" href="thanhtoan" role="button">Xác nhận đặt mua</a>
	</div>
</body>
</html>




