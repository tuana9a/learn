# elastic search

## setup

```bash
mkdir certs/
mkdir confs/
```

## how to set init password for elastic user

```bash
echo 123412341234 | bin/elasticsearch-keystore add -xf "bootstrap.password"
```

generate a keystore file

```bash
docker run --rm -v /tmp/elasticsearch/:/usr/share/elasticsearch/config/ docker.elastic.co/elasticsearch/elasticsearch:7.17.10 bash -c 'echo 123412341234 | bin/elasticsearch-keystore add -xf "bootstrap.password"'
sudo cp /tmp/elasticsearch/elasticsearch.keystore confs/
```
