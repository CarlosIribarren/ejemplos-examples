-- *******************************************
-- ************ INFORMACION ******************
-- *******************************************
-- Antes de ejecutar el proyecto por primera vez, hay que crear la BD (create database db_pruebas;)
-- Flyway crea el usuario y el esquema. 


-- *******************************************
-- ************ Usuario **********************
-- *******************************************


CREATE TABLE schema_pruebas.usuario(
        usuario_nombre text PRIMARY KEY,
        usuario_contraseña text
);

ALTER TABLE schema_pruebas.usuario OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.usuario TO username_pruebas;    
        
-- *******************************************
-- ************ Rol **************************
-- *******************************************      
        
CREATE TABLE schema_pruebas.rol(
        rol_nombre text PRIMARY KEY
);        

ALTER TABLE schema_pruebas.rol OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.rol TO username_pruebas;  

-- *******************************************
-- ************ Usuarios_Roles ***************
-- *******************************************

CREATE TABLE schema_pruebas.usuarios_roles(
        usuarios_roles_usuario_nombre text REFERENCES schema_pruebas.usuario(usuario_nombre),
        usuarios_roles_rol_nombre text REFERENCES schema_pruebas.rol(rol_nombre),
        PRIMARY KEY (usuarios_roles_usuario_nombre,usuarios_roles_rol_nombre)
); 

ALTER TABLE schema_pruebas.usuarios_roles OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.usuarios_roles TO username_pruebas;

-- *******************************************
-- ************ Privilegios ******************
-- *******************************************              
        
CREATE TABLE schema_pruebas.privilegio(
        privilegio_nombre text PRIMARY KEY
);        

ALTER TABLE schema_pruebas.privilegio OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.privilegio TO username_pruebas;  

-- *******************************************
-- ************ Roles_Privilegios ************
-- *******************************************

CREATE TABLE schema_pruebas.roles_privilegios(
        roles_privilegios_rol_nombre text REFERENCES schema_pruebas.rol(rol_nombre),
        roles_privilegios_privilegio_nombre text REFERENCES schema_pruebas.privilegio(privilegio_nombre),
                PRIMARY KEY (roles_privilegios_rol_nombre,roles_privilegios_privilegio_nombre)
); 

ALTER TABLE schema_pruebas.roles_privilegios OWNER TO username_pruebas;
GRANT ALL ON TABLE schema_pruebas.roles_privilegios TO username_pruebas;
