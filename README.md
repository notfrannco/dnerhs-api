#   dnerhs-api

_API REST Sistema DNERHS._

## Pre-requisitos

* OpenJDK 1.8+
* Maven 3.3+

## Configuraciones

* Crear en el PosgreSQL una base de datos con nombre dnerhs


### Base de datos

* Para la creación de la base de datos en modo desarrollo
se puede cambiar el valor de la siguiente propiedad
```
spring.jpa.hibernate.ddl-auto = update
```

Una vez desplegado el servicio, hibernate creará la estructura de la base de datos de acuerdo a las anotaciones de las entidades.

Los datos básicos para la aplicación se encuentran en el archivo import.sql.


## Deploy

#### Maven


```
mvn spring-boot:run

```

## Documentación

#### Swagger

Una vez iniciada la aplicación se puede acceder a la documentación mediante la url:

* http://localhost:8080/api/swagger-ui.html

### Test Endpoint

```
# curl -I  http://localhost:8080/
```

