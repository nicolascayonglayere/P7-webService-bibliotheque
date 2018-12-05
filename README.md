# P7-webService-bibliotheque par Nicolas Cayon-Glayère

Vous trouverez dans ce dossier mon travail pour ce projet.

Le dossier contient le code source des 3 composants : 
	- batch
	- client_webApp
	- webService

Dans chacun de ces dossiers, vous trouverez le code source et sa compilation, la javadoc et un fichier Dockerfile.

De plus, vous trouverez dans le dossier test_docker les fichiers nécessaires aux 3 scénarios de déploiement avec Docker for Windows.
Vous trouverez les variables d'environnement à modifier dans les fichiers docker-compose.yml : 
	- pour le batch : fréquence du cron et propriétés pour l'envoi de mail
	- pour le web service : url de la base de donnée
	- pour la base de donnée : identifiants et nom de la base de donnée
	- pour l'application web : url du web service et chemin des images

