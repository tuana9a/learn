# file-servlet

simple file servlet support caching and etc

# how to run

```shell
# package the project
mvn package
```

```shell
# then run it
PORT=8080 ROOT_FOLDER=. java -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
```
