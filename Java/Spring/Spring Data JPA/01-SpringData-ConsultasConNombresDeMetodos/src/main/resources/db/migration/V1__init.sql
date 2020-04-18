-- *******************************************
-- ************ INFORMACION ******************
-- *******************************************
-- Antes de ejecutar el proyecto por primera vez, hay que crear la BD (create database db_pruebas;)
-- Flyway crea el usuario y el esquema. 


-- *******************************************
-- ************ Usuario **********************
-- *******************************************


CREATE TABLE schema_pruebas.usuario(
        usuario_id integer PRIMARY KEY,
        usuario_nombre text,
        usuario_contraseña text
);

ALTER TABLE schema_pruebas.usuario OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.usuario TO username_pruebas;
        
CREATE SEQUENCE usuario_sequence
  start 1
  increment 1;        
        
