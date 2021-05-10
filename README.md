# Calculadora TEST. Diseño e implementacion

### Diseño del componente a desarrollar
Se nos pide desarrollar una calculadora con Spring Boot que realice las operaciones de suma y resta de dos operandos, teni�ndose en cuenta que podr� realizar otras operaciones m�s complejas en el futuro.

Inicialmente tendremos que crear un Controlador de tipo REST que implemente los metodos propios para la suma y la resta, y a su vez un servicio que lleve implementada la operativa aritm�tica, que invocar� el controlador REST.

Para esto la calculadora construida contiene 2 controladores, uno para operaciones básicas y otro para operaciones complejas, ambos apoyados en un servicio que realiza la lógica de calculo.

Para el desarrollo del servicio solicitado, se han usado las dependencias de spring-boot-starter-web, que provee de las librer�as necesarias para el desarrollo de interfaces REST, y adem�s las utilidades de DevTools que aportan algunas caracter�sticas interesantes como la publicaci�n de codigo en caliente, etc etc.

Tal y como se ha solicitado tambien se hace uso de JUNIT5 para la ejecucion de los tests, que seran desarrollados bajo metodolog�a TDD (Test Driven Development)

Nuestra APP es un servicio REST pero no RESTFUL ya que no se realizan operaciones de insercion, borrado o escritura, sino solo lectura.
Los controladores tanto básico como para operaciones más complejas aplican el principio de única responsabilidad y dejan toda la operativa en un servicio gestionado por Spring que es el que realiza la lógica de operaciones matemáticas.

Se ha decidio usar POST para las peticiones por comodidad y por frecuencia de uso, igualmente podrían haberse usado peticiones HTTP GET con parámetros para recepcionar los datos en la invocacion de los metodos de los controladores con @Requestparam en vez de @RequestBody que es más propio de JSON.

Al ser un controlador REST, se ha adaptado a Tracer para que imprima el json de respuesta a devolver por la API, de forma que siempre se tracee cualquier resultado de la operacion tras realizar las invocaciones oportunas.

### Construir JAR ejecutable
Para la construcción del JAR de la APP, solo tendremos que clonar el repo gitHub y ejecutar: 
**mvn clean install**

Esto nos construirá el JAR 'Calculator-0.0.1.jar' en la carpeta target.

### Ejecución/Arranque de la utilidad
En la propia carpeta en la que se generó el JAR, ejecutar bajo consola: 
**java -jar Calculator-0.0.1.jar**

### Swagger API URL
La documentacion de los metodos expuestos en la API se encontrará una vez lanzada la app en: http://localhost:8080/calculator/swagger-ui.html


### Referencias Spring Boot
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)


