<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-orange.min.css" />
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Contact modifié</title>
</head>
<body>
	<div id="page">
		<div id="divContactAdded">
			<h2><c:out value="${actionOnContact }"></c:out></h2>
		</div>
		<div id="divToHome">
			<a href="FrontControllerServlet">
				<button id="buttonToHome"
					class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--colored">Accueil</button>
			</a>
		</div>
	</div>
</body>
</html>