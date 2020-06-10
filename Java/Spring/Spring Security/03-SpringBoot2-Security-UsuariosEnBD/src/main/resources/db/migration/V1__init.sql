-- *******************************************
-- ************ INFORMACION ******************
-- *******************************************
-- Antes de ejecutar el proyecto por primera vez, hay que crear la BD (create database db_pruebas;)
-- Flyway crea el usuario y el esquema. 


-- *******************************************
-- ************ SCRIPT ***********************
-- *******************************************


CREATE TABLE schema_pruebas.usuario(
        id integer PRIMARY KEY,
        username text,
        password text
);
	

ALTER TABLE schema_pruebas.usuario OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.usuario TO username_pruebas;
        