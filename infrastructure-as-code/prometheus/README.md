# prometheus

## setup

```bash
mkdir grafana-data
mkdir prometheus-data
```

```bash
chmod 777 grafana-data
chmod 777 prometheus-data
```

we need to create and set permissions because the default is `root:root` which cause permission denied error in container

## send test alert

```bash
curl -H 'Content-Type: application/json' -d '[{"labels":{"alertname":"test"}}]' http://127.0.0.1:9093/api/v1/alerts
```
