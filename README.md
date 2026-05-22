# Autoescola API - Checkpoint 3

API REST desenvolvida em Java 17 com Spring Boot para gerenciamento de alunos e instrutores de uma auto-escola.

---

# Integrantes

* Lucas Rodrigues de Queiroz - RM556323
* Victor Hugo de Paula	- RM554787
* Felipe Paes de Barros Muller Carioba	- RM558447
* Djalma Moreira de Andrade Filho	- RM555530
* Matheus Gushi Morioka	- RM556935

---

# Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation
* H2 Database
* Flyway
* Swagger/OpenAPI
* Maven

---

# Funcionalidades

## Alunos

* Cadastro de alunos
* Listagem paginada
* Busca por ID
* Atualização de dados
* Exclusão lógica

## Instrutores

* Cadastro de instrutores
* Listagem paginada
* Busca por ID
* Atualização de dados
* Exclusão lógica

---

# Regras de negócio implementadas

* Todas as informações obrigatórias possuem validação.
* Número e complemento do endereço são opcionais.
* Listagem ordenada por nome em ordem crescente.
* Paginação com 10 registros por página.
* Exclusão lógica utilizando campo `ativo`.
* Não é permitido alterar:

  * CPF do aluno
  * E-mail do aluno
  * CNH do instrutor
  * E-mail do instrutor
  * Especialidade do instrutor

---

# Banco de Dados

O projeto utiliza banco H2 em memória.

## Acesso ao H2 Console

URL:

```bash
http://localhost:8080/h2-console
```

## Configuração

```bash
JDBC URL: jdbc:h2:mem:autoescola
User: sa
Password:
```

---

# Swagger

Documentação da API disponível em:

```bash
http://localhost:8080/swagger-ui.html
```

---

# Como executar o projeto

## 1. Clonar o repositório

```bash
git clone LINK_DO_REPOSITORIO
```

## 2. Abrir no Eclipse

```bash
File > Import > Maven > Existing Maven Projects
```

## 3. Atualizar dependências Maven

```bash
Maven > Update Project
```

## 4. Executar a aplicação

Rodar a classe:

```bash
AutoescolaApiApplication.java
```

ou:

```bash
Run As > Spring Boot App
```

---

# Endpoints principais

## Alunos

```http
POST   /alunos
GET    /alunos
GET    /alunos/{id}
PUT    /alunos/{id}
DELETE /alunos/{id}
```

## Instrutores

```http
POST   /instrutores
GET    /instrutores
GET    /instrutores/{id}
PUT    /instrutores/{id}
DELETE /instrutores/{id}
```

---

# Exemplo JSON - Cadastro de aluno

```json
{
  "nome": "Lucas Rodrigues",
  "email": "lucas@email.com",
  "telefone": "11999999999",
  "cpf": "12345678900",
  "endereco": {
    "logradouro": "Rua A",
    "numero": "100",
    "complemento": "Casa",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "06000-000"
  }
}
```

---

# Exemplo JSON - Cadastro de instrutor

```json
{
  "nome": "Carlos Silva",
  "email": "carlos@email.com",
  "telefone": "11988888888",
  "cnh": "12345678901",
  "especialidade": "CARROS",
  "endereco": {
    "logradouro": "Rua B",
    "numero": "200",
    "complemento": "Sala 1",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "07000-000"
  }
}
```

---

# Status do projeto

* Projeto funcionando
* API REST completa
* CRUD implementado
* Banco de dados funcionando
* Swagger funcionando
* Validações implementadas
* Paginação implementada
* Exclusão lógica implementada
