# Dockerfile
FROM postgres:9.6.10-alpine

ENV POSTGRES_DB P7_bibliothequeWS

COPY [creation_table.sql /docker-entrypoint-initdb.d/] [insertion.sql /docker-entrypoint-initdb.d/]