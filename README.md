# Ticket Management Application

## **Overview**

The Ticket Management Application is a RESTful API built with Java 17 and Spring Boot 3. It provides functionalities to manage tickets, including creating, updating, deleting, and retrieving tickets with pagination and filtering. Additionally, the application can consume the GitHub API to fetch user profiles.

## **Features**
- CRUD operations for ticket management.
- Pagination support for retrieving tickets.
- Integration with the GitHub API to fetch user details.
- Configurable PostgreSQL database connection.
- Dockerized setup for running the application and database locally.

## **Technologies Used**
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Gradle**
- **Docker**
- **Lombok**
- **ModelMapper**
- **WebClient**

---

## **Setup Instructions**

### **1. Clone the Repository**
```bash
git clone https://github.com/your-repo/ticket-management.git
cd ticket-management
```

### **2. Prerequisites**
- **Java 17 installed**
- **Docker and Docker Compose installed**
- **Gradle installed (optional if using Docker)**

### **3. Running the Application Locally**
```bash
docker-compose build
docker-compose up
```

### **4. API Endpoints**
- 1. Download the Postman Collection: Open the email you received and download the attached Postman collection file.

- 2. Open Postman: Launch the Postman application on your computer.

- 3. Import the Collection:

  - Click on the "Import" button in the top-left corner of Postman.
  - Select the "File" tab and choose the downloaded collection file, or alternatively, paste the raw JSON of the collection into the "Raw Text" option.
- 4. Use the Collection: Once the collection is imported, you can find it in the left sidebar. You can now run the available API requests directly from Postman.

- ### **Ticket Management**
  - **Get All Tickets (Paginated) "GET /api/tickets"**
  - **Get Ticket by ID "GET /api/tickets/{id}"**
  - **Create a Ticket "POST /api/tickets
    Body: {
    "user": "JohnDoe",
    "status": "OPEN"
    }
    "**
  - **Update a Ticket "PUT /api/tickets/{id}
    Body: {
    "user": "JaneDoe",
    "status": "CLOSED"
    }
    "**
  - **Delete a Ticket "DELETE /api/tickets/{id}"**
  
- ### **GitHub User Search**
  - **Search GitHub Users "GET /api/users"**
  - **Search GitHub Users by Name "GET /api/users/{name}"**