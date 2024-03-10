# Cucumber BDD API Automation Framework | Rest Assured Project 

This repository contains a Java-based automation framework for testing Place APIs using Cucumber, JUnit, and RestAssured. The framework allows you to add and delete places through API calls and validate the responses.

**pom.xml dependencies used:**

```bash
<dependencies>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>7.14.0</version>
    </dependency>

    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>7.14.0</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>5.3.0</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.15.2</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.15.2</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.15.2</version>
    </dependency>

    <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <version>3.24.2</version>
    </dependency>

  </dependencies>
```

## Prerequisites

Before you can run this framework, you need to have the following installed:

- Java 17 or higher
- Maven

Ensure that JAVA_HOME and MAVEN_HOME are set up in your environment variables.

## Setup Instructions

1. **Clone the repository to your local machine:**

    ```bash
    git clone <repository-url>
    ```

2. **Navigate into the project directory:**

    ```bash
    cd <project-directory>
    ```

3. **Install the dependencies:**

    ```bash
    mvn clean install
    ```

## Running Tests

To run the tests, you can use the following Maven command:

```bash
mvn test
```
This command will trigger the TestRunner class to execute the Cucumber features defined under src/test/java/features.

## Test Reports
After running the tests, you can find the JSON report generated in target/jsonReports/cucumber-report.json. You can use any Cucumber report generator to visualize these results.

## Contributing
Contributions are welcome! If you'd like to contribute, please follow these steps:

1. **Fork the repository.**

2. **Create a new branch for your feature:**

```bash
git checkout -b feature/AmazingFeature
```

3. **Commit your changes:**

```bash
git commit -am 'Add some AmazingFeature'
```

4. **Push to the branch:**

```bash
git push origin feature/AmazingFeature
```

5. **Open a pull request.**

Please make sure your code adheres to the project's coding standards and include tests that cover your changes as much as possible.

## Acknowledgments
Special thanks to Rahul Shetty Academy for providing the API and resources used in this project.
