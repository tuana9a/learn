# learn-ansible

Ansible is a configuration management.

## how to start

```bash
pip install -r requirements.txt
```

## `.example` files

there are `.example` files in all examples just copy and remove `.example` then modify it to fit your task.

## how to run

be sure to create `inventory.ini` from `inventory.ini.example` and edit it.

there are `playbook.yaml` files in all examples. how to run ?

```bash
ansible-playbook -i inventory.ini playbook.yaml
```
