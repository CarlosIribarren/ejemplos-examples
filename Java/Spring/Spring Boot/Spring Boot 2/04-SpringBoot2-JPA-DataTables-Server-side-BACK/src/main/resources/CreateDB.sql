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


INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (1, 'n1', '2001-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (2, 'n2', '2002-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (3, 'n3', '2003-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (4, 'n4', '2004-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (5, 'n5', '2005-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (6, 'n6', '2006-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (7, 'n7', '2007-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (8, 'n8', '2008-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (9, 'n9', '2009-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (10, 'n10', '2010-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (11, 'n11', '2011-01-01');
INSERT INTO pruebaSchema.prueba(id, nombre, fecha) VALUES (12, 'n12', '2012-01-01');