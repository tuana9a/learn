# info

Learning java servlet

# prepare database

mysql

```sql
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```

```sql
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(8) NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
```

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