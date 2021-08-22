drop database if exists VentitasSA;
create database VentitasSA;
use VentitasSA;

CREATE TABLE contacto(
idContacto int auto_increment,
direccion varchar(20),
telefono int,
mail varchar(40),
notificacion varchar(20),
CONSTRAINT PK_contacto PRIMARY KEY (idContacto)
)ENGINE = InnoDB;


CREATE TABLE usuario(
idUsuario int auto_increment,
idContacto int,
nombreUsuario varchar(20),
contrasenia varchar(20),
esAdmin boolean,
CONSTRAINT PK_usuario PRIMARY KEY (idUsuario),
CONSTRAINT FK_usuario FOREIGN KEY (idContacto) REFERENCES contacto(idContacto)
)ENGINE = InnoDB;

insert into contacto values
(1,"medrano 2040",4452421,"juan@gmail.com","mail"),
(2,"mozart 2040",44452421,"admin@gmail.com","mail"),
(3,"medrano 2040",4452421,"goncalves.pab@gmail.com","mail");

insert into usuario values
(null,1,"juan","1234",false),
(null,2,"admin","1234",true),
(null,3,"pablo","1234",false);








