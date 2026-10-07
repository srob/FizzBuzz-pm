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

Requires JDK 25 or newer and Maven. Maven targets Java 25 bytecode.
The first build needs access to Maven Central to download dependencies.

## Run tests

Choose **Terminal > Run Task > Test FizzBuzz**, or run:

```sh
mvn -Dtest=FizzBuzzTest test
```

Run all examples with `mvn test` or the **Test all examples** task.

## GitHub Actions CI

`.github/workflows/ci.yml` runs the FizzBuzz unit tests and Cucumber acceptance scenarios on pushes to `main`
and pull requests targeting `main`. You can also start it manually from
**Actions > FizzBuzz CI > Run workflow** on GitHub.

The job checks out the code, installs Temurin Java 25 (matching the compilation target in `pom.xml`),
caches Maven dependencies, and runs:

```sh
mvn --batch-mode --no-transfer-progress '-Dtest=FizzBuzzTest,FizzBuzzAcceptanceTest' test
```

`-Dtest=FizzBuzzTest,FizzBuzzAcceptanceTest` selects both FizzBuzz suites. Maven still compiles all
application and test sources in this shared project. A compile error elsewhere
can therefore fail this job, but PrimesTest and PlayerTest are not executed.
Any failing FizzBuzz test or acceptance scenario fails the job.
The run saves the Surefire results and Cucumber HTML report as the
`fizzbuzz-test-reports` artifact, including on test failures, for 14 days.
Download it from the workflow run page on GitHub to inspect the reports. Batch mode avoids interactive prompts;
no-transfer-progress keeps dependency download progress out of the logs.

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

## Local FizzBuzz acceptance tests

Cucumber-JVM uses readable Given/When/Then scenarios alongside the existing JUnit tests.
Cucumber 7.34.9 keeps the existing JUnit 4 runner supported without changing the project's test framework.

- `src/test/resources/features/fizzbuzz.feature`: three scenarios for scoring, alternating players, and score display.
- `src/test/java/FizzBuzzSteps.java`: steps that call the game and assert its results. Each scenario gets a fresh game, with an `@After` hook restoring captured console output even if a step fails.
- `src/test/java/FizzBuzzAcceptanceTest.java`: JUnit runner selecting only the FizzBuzz feature.

Choose **Terminal > Run Task > Test FizzBuzz acceptance**, or run:

```sh
mvn --batch-mode --no-transfer-progress -Dtest=FizzBuzzAcceptanceTest test
```

The readable HTML report is generated at `target/cucumber/fizzbuzz.html`.
To run both FizzBuzz suites, use:

```sh
mvn '-Dtest=FizzBuzzTest,FizzBuzzAcceptanceTest' test
```

`mvn test` includes the acceptance scenarios and all existing unit tests.
CI runs both FizzBuzz suites and saves their reports as a downloadable artifact.
