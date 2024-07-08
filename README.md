# API de Cadastro de Beneficiários

## Descrição

Esta aplicação é um serviço backend desenvolvido em Java com Spring Boot que fornece uma API REST para o gerenciamento de beneficiários de um plano de saúde. Ela permite cadastrar beneficiários, listar todos os beneficiários, listar documentos de um beneficiário específico, atualizar dados de um beneficiário e remover um beneficiário. A aplicação utiliza autenticação para proteger os endpoints e está configurada para utilizar um banco de dados H2 em memória.

## Funcionalidades

- **Cadastrar Beneficiário**: Permite cadastrar um novo beneficiário com seus documentos.
- **Listar Beneficiários**: Retorna uma lista de todos os beneficiários cadastrados.
- **Listar Documentos de um Beneficiário**: Retorna todos os documentos de um beneficiário a partir de seu ID.
- **Atualizar Beneficiário**: Permite atualizar os dados cadastrais de um beneficiário.
- **Remover Beneficiário**: Remove um beneficiário do cadastro.
- **Autenticação**: Implementa autenticação utilizando um usuário criado em memória.
- **Documentação com Swagger**: Documentação interativa disponível em `/registro_beneficiarios/swagger-ui/index.html`.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- H2 Database
- Swagger

## Endpoints

Os endpoints principais da API são:

- `POST /beneficiarios`: Cadastra um novo beneficiário.
- `GET /beneficiarios`: Lista todos os beneficiários.
- `GET /beneficiarios/{id}/documentos`: Lista todos os documentos de um beneficiário pelo ID.
- `PUT /beneficiarios/{id}`: Atualiza os dados de um beneficiário.
- `DELETE /beneficiarios/{id}`: Remove um beneficiário.

## Autenticação

Para acessar os endpoints, é necessário autenticar-se utilizando a API de autenticação. A autenticação é feita via um usuário criado em memória com as seguintes credenciais:

- **Username**: `ekan`
- **Senha**: `ekan`

## Documentação da API

A documentação da API está disponível via Swagger na URL:
[http://localhost:8080/registro_beneficiarios/swagger-ui/index.html](http://localhost:8080/registro_beneficiarios/swagger-ui/index.html)

## Acesso ao Banco de Dados H2

O banco de dados H2 em memória pode ser acessado via:
[http://localhost:8080/registro_beneficiarios/h2-console](http://localhost:8080/registro_beneficiarios/h2-console)

## Collection de APIs

Todas as APIs estão documentadas e podem ser importadas diretamente para ferramentas como Postman a partir da collection disponível no diretório resources do projeto. A collection pode ser encontrada no arquivo `APIsCollection.json`.

## Testes

A aplicação possui alguns casos de testes na camada de controller e de service, garantindo a qualidade e funcionamento dos principais fluxos da aplicação.

## Como Executar

### Pré-requisitos

- JDK 11 ou superior
- Maven

### Passos para executar

1. **Clone o repositório**:
   ```bash
   git clone [<URL_DO_REPOSITORIO>](https://github.com/alexsandrodeveloper/ekan-backend.git)
   cd <NOME_DO_REPOSITORIO>
