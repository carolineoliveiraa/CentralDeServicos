# API - Central De Servicos

A aplicação foi desenvolvida para gerenciamento de serviços relacionados a técnicos, clientes e ordens de serviço, com atenção especial à integridade dos dados e às regras de negócio.

Sem serviço de clientes , é possível:

Cadastre novos clientes, desde que o CPF fornecido não esteja duplicado no sistema.
Atualizar informações como nome, CPF e telefone, com verificação de unicidade do CPF.
Listar todos os clientes ou buscar um cliente específico pelo seu ID.
Excluir clientes, desde que não possuam ordens de serviço vinculadas. Caso contrário, o sistema impede a exclusão para preservação do histórico e a rastreabilidade dos dados.
Já não há serviço de pedidos de serviço , é possível:

Criar e atualizar pedidos de serviço com informações como prioridade, status e observações.
Atribuir uma ordem de serviço a um técnico e a um cliente, garantindo que ambas as entidades existam no sistema.
Fechar automaticamente a ordem de serviço, atribuindo uma data de fechamento, caso o status seja atualizado para "finalizado".
Listar todos os pedidos ou buscar uma específica pelo ID, garantindo total controle sobre o histórico de serviços.
No serviço de técnicos , as funcionalidades seguem uma lógica semelhante aos clientes:

Cadastro de técnicos, garantindo que o CPF seja único.
Atualização de informações básicas, como nome e telefone, respeitando a regra de unicidade do CPF.
Exclusão de técnicos, mas apenas não há ordens de serviços associados. Isso protege o sistema contra perda de informações relevantes.
Além disso, o sistema está preparado para lidar com erros comuns, como a tentativa de excluir uma entidade com vínculos ativos ou a duplicidade de CPFs. Mensagens claras e específicas são retornadas ao usuário nesses casos, facilitando a compreensão do que precisa ser ajustado.

Essa estrutura garante que os processos sejam realizados de forma fluida e segura, evitando inconsistências e possibilitando um controle eficiente do histórico de clientes, técnicos e ordens de serviço.

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
