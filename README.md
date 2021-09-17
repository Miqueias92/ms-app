# Microserviços Java com Spring Boot

#### Miqueias Sousa

https://www.linkedin.com/in/miqueias-sousa/

## Executando o projeto no docker

1º Clone esse projeto

``` 
git clone git@github.com:Miqueias92/ms-app.git
```

2º Navegue até a pasta do microserviço 
```
cd /ms-candidate 
```

3º Execute o comando para gerar a build
```
./mvnw clean package
``` 

4º Execute o camando para gerar a imagem docker
```
docker build -t ms-candidate:v1 .
```

5º Crie e execute o container

```
docker run -d --name ms-candidate --network host -p 8181:8181 ms-candidate:v1
```
6º Abra o seu navegador na url 

http://localhost:8181/swagger-ui.html
