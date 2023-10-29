# learn-java-hibernate

## how to run

download `webapp-runner.jar`
from [https://search.maven.org/artifact/com.heroku/webapp-runner/9.0.31.0/jar](https://search.maven.org/artifact/com.heroku/webapp-runner/9.0.31.0/jar)

place downloaded file in project folder

package

```shell
mvn package
```

run

```shell
java -jar webapp-runner-9.0.31.jar --port 8080 target/*.war
```