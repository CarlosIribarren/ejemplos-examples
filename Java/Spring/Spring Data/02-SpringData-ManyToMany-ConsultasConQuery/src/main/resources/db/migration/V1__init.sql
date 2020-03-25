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
        
-- *******************************************
-- ************ Rol **************************
-- *******************************************      
        
CREATE TABLE schema_pruebas.rol(
        rol_id integer PRIMARY KEY,
        rol_nombre text
);        

ALTER TABLE schema_pruebas.rol OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.rol TO username_pruebas;

CREATE SEQUENCE rol_sequence
  start 1
  increment 1;   

-- *******************************************
-- ************ Usuarios_Roles ***************
-- *******************************************

CREATE TABLE schema_pruebas.usuarios_roles(
        usuarios_roles_usuario_id integer REFERENCES schema_pruebas.usuario(usuario_id),
        usuarios_roles_rol_id integer REFERENCES schema_pruebas.rol(rol_id),
        PRIMARY KEY (usuarios_roles_usuario_id,usuarios_roles_rol_id)
); 

ALTER TABLE schema_pruebas.usuarios_roles OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.usuarios_roles TO username_pruebas;

-- *******************************************
-- ************ Privilegios ******************
-- *******************************************              
        
CREATE TABLE schema_pruebas.privilegio(
        privilegio_id integer PRIMARY KEY,
        privilegio_nombre text
);        

ALTER TABLE schema_pruebas.privilegio OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.privilegio TO username_pruebas;

CREATE SEQUENCE privilegio_sequence
  start 1
  increment 1;   

-- *******************************************
-- ************ Roles_Privilegios ************
-- *******************************************

CREATE TABLE schema_pruebas.roles_privilegios(
        roles_privilegios_rol_id integer REFERENCES schema_pruebas.rol(rol_id),
        roles_privilegios_privilegio_id integer REFERENCES schema_pruebas.privilegio(privilegio_id),
                PRIMARY KEY (roles_privilegios_rol_id,roles_privilegios_privilegio_id)
); 

ALTER TABLE schema_pruebas.roles_privilegios OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.roles_privilegios TO username_pruebas;
