FROM java:8

ADD https://drive.google.com/uc?id=17R0II8yrtw25CeZVrCZvkoa0EwLXi3nB&export=download WS.zip

RUN unzip WS.zip

ENTRYPOINT ["java","-jar","bibliothequeWS-AppSpringBoot-1.0-SNAPSHOT.jar"]
