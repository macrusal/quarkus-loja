# Tutorial / Quarkus Java
API Loja

# Arquitetura da Aplicação
* Java 11
* Git
* Quarkus
* Panache
* Hibernate
* Postgres
* TestConteiners
* Database Rider
* Approval Tests
* JUnit
* Swagger

```bash
.
├── README.md
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── quarkus-loja.iml
└── src
    ├── main
    │   ├── docker
    │   │   ├── Dockerfile.fast-jar
    │   │   ├── Dockerfile.jvm
    │   │   └── Dockerfile.native
    │   ├── java
    │   │   └── br
    │   │       └── com
    │   │           └── hibejix
    │   │               └── loja
    │   │                   ├── HelloResource.java
    │   │                   ├── domain
    │   │                   │   ├── Produto.java
    │   │                   │   └── dto
    │   │                   │       └── ProdutoDTO.java
    │   │                   └── resource
    │   │                       └── ProdutoResource.java
    │   └── resources
    │       ├── META-INF
    │       │   └── resources
    │       │       └── index.html
    │       └── application.properties
    └── test
        ├── java
        │   └── br
        │       └── com
        │           └── hibejix
        │               └── loja
        │                   ├── HelloResourceTest.java
        │                   ├── NativeHelloResourceIT.java
        │                   ├── ProdutoResourceTest.java
        │                   └── util
        │                       └── DatabaseLifeCycle.java
        └── resources
            └── ds-produtos.yml
```

# Swagger
http://localhost:8901/swagger-ui.html