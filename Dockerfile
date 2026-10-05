# Usa a versão oficial do PostgreSQL mais recente
FROM postgres:latest

# Define a senha padrão para o usuário superuser 'postgres'
ENV POSTGRES_PASSWORD=postgres

# Define o banco de dados inicial padrão
ENV POSTGRES_DB=postgres-auction

# Expõe a porta padrão do PostgreSQL
EXPOSE 5432