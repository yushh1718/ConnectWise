# ConnectWise CRUD Application

This is a CRUD (Create, Read, Update, Delete) application built using Spring Boot. The application allows users to store their contacts along with options to update, view, and delete. The project uses MySQL as the database, Thymeleaf for dynamic HTML, and Tailwind CSS for styling. It also includes Node modules for front-end support.

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf (for dynamic HTML), Tailwind CSS (for styling)
- **Database**: MySQL
- **Node Modules**: For front-end development
- **Security**: OAuth2 integration (Google, GitHub)
- **Cloudinary**: For image upload management

## Prerequisites

Before running the application, ensure you have the following installed:

- **JDK 17 or later**: Spring Boot is built with Java, so you need to have the Java Development Kit installed.
- **MySQL**: You'll need to have MySQL installed and running locally or remotely.
- **Maven**: To build and run the Spring Boot project.

## Getting Started

Follow these steps to get the project up and running on your local machine.

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/yourusername/ConnectWise.git
cd ConnectWise
```

### 2. Set up MySQL Database

Make sure you have MySQL installed and running.

Create a database named connectwise:

```bash
CREATE DATABASE connectwise;
```

### 3. Update application.properties

Open src/main/resources/application.properties and update the following values to match your setup:

```bash
spring.datasource.url = jdbc:mysql://localhost:3306/connectwise
spring.datasource.username = root
spring.datasource.password = your_mysql_password

# OAuth2 credentials (Google, GitHub)
spring.security.oauth2.client.registration.google.client-id = YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret = YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.github.client-id = YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret = YOUR_GITHUB_CLIENT_SECRET

# Cloudinary Configuration
cloudinary.cloud.name = YOUR_CLOUDINARY_CLOUD_NAME
cloudinary.api.key = YOUR_CLOUDINARY_CLOUD_API_KEY
cloudinary.api.secret = YOUR_CLOUDINARY_CLOUD_API_SECRET
```

### 4. Install Node Modules

```bash
npm install
```

### 5. Build and Run the Application

Run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```
The application will run on http://localhost:8081.

### 6. Access the Application

Open your browser and go to:

```bash
http://localhost:8081
```



