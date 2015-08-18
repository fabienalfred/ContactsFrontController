<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-orange.min.css" />
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Accueil</title>
</head>
<body>
	<div id="page" class="mdl-shadow--4dp">
		<div id="divFormSearch">Rechercher un contact
			<form action="FrontControllerServlet?cde=searchName" method="post">
				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<label class="mdl-textfield__label" for="inputName">Nom</label>
					<input id="inputName" name="inputName" class="mdl-textfield__input" type="text" />
				</div>
			</form>
		</div>
		<br /><br />
		<div id="divFormDelete">Supprimer un contact
			<form action="FrontControllerServlet?cde=delete" method="post">
				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<label class="mdl-textfield__label" for="inputDeleteContact">Nom</label>
					<input id="inputDeleteContact" name="inputDeleteContact" class="mdl-textfield__input" type="text" />
				</div>
			</form>
		</div>
		<br /><br />
		<div id="formAll">
		<form action="FrontControllerServlet?cde=getAll" method="post">
				<button id="buttonAll"
					class="mdl-button mdl-js-button mdl-button--raised 
							mdl-js-ripple-effect mdl-button--colored">Get
					all</button>
			</form>
		</div>
		<br /><br />
		<div id="divFormContact">
			<form id="formContact" action="FrontControllerServlet?cde=add" method="post">
				<fieldset>
					<legend>Nouveau contact</legend>
					<div class="mdl-textfield mdl-js-textfield">
						<label for="contactCiv" class="mdl-textfield__label">Civilité...</label>
						<input id="contactCiv" name="contactCiv" class="mdl-textfield__input" type="text" />
					</div>
<!-- 					<div>Civilité -->
<!-- 						<button type="button" id="buttonCiv" class="mdl-button mdl-js-button mdl-button--icon"> -->
<!-- 		  					<i class="material-icons">more_vert</i> -->
<!-- 						</button> -->
<!-- 						<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="buttonCiv"> -->
<!-- 		  					<li class="mdl-menu__item">Mme</li> -->
<!-- 		 					<li class="mdl-menu__item">Mlle</li> -->
<!-- 		  					<li class="mdl-menu__item">M</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
					<div class="mdl-textfield mdl-js-textfield">
						<label for="contactName" class="mdl-textfield__label">Nom...</label>
						<input id="contactName" name="contactName" class="mdl-textfield__input" type="text" />
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<label for="contactPrenom" class="mdl-textfield__label">Prenom...</label>
						<input id="contactPrenom" name="contactPrenom" class="mdl-textfield__input" type="text" />
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<label for="ville1" class="mdl-textfield__label">Adresse 1</label>
						<input id="ville1" name="ville1" class="mdl-textfield__input" type="text" />
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<label for="ville2" class="mdl-textfield__label">Adresse2</label>
						<input id="ville2" name="ville2" class="mdl-textfield__input" type="text" />
					</div>
					<br /><br />
					<div id="divButtons">
						<button id="createContact" type="submit"
							class="mdl-button mdl-js-button mdl-button--icon mdl-shadow--8dp mdl-js-ripple-effect mdl-button--colored">
							<i class="material-icons">add</i>
						</button>
					</div>
				</fieldset>
			</form>
			<br />
		</div>
	</div>
</body>
</html>