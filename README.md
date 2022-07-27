# Integer Roman Conversion Service

An API that allows you to convert integers to roman, and roman to integers.<br>
Sprint Boot has been used to bootstrap the application.

## Prerequisites

- Java 8
- Gradle

## Run Tests

`gradle test`

## Build

`gradle build`

## Run

`java -jar build/libs/integer-roman-conversion-service-0.0.1-SNAPSHOT.jar`

It will start the server on port 8080.

## Usage

### To convert integer to roman

```
curl --location --request POST 'http://localhost:8080/convert/integer' \
--header 'Content-Type: application/json' \
--data-raw '{"integer":1560}'
```

### To convert roman to integer

```
curl --location --request POST 'http://localhost:8080/convert/roman' \
--header 'Content-Type: application/json' \
--data-raw '{"roman":"MM"}'
```

## TODO

- Add Swagger docs for the HTTP endpoints
- Add validation on the Service layer
- Add more logging, potentially in Service layer, and in Converters
- Create an ErrorResponse that will be returned in case of any Error
- Log HTTP req and res
- Add possibility to run on different port through var
