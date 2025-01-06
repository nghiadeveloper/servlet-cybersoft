<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail Page</title>
</head>
<body>

	<%--
		Các ký hiệu trong JSP
		- Khai báo biến: <%!  %>
		- Xử lý logic code: <%  %>
		- Xuất giá trị của biến: <%=  %> 
	 --%>

	<%-- Lưu ý: File JSP hạn chế viết logic code java --%>
	 
	 <%
	 	String username = (String) request.getAttribute("giatri1");
	 	String password = (String) request.getAttribute("giatri2");
	 %>
	 
	 <%-- 
	 <% if(password.equals("123")) { %>
	 	<b style="color: red"><%= username %></b>
	 <% } else { %>
	 	<b style="color: blue"><%= username %></b>
	 <% } %>
	 --%>
	 
	 <b style="color: ${color}"><%= username %></b>
	 
</body>
</html>