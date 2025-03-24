This is a demonstration of the Test Retry Gradle Plugin's compatibility with various testing styles and libraries. In particular, it highlights the current issues with Cucumber tests and shows which approaches work as expected.

The primary issue is tracked in:
https://github.com/gradle/test-retry-gradle-plugin/issues/279

Additional context can be found in:
- https://github.com/gradle/test-retry-gradle-plugin/issues/276
- https://github.com/gradle/test-retry-gradle-plugin/issues/277
- https://github.com/gradle/test-retry-gradle-plugin/issues/278
- https://github.com/gradle/cucumber-companion/issues/149

## Reproduction and Status

Each subproject represents one testing configuration.

Each subproject contains two tests:
- **All Pass**: (2 tests which both pass)
- **Some Fail**: (1 test passes, 1 test fails)

Each subproject configures the Test Retry plugin to retry failed tests once.

Run the following command to test each configuration:

```
./gradlew test --continue
```

Expected Behavior:
- Passing tests run once.
- The failing test runs twice.

Actual Behavior:

<table>
<tr>
<th>Test Style</th>
<th>Discovery Method</th>
<th>Gradle Execution Mode</th>
<th>Gradle Test Retry Plugin Compatibility</th>
</tr>
<tr>
    <td rowspan="3">class-based</td>
    <td><b>JUnit 4</b></td>
    <td>Classic</td>
    <td>✅ Only retries failed tests</td>
</tr>
<tr>
    <td><b>JUnit 4</b></td>
    <td>Platform</td>
    <td>✅ Only retries failed tests</td>
</tr>
<tr>
    <td><b>JUnit 5</b></td>
    <td>Platform</td>
    <td>✅ Only retries failed tests</td>
</tr>
<tr>
    <td rowspan="4">cucumber</td>
    <td><a href="https://github.com/gradle/cucumber-companion"><b>Cucumber Companion</b></a><br><i>generates a JUnit 5 suite class for each feature file</i></td>
    <td>Platform</td>
    <td>❌ Retries all suites/features</td>
</tr>
<tr>
    <td><b>JUnit 4</b><br><i>using Cucumber's JUnit 4 runner</i></td>
    <td>Classic</td>
    <td>✅ Only retries failed <b>scenarios</b></td>
</tr>
<tr>
    <td><b>JUnit 4</b><br><i>using Cucumber's JUnit 4 runner</i><br><i>(executed via the Vintage Engine)</i></td>
    <td>Platform</td>
    <td>❌ Retries suite (all features)</td>
</tr>
<tr>
    <td><b>JUnit 5</b><br><i>using Cucumber's JUnit 5 engine</i><br><i>(@Suite and @SelectClasspathResource based)</i></td>
    <td>Platform</td>
    <td>❌ Retries suite (all features)</td>
</tr>
</table>
