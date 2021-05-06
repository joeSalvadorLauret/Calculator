# Calculadora TEST. Diseño e implementacion

### Diseño del componente a desarrollar
Se nos pide desarrollar una calculadora con Spring Boot que realice las operaciones de suma y resta de dos operandos, teniéndose en cuenta que podrá realizar otras operaciones más complejas en el futuro.

Inicialmente tendremos que crear un Controlador de tipo REST que implemente los métodos propios para la suma y la resta, y a su vez un servicio que lleve implementada la operativa aritmética, que invocará el controlador REST.

Para el desarrollo del servicio solicitado, se han usado las dependencias de spring-boot-starter-web, que provee de las librerías necesarias para el desarrollo de interfaces REST, y además las utilidades de DevTools que aportan algunas características interesantes como la publicación de codigo en caliente, etc etc.

Tal y como se ha solicitado también se hace uso de JUNIT5 para la ejecución de los tests, que seran desarrollados bajo metodología TDD (Test Driven Development)


### Referencias Spring Boot
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)


