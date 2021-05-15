use master
drop database PROYECTO
CREATE DATABASE PROYECTO 
USE PROYECTO 

CREATE TABLE USUARIO (
ID_USUARIO INT PRIMARY KEY,
NOMBRE VARCHAR (25),
APELLIDO VARCHAR(25),
USUARIO VARCHAR(30),
PASSWORD VARCHAR (20),
ID_ROL INT,
ACTIVO INT,
CODIGO INT
)



CREATE TABLE ROL(
ID_ROL INT PRIMARY KEY,
NOMBRE VARCHAR (20),
DESCRIPCION VARCHAR (25),

USUARIO_CREA VARCHAR (20),
USUARIO_MOD VARCHAR (20)
)

CREATE TABLE MODULO (
ID_MODULO INT PRIMARY KEY,
NOMBRE VARCHAR (25),
DESCRIPCION VARCHAR(25),

ID_MODULO_PADRE INT,
ACTIVO INT,
USUARIO_CREA VARCHAR(60),
USUARIO_MOD VARCHAR(50)
)


ALTER TABLE USUARIO
ADD FOREIGN KEY (ID_ROL) REFERENCES ROL(ID_ROL);

