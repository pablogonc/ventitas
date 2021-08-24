drop database if exists VentitasSA;
create database VentitasSA;
use VentitasSA;

CREATE TABLE contacto(
idContacto int auto_increment,
direccion varchar(100),
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
saldo float,
esAdmin boolean,
CONSTRAINT PK_usuario PRIMARY KEY (idUsuario),
CONSTRAINT FK_usuario FOREIGN KEY (idContacto) REFERENCES contacto(idContacto)
)ENGINE = InnoDB;

CREATE TABLE sucursal(
idSucursal int auto_increment,
direccion varchar(100),
telefono int,
CONSTRAINT PK_sucursal PRIMARY KEY (idSucursal)
)ENGINE = InnoDB;

CREATE TABLE encargado(
idEncargado int auto_increment,
idSucursal int,
idUsuario int,
encargo varchar(100),
CONSTRAINT PK_encargado PRIMARY KEY (idEncargado),
CONSTRAINT FK_encargadoSucursal FOREIGN KEY (idSucursal) REFERENCES sucursal(idSucursal),
CONSTRAINT FK_encargadoUsuario FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
)ENGINE = InnoDB;

CREATE TABLE orden(
idOrden int auto_increment,
idScursal int,
idUsuario int,
precioEnvio float,
fechaPedido date,
confirmado boolean,
CONSTRAINT PK_orden PRIMARY KEY (idOrden),
CONSTRAINT FK_orden_sucursal FOREIGN KEY (idScursal) REFERENCES sucursal(idSucursal),
CONSTRAINT FK_orden_comprador FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
)ENGINE = InnoDB;

CREATE TABLE articuloXorden(
idArticuloXorden int auto_increment,
idOrden int,
idArticulo int,
CONSTRAINT articuloXorden PRIMARY KEY (idArticuloXorden),
CONSTRAINT FK_articuloXorden_orden FOREIGN KEY (idOrden) REFERENCES orden(idOrden)
)ENGINE = InnoDB;

CREATE TABLE articuloXsucursal(
idArticuloXsucursal int auto_increment,
idSucursal int,
idArticulo int,
stock int,
CONSTRAINT PK_articuloXsucursal PRIMARY KEY (idArticuloXsucursal),
CONSTRAINT FK_articuloXsucursal_sucursal FOREIGN KEY (idSucursal) REFERENCES sucursal(idSucursal)
)ENGINE = InnoDB;

insert into sucursal values
(1,"Av. Medrano 951, C1179 AAQ, Buenos Aires",4452421),
(2,"Mozart 2300, C1407 CABA",4452421);

insert into contacto values
(1,"medrano 2040",4452421,"goncalves.pab@gmail.com","mail"),
(2,"mozart 2040",44452421,"goncalves.pab@gmail.com","mail"),
(3,"medrano 2040",4452421,"goncalves.pab@gmail.com","mail");

insert into usuario values
(null,1,"juan","1234",458000,false),
(null,2,"admin","1234",850,true),
(null,3,"pablo","1234",1350,false);







