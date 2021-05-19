# bookRESTAPI

## Steps :

- clone repository
- create database
- Run as `mvn clean install`
- Execute jar as `java -jar bookRest-0.0.1-SNAPSHOT.jar ` in your `~/PROJECT-HOME-DIRECTORY/target ` using command prompt

# CRUD REST-APIs :

- GET http://localhost:9991/api/book/{id} `get book by id`

- GET http://localhost:9991/api/books?author={authorName} `list of books for given author`
- GET http://localhost:9991/api/books/in?min={value}&max={value} `list of books in given price range`

- POST http://localhost:9991/api/book `create book when given in format`

```
{
    "name": "The Adventures of Duck and Goose",
    "author": "Sir Quackalot",
    "price": 100
}
```

- DELETE http://localhost:9991/api/book/{id} `delete book of given id`

- PUT http://localhost:9991/api/book `update book provided in followimg format based on id`

```
{
    "id": 1,
    "name": "The Adventures of Duck and Goose",
    "author": "Sir Quackalot",
    "price": 100
}
```

# Create database

## Steps :

- Execute h2 jar from m2 repository
- Connect to `jdbc:h2:~/bookdb`
- Create following table and insert records

```
CREATE TABLE BOOKS(
    ID INT PRIMARY KEY,
    TITLE VARCHAR(100),
    AUTHOR VARCHAR(100),
    PRICE INT
);

insert into
   books
values
   (
      1, 'The Adventures of Duck and Goose', 'Sir Quackalot', 100
   )
;
insert into
   books
values
   (
      3, 'More Fun with Duck and Goose', 'Sir Quackalot', 120
   )
;
insert into
   books
values
   (
      2, 'The Return of Duck and Goose', 'Sir Quackalot', 119
   )
;
insert into
   books
values
   (
      4, 'Duck and Goose on Holiday', 'Sir Quackalot', 100
   )
;
insert into
   books
values
   (
      5, 'The Return of Duck and Goose', 'Sir Quackalot', 199
   )
;
insert into
   books
values
   (
      6, 'The Adventures of Duck and Goose', 'Sir Quackalot', 189
   )
;
insert into
   books
values
   (
      7, 'My Friend is a Duck', 'A. Parrot', 149
   )
;
insert into
   books
values
   (
      8, 'Annotated Notes on the 'Duck
      and Goose' chronicles	', 'Prof Macaw', 89
   )
;
insert into
   books
values
   (
      9, 'DEMO1', '	abc', 1001
   )
;

SELECT * FROM BOOKS
```
