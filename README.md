# e-commerce microservices 

consul :

`consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=@IP`

vault:

`vault server -dev`

`set VAULT_ADDR=http://127.0.0.1:8200`

`vault kv put secret/vault-ms user.username=root user.password=1234`

`vault kv get secret/vault-ms`
