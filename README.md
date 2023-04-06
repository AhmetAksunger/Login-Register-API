# Login-Register-API

Login Register API coded in Java using Java Spring Boot,Swagger and PostgreSQL.

### Spring Boot Dependencies
   - Spring Boot Dev Tools
   - Lombok
   - Spring Web
   - Spring Data JPA
   - Validation
   - PostgreSql Driver
   
   
Hashes the passwords before saving into PostgreSQL, handles the case
where user tries to register with an email that already has been registered before.


Also checks whether user entered a valid age or not. (A valid age is 18<= age < 100)


Also checks whether user entered a valid password. (A valid password must be longer than 5 chars and must include at least one digit)


To access the API ui: http://localhost:8080/swagger-ui/index.html#/

**Here are some screenshots of the API**


## Main API
User-Controller is the API for admins. It includes 7 different methods

![main](https://user-images.githubusercontent.com/116587797/230489830-e4c848f2-9618-43dc-8742-4770f895cae5.png)


## Login API

![login](https://user-images.githubusercontent.com/116587797/229370494-a3348389-9c06-4dbf-b185-bccfd342023d.png)
![loginResponse](https://user-images.githubusercontent.com/116587797/229370505-1622349f-5de3-4495-a9ea-ffa68e48d5b3.png)

## Register API

![register](https://user-images.githubusercontent.com/116587797/229370521-f62d64f5-8883-4e39-8694-f048358b0cd6.png)
![registerResponse](https://user-images.githubusercontent.com/116587797/229370526-285ae780-e02e-434a-aae7-366c6d235206.png)

## ChangeLog API - Get All Result

This is how get all result looks like in change log api

![getall](https://user-images.githubusercontent.com/116587797/230490057-ac55b17a-88fc-4dde-999b-11210811bcac.png)


## users Table

![PostgreTable](https://user-images.githubusercontent.com/116587797/229370540-b24d90a9-9f44-49d8-a891-75fa4f617aeb.png)

## change_logs Table

![changelog table](https://user-images.githubusercontent.com/116587797/230490327-ea3da5e6-1905-4526-aabf-9cad1d88f613.png)
