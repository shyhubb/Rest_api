+ admin api

 http://localhost:8080/api/admin/deleteuser/{example@gmail.com}  // delete user by email

 http://localhost:8080/api/admin/findAllUser   // show all user + admin in system

 http://localhost:8080/api/admin/setrole/{email}   // change role admin by email


 + auth api

  http://localhost:8080/api/auth/login  // login

  http://localhost:8080/api/auth/register   // register account 

  
folder 
spring-jwt-project
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── config
│   │   │           │   ├── JwtAuthenticationFilter.java
│   │   │           │   ├── SecurityConfig.java
│   │   │           │   └── JwtTokenProvider.java
│   │   │           ├── controller
│   │   │           │   ├── AuthController.java
│   │   │           │   └── UserController.java
│   │   │           ├── dto
│   │   │           │   ├── LoginRequest.java
│   │   │           │   ├── RegisterRequest.java
│   │   │           │   └── UserResponse.java
│   │   │           ├── entity
│   │   │           │   ├── User.java
│   │   │           │   └── Role.java
│   │   │           ├── exception
│   │   │           │   ├── GlobalExceptionHandler.java
│   │   │           │   └── ResourceNotFoundException.java
│   │   │           ├── repository
│   │   │           │   ├── UserRepository.java
│   │   │           │   └── RoleRepository.java
│   │   │           ├── service
│   │   │           │   ├── AuthService.java
│   │   │           │   ├── UserService.java
│   │   │           │   └── impl
│   │   │           │       ├── AuthServiceImpl.java
│   │   │           │       └── UserServiceImpl.java
│   │   │           └── SpringJwtProjectApplication.java
│   │   └── resources
│   │       ├── application.properties
│   |
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── SpringJwtProjectApplicationTests.java
├── pom.xml
└── README.md
