<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
				            	<s:property value="%{#livreType.auteur.nom}"/>
			                    <s:param name="idLivre" value="#livreType.id" />	
			               	</s:a>
				    	</div>
				 	</s:iterator>
				</div>
	  			
	  			
	  			<!-- un formulaire de recherche de livre a partir de auteur, genre, titre -->		
			</div>
	</body>
</html>