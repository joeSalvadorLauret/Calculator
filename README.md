# Calculadora TEST. Dise�o e implementacion

### Dise�o del componente a desarrollar
Se nos pide desarrollar una calculadora con Spring Boot que realice las operaciones de suma y resta de dos operandos, teni�ndose en cuenta que podr� realizar otras operaciones m�s complejas en el futuro.

Inicialmente tendremos que crear un Controlador de tipo REST que implemente los m�todos propios para la suma y la resta, y a su vez un servicio que lleve implementada la operativa aritm�tica, que invocar� el controlador REST.

Para el desarrollo del servicio solicitado, se han usado las dependencias de spring-boot-starter-web, que provee de las librer�as necesarias para el desarrollo de interfaces REST, y adem�s las utilidades de DevTools que aportan algunas caracter�sticas interesantes como la publicaci�n de codigo en caliente, etc etc.

Tal y como se ha solicitado tambi�n se hace uso de JUNIT5 para la ejecuci�n de los tests, que seran desarrollados bajo metodolog�a TDD (Test Driven Development)


### Referencias Spring Boot
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)


