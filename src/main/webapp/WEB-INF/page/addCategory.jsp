<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!-- importing navigation bar -->
<%@ include file="navbar1.jsp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Category</title>

<style>
.error {
	color: #FF0000;
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value="/resource/css/registration.css"/>">
<link rel="stylesheet" href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resource/editable/jquery-editable-select.min.css"/>">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<c:url value="/resource/editable/jquery-editable-select.min.js"/>"></script>
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
		$('#categoryName').editableSelect();
		
		$('body').on('blur', '#categoryName',function(){
			$("#hsnCode").val($('#categoryName').siblings('.es-list').find('li.selected').attr('value'));
		});
		
		$("#addProductBtn").click(function(){
			var categoryName = $("#categoryName").val().toLowerCase();
			if(categoryName.includes("laptop"))
				$(location).attr('href', 'addLaptop');
			else if(categoryName.includes("camera") || categoryName.includes("cctv camera"))
				$(location).attr('href', 'addCamera');
			else if(categoryName.includes("tv") || categoryName.includes("television"))
				$(location).attr('href', 'addTV');
			else
				$(location).attr('href', 'addProduct?hsnCode='+$("#hsnCode").val());
		});
		
		
	});
</script>
</head>
<body style="background-color: #001e4f">


	<div class="regform container">
		<h3 style="color: green; text-align: center">${success}</h3>
		<h3 style="color: red; text-align: center">${failure}</h3>
		<h1>Adding Product Category</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form:form action="addCategory" method="POST"	modelAttribute="categoryModel" name="addCatForm">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label class="control-label" for="categoryName">Category Name :</label>
								<form:select path="categoryName" class="form-control">
									<form:options id="cat" items="${categoryList}"/>
								</form:select>
							</div>
							<div class="col-sm-6 form-group">
								<label class="control-label" for="hsnCode">HSN CODE :</label>
								<form:input path="hsnCode" value="" class="form-control" />
							</div>
						</div>

						<div class="form-actions">
							<div class="col-sm-offset-4 col-sm-10">
								<input type="submit" value="Add New Category" id="addCateoryBtn"	class="btn btn-lg btn-info" />
								<input type="button" value="Add New Product" id="addProductBtn"	class="btn btn-lg btn-info" />
							</div>
							<div class="col-sm-offset-4 col-sm-10">
								
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
<%@ include file="footer.jsp"%> 