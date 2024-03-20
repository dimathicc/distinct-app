## База данных
```
docker run --name postgres_db -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres_db postgres:16
```
```
create table numbers
(
    id        bigserial
        primary key,
    distincts varchar(255),
    numbers   varchar(255),
    timestamp timestamp(6) with time zone
);
```

### Swagger
Также добавил swagger для удобства тестирования:
http://localhost:8080/swagger-ui/index.html#/
