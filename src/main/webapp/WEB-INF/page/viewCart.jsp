<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RedoJet|Cart</title>
<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css"/>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="resource/css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="resource/css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="resource/css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
 		<link rel="stylesheet" href="resource/css/font-awesome.min.css">

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="resource/css/styles.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		<!-- jQuery Plugins -->
		<script src="resource/js/jquery.min.js"></script>
		<script src="resource/js/bootstrap.min.js"></script>
		<script src="resource/js/slick.min.js"></script>
		<script src="resource/js/nouislider.min.js"></script>
		<script src="resource/js/jquery.zoom.min.js"></script>
		<script src="resource/js/main.js"></script>
</head>
<body>
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				<div class="cart-list">
											<c:forEach var="cartItem" items="${cartItems}" varStatus="ind">
											<div class="product-widget">
												<div class="product-img">
													<img src="<c:url value="${cartItem.prodImgs[0].imageUrl}"/>" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="viewProduct?prodId=${cartItem.prodId }&catId=${cartItem.categoryId}">${cartItem.title }</a></h3>
													<h4 class="product-price"><span class="qty">1 x</span>&#x20B9 ${cartItem.price }</h4>
												</div>
												<button type="button" class="delete" value="cart/removeCartItem?indexId=${ind.count}" onclick="removeFromCart (this.value)"><i class="fa fa-close"></i></button>
											</div>
											</c:forEach>
		
											<!-- <div class="product-widget">
												<div class="product-img">
													<img src="./img/product02.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">product name goes here</a></h3>
													<h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
												</div>
												<button class="delete"><i class="fa fa-close"></i></button>
											</div> -->
										</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

</body>
</html>