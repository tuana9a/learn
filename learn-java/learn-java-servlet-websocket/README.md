# info

Learning java servlet websocket

# how to run

remove `.example` of `application.properties.example` and fill your configs

download `webapp-runner.jar` from [https://search.maven.org/artifact/com.heroku/webapp-runner/9.0.31.0/jar](https://search.maven.org/artifact/com.heroku/webapp-runner/9.0.31.0/jar)

## package

```shell
mvn package
```

## run

```shell
java -jar webapp-runner.jar --port 8080 target/*.war
```