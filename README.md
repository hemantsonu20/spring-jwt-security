# spring-jwt-security

A spring security implementation with Json Web Token.

This repository includes three modules.
* **common-lib** A shared common library includes some common security configuration.

* **jwt-token-service** A service which issues token. One need to provide a username / password to the [LoginInfoController](jwt-token-service/src/main/java/com/github/spring/user/controller/LoginController.java) and it will generate jwt token. Currently username / password is hard coded in [application.properties](jwt-token-service/src/main/resources/application.properties) for simplicity.

* **resource-service** A service which resources are protected. See [ResourceController](resource-service/src/main/java/com/github/spring/resource/controller/ResourceController.java) for more details.
