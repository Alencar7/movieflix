# MovieFlix API
## Descrição
MovieFlix é uma API RESTful desenvolvida em Java com Spring Boot, projetada para gerenciar um catálogo de filmes e categorias. A aplicação permite operações como listar filmes, gerenciar categorias e, futuramente, integrar autenticação de usuários. Inicialmente, utiliza mocks para simulação de dados, com planos para integração com um banco de dados real (ex.: MySQL ou PostgreSQL).
O layout da aplicação é baseado em um protótipo desenvolvido no Figma, que guia a estrutura visual e funcional do projeto.

## Tecnologias Utilizadas
Java 17: Linguagem principal do projeto.

Spring Boot: Framework para construção da API.

SpringDoc/Swagger: Documentação automática da API.

Maven: Gerenciamento de dependências.

Docker (opcional): Suporte para containerização.

Mocks: Simulação de dados para desenvolvimento inicial.

## Como Executar
Siga os passos abaixo para rodar a API localmente:
Pré-requisitos:
Java 17 ou superior instalado.

Maven instalado.

Opcional: Docker e Docker Compose para containerização.

Clonar o Repositório:
'''bash

git clone https://github.com/Alencar7/movieflix.git
cd movieflix '''

Compilar e Gerar o JAR:
'''bash

mvn clean package'''

Executar a Aplicação:
''' bash

java -jar target/movieflix-0.0.1-SNAPSHOT.jar'''

## Acessar a Documentação:
Acesse a UI do Swagger em: http://localhost:8080/swagger-ui.html

Documentação OpenAPI: http://localhost:8080/api/api-docs

## Executar com Docker (se aplicável):
'''bash

docker build -t movieflix-api .
docker run -p 8080:8080 movieflix-api'''

## Estrutura do Projeto
src/main/java: Contém o código-fonte da aplicação, incluindo controladores (MovieController, CategoryController), serviços e mappers.

src/main/resources: Arquivos de configuração, como application.properties.

target: Diretório gerado com o arquivo .jar após o build.

Dockerfile: Configuração para containerização da aplicação (se presente).

## Endpoints Principais
GET /api/movies: Lista todos os filmes.

GET /api/categories: Lista todas as categorias.

POST /api/movies: Cria um novo filme.

DELETE /api/movies/{id}: Remove um filme pelo ID.
(Nota: Adicione detalhes específicos dos endpoints se desejar.)

## Status do Projeto
O projeto está em desenvolvimento ativo. As próximas etapas incluem:
Integração com um banco de dados relacional.

Implementação de autenticação com JWT.

Adição de testes unitários e de integração com JUnit e Mockito.

Configuração de uma pipeline CI/CD com GitHub Actions.

## Contato
Desenvolvedor: Adriano de Alencar

GitHub: Alencar7

E-mail: contato.adealencar@gmail.com

