-- *******************************************
-- ************ INFORMACION ******************
-- *******************************************
-- Antes de ejecutar el proyecto por primera vez, hay que crear la BD (create database db_pruebas;)
-- Flyway crea el usuario y el esquema. 


-- *******************************************
-- ************ SCRIPT ***********************
-- *******************************************


-- *******************
-- ***** Usuario *****
-- *******************

CREATE TABLE schema_pruebas.usuario(
        id integer PRIMARY KEY,
        username text,
        password text
);
	

ALTER TABLE schema_pruebas.usuario OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.usuario TO username_pruebas;
        
        
-- *******************
-- ****** Nota *******
-- *******************        
        
CREATE TABLE schema_pruebas.nota(
        id integer PRIMARY KEY,
        titulo text,
        descripcion text
);
	

ALTER TABLE schema_pruebas.nota OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.nota TO username_pruebas;     

INSERT INTO schema_pruebas.nota (id,titulo,descripcion) VALUES 
	(1,'nota 1 Titulo','nota 1 Descripcion'),
	(2,'nota 2 Titulo','nota 2 Descripcion'),
	(3,'nota 3 Titulo','nota 3 Descripcion'),
	(4,'nota 4 Titulo','nota 4 Descripcion'),
	(5,'nota 5 Titulo','nota 5 Descripcion'),
	(6,'nota 6 Titulo','nota 6 Descripcion'); 