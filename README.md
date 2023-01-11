# Gestion de direcciones  Backend
Este proyecto tiene como objetivo el control de un gestor de direcciones de una empresa que realiza servicios domiciliarios en Colombia, Chile, Mexico y Argentina desde la creacion, manipulacion y visualizaciones de las direcciones de cada sede en su determinado pais.
## Requerimientos
Para correr este proyecto en un entorno diferente se describen a continuacion las caracteristicas del proyecto:

- Java version '11'
- Spring Boot version '2.7.6'
- Gradle 

### Las siguientes dependencias son usadas:

- implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
- implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
- implementation 'org.springframework.boot:spring-boot-starter-web'
- compileOnly 'org.projectlombok:lombok'
- developmentOnly 'org.springframework.boot:spring-boot-devtools'
- runtimeOnly 'com.oracle.database.jdbc:ojdbc8'
- annotationProcessor 'org.projectlombok:lombok'
- testImplementation 'org.springframework.boot:spring-boot-starter-test'

- implementation 'org.springdoc:springdoc-openapi-ui:1.6.9'

- implementation 'org.mapstruct:mapstruct:1.5.3.Final'
- annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.3.Final'
- implementation 'javax.validation:validation-api:2.0.1.Final'


### Los diferentes endpoints creados para este proyecto son:
 
-    POST http://localhost:8080/caddress
-    DELETE http://localhost:8080/caddress/delete/{{address_id}}
-    GET http://localhost:8080/caddress/getlist
-    GET http://localhost:8080/caddress/listdeleted
  - GET http://localhost:8080/caddress/listdeleted?isDeleted=false
  - GET http://localhost:8080/caddress/listdeleted?isDeleted=true
-   PUT http://localhost:8080/caddress/update/{{address_id}}
-    GET http://localhost:8080/caddress/getlist{{id}}
-  GET http://localhost:8080/caddress/citybyreg
- POST http://localhost:8080/caddress/createcountry
- GET http://localhost:8080/caddress/exportfile
- GET http://localhost:8080/caddress/regbycountry