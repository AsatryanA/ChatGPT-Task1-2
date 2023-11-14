# Inventory Management Application

This is a simple Spring Boot application for managing an inventory system. It allows users to view a list of available
products, add new products, and update existing ones. The product information is persisted in a MySQL database using
Hibernate.

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- MySQL installed

### Installing

1. Clone the repository:

    ```bash
    git clone https://github.com/AsatryanA/ChatGPT-Task1-2
    ```

2. Open the project in your preferred IDE.

3. Configure the database properties in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
    spring.datasource.username=root
    spring.datasource.password=mysql
    ```


4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

The application should be running at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Get All Products

```http
GET /api/products
```

### Get Product by ID

```http
GET /api/products/{id}
```

### Add New Product

```http
POST /api/products
```
Request Body:
```json
{
   "name": "Product Name",
   "description": "Product Description",
   "price": 19.99,
   "quantity": 100
}
```
### Update Existing Product
    
```http
PUT /api/products/{id}
```
### Delete Product

```http
DELETE /api/products/{id}
```
## Built With
- Spring Boot - The web framework used
- Hibernate - Object-relational mapping framework
- MySQL - Database system

## Authors
Arsen Asatryan

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
