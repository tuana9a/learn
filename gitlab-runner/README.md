# gitlab-runner

see `config.toml.example` for default config generated by gitlab-runner after register

## How to register gitlab runner

```bash
gitlab-runner register \
  --non-interactive \
  --url "https://gitlab.com/" \
  --registration-token "PROJECT_REGISTRATION_TOKEN" \
  --executor "docker" \
  --docker-image ubuntu:18.04 \
  --description "" \
  --maintenance-note "" \
  --tag-list "docker,local" \
  --run-untagged="true" \
  --locked="false" \
  --access-level="not_protected"
```

## Tips

### **make job access host's dockerd**

```toml
concurrent = 1
check_interval = 3

[session_server]
  session_timeout = 1800

[[runners]]
  url = "https://gitlab.com"
  token = "YOURTOKEN"
  executor = "docker"
  [runners.custom_build_dir]
  [runners.cache]
    [runners.cache.s3]
    [runners.cache.gcs]
    [runners.cache.azure]
  [runners.docker]
    tls_verify = false
    image = "ubuntu:18.04"
    privileged = false
    disable_entrypoint_overwrite = false
    oom_kill_disable = false
    disable_cache = false

    # default it has only /cache
    # adding volume for docker make job can access host's dockerd
    volumes = ["/cache", "/var/run/docker.sock:/var/run/docker.sock"]

    shm_size = 0
```

### **job run in unsafe mode (root user access)**

this useful for some image like **docker:dind** if you need to spin a temp dockerd for your CI/CD

but I personaly like the way [above](#make-job-access-hosts-dockerd) because two has some security issue but mounting docker seems more extensible and convenient

```toml
concurrent = 1
check_interval = 3

[session_server]
  session_timeout = 1800

[[runners]]
  url = "https://gitlab.com"
  token = "YOURTOKEN"
  executor = "docker"
  [runners.custom_build_dir]
  [runners.cache]
    [runners.cache.s3]
    [runners.cache.gcs]
    [runners.cache.azure]
  [runners.docker]
    tls_verify = false
    image = "ubuntu:18.04"

    # default is false but set to true for purpose
    privileged = true

    disable_entrypoint_overwrite = false
    oom_kill_disable = false
    disable_cache = false
    volumes = ["/cache"]
    shm_size = 0
```
