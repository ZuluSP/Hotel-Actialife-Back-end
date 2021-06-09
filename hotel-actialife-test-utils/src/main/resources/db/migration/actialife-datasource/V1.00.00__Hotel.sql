-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.13-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- -----------------------------------------------------
-- Schema actialife
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS actialife DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------

-- Volcando estructura para tabla hotel_actialife.SEQUENCE
CREATE TABLE IF NOT EXISTS SEQUENCE (
  KeyVal varchar(50) NOT NULL,
  IdValue bigint(19) NOT NULL DEFAULT '0',
  PRIMARY KEY (KeyVal) 
)



-- Volcando estructura para tabla hotel_actialife.caracteristicas
CREATE TABLE IF NOT EXISTS caracteristicas (
  id int(11) NOT NULL,
  Nombre varchar(50) NOT NULL,
  Descripcion text NOT NULL,
  PRIMARY KEY (id)
)

-- Volcando datos para la tabla hotel_actialife.caracteristicas: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `caracteristicas` DISABLE KEYS */;
INSERT INTO caracteristicas (id, Nombre, Descripcion) VALUES
	(1, 'air_conditioner', ''),
	(2, 'breakfast_included', ''),
	(3, 'coffee_maker', ''),
	(4, 'kitchen', ''),
	(5, 'flat_tv', ''),
	(6, 'wifi', ''),
	(7, 'terrace', ''),
	(8, 'views', '');
insert into SEQUENCE (KeyVal, IdValue) VALUES ('caracteristicas', 8);
/*!40000 ALTER TABLE `caracteristicas` ENABLE KEYS */;

-- Volcando estructura para tabla hotel_actialife.caracteristicas_habitaciones
CREATE TABLE IF NOT EXISTS caracteristicas_habitaciones (
  id_caracteristica int(11) NOT NULL,
  id_habitacion int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id_caracteristica,id_habitacion),
)

-- Volcando datos para la tabla hotel_actialife.caracteristicas_habitaciones: ~26 rows (aproximadamente)
/*!40000 ALTER TABLE `caracteristicas_habitaciones` DISABLE KEYS */;
INSERT INTO caracteristicas_habitaciones (id_caracteristica, id_habitacion) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(2, 5),
	(3, 1),
	(3, 2),
	(4, 4),
	(4, 5),
	(5, 1),
	(5, 2),
	(5, 3),
	(5, 4),
	(5, 5),
	(6, 1),
	(6, 2),
	(6, 3),
	(6, 4),
	(6, 5),
	(7, 2),
	(7, 4),
	(7, 5),
	(8, 2),
	(8, 3),
	(8, 5);
/*!40000 ALTER TABLE `caracteristicas_habitaciones` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('caracteristicas_habitaciones', 8);


-- Volcando estructura para tabla hotel_actialife.habitaciones
CREATE TABLE IF NOT EXISTS habitaciones (
  id int(11) NOT NULL DEFAULT '0',
  tipo_de_habitacion int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
)

-- Volcando datos para la tabla hotel_actialife.habitaciones: ~30 rows (aproximadamente)
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO habitaciones (id, tipo_de_habitacion) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(7, 1),
	(8, 1),
	(9, 1),
	(10, 1),
	(11, 1),
	(4, 2),
	(5, 2),
	(12, 2),
	(13, 2),
	(14, 2),
	(15, 2),
	(16, 2),
	(17, 2),
	(6, 3),
	(18, 3),
	(19, 3),
	(20, 3),
	(21, 3),
	(22, 3),
	(23, 4),
	(24, 4),
	(25, 4),
	(26, 4),
	(27, 4),
	(28, 5),
	(29, 5),
	(30, 5);
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('habitaciones', 30);

-- Volcando estructura para tabla hotel_actialife.habitacion_servicio
CREATE TABLE IF NOT EXISTS habitacion_servicio (
  id_tipo_habitacion int(11) NOT NULL DEFAULT '0',
  id_servicio int(11) NOT NULL DEFAULT '0',
  fecha_servicio datetime NOT NULL,
  fecha_fin_servicio datetime NOT NULL,
  PRIMARY KEY (id_tipo_habitacion,id_servicio),
);

-- Volcando datos para la tabla hotel_actialife.habitacion_servicio: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `habitacion_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitacion_servicio` ENABLE KEYS */;

