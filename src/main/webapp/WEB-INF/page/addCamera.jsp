<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!-- importing navigation bar -->
<%@ include file="navbar.jsp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Camera</title>
<style>
.error {
	color: #FF0000;
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resource/css/registration.css">
<link rel="stylesheet" href="resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resource/editable/jquery-editable-select.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style type="text/css">
.inputWithIcon {
	position: relative;
}

.inputWithIcon i {
	position: absolute;
	left: 0;
	top: 0px;
	padding: 9px 8px;
	color: #aaa;
	transition: 0.3s;
}

.inputWithIcon #pw {
	position: absolute;
	left: 0;
	top: 20px;
	padding: 9px 8px;
	color: #aaa;
	transition: 0.3s;
}

.inputWithIcon input:focus+i {
	color: dodgerBlue;
}
</style>
<script>
$(function() {

	$('form[id="addCamForm"]').validate({
		rules : {
			title : 'required',
			brand : 'required',
			itemModelNumber : 'required',
			opticalSensorResolution : 'required',
			purchagingPrice : {
				required : true,
				number : true
			},
			quantity : {
				required : true,
				number : true
			},
			mrp : {
				required : true,
				number : true
			},
			price : {
				required : true,
				number : true
			},
			warrantyPeriod : {
				required : true,
				number : true
			}
		},
		messages : {
			title : 'Please Enter Camera Title With Description',
			brand : 'Please Enter Camera Brand Name',
			itemModelNumber : 'Please Enter Camera Model Number',
			opticalSensorResolution : 'Please Enter Camera Optical Sensor Resolution (in Mega Pixel)',
			purchagingPrice : {
				required : 'Please Enter Valid Camera Purchanging Price',
				number : 'Please Enter Valid Camera Purchanging Price (Numerical Value only)'
			},
			quantity : {
				required : 'Please Enter Valid Camera Quantity',
				number : 'Please Enter Valid Camera Quantity (Numerical Value only)'
			},
			mrp : {
				required : 'Please Enter Valid Camera MRP',
				number : 'Please Enter Valid Camera MRP (Numerical Value only)'
			},
			price : {
				required : 'Please Enter Camera Selling Price',
				number : 'Please Enter Valid Camera Selling Price(Numerical Value only)'
			},
			warrantyPeriod : {
				required : 'Please Enter a valid warranty period(in Months)',
				number : 'Please Enter a valid warranty period(Numerical Value only)'
			}
		},
		submitHandler : function(form) {
			form.submit();
		}		
	});
});
</script>
</head>
<body style="background-color: #001e4f">


	<div class="regform container">
		<h3 style="color: green; text-align: center">${success}</h3>
		<h3 style="color: red; text-align: center">${failure}</h3>
		<h1>Adding Camera</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form:form action="addCamera" method="POST"	modelAttribute="camModel" id="addCamForm"	enctype="multipart/form-data">
					<div class="col-sm-12">
					<div class="row">
							<p style="text-align: right; color: #FF0000;">All Asterisk(*) marked fields are mandatory to fill</p>
					</div>
						<div class="row">
							<div class="col-sm-12 form-group">
								<label class="control-label" for="title">Product Title</label><span class="error">* </span>:
								<form:input path="title" placeholder="Product Title with discription" class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label class="control-label" for="hsnCode">HSN CODE :</label>
								<form:input path="hsnCode" readonly="true" class="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<label class="control-label" for="brand">Brand</label><span class="error">* </span>:
								<form:input path="brand" placeholder="Camera Brand"
									class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
									<label class="control-label" for="itemModelNumber">Item model number</label><span class="error">* </span>:
									<form:input path="itemModelNumber" placeholder="Item model number" class="form-control" />
							</div>
							<div class="col-sm-6 form-group">
									<label class="control-label" for="itemWeight">Item Weight :</label>
									<form:input path="itemWeight" placeholder="Item Weight(in KiloGrams)" class="form-control" />
							</div>
						</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=includedComponents>Included Components :</label>
									<form:input path="includedComponents" placeholder="Included Components" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="productDimensions">Product Dimensions	:</label>
									<form:input path="productDimensions" placeholder="Product Dimensions(in Centimeters)" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="opticalSensorResolution">Optical Sensor Resolution (in Mega Pixel)</label><span class="error">* </span>:
									<form:input path="opticalSensorResolution" placeholder="Optical Sensor Resolution (in Mega Pixel)" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="opticalZoom">Optical Zoom :</label>
									<form:input path="opticalZoom" placeholder="Optical Zoom" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="videoCaptureResolution">Video Capture Resolution :</label>
									<form:input path="videoCaptureResolution" placeholder="Video Capture Resolution" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="minFocalLength">Min Focal Length :</label>
									<form:input path="minFocalLength" placeholder="Min Focal Length" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="connectorType">Connector Type :</label>
									<form:input path="connectorType" placeholder="Connector Type" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="warrantyPeriod">Warranty Period</label><span class="error">* </span>:
									<form:input path="warrantyPeriod" placeholder="Warranty Period" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 form-group">
									<label class="control-label" for="additionalFeatures">Additional Features :</label>
									<form:input path="additionalFeatures" placeholder="Additional Features" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=purchagingPrice>Purchasing Price</label><span class="error">* </span>:
									<form:input path="purchagingPrice" placeholder="Purchasing Price" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="quantity">Quantity</label><span class="error">* </span>:
									<form:input path="quantity" placeholder="Camera Quantity (Same Model & Configuration)" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=mrp>MRP</label><span class="error">* </span>:
									<form:input path="mrp" placeholder="MRP" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="price">Price</label><span class="error">* </span>:
									<form:input path="price" placeholder="Price" class="form-control"/>
								</div>
							</div>
							
							<div class="col-sm-6 form-group">
									<label class="control-label" for="images">Images :</label>
									<form:input type="file" path="images" placeholder="Images" class="form-control" multiple = "true"/>
								</div>
						</div>

						<form:hidden path="prodId" />
						<form:hidden path="custId" />
						<form:hidden path="active" />
						<form:hidden path="categoryId" />
						<form:hidden path="sold" />
						<form:hidden path="warrantyStatus" />
						
						<c:if test="camModel.createDate!=null">
							<form:hidden path="createdBy" />
							<form:hidden path="updatedBy" />
							<form:hidden path="createDate" />
							<form:hidden path="updateDate" />
							<form:hidden path="warrantyStartDate" />
							<form:hidden path="sellingDate"/>
						</c:if>

						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<input type="submit" value="Add" id="addCameraBtn"	class="btn btn-default" />
							</div>
						</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
<%@ include file="footer.jsp"%> 