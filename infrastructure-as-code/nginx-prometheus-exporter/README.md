# nginx-prometheus-exporter

* Expose the built-in metrics in NGINX/NGINX Plus:
  * For NGINX, expose the [stub_status page](https://nginx.org/en/docs/http/ngx_http_stub_status_module.html#stub_status) at `/stub_status` on port `8080`.
  * For NGINX Plus, expose the [API](https://nginx.org/en/docs/http/ngx_http_api_module.html#api) at `/api` on port `8080`.
* Configure Prometheus to scrape metrics from the server with the exporter. Note that the default scrape port of the exporter is `9113` and the default metrics path -- `/metrics`.
* Create `.env` from `.env.example`, edit it to match your setup.
* Then ```docker-compose up -d```
