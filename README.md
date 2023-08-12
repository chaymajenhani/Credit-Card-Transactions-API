# Credit Card Transactions RESTful API

This project implements a RESTful API for managing credit card transactions. 
It allows you to list, filter, sort, and paginate credit card transactions.

## System Requirements

- Java 11 or higher
- Maven
- Git (optional)

## Installation and Setup

1. Clone the repository (if not done already):
   ```bash
   git clone https://github.com/chaymajenhani/Credit-Card-Transactions-API.git
3. Navigate to the project directory:
   ```bash
   cd Credit_Card_Transactions
5. Build the project using Maven:
   ```bash
   mvn clean install
   
## Running the Application
1. After successfully building the project, run the following command to start the Spring Boot application:
   ```bash
   mvn spring-boot:run
3. The application will be accessible at: http://localhost:8080

## Testing the API
You can use tools like curl or Postman to test the API. Below are some sample API requests:

- List transactions (with optional query parameters):
  ```bash
  GET http://localhost:8080/api/transactions?page=1&size=10&status=approved
- Sort transactions by amount:
  ```bash
  GET http://localhost:8080/api/transactions?page=1&size=10&sortField=amount
  
#### query parameters
- `page`: Page number for pagination.
- `size`: Number of items per page.
- `amount`: Filter transactions by amount.
- `merchant`: Filter transactions by merchant.
- `status`: Filter transactions by status (e.g., approved, refused, pending).
- `date`: Filter transactions by date.
- `sortFied`: Specify the property to sort by (e.g., amount, merchant, status) .



