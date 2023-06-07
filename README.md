# REST API for manage a simple "Employee" entity.

# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Spring Security

# Installation & Run
- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

# Note
- Don't Create Database By Default I will Pass the Database name IjonaDB
- jdbc:mysql://localhost:3306/IjonaDB?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
- Don't Forget to change your username and password  for your local

```
    server.port=8088
    jdbc:mysql://localhost:3306/IjonaDB?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
    spring.datasource.username=root
    spring.datasource.password=root
```

# STEPS :
- First we run the application
- Insert The roles through Hard coded
-   INSERT INTO role_master (id,name,status,is_delete) VALUES (1,'EMPLOYEE_ADMIN',1,0);

-   INSERT INTO role_master (id,name,status,is_delete) VALUES (2,'EMPLOYEE_FRONTEND',1,0);

-   INSERT INTO role_master (id,name,status,is_delete) VALUES (3,'EMPLOYEE_BACKEND',1,0); 

-   After that Do Sign Up Use Below Dummy Details
-   Then Do Sign In
-   Then Save the Employees In the Database



# API Root Endpoint
```
Sign Up :
           http://localhost:8080/Employee/api/v1/signup
           {
             "username":"prashantFrontEnd",
             "email":"imanandfrontENd@gmail.com",
             "password":"anandafront",
             "name":["EMPLOYEE_ADMIN"]
            }
```
```
Login :
                 http://localhost:8080/Employee/api/v1/signin

                 {
                   "username":"prashantFrontEnd",
                   "password":"anandafront"
                 }
                 
        Note : Please Copy the JWT Token and paste it into the Authentication
```
```
step 5 : save the employee :

http://localhost:8080/api/employee/saveemployee

{
    "employeeEmail": "Prashant@gmail.com",
    "employeeName": "Prashant Anand",
    "employeeDepartment": "CSE"
}
Note : Id Is Autogenerated

```
```
Step 6 : Get the Employee By Id

       http://localhost:8080/api/employee/getEmployeeById/{{id}}
```
```
Step 7 : getAllEmployee

       http://localhost:8080/api/employee/getAllEmployees
```
```

step 8 : For Delete
       http://localhost:8080/api/employee/deleteEmployee/{{id}}
   
```   

# Collaborators

- [Prashant Anand](https://github.com/annax3)
