<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="_head.jsp" %>

		<title>Accueil</title>
	</head>
	
	
	<body>
			<div class = "container">

				<h1 id="titre"><s:text name="index.bienvenue"/></h1>
				<s:actionmessage/>
				<s:if test="#session.utilisateur">
					<p><s:text name="index.bonjour"/> <s:property value="#session.utilisateur.pseudo"/></p>	
				</s:if>
				<s:else>
					<p>
						<s:a action="go_login" namespace="/"><s:text name="index.connexion"/></s:a>					
					</p>
				</s:else>	
					
				<div class="row" id="blocImgTopo">
					<s:iterator value="livresAccueil" var="livreType">
				    	<div class="col-lg-3" id="imageTopo" >
				    		<s:a action="go_livre" namespace="/">
				    			<!-- mettre l'image de couv 
								<s:url action="ImageAction" namespace="/" var="URLTag">
									<s:param name="imageId" value="%{#topo.image}"/>
								</s:url>
								<img src="<s:property value="#URLTag"/>" class="thumbnail, rounded" />-->			    			
				            	<s:property value="#livreType.titre"/></br>
				            	<s:property value="#livreType.auteurType.nom}"/>
			                    <s:param name="idLivre" value="#livreType.id" />	
			               	</s:a>
				    	</div>
				 	</s:iterator>
				</div>
	  			
	  			
	  			<!-- un formulaire de recherche de livre a partir de auteur, genre, titre -->	
				<h2 id="titre"><s:text name="index.recherche"/></h2>
				<h3><s:text name="index.explication"></s:text></h3>
				<s:form action="rechMulti" cssClass="form-vertical" namespace="/">
					<s:textfield name="titre" placeholder="titre" label="%{getText('form.titre')}" requiredLabel="true"/>
					<s:textfield name="nomAuteur" placeholder="nomAuteur" label="%{getText('form.auteur')}" requiredLabel="true"/>
					<s:select name="selectedGenre" label="%{getText('livre.genre')}" list="listGenre" size="1" />
					<s:submit class="btn btn-default" value="%{getText('bouton.valider')}">
						<!--<s:param name="nom" value="topo.nomTopo"/>-->
					</s:submit>					
				</s:form>	
				
				<s:if test="listResultat">
					<s:iterator value="listLivre" var="livreType">
						<s:a action="go_livre" namespace="/">				
							<p id="listLivreType">
								<li><s:property value="#livreType.titre"/> <s:property value="#livreType.auteurs.nom"/> <s:property value="#livreType.genre"/></li>	
								<s:param name="idLivre" value="#livreType.id" />										
							</p>
						</s:a>
					</s:iterator>
				</s:if>				  				
			</div>
	</body>
</html>