# spring-jwt-security

A spring security implementation with Json Web Token

This repository includes three modules.
1. **common-lib** A shared common library includes some common security configuration
2. **jwt-token-service** A service which issues token. One need to provide a username / password and library to the (LoginInfoController) will generate jwt token. Currently username / password is hard coded in [application.properties](jwt-token-service/src/main/resources/application.properties)
