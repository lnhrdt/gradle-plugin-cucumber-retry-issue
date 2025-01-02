Issue reproduction for:
- https://github.com/gradle/test-retry-gradle-plugin/issues/278
- https://github.com/gradle/cucumber-companion/issues/149

## Reproduction

The repo has three subprojects:
1. `just-junit`
2. `suite`
3. `cucumber`

Each subproject contains two tests (one passing, one failing) and configures the Test Retry plugin to retry failed tests once.

Run this command to reproduce the issue:

```
./gradlew test --continue
```

Expected Behavior:
- Passing tests run once in each subproject.
- Failing tests run twice in each subproject.

Observed Behavior:
- `just-junit` and `suite`: Passing tests run once and failing tests retry correctly.
- `cucumber`: Passing tests incorrectly run twice.
