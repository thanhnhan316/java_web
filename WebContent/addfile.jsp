<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>Thêm sách</h1>
 	<form method="post" action="EditSachAdmin?action=${ACTION}" enctype= "multipart/form-data" style = "margin-left:50px; margin-top: 50px">
	  Mã sách : <input type="text" name="txtmasach" value="${sachbeanadmin.maSach}"> <br>
	  Tên sách: <input type="text" name="txttensach" value="${sachbeanadmin.tenSach}"> <br>
	  Tác giả: <input type="text" name="txttacgia" value="${sachbeanadmin.tacGia}"> <br>
	  Giá: <input type="number" name="txtgia" value="${sachbeanadmin.gia}"> <br>
	  Số lượng: <input type="number" name="txtsoluong" value="${sachbeanadmin.soLuong}"> <br>
	  Số tập: <input type="number" name="txtsotap" value="${sachbeanadmin.soTap}"> <br>
	  Mã loại: <input type="text" name="txtmaloai" value="${sachbeanadmin.maLoai}"> <br>
	  File ảnh:   	
  	<input type="file" name="txtfile" value = "${sachbeanadmin.anh }"><br>
  	<input type="submit"> 
	  
  </form> 	 
  
</body>
</html>