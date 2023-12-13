# sonatype nexus

## nexus behind nginx reverse proxy

main nexus

```conf
server {
  listen 443 ssl;
  server_name nexus.tuana9a.com;
  ssl_certificate /etc/letsencrypt/live/tuana9a.com/fullchain.pem;
  ssl_certificate_key /etc/letsencrypt/live/tuana9a.com/privkey.pem;
  # allow large uploads of files - refer to nginx documentation
  client_max_body_size 1G;
  # optimize downloading files larger than 1G - refer to nginx doc before adjusting
  #proxy_max_temp_file_size 2G;
  location / {
    proxy_pass http://10.103.107.8:8081; # nexus port
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto https;
  }
}
```

nexus docker registry

```conf
server {
  listen 443 ssl;
  charset UTF-8;
  server_name registry2.tuana9a.com;
  client_max_body_size 1000m;
  ssl_certificate /etc/letsencrypt/live/tuana9a.com/fullchain.pem;
  ssl_certificate_key /etc/letsencrypt/live/tuana9a.com/privkey.pem;
  location / {
    proxy_pass http://10.103.107.8:5001; # nexus docker registry port (can configure)
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr; # pass on real client's IP
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto $scheme;
  }
}
```

## create docker registry (hosted)

[https://help.sonatype.com/repomanager3/nexus-repository-administration/formats/docker-registry/ssl-and-repository-connector-configuration](https://help.sonatype.com/repomanager3/nexus-repository-administration/formats/docker-registry/ssl-and-repository-connector-configuration)
