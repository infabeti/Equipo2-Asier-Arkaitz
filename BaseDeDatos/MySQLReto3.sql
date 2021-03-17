CREATE DATABASE equipo2hosteleria_dam COLLATE utf8mb4_spanish_ci;
GRANT ALL ON equipo2hosteleria_dam.* TO dam;

USE equipo2hosteleria_dam;

CREATE TABLE local
(nif char(9) primary key,
nombre varchar(40) unique not null,
nombre_propietario varchar(40) not null,
tipo enum ('BAR', 'CAFETERIA', 'RESTAURANTE') not null,
direccion varchar(40) unique not null);

CREATE TABLE usuario
(dni char(9) primary key,
contraseña varchar(20) not null,
nombre varchar(20) not null,
apellido varchar(20) not null,
nif_local char(9),
CONSTRAINT fk_nif_local_usuario FOREIGN KEY (nif_local) references local(nif) );

CREATE TABLE producto
(nombre varchar(40) primary key,
tipo enum ('BEBIDA', 'COMIDA', 'OTROS', 'INGREDIENTE') not null,
fecha_caducidad date,
precio_venta float,
precio_compra float not null,
alergeno enum ('GLUTEN', 'MARISCO', 'FRUTOS SECOS'));

CREATE TABLE ticket
(num_trans int auto_increment primary key,
fecha date not null,
nif_local char(9) not null,
tipo enum ('TICKET', 'FACTURA', 'PEDIDO', 'APROVISIONAMIENTO', 'COMANDA') not null, 
CONSTRAINT fk_nif_local_ticket FOREIGN KEY (nif_local) references local(nif) );

CREATE TABLE tiene
(nif_local char(9),
nombre_producto varchar(40),
cantidad int not null,
CONSTRAINT pk_tiene PRIMARY KEY (nif_local, nombre_producto),
CONSTRAINT fk_nif_local_tiene FOREIGN KEY (nif_local) references local(nif),
CONSTRAINT fk_nombre_producto_tiene FOREIGN KEY (nombre_producto) references producto(nombre) );

CREATE TABLE incluye
(nombre_producto varchar(40),
num_trans int,
cantidad int not null,
precio float not null,
CONSTRAINT pk_incluye PRIMARY KEY (nombre_producto, num_trans),
CONSTRAINT fk_nombre_producto_incluye FOREIGN KEY (nombre_producto) references producto(nombre),
CONSTRAINT fk_num_trans_incluye FOREIGN KEY (num_trans) references ticket(num_trans) );

CREATE TABLE identificacion
(nif char(9) primary key,
nombre varchar(40) not null,
apellidos varchar(40) not null);

CREATE TABLE factura 
(num_trans int primary key,
nif char(9) not null,
CONSTRAINT fk_num_trans_factura FOREIGN KEY (num_trans) references ticket(num_trans) ,
CONSTRAINT fk_nif_factura FOREIGN KEY (nif) references identificacion(nif) );

CREATE TABLE pedido
(num_trans int primary key,
tipo enum ('RECOGIDA', 'ENTREGA') not null,
domicilio varchar(40),
CONSTRAINT fk_num_trans_pedido FOREIGN KEY (num_trans) references ticket(num_trans) );

CREATE TABLE proveedor
(nombre varchar(40) primary key,
tiempo_de_entrega int not null);

CREATE TABLE aprovisionamiento
(num_trans int primary key,
nombre_prov varchar(40),
CONSTRAINT fk_num_trans_aprovisionamiento FOREIGN KEY (num_trans) references ticket(num_trans),
CONSTRAINT fk_nombre_aprovisionamiento FOREIGN KEY (nombre_prov) references proveedor(nombre) );

CREATE TABLE comandas
(num_trans int primary key,
CONSTRAINT fk_num_trans_comandas FOREIGN KEY (num_trans) references ticket(num_trans) );

CREATE TABLE plato
(codigo varchar(20) primary key,
nombre varchar(20) not null,
tipo_comida enum ('VEGETARIANO', 'VEGANO', 'NORMAL') not null,
precio_venta float not null,
tipo_plato enum ('PRIMERO', 'SEGUNDO', 'POSTRE') not null);

CREATE TABLE contiene
(codigo_plato varchar(20),
num_trans int,
precio float not null,
cantidad int not null,
CONSTRAINT pk_tiene PRIMARY KEY (codigo_plato, num_trans),
CONSTRAINT fk_codigo_plato_contiene FOREIGN KEY (codigo_plato) references plato(codigo),
CONSTRAINT fk_num_trans_contiene FOREIGN KEY (num_trans) references comandas(num_trans) );

CREATE TABLE composicion
(codigo_plato varchar(20),
nombre_producto varchar(20),
CONSTRAINT pk_tiene PRIMARY KEY (codigo_plato, nombre_producto),
CONSTRAINT fk_codigo_plato_composicion FOREIGN KEY (codigo_plato) references plato(codigo),
CONSTRAINT fk_nombre_producto_composicion FOREIGN KEY (nombre_producto) references producto(nombre) );

insert into producto values ("Garbanzos","COMIDA","2021/01/20",4,2, null);
insert into producto values ("Paella","COMIDA","2021/01/31",7,4, null);
insert into producto values ("Bacalao","COMIDA","2021/02/02",5,4, null);
insert into producto values ("Hamburguesa","COMIDA","2021/01/30",4,3,null);
insert into producto values ("Cerveza","BEBIDA","2021/02/01",2,1,null);

insert into local values ("B95970901","Freddy Fazbears Pizza","William Afton","RESTAURANTE","Calle El Mundo de las Pizzas 4");
insert into local values ("B95231197","Los Cafres Hermanos","Gus Fring","CAFETERIA","Avenida de Trafico 2");
insert into local values ("B78107158","Taberna de Moe","Moe Szyslak","BAR","Evergreen Terrace 666");

insert into proveedor values ("ACME",72);

insert into usuario values ("12345678A",123,"Emilio","Emiliano","B95970901");
insert into usuario values ("87654321A",876,"Carlos","Garcia","B95231197");
insert into usuario values ("11111111A",111,"Roberto","Rodriguez","B78107158");