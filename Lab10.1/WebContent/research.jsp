<%@page import="com.Research"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Research Management</title>
	
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.6.0.js"></script>
	<script src="Components/items.js"></script>
</head>

<body>
 
	<div class="container"><div class="row"><div class="col-6"> 

	<h1>Research Management</h1>
	
	<form id="formItem" name="formItem">
 		Research name: 
 		<input id="researchName" name="researchName" type="text" class="form-control form-control-sm">
 		<br> 
 		Research field: 
 		<input id="researchField" name="researchField" type="text" class="form-control form-control-sm">
 		<br> 
 		Fund total: 
 		<input id="fundTotal" name="fundTotal" type="text" class="form-control form-control-sm">
 		<br> 
 		Complete Status: 
 		<input id="complStatus" name="complStatus" type="text" class="form-control form-control-sm">
 		<br>
 	
 		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 		<input type="hidden" id="hidResearchIDSave" name="hidResearchIDSave" value="">

	</form>

	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>

	<br>
	<div id="divResearchGrid">
	 	<%
	 	Research researchObj = new Research(); 
 			out.print(researchObj.readResearch()); 
 	 	%>
	</div>

	</div> </div> </div> 
</body>
</html>