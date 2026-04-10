# 📦 Product Management API

Uma API RESTful robusta desenvolvida em **Java e Spring Boot** para o gerenciamento inteligente de produtos. O foco central deste projeto é a aplicação de padrões de design (Design Patterns), separação de responsabilidades e automação de regras de negócio no backend.

---

## 🛠️ Diferenciais Técnicos e Arquitetura

Este projeto demonstra maturidade no desenvolvimento backend, indo muito além de operações básicas de banco de dados:

* **Arquitetura em Camadas:** Separação estrita entre Controller, Service e Repository, garantindo uma manutenção simplificada e testabilidade.
* **Padronização de Respostas com DTOs:** Uso de `RequestDTO` e `ResponseDTO` para desacoplar a entidade do banco de dados da interface da API, protegendo dados sensíveis e otimizando o tráfego.
* **Tratamento Global de Exceções:** Implementação de um `GlobalExceptionHandler` utilizando `@ControllerAdvice`. Isso padroniza os retornos de erro da API (como validações de campos e recursos não encontrados), melhorando a experiência do desenvolvedor front-end.
* **Automação de Regras de Negócio:**
    * **Disponibilidade Automática:** A disponibilidade do produto é derivada logicamente do status do estoque.
    * **Timestamps Automatizados:** Controle de `createdAt` e `updatedAt` gerenciado pela entidade, simplificando a camada de serviço.
* **Tipagem Forte com Enums:** Uso de `ProductType` para substituir strings puras, evitando erros de digitação e garantindo integridade nos tipos de produtos cadastrados.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+:** Linguagem base com recursos modernos.
* **Spring Boot 3:** Framework para agilidade no desenvolvimento e configuração.
* **Spring Data JPA:** Para abstração da camada de persistência e consultas ao banco.
* **Lombok:** Para redução de código boilerplate (Getters, Setters, Constructors).
* **Bean Validation (Hibernate Validator):** Para garantir a integridade dos dados de entrada.

---

## 📈 Evolução do Desenvolvimento

O histórico de commits reflete um progresso estruturado:

1.  **Fundação (MVP):** Criação da entidade `Product`, repositório JPA e endpoints CRUD básicos.
2.  **Refatoração para DTOs:** Implementação da camada de transferência de dados para maior segurança.
3.  **Resiliência:** Criação do sistema de tratamento de erros global e exceções personalizadas.
4.  **Enriquecimento de Domínio:** Adição de controle de estoque, enums e automação de timestamps.
5.  **Otimização de Lógica:** Simplificação do `ProductService` movendo responsabilidades lógicas para a própria entidade.

---

## 📋 Endpoints Principais

* `GET /products` - Lista todos os produtos com resposta formatada.
* `POST /products` - Cadastro de novos produtos com validação de campos.
* `PUT /products/{id}` - Atualização inteligente de atributos.
* `DELETE /products/{id}` - Remoção com tratamento de erro caso não exista.

---

## 📦 Como Executar

1. Clone o repositório:
```bash
   git clone git@github.com:juniorbonini/product-api.git

```bash
2. Certifique-se de ter o Maven e o JDK 17 instalados.
3. Execute a aplicação:
mvn spring-boot:run
```


👤 Autor
Luiz Augusto Bonini Junior — Backend Developer

"Construindo sistemas onde a lógica de negócio é automatizada e a arquitetura é a prioridade."
