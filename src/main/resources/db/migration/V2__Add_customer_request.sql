CREATE TABLE customer(
   id serial PRIMARY KEY,
   username VARCHAR (50) UNIQUE NOT NULL,
   email VARCHAR (355) UNIQUE NOT NULL
);