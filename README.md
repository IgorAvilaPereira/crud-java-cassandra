# crud-java-cassandra

## Docker (Cassandra)

```sh
sudo docker pull cassandra
sudo docker run --name cassandra -p \
127.0.0.1:9042:9042 -p 127.0.0.1:9160:9160 -d cassandra
sudo docker exec -it cassandra cqlsh
```

## Database

```sql
CREATE KEYSPACE IF NOT EXISTS exemplo WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE exemplo;

CREATE TABLE exemplo.pessoa (
  cpf text primary key,
  nome text,
  nascimento date,
  gostos list<text>
);
```
