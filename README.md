# DynamicBurger



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

É necessário ter o JDK 7 e Maven instalado. Para rodar:
```sh
cd dynamic-burger-api/
mvn spring-boot:run
```

## Executando Docker