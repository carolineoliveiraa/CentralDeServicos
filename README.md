# API Central De Servicos

Este README fornece informações sobre a API CentralDeServicos, que gerencia recursos relacionados a técnicos, clientes e ordens de serviço.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Jakarta Validation
- Banco H2
- MySql



## Endpoints da API

### Técnico

#### Buscar Técnico por ID

- **URL:** `/tecnicos/{id}`
- **Método:** `GET`
- **Descrição:** Retorna os detalhes de um técnico específico.

#### Listar Todos os Técnicos

- **URL:** `/tecnicos`
- **Método:** `GET`
- **Descrição:** Retorna todos os técnicos cadastrados.

#### Criar Técnico

- **URL:** `/tecnicos`
- **Método:** `POST`
- **Descrição:** Cria um novo técnico.

#### Atualizar Técnico

- **URL:** `/tecnicos/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza um técnico existente.

#### Excluir Técnico

- **URL:** `/tecnicos/{id}`
- **Método:** `DELETE`
- **Descrição:** Remove um técnico existente.

### Cliente

#### Buscar Cliente por ID

- **URL:** `/clientes/{id}`
- **Método:** `GET`
- **Descrição:** Retorna os detalhes de um cliente específico.

#### Listar Todos os Clientes

- **URL:** `/clientes`
- **Método:** `GET`
- **Descrição:** Retorna todos os clientes cadastrados.

#### Criar Cliente

- **URL:** `/clientes`
- **Método:** `POST`
- **Descrição:** Cria um novo cliente.

#### Atualizar Cliente

- **URL:** `/clientes/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza um cliente existente.

#### Excluir Cliente

- **URL:** `/clientes/{id}`
- **Método:** `DELETE`
- **Descrição:** Remove um cliente existente.

### Ordem de Serviço (OS)

#### Buscar OS por ID

- **URL:** `/os/{id}`
- **Método:** `GET`
- **Descrição:** Retorna os detalhes de uma ordem de serviço específica.

#### Listar Todas as OS

- **URL:** `/os`
- **Método:** `GET`
- **Descrição:** Retorna todas as ordens de serviço cadastradas.

#### Criar OS

- **URL:** `/os`
- **Método:** `POST`
- **Descrição:** Cria uma nova ordem de serviço.

#### Atualizar OS

- **URL:** `/os/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza uma ordem de serviço existente.

## Como Utilizar o Projeto

Para compilar e executar o projeto localmente, siga os passos abaixo:

### Pré-requisitos

- JDK (Java Development Kit) 8 ou superior
- Maven

### Compilar o Projeto

```bash
mvn clean install
