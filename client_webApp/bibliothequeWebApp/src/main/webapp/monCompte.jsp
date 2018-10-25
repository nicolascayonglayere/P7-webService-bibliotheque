<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="_head.jsp" %>
		<title>Mon compte</title>
	</head>
	
	<body>
		<%@include file="_navigation.jsp" %>
		<div id=blocPge>
			<div class="container">
				<div class="col-lg-9" id="titreCompteUser">
					<h1 id="titre"><s:text name="compteUser.titre"/><s:property value="utilisateur.pseudo"/></h1>
					<h3 id="titre"><s:text name="compteUser.bonjour"/> <s:property value="utilisateur.nom"/> <s:property value="utilisateur.prenom"/></h3>
					<s:actionmessage/>
				</div>				
			</div>

			<div class="col-lg-9">	
				<h4 id="titre"><s:text name="compteUser.emprunt"/></h4>
				
				<!-- un tab recapitulatif des enmprunts en cours-->
				<s:iterator value="listEmprunt" var="livreEmpruntType" status="stat">
					<ul>
						<li id="empruntLivre">
							<div><s:property value="#livreEmpruntType.ouvrage.titre"/> </div>
							<div>
								<s:text name="compteUser.dateEmprunt"/> <s:property value="#livreEmpruntType.dateEmprunt"/>
								<s:text name="compteUser.dateRetour"/> <s:property value="%{listDate.get(stat.index)}"/>
							</div>
							<!-- un bouton pour le retour -->
				    		<s:a action="retour_ouvrage" namespace="/utilisateur">
				    			<s:param name="idEmprunt" value="#livreEmpruntType.id"/>
				    			<s:submit class="btn btn-default" value="%{getText('bouton.retour')}"/>
				    		</s:a>	
				    		<!-- un bouton pour la prolongation -->
				    		<s:if test="%{#livreEmpruntType.prolongation==false}">
					    		<s:a action="prolongation_ouvrage" namespace="/utilisateur">
					    			<s:param name="idEmprunt" value="#livreEmpruntType.id"/>
					    			<s:submit class="btn btn-default" value="%{getText('bouton.prolongation')}"/>
					    		</s:a>
				    		</s:if>
						</li>
				   	</ul>
				</s:iterator>		
			</div>	
		</div>				
		<%@include file="_footer.jsp" %>
	</body>
</html>