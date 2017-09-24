# Location Service Service

Created by 

Sample Service to track location

Note: This assumes that your environment is setup to use maven with cvent's internal nexus repository.  If not follow the instructions [here](https://wiki/display/DEV/Maven+Setup).

# IDE Support

Any IDE supports maven so feel free to use Netbeans, IntelliJ, Eclipse

# How to build locally
```
mvn package -Prelease
```
# How to check code coverage
```
mvn package -Pcoverage
```
# How to run locally
```
cd location-service-service
java -jar target/location-service-service-1.0.0-SNAPSHOT.jar server configs/dev.yaml
```

or

```
cd location-service-service
mvn exec:java
```

# How to access API docs

## Option 1
1. Use the mulesoft platform ```https://anypoint.mulesoft.com/login/#/signin```

## Option 2
1. Use the developer portal built-in api docs/console
2. Example: ```https://developers-staging.cvent.com/#/applications/1640/api```

# How to run integration tests locally
```
mvn -Prun-it -Denv.IT_ENVIRONMENT=dev verify
```
# How to get a report on unit test coverage

```
mvn clover:clover
```

open in browser ```target/site/clover/index.html```
