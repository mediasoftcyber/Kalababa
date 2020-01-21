<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="navbar1.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>${product.title }</title>

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
					<!-- Product main img -->
					<div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
							<c:forEach var="img" items="${product.prodImgs}">
								<div class="product-preview">
									<img src="${img.imageUrl }" alt="${img.imageName}">
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					<div class="col-md-2  col-md-pull-5">
						<div id="product-imgs">
							<c:forEach var="img" items="${product.prodImgs}">
								<div class="product-preview">
									<img src="${img.imageUrl }" alt="${img.imageName}">
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- /Product thumb imgs -->

					<!-- Product details -->
					<div class="col-md-5">
						<div class="product-details">
							<h2 class="product-name">${product.title}</h2>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o"></i>
								</div>
								<a class="review-link" href="#">10 Review(s) | Add your review</a>
							</div>
							<div>
								<h3 class="product-price">${product.price} <del class="product-old-price">${product.mrp}</del></h3>
								<span class="product-available">
								<c:if test="${product.quantity < 1 }">
								Out of Stock
								</c:if>
								<c:if test="${product.quantity < 5 and product.quantity > 1 }">
								Few Left In Stock
								</c:if>
								<c:if test="${product.quantity > 5 }">
								In Stock
								</c:if>
								</span>
							</div>
							<p>
							<table style="vertical-align: top; text-align: left;">
							<tr>
							<td style="vertical-align: top;">&bull;&emsp;</td><td style="vertical-align: top;">${product.screenSize}<c:if test="${product.andriod}"> Andriod</c:if> LED 4K TV</td>
							</tr>
							<tr>
							<td style="vertical-align: top;">&bull;&emsp;</td><td style="vertical-align: top;">Resolution: HD Ready (1366x768) | Refresh Rate: 60 Hertz | View angle - 178 / 178 </td>
							</tr>
							<tr>
							<td style="vertical-align: top;">&bull;&emsp;</td><td style="vertical-align: top;">Connectivity: 2 HDMI ports to connect set top box, Blu Ray players, gaming console | 2 USB ports to connect hard drives and other USB devices | 1 VGA Port to connect the laptop </td>
							</tr>
							<tr>
							<td style="vertical-align: top;">&bull;&emsp;</td><td style="vertical-align: top;">Sound : 20 Watts Output | Stereo Output | Speaker Location - Bottom </td>
							</tr>
							<tr>
							<td style="vertical-align: top;">&bull;&emsp;</td><td style="vertical-align: top;">Display : HD LED Panel | Dynamic Contrast Ratio - Mega, Response Time (ms) 8, Aspect Ratio - 16:9, Brightness (cd/m2) - 280 | DLED, HD 4K Video Playability through USB 2.0 </td>
							</tr>
							<tr>
							<td style="vertical-align: top;">&bull;&emsp;</td><td style="vertical-align: top;">2 year manufacturer warranty from the date of purchase from SamSoni</td>
							</tr>
							</table>
							</p>
							<a href="#product-tab">see more product details</a>

							<div class="add-to-cart">
								<a href="cart/add"><button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
							</div>

							<ul class="product-btns">
								<li><a href="#"><i class="fa fa-heart-o"></i> add to wishlist</a></li>
								<li><a href="#"><i class="fa fa-exchange"></i> add to compare</a></li>
							</ul>

							<!-- <ul class="product-links">
								<li>Category:</li>
								<li><a href="#">Headphones</a></li>
								<li><a href="#">Accessories</a></li>
							</ul> -->

							<!-- <ul class="product-links">
								<li>Share:</li>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-envelope"></i></a></li>
							</ul> -->

						</div>
					</div>
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Warranty Details</a></li>
								<li><a data-toggle="tab" href="#tab2">Technical Details</a></li>
								<li><a data-toggle="tab" href="#tab3">Reviews (3)</a></li>
							</ul>
							<!-- /product tab nav -->

							<!-- product tab content -->
							<div class="tab-content">
								<!-- tab1  -->
								<div id="tab1" class="tab-pane fade in active">
									<div class="row">
										<div class="col-md-12">
											<!-- <p> -->
												<table>
													<tr>
														<td>Warranty Summary&emsp;</td>
														<td>Seller warranty of 12 months provided by Media Soft Pvt Ltd.</td>
													</tr>
											    	<tr>
														<td>Warranty Service Type&emsp;</td>
														<td>For warranty claims or any product related issues please email mediasoftpatna@gmail.com or call </td>
													</tr>
													<tr>
														<td>Covered in Warranty&emsp;</td>
														<td>Warranty for Manufacturing Defects Only</td>
													</tr>
													<tr>
														<td>Not Covered in Warranty&emsp;</td>
														<td>Physical, Liquid, Electrical Damages and Unauthorized repair is Not Covered</td>
													</tr>
													<tr>
														<td>Domestic Warranty&emsp;</td>
														<td>12 Months</td>
													</tr>
												</table>
											<!-- </p> -->
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab2  -->
								<div id="tab2" class="tab-pane fade in">
									<div class="row">
										<div class="col-md-12">
											<p>
												<h4>General</h4><br>
												<table>
													<tr>
														<td>Brand&emsp;</td>
														<td>${product.brand}</td>
													</tr>
													<tr>
														<td>Item Model Number&emsp;</td>
														<td>${product.itemModelNumber}</td>
													</tr>
													<c:if test="!${product.colour.length().equals(0)}">
													<tr>
														<td>Colour&emsp;</td>
														<td>${product.colour}</td>
													</tr>
													</c:if>
													<c:if test="!${product.itemHeight.length().equals(0)}">
													<tr>
														<td>Item Height&emsp;</td>
														<td>${product.itemHeight}</td>
													</tr>
													</c:if>
													<c:if test="!${product.itemWidth.length().equals(0)}">
													<tr>
														<td>Item Width&emsp;</td>
														<td>${product.itemWidth}</td>
													</tr>
													</c:if>
													<c:if test="!${product.itemWeight.length().equals(0)}">
													<tr>
														<td>Item Weight&emsp;</td>
														<td>${product.itemWeight}</td>
													</tr>
													</c:if>
													<c:if test="!${product.productDimensions.length().equals(0)}">
													<tr>
														<td>Product Dimensions&emsp;</td>
														<td>${product.productDimensions}</td>
													</tr>
													</c:if>
													<c:if test="!${product.includedComponents.length().equals(0)}">
													<tr>
														<td>Included Components&emsp;</td>
														<td>${product.includedComponents}</td>
													</tr>
													</c:if>
													<tr>
														<td>Andriod&emsp;</td>
														<td>${product.andriod}</td>
													</tr>
												</table><br>
												<h4>Display And Audio Features</h4><br>
												<table>
													<tr>
														<td>Screen Size&emsp;</td>
														<td>${product.screenSize}</td>
													</tr>
													<c:if test="!${product.maximumDisplayResolution.length().equals(0)}">
													<tr>
														<td>Maximum Display Resolution&emsp;</td>
														<td>${product.maximumDisplayResolution}</td>
													</tr>
													</c:if>.
													<c:if test="!${product.viewingAngle.length().equals(0)}">
													<tr>
														<td>Viewing Angle&emsp;</td>
														<td>${product.viewingAngle}</td>
													</tr>
													</c:if>
													<c:if test="!${product.speakerDescription.length().equals(0)}">
													<tr>
														<td>Speaker Description&emsp;</td>
														<td>${product.speakerDescription}</td>
													</tr>
													</c:if>
												</table><br>
												<c:if test="!${product.connectivityType.length().equals(0) 
														and product.numberOfUSBPorts.length().equals(0) 
														and product.numberOfHDMIPorts.length().equals(0)}"> 
												<h4>Connectivity Features</h4><br>
												<table>
													<c:if test="!${product.connectivityType.length().equals(0)}">
													<tr>
														<td>Connectivity Type&emsp;</td>
														<td>${product.connectivityType}</td>
													</tr>
													</c:if>
													<c:if test="!${product.numberOfUSBPorts.length().equals(0)}">
													<tr>
														<td>Number of USB Ports&emsp;</td>
														<td>${product.numberOfUSBPorts}</td>
													</tr>
													</c:if>
													<c:if test="!${product.numberOfHDMIPorts.length().equals(0)}">
													<tr>
														<td>Number of HDMI Ports&emsp;</td>
														<td>${product.numberOfHDMIPorts}</td>
													</tr>
													</c:if>
												</table><br>
												</c:if>
											</p>
										</div>
									</div>
								</div>
								<!-- /tab2  -->

								<!-- tab3  -->
								<div id="tab3" class="tab-pane fade in">
									<div class="row">
										<!-- Rating -->
										<div class="col-md-3">
											<div id="rating">
												<div class="rating-avg">
													<span>4.5</span>
													<div class="rating-stars">
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star-o"></i>
													</div>
												</div>
												<ul class="rating">
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
														</div>
														<div class="rating-progress">
															<div style="width: 80%;"></div>
														</div>
														<span class="sum">3</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: 60%;"></div>
														</div>
														<span class="sum">2</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
												</ul>
											</div>
										</div>
										<!-- /Rating -->

										<!-- Reviews -->
										<div class="col-md-6">
											<div id="reviews">
												<ul class="reviews">
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
												</ul>
												<ul class="reviews-pagination">
													<li class="active">1</li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#">4</a></li>
													<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
												</ul>
											</div>
										</div>
										<!-- /Reviews -->

										<!-- Review Form -->
										<div class="col-md-3">
											<div id="review-form">
												<form class="review-form">
													<input class="input" type="text" placeholder="Your Name">
													<input class="input" type="email" placeholder="Your Email">
													<textarea class="input" placeholder="Your Review"></textarea>
													<div class="input-rating">
														<span>Your Rating: </span>
														<div class="stars">
															<input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
															<input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
															<input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
															<input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
															<input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
														</div>
													</div>
													<button class="primary-btn">Submit</button>
												</form>
											</div>
										</div>
										<!-- /Review Form -->
									</div>
								</div>
								<!-- /tab3  -->
							</div>
							<!-- /product tab content  -->
						</div>
					</div>
					<!-- /product tab -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- Section -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-12">
						<div class="section-title text-center">
							<h3 class="title">Related Products</h3>
						</div>
					</div>
					
					<c:forEach var="prod" items="${tvList}" varStatus="index">
					<c:if test="${!prod.prodId.equals(product.prodId)}">
					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="<c:url value="${prod.prodImgs[0].imageUrl}"/>" alt="">
								<div class="product-label">
									<span class="sale">-${Integer.valueOf(100*(prod.mrp-prod.price)/prod.mrp)}%</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">LED TV</p>
								<h3 class="product-name"><a href="viewProduct?prodId=${prod.prodId }&catId=${prod.categoryId}">${prod.title }</a></h3>
								<h4 class="product-price">${prod.price} <del class="product-old-price">${prod.mrp}</del></h4>
								<div class="product-rating">
								</div>
								<div class="product-btns">
									<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
									<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
									<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
								</div>
							</div>
							<div class="add-to-cart">
								<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
							</div>
						</div>
					</div>
					<!-- /product -->
					</c:if>
					</c:forEach>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /Section -->
</body>
<%@ include file="footer1.jsp"%>
</html>