--Habitacion_tipo
CREATE TABLE IF NOT EXISTS Habitacion_tipo (
  id int(11) NOT NULL,
  tipo_habitacion varchar(255) NOT NULL,
  descripcion varchar(1024) NOT NULL,
  precio float NOT NULL,
  m2 float NOT NULL,
  numero_habitaciones int(11) NOT NULL,
  PRIMARY KEY (Id));

-- Volcando datos para la tabla hotel_actialife.habitacion_tipo: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `habitacion_tipo` DISABLE KEYS */;
INSERT INTO habitacion_tipo (id, tipo_habitacion, descripcion, precio, m2, numero_habitaciones) VALUES
	(1, 'Single', 'Our comfortable single rooms are just the right size if you are travelling alone. Similar to all the other rooms in the ActiaLife Hotel, the single room is fully equipped with all comforts.\r\nOur Single has a size of 25 m². In addition to the comfy bed, you will have plenty of room to relax. \r\nWith a book, a movie or a drink from the lounge, for example. \r\n\r\nThe rooms are fully equipped for a relaxing stay.', 50, 25, 8),
	(2, 'Double', 'The sleek and warm interior of our rooms invites you to relax and enjoy what our great ActiaLife Hotel has to offer.\r\n\r\nOur Double room has a size of 30 m². In addition to our comfy bed, you will have plenty of room to relax. With a book, a movie or a drink from the lounge, for example.\r\n\r\nThe rooms are fully equipped for a relaxing stay.', 60, 30, 8),
	(3, 'Twin Room', 'The sleek and warm interior of our rooms invites you to relax and enjoy what the ActiaLife Hotel has to offer.\r\n\r\nOur twin room has a size of 30 m². In addition to the two comfy beds, you will have plenty of room to relax. With a book, a movie or a drink from the lounge, for example. \r\n\r\nThe rooms are fully equipped for a relaxing stay', 75, 30, 6),
	(4, 'Familiar Room', 'The sleek and warm interior of our rooms invites you to relax and enjoy what the ActiaLife Hotel has to offer.\r\n\r\nThe family room has a size of 50 m². In addition to big familiar comfy bed, for you and your familly.\r\n\r\nYou all will have plenty of room to relax. With a book, a movie or a drink from the lounge, for example.\r\n\r\nThe rooms are fully equipped for a relaxing stay.', 60, 50, 5),
	(5, 'Suite Deluxe\r\n', 'Welcome to Luxury Suites Actialife, one of the finest hotels where you can enjoy a luxurious and tailor-made stay. \r\n\r\nOur Suite room has a size of 100 m². In addition to the big comfy bed, you will have plenty of room to relax. With a book, a movie or a drink from the lounge, for example. The rooms are fully equipped for a relaxing stay.\r\n\r\nour friendly and well-trained staff will make sure that you make the most of your stay in ActiaLife.\r\n\r\nTake the best rest in our best room!', 70, 100, 3),
	(6, 'nueva', 'nueva habitacion', 78, 25, 10),
	(7, 'string', 'string', 100, 0, 0),
	(8, 'prueba 26-05-2021', 'string', 100, 0, 0),
	(9, 'string', 'string', 60, 0, 0),
	(10, 'string', 'string', 60, 0, 0);
