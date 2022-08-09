# Desafio Fullstack Spring Boot

![Build](https://github.com/tiageta/desafio-fullstack-springboot/actions/workflows/build.yml/badge.svg)

Esse projeto foi gerado com o [Angular CLI](https://github.com/angular/angular-cli) versão 13.3.6 e [Spring Boot](https://spring.io). A API também serve as páginas geradas pelo _build_ da aplicação, e usando `npm run install` na pasta `client`, é possível instalar os _node_modules_ para a aplicação Angular.

Você pode acessar uma versão de deploy hospedada no Heroku [aqui](https://ford-springboot-tiagolima.herokuapp.com), logando-se como `admin` com a senha `123`.

## Banco de dados MySQL

Um servidor MySQL está rodando em nuvem por meio do ClearDB e Heroku. Caso se queira alternar para um desenvolvimento local, as configurações do banco de dados devem ser ajustadas em `src/main/resources/application.yml`.
