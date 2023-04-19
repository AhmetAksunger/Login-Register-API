# Login-Register-API

Login Register API coded in Java using Java Spring Boot,Swagger and PostgreSQL.

### Spring Boot Dependencies
   - Spring Boot Dev Tools
   - Lombok
   - Spring Web
   - Spring Data JPA
   - Validation
   - PostgreSql Driver
   - Thymeleaf
   - SpringMVC
   
   
### API Controllers and Methods
   - **user-controller**
      - add
      - remove
      - update
      - getall
      - getbyid
      - getbyfirstname
      - getbylastname
      - getbyfirstnameorlastname
   - **register-controller**
      - register
   - **login-controller**
      - login
   - **change-log-controller**
      - getbyid (user id)
      - getall
      - getByFirstNameOrLastName

### UI Urls
   - **Login Form** : http://localhost:8080/loginform
   - **Register Form** : http://localhost:8080/registerform
   - **User List**: http://localhost:8080/list
   - **Add Form**: http://localhost:8080/addform
   - **Update Form**: http://localhost:8080/updateform?id= 

To access the swagger: http://localhost:8080/swagger-ui/index.html#/

**Here are some screenshots of the API**

## Swagger
User-Controller is the API for admins.

![main](https://user-images.githubusercontent.com/116587797/230489830-e4c848f2-9618-43dc-8742-4770f895cae5.png)

## Login Form
![login](https://user-images.githubusercontent.com/116587797/232918589-9d80510b-b11a-4215-a4a4-47ec25162d2c.png)

## Register Form
![register](https://user-images.githubusercontent.com/116587797/232918639-443f42e7-cc42-44ea-a99e-08133afcdbc7.png)

## User List
![userslist](https://user-images.githubusercontent.com/116587797/232918669-dfe452b6-a554-4409-86c3-08d4d48afe86.png)

## Add User Form
![add user form](https://user-images.githubusercontent.com/116587797/232918702-9b4d0762-5780-4165-a33c-02e4d64142f7.png)

## Update User Form
![update user](https://user-images.githubusercontent.com/116587797/232918731-acec4c34-9fc7-4472-ad15-4bb70c2c2668.png)

## Logs
![logs](https://user-images.githubusercontent.com/116587797/233120755-37ec8fc2-386e-45d7-9d6c-007ef89d2a67.png)


## users Table

![PostgreTable](https://user-images.githubusercontent.com/116587797/229370540-b24d90a9-9f44-49d8-a891-75fa4f617aeb.png)

## change_logs Table

![changelog table](https://user-images.githubusercontent.com/116587797/230490327-ea3da5e6-1905-4526-aabf-9cad1d88f613.png)
