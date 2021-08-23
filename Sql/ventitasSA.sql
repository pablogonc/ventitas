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
saldo float,
esAdmin boolean,
CONSTRAINT PK_usuario PRIMARY KEY (idUsuario),
CONSTRAINT FK_usuario FOREIGN KEY (idContacto) REFERENCES contacto(idContacto)
)ENGINE = InnoDB;

CREATE TABLE sucursal(
idSucursal int auto_increment,
direccion varchar(20),
telefono int,
mail varchar(40),
CONSTRAINT PK_sucursal PRIMARY KEY (idSucursal)
)ENGINE = InnoDB;

CREATE TABLE articulo(
idArticulo int auto_increment,
nombre varchar(30),
marca varchar(30),
descripcion varchar(30),
precio float,
CONSTRAINT PK_articulo PRIMARY KEY (idArticulo)
)ENGINE = InnoDB;

/* NO relacional
CREATE TABLE carrito(
idContacto int auto_increment,
direccion varchar(20),
telefono int,
mail varchar(40),
notificacion varchar(20),
CONSTRAINT PK_contacto PRIMARY KEY (idContacto)
)ENGINE = InnoDB;
*/
/* NO relacional
CREATE TABLE stock(
idContacto int auto_increment,
direccion varchar(20),
telefono int,
mail varchar(40),
notificacion varchar(20),
CONSTRAINT PK_contacto PRIMARY KEY (idContacto)
)ENGINE = InnoDB;
*/

CREATE TABLE adminSucursal(
idUsuarioSucursal int auto_increment,
idUsuario int,
idSucursal int,
CONSTRAINT PK_adminSucursal PRIMARY KEY (idUsuarioSucursal),
CONSTRAINT FK_adminSucursal_usuario FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
CONSTRAINT FK_adminSucursal_sucursal FOREIGN KEY (idSucursal) REFERENCES sucursal(idSucursal)
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
idArticuloXorden int,
idOrden int,
idArticulo int,
CONSTRAINT articuloXorden PRIMARY KEY (idOrden),
CONSTRAINT FK_articuloXorden_articulo FOREIGN KEY (idArticulo) REFERENCES articulo(idArticulo),
CONSTRAINT FK_articuloXorden_orden FOREIGN KEY (idOrden) REFERENCES orden(idOrden)
)ENGINE = InnoDB;



insert into sucursal values
(1,"Av. Medrano 951, C1179 AAQ, Buenos Aires",4452421,"medrano@gmail.com"),
(2,"Mozart 2300, C1407 CABA",4452421,"mozart@gmail.com");

insert into articulo values
(1,"PlayStation 4","sony","consola de juego",88999),
(2,"Dualshock 4","sony","control",10397),
(3,"Uncharted 4","Naughty Dog","para ps4",2299);

insert into contacto values
(1,"medrano 2040",4452421,"juan@gmail.com","mail"),
(2,"mozart 2040",44452421,"admin@gmail.com","mail"),
(3,"medrano 2040",4452421,"goncalves.pab@gmail.com","mail");

insert into usuario values
(null,1,"juan","1234",458,false),
(null,2,"admin","1234",850,true),
(null,3,"pablo","1234",1350,false);