/*!40000 ALTER TABLE `habitacion_tipo` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('habitacion_tipo', 30);

-- Volcando estructura para tabla hotel_actialife.imagenes_habitaciones
CREATE TABLE IF NOT EXISTS imagenes_habitaciones (
  id int(11) NOT NULL DEFAULT '0',
  id_habitacion_tipo int(11) NOT NULL DEFAULT '0',
  imagen_habitacion varchar(255) NOT NULL,
  descripcion_imagen varchar(50) NOT NULL,
  PRIMARY KEY (id)
);


-- Volcando datos para la tabla hotel_actialife.imagenes_habitaciones: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `imagenes_habitaciones` DISABLE KEYS */;
INSERT INTO imagenes_habitaciones (id, id_habitacion_tipo, imagen_habitacion, descripcion_imagen) VALUES
	(1, 1, '../img/rooms/individual.jpg', ''),
	(2, 2, '../img/rooms/doble.jpg', ''),
	(3, 3, '../img/rooms/twin.jpg', ''),
	(4, 4, '../img/rooms/familiar.jpg', ''),
	(5, 5, '../img/rooms/suite.jpg', ''),
	(6, 2, '../img/rooms/doble2.jpg', ''),
	(7, 1, '../img/rooms/individual2.jpg', ''),
	(8, 3, '../img/rooms/twin2.jpg', ''),
	(9, 4, '../img/rooms/familiar2.jpg', ''),
	(10, 4, '../img/rooms/familiar3.jpg', ''),
	(11, 5, '../img/rooms/suite2.jpg', '');
