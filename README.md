
# 📦 ProyectoBackend – Backend Documentado

## 📖 Descripción

Este módulo forma parte del proyecto **ProyectoBackend** y se encarga de la lógica de negocio y la gestión de datos. Implementa una API RESTful que permite interactuar con la base de datos y proporciona servicios esenciales para el funcionamiento del sistema.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java
- **Framework:** Spring Boot
- **Base de Datos:** (especificar, por ejemplo, MySQL o PostgreSQL)
- **ORM:** JPA (Java Persistence API)
- **Gestión de Dependencias:** Maven

## 📂 Estructura del Proyecto

```
com.backend/
├── MainApplication.java
├── controller/
│   ├── UserController.java
│   └── ProductController.java
├── service/
│   ├── UserService.java
│   └── ProductService.java
├── repository/
│   ├── UserRepository.java
│   └── ProductRepository.java
├── model/
    ├── User.java
    └── Product.java
```

## 📄 Detalles de Archivos

### MainApplication.java
Punto de entrada de la aplicación Spring Boot.

### controller/
Contiene los controladores que manejan las peticiones HTTP:
- **UserController.java:** Maneja el registro, login y gestión de usuarios.
- **ProductController.java:** Gestiona las operaciones CRUD sobre productos.

### service/
Contiene la lógica de negocio:
- **UserService.java:** Procesa datos y operaciones sobre usuarios.
- **ProductService.java:** Valida operaciones de productos, como cálculo de precios y stock.

### repository/
Interfaces para interactuar con la base de datos usando Spring Data JPA:
- **UserRepository.java:** Acceso a datos de usuarios.
- **ProductRepository.java:** Acceso a datos de productos.

### model/
Define las entidades del dominio:
- **User.java:** Atributos: id, nombre, correo, etc.
- **Product.java:** Atributos: id, nombre, precio, descripción, etc.
