# API REST - Spring Boot

## Objetivo Geral
Desenvolver um API REST em ligugem Java, usando o framework Spring Boot e o gerenciador de dependências Maven.

---

## Decrição
A troca de mensagens é feita no formato JSON.

Foi usado a ferramenta Swagger para fazer a documentação automatizada dos recursos da API.

Esta API REST é um desenvolvimento básico com implementação de tratamentos de erros, autorização e autenticação com JWT, mas somente para o endpoint User.

O desenvolvedor deverá adionar os seus endpoints necessários para completar sua API.

---

## Software
Windows:

* [java version "1.8.0_241"](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
* [spring toll suite](https://spring.io/tools).
* [Apache Maven 3.6.3 ](https://maven.apache.org/guides/getting-started/windows-prerequisites.html).
* [Postman](https://www.postman.com/downloads/)

---

## Tecnologias
Como o Spring Boot é divido em módulos, foi usado os seguintes módulos:

1. [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web).
2. [Spring Boot Data JPA Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa).
3. [Spring Boot Developer Tools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools).
4. [H2 Database Engine](https://mvnrepository.com/artifact/com.h2database/h2).
5. [Spring Boot Security Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security).
6. [JSON Web Token Support For The JVM](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt).
7. [Spring Boot Mail Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail).
8. [Springfox Swagger2 » 2.9.2](https://mvnrepository.com/artifact/io.springfox/springfox-swagger2).
9. [Springfox Swagger UI » 2.9.2](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui).

---

## Meta

Lucio Pintanel – [Linkedin](https://www.linkedin.com/in/lucio-pintanel-89a68057/) – lm.pintanel@gmail.com

Distribuído sob a licença gpl-3.0. Veja `LICENSE` para mais informações.

[LICENSE](/licenses/gpl-3.0.txt)

---

## Execução
Após baixar o código fonte para seu PC entre na pasta do projeto e execute.

```sh
mvn spring-boot:run
```

No navegador de internet acessar a documentação da API executando a seguinte URL.

```sh
_http://localhost:9000/swagger-ui.html_
```

---

## Contributing

1. Faça o _fork_ do projeto (<https://github.com/yourname/yourproject/fork>)
2. Crie uma _branch_ para sua modificação (`git checkout -b feature/fooBar`)
3. Faça o _commit_ (`git commit -am 'Add some fooBar'`)
4. _Push_ (`git push origin feature/fooBar`)
5. Crie um novo _Pull Request_

---

## Referencia
Este projeto foi criado baseado no curso feito na Udemy, Prof. Dr. Nelio Alves
https://www.udemy.com/user/nelio-alves