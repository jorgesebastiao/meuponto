 
# Projeto de exemplo DDD Meu Ponto 

 Tecnologias utilizadas

**Front-end**
- Frameworks
 
  - Angular V 8.0.0
  - Angular Material(UI)
- Typescript 3.5.3

**Back-end**
- Java 11
- Gradle 5.2.1
- Spring Boot 2.1.6.RELEASE,
- Spring Security,
- Spring Data + JPA + Hibernate 
- flyway-db Para migração de dados 
- `springfox-swagger` Para gerar a UI da documentação dos serviços Rest

**Ambiente**
 - Docker

**Banco de dados**
 - mysql 8.0.0

Como executar ambiente Windows:

Utilizando imagen docker:
necessário ter instalado Docker

 navegar pelo termina(CMD) caminho  C:\Projetos\meuponto\meuponto-ws
 
 executar comando 'docker-compose up' 
 
 acessar através do link localhost:8080

Executando localmente:

necessario ter instalado:
- nodejs 12
- npm
- JDK JAVA 11
- Docker
- Gradle 5.2.1

navegar pelo termina(CMD) caminho  C:\Projetos\meuponto\meuponto-portal

executar o comando npm i e npm run build:prod

navegar pelo terminal ate  C:\Projetos\meuponto\meuponto\meuponto-portal

executar o comando  C:\Projetos\meuponto\meuponto-ws>gradlew.bat build

em seguida executar o comando  docker-compose -f docker-compose-dev.yaml up
 acessar através do link localhost:8080
 
**Dados de acesso**

 - email: admin@meuponto.com.br
 - senha: meuponto
 
# Referencias 
- [Detailed example text about DDD](https://www.mirkosertic.de/blog/2013/04/domain-driven-design-example/)
- [The DDD Sample project](https://github.com/citerus/dddsample-core)
- [Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Spring Dependency Injection](http://projects.spring.io/spring-framework/)
- [Spring Data JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Spring Data JPA Query Methods](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
- [Spring mediatR](https://github.com/jkratz55/spring-mediatR)
