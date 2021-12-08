<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Admin</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="HtsachAdmin">Trang chủ</a></li>
      <li><a href="lichsuAdmin">Lịch sử bán hàng</a></li>
      <li><a href="AccountAdmin">Tài khoản Admin</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">

				<%
				if(request.getParameter("dangxuat")!=null){
					session.setAttribute("admin", null);
				}
				%>
				<c:choose> 
					<c:when  test = "${sessionScope.admin != null}"  >
						<li style="color: white; margin-top: 14px"><i class="fa fa-user-circle"
					aria-hidden="true"></i> <c:out value="${tenadmin}"></c:out> </li>
						<li><a class="nav-link disabled" href="logoutAdmin?dangxuat=logout"
						style="color: white;"> Đăng xuất</a></li>
					</c:when>
					
					<c:otherwise>
						<li><a class="nav-link disabled" href=""
							style="color: white;" data-toggle="modal" data-target="#myModal">
						<i class="fa fa-user-circle" aria-hidden="true"></i> Đăng nhập
						</a></li>
						<li><a class="nav-link disabled" href="" style="color: white;"
							data-toggle="modal" data-target="#myModalregister" >
						<i class="fa fa-user-plus" aria-hidden="true"></i> Đăng ký
						</a></li>
					</c:otherwise>
				</c:choose>
				<c:if test = "${(kt != null) && (kt == 0)}">
					<script>
					alert('Dang nhap sai');
				</script>
				</c:if>
    </ul>
    
</div>
</nav>
	<c:choose>
		<c:when test = "${ktdk == 1}">
			<script>
				alert('Đăng kí thành công');
			</script>
		 </c:when>
		 <c:when test="${ktdk == 0}">
			 <script>
				alert('Đăng kí thất bại');
			</script>
		 </c:when>
		 <c:when test = "${ktdk == 2}">
		 	<script>
				alert('Tên đăng nhập đã tồn tại');
			</script>
		 </c:when>
	</c:choose>
	
		<c:choose>
		<c:when test = "${checksave == 1}">
			<script>
				alert('Save thành công');
			</script>
		 </c:when>
		
	</c:choose>
<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng nhập hệ thống</h4>
        </div>
        <div class="modal-body">
          <form method="post" action="checkloginAdmin">
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
					<form method="post" action="registerAdmin">
						<label> Tên đăng nhập: </label> 
						<input name="txttendn" type="text" class="form-control">
						<label> Mật khẩu: </label> 
						<input name="txtpassword" type="password" class="form-control">
						<label> Quyen: </label> 
						<input name="txtquyen" type="number" class="form-control">
						<div style="text-align: center;">
							<input name="btnregister" type="submit" value="Đăng ký"
								class="btn-primary" style="margin-top: 10px">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div
		style="cursor: pointer; width: auto; border-bottom: #d6d6d6 1px dotted;">
		<h2>Lịch sử bán hàng</h2>
	</div>
	<c:choose>
		<c:when test="${lichsuadmin != null }">
				<form action = "xacnhanAdmin" method = "post">
				<c:forEach items = "${lichsuadmin}" var = "lsmh">
				<div style = "margin-left: 500px">
					<img src="${lsmh.getAnhsach()}" style="width: 200px; height: 150px"> <br>
						
					Tên sách: ${lsmh.getTensach() } <br>
										
					Giá: ${lsmh.getGiasach() } <br>
					Số lượng : ${lsmh.getSoluongmua()} <br>
					<br>
					<a class = "btn btn-primary"  name = "xacnhan" href = "xacnhanAdmin?mct=${lsmh.getMaCTHD()}" style = " margin-left : 500px"> Xác nhận</a>
				</div>
				
				</c:forEach>
				<input name="xacnhanall" type="submit" value="Xác nhận toàn bộ"
											class="btn-primary" style = "margin-top: 50px; margin-left : 500px">
				</form>
		</c:when>
		<c:otherwise>
			<div align = "center">
			
				<h2  > Chưa có đơn hàng nào</h2>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>



