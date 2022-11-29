-- borra la bd si existe
DROP DATABASE IF EXISTS cdi;
-- creamos la bd
CREATE DATABASE cdi;
-- activamos la bd
USE cdi;

create table tb_acceso(
idaccess int auto_increment primary key,
descripcion varchar(15)
);

CREATE TABLE tb_usuarios(
idusua  int auto_increment,
nomusua varchar(25),
apeusua varchar(25),
correo char(45) NOT NULL unique,
clave char(100),
fecing  date  null,
idaccess int DEFAULT 2 CHECK (idaccess IN (1,2)), 
estado  int DEFAULT 1 check (estado IN (1,2)),
primary key (idusua),
constraint fk_acceso foreign key (idaccess) references tb_acceso(idaccess)
);

create table tb_proveedor(
idproveedor int auto_increment,
nombre_rs varchar(45) not null,
telefono varchar(10) not null,
email varchar(45) not null, 
primary key (idproveedor)
);

create table tb_marcas(
idmarcas int auto_increment primary key,
descripcion varchar(45)
);

create table tb_generos(
idgeneros int auto_increment primary key,
genero varchar(45)
);

create table tb_estado(
idestado int auto_increment not null primary key,
estado varchar(45)
);

create table tb_categoria(
idcategoria int auto_increment primary key,
categoria varchar(45)
);

create table tb_productos(
id_prod int auto_increment primary key,
modelo varchar(45) not null,
talla int not null,
idmarcas int,
idestado int,
idcategoria int,
idgeneros int, 
constraint fk_marcas foreign key (idmarcas) references tb_marcas(idmarcas),
constraint fk_estado foreign key (idestado) references tb_estado(idestado),
constraint fk_categoria foreign key (idcategoria) references tb_categoria(idcategoria),
constraint fk_genero foreign key (idgeneros) references tb_generos(idgeneros)
);

insert into tb_acceso values(1,'Administrador');
insert into tb_acceso values(2,'Usuario');

insert into tb_generos values(null,'Femenino');
insert into tb_generos values(null,'Masculino');

insert into tb_estado values(null,'Activo');
insert into tb_Estado values(null,'Inactivo');

insert into tb_categoria values(null,'Running');
insert into tb_categoria values(null,'Outdoor');
insert into tb_categoria values(null,'Zapatillas');
insert into tb_categoria values(null,'Botines');

insert into tb_marcas values(1,'Nike');
insert into tb_marcas values(2,'Adidas');

insert into tb_usuarios values(null,'Daniel','Mercado','dmercado@cdi.com','123456',curdate(),1,1);

insert into tb_proveedor values(null,'Nike CO','015553211','ventas@nike.com');
insert into tb_proveedor values(null,'Adidas SAC','015555678','ventas@adidas.com');

select * from tb_usuarios;
select* from tb_marcas;
select* from tb_proveedor;
select * from tb_acceso;
select * from tb_productos;