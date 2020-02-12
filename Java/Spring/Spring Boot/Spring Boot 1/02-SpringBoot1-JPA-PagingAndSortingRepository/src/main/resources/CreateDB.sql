create database pruebaDB;
create user pruebaUser with password 'pruebaPass';
create tablespace pruebaSchema owner pruebaUser location 'D:\PostgreSQL\data';
set default_tablespace = pruebaSchema;
grant all privileges on database pruebaDB to pruebaUser;

CREATE TABLE pruebaSchema.pruebaTable
(
    id integer,
    nombre text,
    fecha date
)


ALTER TABLE pruebaSchema.prueba OWNER to pruebaUser;


INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (1, 'n1', '2011-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (2, 'n2', '2012-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (3, 'n3', '2013-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (4, 'n4', '2014-01-01');