/*!40000 ALTER TABLE `imagenes_habitaciones` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('imagenes_habitaciones', 11);


-- Volcando estructura para tabla hotel_actialife.logs
CREATE TABLE IF NOT EXISTS logs (
  id int(11) NOT NULL,
  id_usuario int(11) NOT NULL DEFAULT '0',
  log varchar(50) NOT NULL,
  time varchar(255) NOT NULL,
  PRIMARY KEY (id)
);


-- Volcando datos para la tabla hotel_actialife.logs: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO logs (id, id_usuario, log, time) VALUES
	(1, 1, 'YESS!', '09:13');
	
insert into SEQUENCE (KeyVal, IdValue) VALUES ('logs', 1);
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;

-- Volcando estructura para tabla hotel_actialife.reservas
CREATE TABLE IF NOT EXISTS reservas (
  id int(11) NOT NULL DEFAULT '0',
  id_usuario int(11) NOT NULL DEFAULT '0',
  fecha_inicio date NOT NULL,
  fecha_fin date NOT NULL,
  id_tipo_habitacion int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
);


-- Volcando datos para la tabla hotel_actialife.reservas: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO reservas (id, id_usuario, fecha_inicio, fecha_fin, id_tipo_habitacion) VALUES
	(2, 1, '2021-03-05', '2021-03-21', 2),
	(3, 1, '2021-03-14', '2021-03-17', 3),
	(4, 2, '2021-03-15', '2021-03-17', 1),
	(5, 1, '2021-03-14', '2021-03-16', 1),
	(6, 4, '2021-04-15', '2021-04-22', 3),
	(7, 4, '2021-04-17', '2021-04-21', 2),
	(8, 9, '2021-03-19', '2021-03-21', 2),
	(9, 1, '2021-03-17', '2021-03-19', 2),
	(10, 13, '2021-03-15', '2021-03-20', 3),
	(11, 13, '2021-03-18', '2021-03-20', 2),
	(12, 1, '2021-05-31', '2021-05-31', 0);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('reservas', 12);

-- Volcando estructura para tabla hotel_actialife.roles
CREATE TABLE IF NOT EXISTS roles (
  id int(11) NOT NULL DEFAULT '0',
  nombre_rol varchar(50) NOT NULL,
  PRIMARY KEY (id)
);


-- Volcando datos para la tabla hotel_actialife.roles: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO roles (id, nombre_rol) VALUES
	(1, 'estandar'),
	(2, 'admin'),
	(3, 'string');

/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('roles', 3);

-- Volcando estructura para tabla hotel_actialife.servicios
CREATE TABLE IF NOT EXISTS servicios (
  id int(11) NOT NULL DEFAULT '0',
  nombre_servicio varchar(255) NOT NULL,
  precio_servicio decimal(6,2) NOT NULL,
  descripcion varchar(255) NOT NULL,
  disponibilidad bit(1) NOT NULL DEFAULT b'1'
);

-- Volcando datos para la tabla hotel_actialife.servicios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;

-- Volcando estructura para tabla hotel_actialife.usuarios
CREATE TABLE IF NOT EXISTS usuarios (
  id int(11) NOT NULL,
  nombre varchar(255) NOT NULL,
  apellidos varchar(255) NOT NULL,
  email varchar(50) NOT NULL,
  telf varchar(9) NOT NULL,
  direccion varchar(60) NOT NULL,
  password varchar(255) NOT NULL,
  rol_usuario int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
);

alter table usuarios
	add constraint FK_usuarios_roles 
		foreign key (rol_usuario) REFERENCES roles (id);




-- Volcando datos para la tabla hotel_actialife.usuarios: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO usuarios (id, nombre, apellidos, email, telf, direccion, password, rol_usuario) VALUES
	(1, 'carlos', 'zulueta', 'carlos@carlos.com', '123', '1233', '$2y$10$xXebmSRhrlq9fEz1BVHrSeCKlsHk/prlPzEjf3BwP52FjDJeAfQ4i', 2),
	(2, 'Brais', 'Gomas', 'brais@brais.com', '1234', '1234', '$2y$10$9ZnNWrOE0cRy/Xe2nP/9Nu1TaZcHicfUw6k4U9aeFsISEBF3I4bja', 1),
	(3, 'Patricia', 'Pardo', 'patri@patri.com', '12345', 'Su casa', '$2y$10$Hh6lSzCZ7PkUOOW/Reljh.ouGkfeVbOP385G0HDtQBoXLm6Ki7bUm', 1),
	(4, 'Asier', 'Villar', 'asier@asier.com', '1234566', '1234565', '$2y$10$kbmrOxyxo8Es.D3gwewb0erHm6ZUMy32zrGvFNGTiMcpdfTS6F96q', 1),
	(5, 'true', 'faiter', 'true@true.com', '111111', '1234565', '$2y$10$wrmn0fP3.b1QO8dWwLAmbOtWcv4Jl6j989snv6n/fzmM0fnTqG8Ma', 1),
	(6, 'andres', 'gonzales', 'andres@andres.com', '12221112', 'su casita', '$2y$10$lc2hYqCuX4laClKZnMkGVe10wh8KCWPO32fgVXlaDZbK7NWx.Razi', 1),
	(7, 'Brais', 'Gomas', 'axain.slr.pk@gmail.com', '121313123', '1234', '$2y$10$C35Dn7yh5o16OUXdpNUlRe72yPt9p2yfim9nd7J.0ttG7Zp6/OUKC', 1),
	(8, 'Carlitos', 'Zulueta', 'zuluetam22@gmail.com', '123456789', '12345', '$2y$10$MikSpBIDYUXVnpN8r7lcvO4g6baP.sMXqC47B/R/Qxne2CG/85xja', 1),
	(9, 'roi', 'Gonzalez', 'Roi@roi.com', '1231412', 'en su casita', '$2y$10$9ZnNWrOE0cRy/Xe2nP/9Nu1TaZcHicfUw6k4U9aeFsISEBF3I4bja', 1),
	(11, 'string', 'string', 'string', 'string', 'string', 'string', 1),
	(12, 'Mario', 'Moure', 'MarioMoure@Moure.com', '699234726', 'En su puta casa teletrabajando', 'string', 1),
	(13, 'string', 'string', 'string', 'string', 'string', 'string', 1),
	(15, 'test', 'string', 'string', 'string', 'string', 'string', 2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
insert into SEQUENCE (KeyVal, IdValue) VALUES ('usuarios', 15);
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
