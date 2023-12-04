# GitLab

## **IMPORTANT**

- in production we should separate gitlab and gitlab runner on different machines (virtual machines) and should not share docker engine between them because gitlab runner can shutdown gitlab :poop:

- should register gitlab-runner with

```bash
gitlab-runner register
```

- gitlab will use port 22 for `git clone` command so default ssh port should be changed for default cloning behavior

- gitlab require at least **4 GB** of RAM to work
