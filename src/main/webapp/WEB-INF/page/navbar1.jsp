<%@page import="com.kalababa.product.model.ProductMaster"%>
<%@page import="com.kalababa.product.model.CameraMaster"%>
<%@page import="com.kalababa.product.model.TVMaster"%>
<%@page import="com.kalababa.product.model.LaptopMaster"%>
<%@ page import = "java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/favicon.png"/>" />
<%-- <link rel="stylesheet"
	href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/overall.css"/>"> --%>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>""/>

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
		<script type="text/javascript">
		function addToCart (urL) {
				$.ajax({
					url : urL,
					success : function(result) {
							alert('Added To Cart');
							$("#header").load(document.URL+" #header");
					}
				});
		}
		function clearCart (urL) {
			$.ajax({
				url : urL,
				success : function(result) {
						alert('All Cart Items Removed');
						$("#header").load(document.URL+" #header");
				}
			});
		}
		function removeFromCart (urL) {
				$.ajax({
					url : urL,
					success : function(result) {
							alert("Removed From Cart");
							$("#header").load(document.URL+" #header");
					}
				});
		/*
		 setInterval(function() {
			//alert("added to cart");
			//$("#cartDrpdwn").load(document.URL+" #cartDrpdwn");
			$("#header").load(document.URL+" #header");
			}, 10000); */
		}
		</script>
</head>
<body>
<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +91-87898-82237</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> care@redojet.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> Patna</a></li>
					
					</ul>
					<ul class="header-links pull-right">
						<!-- Only admin can view this link -->
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href=" <c:url value="/addCategory" />"><i class="fa fa-laptop" aria-hidden="true"></i> Add New Products</a></li>
						</security:authorize>
						<c:if test="${empty pageContext.request.userPrincipal.name}">
							<li><a href="<c:url value="/login" />"><i class="fa fa-user-o"></i> Login</a></li>
							<li><a href=" <c:url value="/customer/registration" />"> /SignUp</a></li>
						</c:if>
						<c:if test="${!empty pageContext.request.userPrincipal.name}">
							<li><a href='<c:url value="/index" />'><i class="fa fa-user-o"></i> ${pageContext.request.userPrincipal.name}</a></li>
							<li><a href="<c:url value='./logout'/>"> Logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="/index" class="logo">
									<img src="<c:url value="/resource/images/redojetLogo0.png"/>" style="max-width: 200px" alt="Kalababa">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<%-- <form:form>
									<form:select cssClass="input-select" items="${categoryList}"/>
									<input class="input" placeholder="Search here">
									<button class="search-btn">Search</button>
								</form:form> --%>
								<form>
									<select class="input-select">
										<option value="0">All Categories</option>
										<option value="1">Category 01</option>
										<option value="1">Category 02</option>
									</select>
									<input class="input" placeholder="Search here">
									<button class="search-btn">Search</button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								<!-- Wishlist -->
								<div>
									<!-- <a href="#">
										<i class="fa fa-heart-o"></i>
										<span>Your Wishlist</span>
										<div class="qty">2</div>
									</a> -->
								</div>
								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
										<div class="qty" ><c:if test="${cartItems==null}">0</c:if>${cartItems.size()}</div>
									</a>
									<div class="cart-dropdown">
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
										<div class="cart-summary">
											<small>${cartItems.size()} Item <c:if test="${cartItems.size()>1}">(s)</c:if> selected</small>
											<h5>SUBTOTAL: &#x20B9
											<% 
											int totalCartPrice=0;
											List cartItems=(List)session.getAttribute("cartItems");
											if(cartItems!=null){
											for(int i=0; i<cartItems.size();i++){
												if(cartItems.get(i) instanceof LaptopMaster)
													totalCartPrice+=((LaptopMaster)(cartItems.get(i))).getPrice();
												if(cartItems.get(i) instanceof TVMaster)
													totalCartPrice+=((TVMaster)(cartItems.get(i))).getPrice();
												if(cartItems.get(i) instanceof CameraMaster)
													totalCartPrice+=((CameraMaster)(cartItems.get(i))).getPrice();
												if(cartItems.get(i) instanceof ProductMaster)
													totalCartPrice+=((ProductMaster)(cartItems.get(i))).getPrice();
												} 
											}
											out.print(totalCartPrice); %></h5>
											<h5><button type="button" class="delete" value="cart/removeAllItems" onclick="clearCart (this.value)">Clear Cart</button></h5>
										</div>
										<div class="cart-btns">
											<!-- <a href="#">View Cart</a> -->
											<a href="cart/checkout">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Hot Deals</a></li>
						<li><a href="#">Categories</a></li>
						<li><a href="#">Laptops</a></li>
						<li><a href="#">Smartphones</a></li>
						<li><a href="#">Cameras</a></li>
						<li><a href="#">Accessories</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->
</body>
</html>