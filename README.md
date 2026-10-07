# CSD Java examples

This Maven project contains FizzBuzz, prime numbers, and player refactoring examples.
Maven manages compilation and JUnit dependencies, removing the need for VSCode's unmanaged Java build.

## Open in VSCode

1. Open this folder, containing `pom.xml`.
2. Install the recommended **Extension Pack for Java** if prompted.
3. If the folder was already open, run **Developer: Reload Window** from the Command Palette.
4. Allow the Java extension to import the Maven project.
5. Open `src/test/java/FizzBuzzTest.java` and use **Run Test**, or use the Testing sidebar.

If VSCode still shows the old layout, run **Java: Clean Java Language Server Workspace** and allow it to restart.

Requires JDK 17 or newer and Maven. This machine has JDK 23 and Maven 3.9.9.
The first build needs access to Maven Central to download dependencies.

## Run tests

Choose **Terminal > Run Task > Test FizzBuzz**, or run:

```sh
mvn -Dtest=FizzBuzzTest test
```

Run all examples with `mvn test` or the **Test all examples** task.

Run the FizzBuzz demonstration using **Run** above `main` in `App.java`, or:

```sh
mvn compile
java -cp target/classes App
```

## Layout

- `src/main/java`: application and example classes; FizzBuzz is in `App.java`.
- `src/test/java`: existing JUnit 4 tests, including `FizzBuzzTest.java`.
- `target`: generated classes and test reports.

The old `bin` output and `lib` JUnit console jar are no longer used by Maven.
