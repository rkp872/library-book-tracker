# Book Management API

## Project Description

The **Book Management API** is a RESTful service built using **Java** and **Spring Boot**. It allows users to manage a collection of books by providing endpoints for adding, updating, retrieving, and deleting books. The service includes features like pagination and filtering to enhance data retrieval capabilities.

## Features

- Add new books to the collection.
- Update existing book details.
- Retrieve details of a specific book by ID.
- Fetch all books with pagination and optional filtering by title, author, or genre.
- Delete a book by its ID.

## Technologies Used

- **Programming Language**: Java
- **Framework**: Spring Boot
- **Database**: MySQL
- **Tools**: Postman (for API testing)

## API Endpoints

### 1. Add a New Book
- **Endpoint**: `POST /api/v1/books`
- **Request Body**:
  ```json
  {
    "title": "Book Title",
    "author": "Author Name",
    "genre": "Genre",
    "price": 299.99,
    "description": "A brief description of the book."
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "title": "Book Title",
    "author": "Author Name",
    "genre": "Genre",
    "price": 299.99,
    "description": "A brief description of the book."
  }
  ```

### 2. Retrieve All Books (with Pagination and Filtering)
- **Endpoint**: `GET /api/v1/books`
- **Query Parameters**:
  - `page` (optional, default: 0)
  - `size` (optional, default: 10)
  - `title` (optional)
  - `author` (optional)
  - `genre` (optional)
- **Response**:
  ```json
  {
    "content": [
      {
        "id": 1,
        "title": "Book Title",
        "author": "Author Name",
        "genre": "Genre",
        "price": 299.99,
        "description": "A brief description of the book."
      }
    ],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 10
    },
    "totalPages": 5,
    "totalElements": 50
  }
  ```

### 3. Retrieve a Book by ID
- **Endpoint**: `GET /api/v1/books/{id}`
- **Response**:
  ```json
  {
    "id": 1,
    "title": "Book Title",
    "author": "Author Name",
    "genre": "Genre",
    "price": 299.99,
    "description": "A brief description of the book."
  }
  ```

### 4. Update a Book
- **Endpoint**: `PUT /api/v1/books/{id}`
- **Request Body**:
  ```json
  {
    "title": "Updated Book Title",
    "author": "Updated Author Name",
    "genre": "Updated Genre",
    "price": 399.99,
    "description": "An updated description of the book."
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "title": "Updated Book Title",
    "author": "Updated Author Name",
    "genre": "Updated Genre",
    "price": 399.99,
    "description": "An updated description of the book."
  }
  ```

### 5. Delete a Book
- **Endpoint**: `DELETE /api/v1/books/{id}`
- **Response**:
  ```json
  {
    "message": "Book deleted successfully."
  }
  ```

## Database Schema

### Table: `books`
| Column Name | Data Type       | Constraints         |
|-------------|-----------------|---------------------|
| id          | BIGINT          | PRIMARY KEY, AUTO_INCREMENT |
| title       | VARCHAR(255)    | NOT NULL            |
| author      | VARCHAR(255)    | NOT NULL            |
| genre       | VARCHAR(100)    | NOT NULL            |
| price       | DECIMAL(10,2)   | NOT NULL            |
| description | VARCHAR(500)    |                     |

## Example Insert Queries

```sql
INSERT INTO books (id, title, author, genre, price, description) VALUES
(1, 'The Alchemist', 'Paulo Coelho', 'Fiction', 299.99, 'A philosophical novel about self-discovery'),
(2, 'Atomic Habits', 'James Clear', 'Self-Help', 499.50, 'A guide to building good habits and breaking bad ones'),
(3, 'Becoming', 'Michelle Obama', 'Biography', 350.00, 'The memoir of the former First Lady of the United States');
-- Add 47 more entries as needed
```

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/book-management-api.git
   ```
2. Navigate to the project directory:
   ```bash
   cd book-management-api
   ```
3. Configure the database:
   - Update the `application.properties` file in the `src/main/resources` directory with your MySQL database credentials.
4. Build and run the project:
   ```bash
   mvn spring-boot:run
   ```
5. Access the API at `http://localhost:8080/api/v1/books`.

## Future Enhancements

- Add user authentication and authorization.
- Include bulk upload functionality for books.
- Add sorting capabilities to the `GET /api/v1/books` endpoint.
- Implement caching for frequently accessed data.
- Add support for multiple languages for book descriptions.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.

