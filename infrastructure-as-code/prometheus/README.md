# prometheus

## setup

```bash
mkdir -p data/grafana
mkdir -p data/prometheus
sudo chown 472:0 data/grafana # user:group for grafana
sudo chown 65534:65534 data/prometheus # user:group for prometheus
```

we need to create and set permissions because the default is `root:root` which cause permission denied error in container

## send test alert

```bash
curl -H 'Content-Type: application/json' -d '[{"labels":{"alertname":"test"}}]' http://127.0.0.1:9093/api/v1/alerts
```
