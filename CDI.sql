-- borra la bd si existe
DROP DATABASE IF EXISTS cdi;
-- creamos la bd
CREATE DATABASE cdi;
-- activamos la bd
USE cdi;

create table tb_acceso(
idaccess int not null primary key,
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

insert into tb_acceso values(1,'Administrador');
insert into tb_acceso values(2,'Usuario');
select * from tb_acceso;

insert into tb_usuarios values(null,'Daniel','Mercado','dmercado@cdi.com','123456',curdate(),1,1);
select * from tb_usuarios;
