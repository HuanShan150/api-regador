# Regador-API

Este é um projeto Spring Boot utilizando arquitetura hexagonal, Docker. O projeto é uma aplicação para trabalho de Embarcados

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database
- Docker
- Postgres

## Estrutura do Projeto

A estrutura do projeto segue a arquitetura HEXAGONAL (Ports and Adapters), dividida nos seguintes pacotes:

- **domain**: Contém as entidades do domínio e enumerações.
- **repository**: Interfaces de repositórios para acesso ao banco de dados.
- **service**: Classes de serviços contendo a lógica de negócios.
- **adapter.controller**: Controladores REST que expõem as APIs.

![image](https://github.com/HuanShan150/microject/assets/30788893/6009a327-6bf1-4bc2-9e58-9157cb43e76b)


## Configuração e Execução do Projeto

### Pré-requisitos

- Java 17
- Docker
- Docker Compose
- Gradle

### Passos para Execução
   **Clone o repositório:**

  Foi utilizado DevContainers para facilitar a instalação do projeto, já terá todas configurações no arquivo .devcontainer.json

  https://code.visualstudio.com/docs/devcontainers/containers

  Ter vscode com a extensão do devcontainer, docker, dockercompose e docker desktop para vizualização dos containers.

  Vscode: 
  https://code.visualstudio.com/download
  
  Docker instalação:
  https://docs.docker.com/get-docker/

  Docker Compose instalação: 

  https://docs.docker.com/compose/install/

  Docker Desktop instalação: 

  https://docs.docker.com/desktop/install/linux-install/

  No vscode após ter a extensão do devcontainers use o atalho:

  CTRL + SHIFT + P

  ![image](https://github.com/HuanShan150/microject/assets/30788893/960af88c-c313-4938-be31-11377e702626)

  
  Selecione a opção Devcontainers: Rebuild and Reopen in Container 

  A primeira build é mais demorado. 

  Após finalizar a API já estará disponivel na porta 8080.

  Obs: Se não desejar usar devcontainer é pode-se rodar apenas com Docker e Docker Compose.

  Obs2: Necessario que o consumidor utilizer a localhost:5173, caso deseje usar outra porta adicionar no WebConfig.java

  Endpoints da API
  Regas:
  
    POST /regas: Adicionar uma nova rega
    GET /regas: Listar todos as regas
    GET /regas/{id}: Buscar rega por ID
    DELETE /regas/{id}: Remover rega por ID
  
  Exemplo POST:
    POST /regas HTTP/1.1
    Host: seu-servidor
    Content-Type: application/json
    
    {
        "umidade": 45.7
    }
  Resposta (200 ok): 
    {
    "id": 1,
    "umidade": 45.7,
    "dataHora": "2023-10-31T12:34:56.789+00:00"
    }



Banco de Dados: 

  Rega

ID (PK)          
Umidade Double             
Data            


