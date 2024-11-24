# Mini C Compiler

This project is a mini C compiler that translates C code into assembly code.

## How to Compile

To compile a file, use the following command:

```sh
$ java -jar compiler.jar testfiles/example.in
```

## Project Structure

- `src/java/lang`: Contains the main compiler code.
- `src/test/lang`: Contains the test cases for the compiler.
- `build`: Contains the build outputs and reports.
- `testfiles`: Contains the test input files.

## Running Tests

To run the tests, use the following command:

```sh
$ ./gradlew test
```

## Dependencies

- JUnit: For running the test cases.
- Gradle: For building the project.

## Authors

- Adrian Steene
- Christoffer Sylve
