<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}

.w3-sidenav a, .w3-sidenav h4 {
	font-weight: bold
}
</style>
</head>
<body>
	<hr>
	<div class="ourbkground wow flipInX" data-wow-delay="0.6s">
		
		<div class="container text-center">
			<h1 class="text-left">Laptop</h1>
			<div class="row">
			<c:forEach var="laptop" items="${laptopList}" varStatus="index">
				<div class="carousel slide row innerbkground" data-ride="carousel" data-type="multi" data-interval="3000" id="productscarousel">
					
					<div class="carousel-inner">
					
						<div class="item active">
							<div class="col-md-3 col-sm-4 col-xs-12">
								<div class="spe-prods">
									<div class="mainbox">
										<h3>${laptop.title }</h3>
										<img class="rotprod" src="<c:url value="/resource/images/products/laptop_${laptop.prodId}_img_1.jpg"/>" alt="${laptop.brand}">
									</div>
									<div class="price-big">
										<div>
											<div class="floatting-price">
												<h3 class="error"><del>MRP - ${laptop.mrp}</del></h3>
												<h3>Price - ${laptop.price}</h3>
											</div>
										</div>
										<div class="ordersection">
											<a href="#" class="buybtn">Order</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>



					<a class="left carousel-control" href="#productscarousel"
						data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>



					<a class="right carousel-control" href="#productscarousel"
						data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i></a>

				</div>
			</div>
		</div>
		
	</div>
</body>
</html>