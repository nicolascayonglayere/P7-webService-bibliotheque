<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="_head.jsp" %>
		<title>Login</title>
	</head>

	<body>
			<s:actionmessage/>
			<div class="container">
				<h1 id="titre"><s:text name="login.titre"/></h1>
				<s:actionerror/>
				
				<s:form id="idLoginForm" action="loginUser" cssClass="form-vertical" namespace="/">
					<s:textfield name="utilisateur.pseudo" placeholder="pseudo" label="%{getText('form.pseudo')}" requiredLabel="true"/>
					<s:password name="utilisateur.motDePasse" placeholder="motDePasse" label="%{getText('form.mdp')}" requiredLabel="true"/>
					<s:submit id="btOK" class="btn btn-default" value="%{getText('login.titre')}">	
	       				<s:param name="pseudo">${utilisateur.pseudo }</s:param>
	      				<s:param name="motDePasse">${utilisateur.motDePasse }</s:param>
	     			 </s:submit>
	     			 <s:token/>		
				</s:form>	
				
				<!-- Lien pour créer un utilisateur -->
				<!--<s:text name="login.inscription"/>
				<s:url var="goInscription" action="inscription" namespace="/"/>
				<s:a href="%{goInscription}">
					<s:text name="creerUser.titre"/>
				</s:a>-->		
			</div>
	</body>
</html>