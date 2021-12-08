<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	Hien thi gia tri cua bien:  ${tb}
 <%
   
 for(String ht: (String[])session.getAttribute("dsht")){
	 out.print(ht);
 }%>
 
Thu vien the: 
 <c:forEach items="${sessionScope.dsht}" var="ht"> 
      ${ht}
 </c:forEach>
Ds cac loai:<hr>
 <c:forEach items="${dsLoai}" var ="loai">
     <c:out value="${loai.getMaLoai()}"></c:out> <hr>
     ${loai.getTenLoai()}<hr>
 
 </c:forEach>
 
 
</body>
</html>