There is a tiny `employee information system` built using Spring Boot. Currently, the system accepts employee 
information as Employee objects from the client requests, but it lacks the validation of the Employee object attributes
that checks for correctness. The application owner doesn't want invalid data to be saved in the system, meaning the
employee information should be validated according to the given constraints. The REST API request is validated by using
the `@Valid` request Bean Validation or programmatically by implementing a custom request validator. This question deals
with setting up a custom request validator in order to validate a RESTful API request.

The given project has all the classes defined for accepting requests from clients and saving employee information into
the database. It also uses a custom request validator `EmployeeValidator` to validate each Employee request object 
before saving it into the database. However, the validator currently does nothing, meaning it doesn't report any errors 
upon receiving invalid data. Your task is to complete the implementation of this custom request validator class
`EmployeeValidator` so that it reports errors.

The validation constraints are given below:

1. `fullName`:
   * validation: check if it's null or empty
   * message: The fullName is a mandatory field
2. `mobileNumber`:
   * validation: check if it's null or not of 10 digits
   * message: The mobileNumber is a mandatory field
3. `emailId`:
   * validation: check if it's null or empty
   * message: The emailId is a mandatory field
   * validation: check if it doesn't contain the @ sign
   * message: The email should be in a valid email format
4. `dateOfBirth`:
   * validation: check if it's null or empty
   * message: The dateOfBirth is a mandatory field
   * validation: check if it's not in YYYY-MM-DD format
   * message: The dateOfBirth should be in YYYY-MM-DD format
NOTE: All the validation error messages must be reported in the same order as the corresponding field declaration order.

Here is an example of a valid employe data JSON object:
```json
{
  "fullName": "Foo Bar",
  "mobileNumber": 9837465792,
  "emailId": "test@gmail.com",
  "dateOfBirth": "1990-01-01"
}
```

There is a single REST API endpoint exposed for receiving employee information.

`POST` request to `/employee`:
* accepts an `Employee` object as a request body
* calls employee validator
* if there are no errors, then it returns status code 200
* if there are any errors, then `EmployeeValidationErrorHandler` returns a list of validation error messages 
 `List<FieldValidationMessage>` with status code 400

Your task is to complete the given project so that it passes all the test cases when running the provided *unit* tests.


## Example requests and responses
`POST` request to `/employee`

Request body:
```json
{
  "fullName": null,
  "mobileNumber": 0,
  "emailId": null,
  "dateOfBirth": null
}
```

The response code is 400, and when converted to JSON, the response body is:

```json
[
  {
    "message": "The fullName is a mandatory field"
  },
  {
    "message": "The mobileNumber is a mandatory field"
  },
  {
    "message": "The emailId is a mandatory field"
  },
  {
    "message": "The dateOfBirth is a mandatory field"
  }
]
```

`POST` request to `/employee`

Request body:

```json
{
  "fullName": "",
  "mobileNumber": 0,
  "emailId": "",
  "dateOfBirth": ""
}
```

The response code is 400, and when converted to JSON, the response body is:

```json
[
  {
    "message": "The fullName is a mandatory field"
  },
  {
    "message": "The mobileNumber is a mandatory field"
  },
  {
    "message": "The emailId is a mandatory field"
  },
  {
    "message": "The dateOfBirth is a mandatory field"
  }
]
```

`POST` request to `/employee`

Request body:

```json
{
  "fullName": "Foo Bar",
  "mobileNumber": 123456789,
  "emailId": "test@gmail.com",
  "dateOfBirth": "1990-01-01"
}
```

The response code is 400, and when converted to JSON, the response body is:

```json
[
  {
    "message": "The mobileNumber is a mandatory field"
  }
]
```

`POST` request to `/employee`

Request body:

```json
{
  "fullName": "Foo Bar",
  "mobileNumber": 1234567891,
  "emailId": "test-At-gmail.com",
  "dateOfBirth": "1990-01-01"
}
```
The response code is 400, and when converted to JSON, the response body is:

```json
[
  {
    "message": "The emailId should be in a valid email format"
  }
]
```

`POST` request to `/employee`

Request body:

```json
{
  "fullName": "Foo Bar",
  "mobileNumber": 1234567891,
  "emailId": "test@gmail.com",
  "dateOfBirth": "1990/01/01"
}
```

The response code is 400, and when converted to JSON, the response body is:

```json
[
  {
    "message": "The dateOfBirth should be in YYYY-MM-DD format"
  }
]
```

`POST` request to `/employee`

Request body:
```json
{
  "fullName": "Foo Bar",
  "mobileNumber": 1234567891,
  "emailId": "test@gmail.com",
  "dateOfBirth": "1990-01-01"
}
```

The response code is 200. This adds a new object to the database with the given properties and id 1.