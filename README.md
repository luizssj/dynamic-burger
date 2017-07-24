# DynamicBurger

## Justificativas

### Frontend

Escolhi o Angular 4 pois:

* O Angular 4 tem a maior comunidade dos frameworks frontend e isso ajuda na hora de tirar dúvidas, corrigir bugs e no desenvolvimento do tooling em volta do framework.
* O Angular-CLI ajuda a configurar o projeto e gera código que repetido economizando tempo no dia-a-dia.

### Backend

* O principal framework é o Spring Boot, ele prioriza a convenção à configuração. Economizando bastante tempo de ramp-up do projeto e padroniza a configuração.
* O Hibernate é utilizado para acesso ao banco de dados. Ele garante a abstração da aplicação para o banco de dados, e também aumenta a produtividade do desenvolvedor.

## Executando local

### Frontend

É necessário ter instalado node 6+ e Angular CLI, segue como instalar usando nvm (Node Version Manger):

```sh
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.2/install.sh | bash
nvm install 6
npm install -g @angular/cli
```

E então, para subir o servidor de desenvolvimento:

```sh
cd dynamic-burger-web/
ng serve
```

E navegue para `http://localhost:4200/`

### Backend

É necessário ter o JDK 8 e Maven instalado. Para rodar:
```sh
cd dynamic-burger-api/
mvn spring-boot:run
```

## Executando Docker
