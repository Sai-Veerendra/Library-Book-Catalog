# 📚 Library Book Catalog API 📖

A simple Java-based RESTful API for managing a library's book catalog, built with Spring Boot. This project demonstrates core Java concepts, OOP principles, and the development of a backend system with RESTful endpoints and database integration.

---

## ✅ Features

- Add a new book
- Get all books
- Get book by ID
- Delete a book
- Update book availability

---

## 📦 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Postman (for testing)

---

## 📁 Project Structure

```
LIBRARY-BOOK-CATALOG
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── LBC
│   │   │               ├── controller
│   │   │               │   └── BookController.java
│   │   │               ├── model
│   │   │               │   └── BookModel.java
│   │   │               ├── repository
│   │   │               │   └── BookRepository.java
│   │   │               └── service
│   │   │                   └── BookService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   │       └── templates
```

## ⚙️ How to Run the Project

### Prerequisites:
- Java 17 or higher
- MySQL database installed and running
- Maven
- IDE (like IntelliJ, VS Code)

### Step 1: Clone the Repository

```bash
git clone https://github.com/Sai-Veerendra/Library-Book-Catalog

cd LIBRARY-BOOK-CATALOG
````

### Step 2: Configure MySQL in `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Create a database named `library_db` in MySQL before starting.

```sql
CREATE DATABASE library_db;
```

### Step 3: Build and Run the Project

```bash
mvn clean install
mvn spring-boot:run
```

The application will start at:
📍 `http://localhost:8080/books`

---

## 📨 API Endpoints & Sample Requests

### 🔹 Add a New Book (POST) ➕

* `POST /books`

```json
{
    "title": "The Hitchhiker's Guide to the Galaxy",
    "author": "Douglas Adams",
    "isbn": "978-0345391803"
}
```

**Expected Response (200 OK):**

```json
{
    "id": 1,
    "title": "The Hitchhiker's Guide to the Galaxy",
    "author": "Douglas Adams",
    "isbn": "978-0345391803",
    "available": true
}
```

**Expected Response (400 Bad Request - if validation fails):**

```json
"Failed to add book"
```
(Example: if title, author, or isbn are empty)

---

### 🔹 Get All Books (GET) 📚

* `GET /books`

**Success Response:**

```json
[
    {
        "id": 1,
        "title": "The Hitchhiker's Guide to the Galaxy",
        "author": "Douglas Adams",
        "isbn": "978-0345391803",
        "available": true
    },
    {
        "id": 2,
        "title": "1984",
        "author": "George Orwell",
        "isbn": "978-0451524935",
        "available": true
    }
]
```

---

### 🔹 Get Book by ID (GET) 🔍

* `GET /books/{id}`
  e.g., `/books/1`

**If book exists: (200 OK)**

```json
{
    "id": 1,
    "title": "The Hitchhiker's Guide to the Galaxy",
    "author": "Douglas Adams",
    "isbn": "978-0345391803",
    "available": true
}
```

**If not found: (404 Not Found)**

```json
"Book not found"
```

---

### 🔹 Delete a Book (DELETE) 🗑️

* `DELETE /books/{id}`

**If success:  (200 OK)**

```json
"Book deleted"
```

**If not found: (404 Not Found)**

```json
"Book not found"
```

---

### 🔹 Update Book Availability (PATCH) 🔄

* `PATCH /books/{id}/availability?available=false`

**Success: (200 OK)**

```json
{
    "id": 1,
    "title": "The Hitchhiker's Guide to the Galaxy",
    "author": "Douglas Adams",
    "isbn": "978-0345391803",
    "available": false
}
```

**Failure: (404 Not Found)**

```json
"Update failed"
```

---

## 📬 Postman Collection

Test the complete API using the following Postman Collection:
🔗 [Postman Collection Link](https://veeru-7141959.postman.co/workspace/Veeru's-Workspace~77c5f722-40a5-4271-8520-d43585067196/collection/46704453-44789371-f783-4fff-8f9b-3fee3997af45?action=share&creator=46704453)

---

## ✍️ Notes

* Simple validation is added: `title`, `author`, and `isbn` must not be empty.
* The database auto-generates the book `id`.
* Availability is `true` by default when a new book is added.

---

## 🧑‍💻 Author

**Sai Veerendra Kotipalli**

- 📧 Email: [saiveerendrakotipalli@gmail.com](mailto:saiveerendrakotipalli@gmail.com)
- 💼 LinkedIn: [www.linkedin.com/in/sai-veerendra-kotipalli-31969b247](https://www.linkedin.com/in/sai-veerendra-kotipalli-31969b247/)
- 🐙 GitHub: [@Sai-Veerendra](https://github.com/Sai-Veerendra)

---

```
