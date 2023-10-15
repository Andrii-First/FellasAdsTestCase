# 🚀 FellasAds - Test Assignment 🚀

FellasAds is a Spring Boot application created as a test assignment for evaluating specific functionalities. The application focuses on the following tasks:

1. **Spring Boot Application**: A Spring Boot application is the foundation of FellasAds.

2. **Endpoint for Adding Domains**: The application features an API endpoint to add domains to a MySQL database.

3. **HTTP Status Code Check**: After adding a domain, the application checks for the correct HTTP status code (502). If the status code is correct, it sends a message to a Slack channel.

4. **Bearer Token Authorization Checker**: A simple Bearer token authorization checker has been implemented and is used for API calls.

5. **Daily Health Check Task**: A daily task checks the application's health and sends relevant information to a designated Slack channel.

6. **Unit Tests**: Unit tests have been included to ensure the functionality of the application.

## 🌟 Features

FellasAds was created to address the specific tasks outlined in the test assignment:

- **Spring Boot Application**: The application is built using Spring Boot, providing a robust foundation.

- **Domain Management**: An API endpoint allows users to add and manage domains.

- **HTTP Status Code Check**: The application monitors domains for a specific HTTP status code (502) and notifies a Slack channel if the condition is met.

- **Bearer Token Authorization**: Security is enhanced with a Bearer token authorization checker, ensuring secure API access.

- **Daily Health Check**: A daily task checks the application's health and provides relevant information to the designated Slack channel.

- **Unit Tests**: Unit tests have been implemented to validate the application's functionality.

## 💻 Technologies

FellasAds leverages the following technologies and libraries:

- Java
- Spring Boot
- MySQL
- [Other technologies]

## ⚙️ Installation

To get started with FellasAds, follow these installation steps:

1. Clone the repository:
    ```shell
    git clone https://github.com/Andrii-First/FellasAdsTestCase.git
    ```

2. Navigate to the project directory:
    ```shell
    cd fellasads
    ```

3. Configure application.properties:

   In the `application.properties` file, update the following configurations:

    - **Database Connection**: Modify database connection details.
    - **Bearer Token**: Enter the expected Bearer token for authentication.
    - **Slack Webhook URL**: Provide the Slack Webhook URL for message notifications.

4. Build and run the application:
    ```shell
    ./mvnw spring-boot:run
    ```

## 🚀 Usage

Use FellasAds to perform the tasks specified in the test assignment. Below is an example of adding a domain:

```shell
# Create a new domain
curl -X POST -H "Authorization: Bearer your-token" -d '{"name": "example.com"}' http://localhost:8080/domains
