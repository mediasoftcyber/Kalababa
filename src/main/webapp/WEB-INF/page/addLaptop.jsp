<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Laptop</title>
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

		$('form[id="addLaptopForm"]').validate({
			rules : {
				title : 'required',
				brand : 'required',
				description : 'required',
				itemModelNumber : 'required',
				screenSize : 'required',
				colour : 'required',
				ramSize : 'required',
				hardDriveSize : 'required',
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
				replWarrantyPeriod : {
					required : true,
					number : true
				},
				servWarrantyPeriod : {
					required : true,
					number : true
				}
			},
			messages : {
				title : 'Please Enter Laptop Title With Description',
				brand : 'Please Enter Laptop Brand Name',
				description : 'Please Enter Laptop Description',
				itemModelNumber : 'Please Enter Laptop Model Number',
				screenSize : 'Please Enter Laptop Screen Size',
				colour  : 'Please Enter Colour of Laptop',
				ramSize : 'Please Enter Ram Size(in GB)',
				hardDriveSize : 'Please Enter Hard Drive Size(in GB)',
				purchagingPrice : {
					required : 'Please Enter Valid Laptop Purchanging Price',
					number : 'Please Enter Valid Laptop Purchanging Price (Numerical Value only)'
				},
				quantity : {
					required : 'Please Enter Valid Laptop Quantity',
					number : 'Please Enter Valid Laptop Quantity (Numerical Value only)'
				},
				mrp : {
					required : 'Please Enter Valid Laptop MRP',
					number : 'Please Enter Valid Laptop MRP (Numerical Value only)'
				},
				price : {
					required : 'Please Enter Laptop Selling Price',
					number : 'Please Enter Valid Laptop Selling Price(Numerical Value only)'
				},
				replWarrantyPeriod : {
					required : 'Please Enter a valid Replacement warranty period(in Months)',
					number : 'Please Enter a valid Replacement warranty period(Numerical Value only)'
				},
				servWarrantyPeriod : {
					required : 'Please Enter a valid Service warranty period(in Months)',
					number : 'Please Enter a valid Service warranty period(Numerical Value only)'
				}
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
</script>
</head>
<body style="background-color: #001e4f">


	<div class="regform container">
		<h3 style="color: green; text-align: center">${success}</h3>
		<h3 style="color: red; text-align: center">${failure}</h3>
		<h1>Adding Laptop</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form:form action="addLaptop" method="POST"	modelAttribute="laptopModel" name="addLaptopForm" enctype="multipart/form-data">
					<div class="col-sm-12">
						<div class="row">
							<p style="text-align: right; color: #FF0000;">All Asterisk(*) marked fields are mandatory to fill</p>
						</div>
						<div class="row">
							<div class="col-sm-12 form-group">
								<label class="control-label" for="title">Laptop Title</label><span class="error">* </span>:
								<form:input path="title" placeholder="Laptop Title with discription" class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label class="control-label" for="hsnCode">HSN CODE :</label>
								<form:input path="hsnCode" readonly="true" class="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<label class="control-label" for="brand">Brand</label><span class="error">* </span>:
								<form:input path="brand" placeholder="Laptop Brand"
									class="form-control" />
							</div>

						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label class="control-label" for="series">Series</label><span class="error">* </span>:
								<form:input path="series" placeholder="Laptop Series"
									class="form-control" />
							</div>
							<div class="col-sm-6 form-group">
									<label class="control-label" for="itemModelNumber">Item model number</label><span class="error">* </span>:
									<form:input path="itemModelNumber" placeholder="Item model number" class="form-control" />
							</div>
						</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="itemHeight">Item Height :</label>
									<form:input path="itemHeight"
										placeholder="Item Height(in Millimeters)" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="itemWidth">Item Width	:</label>
									<form:input path="itemWidth" placeholder="Item Width(in Centimeters)" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="screenSize">Screen Size</label><span class="error">* </span>:
									<form:input path="screenSize" placeholder="Screen Size(in Inches)" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="maximumDisplayResolution">Maximum Display Resolution	:</label>
									<form:input path="maximumDisplayResolution"
										placeholder="Maximum Display Resolution" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="itemWeight">Item Weight :</label>
									<form:input path="itemWeight" placeholder="Item Weight(in KiloGrams)" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="productDimensions">Laptop Dimensions	:</label>
									<form:input path="productDimensions" placeholder="Laptop Dimensions(in Centimeters)" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="batteries">Batteries :</label>
									<form:input path="batteries" placeholder="Batteries" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="colour">Colour</label><span class="error">* </span>:
									<form:input path="colour" placeholder="Laptop Colour" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="processorBrand">Processor Brand :</label>
									<form:input path="processorBrand" placeholder="Processor Brand" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="processorType">Processor Type :</label>
									<form:input path="processorType" placeholder="Processor Type" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="ramSize">RAM Size</label><span class="error">* </span>:
									<form:input path="ramSize" placeholder="RAM Size(in GB)" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="memoryTechnology">Memory Technology</label><span class="error">* </span>:
									<form:input path="memoryTechnology" placeholder="Memory Technology" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="maximumMemorySupported">Maximum Memory Supported :</label>
									<form:input path="maximumMemorySupported" placeholder="Maximum Memory Supported" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="hardDriveSize">Hard Drive Size</label><span class="error">* </span>:
									<form:input path="hardDriveSize" placeholder="Hard Drive Size(in GB)" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="hardDiskTechnology">Hard Disk Technology :</label>
									<form:input path="hardDiskTechnology" placeholder="Hard Disk Technology" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="audioDetails">Audio Details :</label>
									<form:input path="audioDetails" placeholder="Audio Details" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="speakerDescription">Speaker Description :</label>
									<form:input path="speakerDescription" placeholder="Speaker Description" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="graphicsCoprocessor">Graphics Coprocessor :</label>
									<form:input path="graphicsCoprocessor" placeholder="Graphics Coprocessor" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=connectivityType>Connectivity Type :</label>
									<form:input path="connectivityType" placeholder="Connectivity Type" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="wirelessType">WirelessType :</label>
									<form:input path="wirelessType" placeholder="Wireless Type" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=numberOfUSB2_0Ports>Number of USB 2.0 Ports :</label>
									<form:input path="numberOfUSB2_0Ports" placeholder="Number of USB 2.0 Ports" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="numberOfUSB3_0Ports">Number of USB 3.0 Ports :</label>
									<form:input path="numberOfUSB3_0Ports" placeholder="Number of USB 3.0 Ports" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=numberOfHDMIPorts>Number of HDMI Ports :</label>
									<form:input path="numberOfHDMIPorts" placeholder="Number of HDMI Ports" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="numberOfAudioOutPorts">Number of Audio-out Ports :</label>
									<form:input path="numberOfAudioOutPorts" placeholder="Number of Audio-out Ports" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=numberOfEthernetPorts>Number of Ethernet Ports :</label>
									<form:input path="numberOfEthernetPorts" placeholder="Number of Ethernet Ports" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="numberOfMicrophonePorts">Number of Microphone Ports :</label>
									<form:input path="numberOfMicrophonePorts" placeholder="Number of Microphone Ports" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=opticalDriveType>Optical Drive Type :</label>
									<form:input path="opticalDriveType" placeholder="Optical Drive Type" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="operatingSystem">Operating System :</label>
									<form:input path="operatingSystem" placeholder="Operating System" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=hardwarePlatform>Hardware Platform :</label>
									<form:input path="hardwarePlatform" placeholder="Hardware Platform" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="averageBatteryLife">Average Battery Life :</label>
									<form:input path="averageBatteryLife" placeholder="Average Battery Life" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=lithiumBatteryEnergyContent>Lithium Battery Energy Content :</label>
									<form:input path="lithiumBatteryEnergyContent" placeholder="Lithium Battery Energy Content" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="numberOfLithiumIonCells">Number of Lithium Ion Cells :</label>
									<form:input path="numberOfLithiumIonCells" placeholder="Number of Lithium Ion Cells" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=includedComponents>Included Components :</label>
									<form:input path="includedComponents" placeholder="Included Components" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="touchScreen">Touch Screen :</label>
									<form:select path="touchScreen" placeholder="Touch Screen" class="form-control" items="${boolList}"/>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for=purchagingPrice>Purchasing Price</label><span class="error">* </span>:
									<form:input path="purchagingPrice" placeholder="Purchasing Price" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="quantity">Quantity</label><span class="error">* </span>:
									<form:input path="quantity" placeholder="Laptop Quantity (Same Model & Configuration)" class="form-control" />
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
							<div class="row">
								<div class="col-sm-6 form-group">
									<label class="control-label" for="replWarrantyPeriod">Replacement Warranty Period</label><span class="error">* </span>:
									<form:input path="replWarrantyPeriod" placeholder="Replacement Warranty Period" class="form-control" />
								</div>
								<div class="col-sm-6 form-group">
									<label class="control-label" for="servWarrantyPeriod">Service Warranty Period</label><span class="error">* </span>:
									<form:input path="servWarrantyPeriod" placeholder="Service Warranty Period" class="form-control" />
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
						<form:hidden path="replWarrantyStatus" />
						<form:hidden path="servWarrantyStatus" />
						
						<c:if test="laptopModel.createDate!=null">
							<form:hidden path="createdBy" />
							<form:hidden path="updatedBy" />
							<form:hidden path="createDate" />
							<form:hidden path="updateDate" />
							<form:hidden path="warrantyStartDate" />
							<form:hidden path="sellingDate"/>
						</c:if>

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<input type="submit" value="Add" id="addLapBtn"
									class="btn btn-default" />
							</div>
						</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>