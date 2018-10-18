<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="_head.jsp" %>
		<title>Livre</title>
	</head>
	
	<body>
		<div class="container">
			<s:actionmessage/>		
			<div class="row">
				<div class="col-lg-12">
					<h1 id="titre"><s:property value="livreType.titre"/></h1>
					<div class="row text-center">
						<div class="col-lg-6"><s:text name="livre.auteur"/> <s:property value="livreType.auteurs.nom"/></div>
						<div class="col-lg-6"><s:text name="livre.genre"/> <s:property value="livreType.genre"/></div>
					</div>
					<!--  <p><s:property value="livreType.resume"/></br></p>-->			
				</div>
			</div>
			<!-- un bouton pour emprunter -->
			<s:a action="emprunt_livre" namespace="/utilisateur">
				<s:param name="idLivre" value="livreType.id"/>
				<s:submit class="btn btn-default" value="%{getText('bouton.emprunt')}"/>
			</s:a>						
		</div>
	</body>
</html>