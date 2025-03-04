<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/product.css">
    <title>Quản lý sản phẩm</title>
</head>
<body>
    <div class="product-box">
		<h1>QUẢN LÝ SẢN PHẨM</h1>
		<form action="" method="post">
			<div class="user-box">
				<input type="text" name="name" required> <label>Tên sản phẩm</label>
			</div>
			<div class="user-box">
				<input type="text" name="quantity" required> <label>Số	lượng</label>
			</div>
			<div class="user-box">
				<input type="text" name="price" required> <label>Giá bán</label>
			</div>
			<a href="javascript:$('form').submit()">Lưu lại</a>
		</form>
		<div class="scrollbar">
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">Số thứ tự</th>
						<th scope="col">Tên sản phẩm</th>
						<th scope="col">Số lượng</th>
						<th scope="col">Giá bán</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="no" value="0" />
					<c:forEach var="product" items="${list}">
						<c:set var="no" value="${no+1}" />
						<tr>
							<td>${no}</td>
							<td>${product.getNameProduct()}</td>
							<td>$product.getAmount()}</td>
							<td>${product.getPrice()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
</body>
</html>