# jenkins

create `.env` from `.env.example`

## how to run

```bash
mkdir jenkins_home/
```

choose [standalone](#standalone) or [dockerd](#dockerd)

## standalone

only jenkins is up and running

```bash
ln -s docker-compose.standalone.yaml docker-compose.yaml
```

```bash
docker-compose up -d
```

## dockerd

jenkins will run with dockerd as its private docker backend for running docker jobs

```bash
ln -s docker-compose.dockerd.yaml docker-compose.yaml
```

```bash
docker-compose build
```

```bash
docker-compose up -d
```

## switch between standalone and dockerd

update existing symlink

```bash
ln -sf docker-compose.dockerd.yaml docker-compose.yaml
```

```bash
ln -sf docker-compose.standalone.yaml docker-compose.yaml 
```

## how to install plugin from command line

```bash
jenkins-plugin-cli --plugins "docker-plugin docker-workflow"
```

## how to reset password

[https://cuongquach.com/jenkins-huong-dan-reset-mat-khau-user-jenkins-admin.html](https://cuongquach.com/jenkins-huong-dan-reset-mat-khau-user-jenkins-admin.html)
