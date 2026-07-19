# RestAssured Project

A comprehensive REST API testing project using **RestAssured** and **TestNG** frameworks.

## Project Overview

This project demonstrates API testing best practices including:
- GET requests
- POST requests (creating resources)
- PUT requests (updating resources)
- DELETE requests (removing resources)
- Request/Response validation
- API authentication with headers
- JSON path assertions

## Technologies Used

- **Java 8+**
- **RestAssured 5.4.0** - REST API testing library
- **TestNG 7.8.0** - Testing framework
- **Maven** - Build tool
- **Hamcrest** - Assertion matchers
- **Jackson** - JSON processing
- **Log4j 2** - Logging framework

## Project Structure

```
RestAssured_Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── DAY_1/
│       │       ├── HTTPRequest.java
│       │       └── HTTPRequestTest.java
│       └── resources/
├── pom.xml
├── testng.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6+
- Git

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/YOUR_USERNAME/RestAssured_Project.git
cd RestAssured_Project
```

2. **Install dependencies**
```bash
mvn clean install
```

3. **Run tests**
```bash
mvn test
```

## Test Cases

### HTTPRequest.java
CRUD operations on ReqRes API (requires API key):
- `getUsers()` - Fetch users from page 2
- `createUser()` - Create a new user
- `updateUser()` - Update user details
- `deleteUser()` - Delete user

### HTTPRequestTest.java
Public API testing (no authentication required):
- `TestGetPostsEndpoint()` - Fetch a single post
- `TestGetUsersEndpoint()` - Fetch all users
- `TestGetSingleUserEndpoint()` - Fetch a single user

## Running Specific Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=DAY_1.HTTPRequestTest

# Run with verbose output
mvn test -X
```

## API Endpoints Used

### JSONPlaceholder (Free, No Auth Required)
- `GET https://jsonplaceholder.typicode.com/posts/1`
- `GET https://jsonplaceholder.typicode.com/users`
- `GET https://jsonplaceholder.typicode.com/users/1`

### ReqRes (Requires API Key)
- `GET https://reqres.in/api/users?page=2`
- `POST https://reqres.in/api/users`
- `PUT https://reqres.in/api/users/{id}`
- `DELETE https://reqres.in/api/users/{id}`

## Configuration

### pom.xml
The project dependencies are configured in `pom.xml`. Key dependencies:
- RestAssured
- TestNG
- Hamcrest Matchers
- Jackson
- Log4j 2

### testng.xml
TestNG suite configuration for running all tests.

## Test Results

All tests are currently passing:
- **Tests Run**: 3
- **Failures**: 0
- **Errors**: 0
- **Build Status**: ✅ SUCCESS

## Common Issues & Solutions

### Issue: 401 Unauthorized Error
**Solution**: Ensure you're using a valid API key header or use free endpoints like JSONPlaceholder.

### Issue: Tests not running
**Solution**: 
1. Ensure test class follows naming convention (ends with `Test`)
2. Run `mvn clean compile` first
3. Check that `@Test` annotations are present

### Issue: Maven build fails
**Solution**: 
```bash
mvn clean install -U  # -U forces update of dependencies
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-tests`)
3. Commit changes (`git commit -m 'Add new test cases'`)
4. Push to branch (`git push origin feature/new-tests`)
5. Create a Pull Request

## License

This project is licensed under the MIT License - see LICENSE file for details.

## Author

- Your Name

## Resources

- [RestAssured Documentation](https://rest-assured.io/)
- [TestNG Documentation](https://testng.org/)
- [JSONPlaceholder API](https://jsonplaceholder.typicode.com/)
- [ReqRes API](https://reqres.in/)

## Contact

For questions or suggestions, please open an issue in the repository.
