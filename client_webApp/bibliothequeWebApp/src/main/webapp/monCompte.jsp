<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="_head.jsp" %>
		<title>Mon compte</title>
	</head>
	
	<body>
			<div class="container">
				<div class="col-lg-9" id="titreCompteUser">
					<h1 id="titre"><s:text name="compteUser.titre"/><s:property value="utilisateur.pseudo"/></h1>
					<h3 id="titre"><s:text name="compteUser.bonjour"/><s:property value="utilisateur.nom"/> <s:property value="utilisateur.prenom"/></h3>
					<s:actionmessage/>
				</div>				
			</div>

			<div class="col-lg-12">	
				<h4 id="titre"><s:text name="compteUser.emprunt"/></h4>
				
				<!-- un tab recapitulatif des enmprunts en cours-->
				<s:iterator value="listEmprunt" var="livreEmpruntType">
					<ul>
						<li>
							<s:property value="#livreEmpruntType.livreType.titre"/> <s:property value=#livreEmpruntType.dateEmprunt/>
							<!-- un bouton pour le retour -->
				    		<s:a action="retour_ouvrage" namespace="/utilisateur">
				    			<s:param name="idEmprunt" value="#livreEmpruntType.id"/>
				    			<s:submit class="btn btn-default" value="%{getText('bouton.retour')}"/>
				    		</s:a>	
				    		<!-- un bouton pour la prolongation -->
				    		<s:a action="prolongation_ouvrage" namespace="/utilisateur">
				    			<s:param name="idEmprunt" value="#livreEmpruntType.id"/>
				    			<s:submit class="btn btn-default" value="%{getText('bouton.prolongation')}"/>
				    		</s:a>
						</li>
				   	</ul>
				</s:iterator>		
			</div>
			
				<!-- un formulaire pour modifier ses param pseudo et mdp et coordonnee -->
				<!--  <div class="col-lg-12" id="modifUser">
					<h4 id="titre"><s:text name="compteUser.modifier"/></h4>
					<s:form action="modifier_user" cssClass="form-vertical" namespace="/utilisateur">
						<s:textfield name="utilisateur.pseudo" placeholder="pseudo" label="%{getText('form.pseudo')}" requiredLabel="true"/>
						<s:textfield name="utilisateur.motDePasse" placeholder="motDePasse" label="%{getText('form.mdp')}" requiredLabel="true"/>
						<s:textfield name="coordonneeUtilisateur.email" placeholder="email" label="%{getText('form.email')}" requiredLabel="true"/>
						<s:textfield name="coordonneeUtilisateur.adresse" placeholder="adresse" label="%{getText('form.adresse')}" requiredLabel="true"/>
						<s:submit class="btn btn-default" value="%{getText('bouton.modifier')}">
							<s:param name="pseudo">${utilisateur.pseudo}</s:param>
							<s:param name="motDePasse">${utilisateur.motDePasse}</s:param>
							<s:param name="email">${coordonneeUtilisateur.email}</s:param>
							<s:param name="adresse">${coordonneeUtilisateur.adresse}</s:param>
						</s:submit>
					</s:form>
				</div>
				
				</br>
			
				<div class="col-lg-12" id="modifUser">
					<h5 id="titre"><s:text name="compteUser.supprimer"/></h5>
					<p><s:text name="compteUser.supprMessage"/> 
						<s:a action = "supprimer_compte" namespace="/jsp/utilisateur">
							<s:submit class="btn btn-default" value="%{getText('bouton.supprimer')}"/>			
						</s:a>
					</p>		
				</div>-->			

	</body>
</html>