<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/home.css">
    <title>Trang chủ</title>
</head>
<body>
    <div class="main">
		<video autoplay loop id="video" plays-inline>
			<source src="./video/background.mp4" type="video/mp4">
		</video>
		<div class="overlay"></div>
		<div class="heading">
			<h1 class="head">
				WELCOME TO OUR <span>WEBSITE</span>
			</h1>
			<h3 class="sub">Lorem ipsum dolor sit amet</h3>
			<form action="" method="post">
				<div class="btns">
					<a href="javascript:$('form').submit()">Enter</a>
				</div>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</body>
</html>