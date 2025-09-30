# 🚀 Projeto Nexus - API de Agendamento

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=openjdk) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen?style=for-the-badge&logo=spring) ![MongoDB](https://img.shields.io/badge/MongoDB-4479A1?style=for-the-badge&logo=mongodb&logoColor=white) ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

[![Deploy no Render](https://img.shields.io/badge/Deploy-Acessar%20API%20no%20Ar-blueviolet?style=for-the-badge)](https://nexus-yrm5.onrender.com)

---

## 📋 Sobre o Projeto

**Nexus** é uma API para um sistema de agendamento de consultas médicas, construída com as tecnologias mais modernas do ecossistema Spring. O projeto abrange o ciclo de vida completo de desenvolvimento de um backend, desde a concepção da API, conexão com banco de dados na nuvem, implementação de segurança, até o deploy final em uma plataforma de nuvem utilizando Docker.

---

## ✨ Funcionalidades Implementadas

-   **API REST Completa:** Implementação de um CRUD (Create, Read, Update, Delete) completo e funcional para 3 entidades principais:
    -   `Pacientes`
    -   `Clinicas`
    -   `Funcionarios`
-   **Segurança Robusta:** Utilização do **Spring Security** para proteger todos os endpoints da API. O acesso é controlado via autenticação **Basic Auth**.
-   **Paginação:** Os endpoints de listagem (`GET All`) são paginados para otimizar a performance e escalar para grandes volumes de dados de forma eficiente.
-   **Validação de Dados:** As entradas da API são validadas com o `Spring Validation` (`@Valid`), garantindo a integridade dos dados antes de chegarem à camada de negócio.
-   **Tratamento de Exceções Profissional:** Um manipulador de exceções global (`@ControllerAdvice`) foi implementado para capturar erros de negócio (ex: "recurso não encontrado", "dado duplicado") e retornar respostas JSON padronizadas e com os status HTTP corretos (`404`, `400`, etc.).
-   **Documentação Interativa (Swagger):** A API é 100% documentada com **SpringDoc OpenAPI**, gerando uma UI que permite visualizar e testar cada endpoint diretamente pelo navegador.
-   **Página de Apresentação:** Uma página inicial (`index.html`) servida pela aplicação, que funciona como um hub central do projeto.
-   **Deploy com Docker:** A aplicação foi conteinerizada com Docker para garantir um ambiente de execução consistente e facilitar o deploy em qualquer plataforma de nuvem.

---

## 💻 Tecnologias Utilizadas

-   **Backend:** Java 21, Spring Boot 3.3.0, Spring Security
-   **Banco de Dados:** Spring Data MongoDB, MongoDB Atlas (Cloud)
-   **Documentação:** SpringDoc OpenAPI (Swagger)
-   **Build:** Maven
-   **Deploy:** Docker, Render.com
-   **Testes:** Postman

---

## 🌐 Acesso e Testes

A aplicação foi implantada na plataforma Render e pode ser acessada publicamente.

-   **Página Inicial:**
    -   [`Pagina Inicial da aplicação`](https://nexus-yrm5.onrender.com)

-   **Documentação da API (Swagger):**
    -   [`Documentação SWAGGER`](https://nexus-yrm5.onrender.com/swagger-ui/index.html)

-   **Autenticação:**
    -   Para testar os endpoints protegidos (via Postman ou Swagger), solicite a autorização
