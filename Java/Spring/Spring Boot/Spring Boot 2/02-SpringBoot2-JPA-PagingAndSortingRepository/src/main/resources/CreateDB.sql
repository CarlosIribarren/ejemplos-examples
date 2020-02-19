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
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (5, 'n5', '2015-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (6, 'n6', '2016-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (7, 'n7', '2017-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (8, 'n8', '2018-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (9, 'n9', '2019-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (10, 'n10', '2020-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (11, 'n11', '2021-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (12, 'n12', '2022-01-01');