--Generos
INSERT INTO public.genero (id, descripcion) VALUES(1, 'Femenino');
INSERT INTO public.genero (id, descripcion) VALUES(2, 'Masculino');
--Nacionalidades
INSERT INTO public.nacionalidad (id, nombre) VALUES(1, 'Paraguaya');
INSERT INTO public.nacionalidad (id, nombre) VALUES(2, 'Argentina');
--Cargos
INSERT INTO public.cargo(id, descripcion) VALUES(1, 'Director');
INSERT INTO public.cargo(id, descripcion) VALUES(2, 'Tutor');
--Tipo de instituciones
INSERT INTO public.tipo_institucion (id, descripcion) VALUES(1, 'Establecimiento');
INSERT INTO public.tipo_institucion (id, descripcion) VALUES(2, 'Formadora');
-- Departamentos
INSERT INTO public.departamento (id, descripcion, region) VALUES(1, 'Central', 'Oriental');
-- Ciudades
INSERT INTO public.ciudad (id, descripcion, departamento_id) VALUES(1, 'Asunción', 1);
INSERT INTO public.ciudad (id, descripcion, departamento_id) VALUES(2, 'San Lorenzo', 1);
INSERT INTO public.ciudad (id, descripcion, departamento_id) VALUES(3, 'Luque', 1);

--Carreras
INSERT INTO public.carreraprograma (fecha_creacion,fecha_modificacion,usuario_creacion_id,usuario_modificacion_id,descripcion) VALUES
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Medicina'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Enferemeria'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Obstetricia'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Fisioterapia y Kinesiologia'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Fisioterapia'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Fisiatria'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Nutrición'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Psicología'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Sicología Clínica'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Odontología');
INSERT INTO public.carreraprograma (fecha_creacion,fecha_modificacion,usuario_creacion_id,usuario_modificacion_id,descripcion) VALUES
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Bioquimica'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Emergentología'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Quimica y Farmacia'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Farmacia'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Fonoaudiología'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Radiología'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Imagenología'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Laboratorio Clínico'),
	 ('2022-02-21 00:00:00.000','2022-02-21 00:00:00.000',1,1,'Ciencias del Deporte');

-- Regiones Sanitarias
INSERT INTO public.regiones_sanitarias (id, region) VALUES(1, 'Región I - Concepción');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(2, 'Región II - San Pedro');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(3, 'Región III - Cordillera');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(4, 'Región IV - Guairá');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(5, 'Región V - Caaguazú');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(6, 'Región VI - Caazapá');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(7, 'Región VII - Itapúa');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(8, 'Región VIII - Misiones');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(9, 'Región IX - Paraguarí');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(10, 'Región X - Alto Paraná');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(11, 'Región XI - Central');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(12, 'Región XII - Ñeembucú');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(13, 'Región XIII - Amambay');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(14, 'Región XIV - Canindeyú');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(15, 'Región XV - Presidente Hayes');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(16, 'Región XVI - Boquerón');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(17, 'Región XVII - Alto Paraguay');
INSERT INTO public.regiones_sanitarias (id, region) VALUES(18, 'Región XVIII - Capital');

--Roles
INSERT INTO public.role (descripcion) VALUES('ROLE_ADMIN');
INSERT INTO public.role (descripcion) VALUES('ROLE_USER');
INSERT INTO public.role (descripcion) VALUES('ROLE_DNERHS');
INSERT INTO public.role (descripcion) VALUES('ROLE_RESPONSABLE_ESTABLECIMIENTO');

--Administrador
INSERT INTO public.usuario (fecha_creacion, usuario_creacion_id, password, role, username) VALUES('2021-08-04 13:04:46.343000', 1, '$2a$10$ad2I40ylH29Bp2LZn1MeKekvGXDQE.V4eoBvaWRgMska5UwBmPBXq', 1, 'admin');
INSERT INTO public.usuario (fecha_creacion, usuario_creacion_id, password, role, username) VALUES('2021-08-04 13:04:46.343000', 1, '$2a$10$Qy4UZQe.2dE44p/VcqGXy.Ikc315pw/VZmc4dRldyQzv/xxOLXUom', 3, 'dnerhs');

--Tipos Establecimientos
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.NACIONAL');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.GENERAL');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.G.PEDIATRICO');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.ESPECIALIZADO');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.REGIONAL');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.DISTRITAL');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.MATERNO INFANTIL');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.INTEGRADO');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('H.BASICO');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('CAES-POLINICO');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('CLINICA');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('CENTRO DE SALUD');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('PUESTO DE SALUD');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('LAB');
INSERT INTO public.tipo_establecimiento (descripcion) VALUES('USF');

--Establecimientos Carreras Plazas  
INSERT INTO public.establecimientos_carreras_plazas
(id, fecha_creacion, fecha_modificacion, usuario_creacion_id, usuario_modificacion_id, cantidad, carreraprograma_disponible, disponible, engestion, medicina_anos_inferiores, ocupadas, carreraprograma_id, nombre_servicio_id)
VALUES(1, '2022-01-01 00:00:00.000', '2022-01-01 00:00:00.000', 1, 1, 0, true, 0, 0, 0, 0, 1, 1);
INSERT INTO public.establecimientos_carreras_plazas
(id, fecha_creacion, fecha_modificacion, usuario_creacion_id, usuario_modificacion_id, cantidad, carreraprograma_disponible, disponible, engestion, medicina_anos_inferiores, ocupadas, carreraprograma_id, nombre_servicio_id)
VALUES(2, '2022-01-01 00:00:00.000', '2022-01-01 00:00:00.000', 1, 1, 0, true, 0, 0, 0, 0, 2, 1);
INSERT INTO public.establecimientos_carreras_plazas
(id, fecha_creacion, fecha_modificacion, usuario_creacion_id, usuario_modificacion_id, cantidad, carreraprograma_disponible, disponible, engestion, medicina_anos_inferiores, ocupadas, carreraprograma_id, nombre_servicio_id)
VALUES(3, '2022-01-01 00:00:00.000', '2022-01-01 00:00:00.000', 1, 1, 0, true, 0, 0, 0, 0, 3, 1);
INSERT INTO public.establecimientos_carreras_plazas
(id, fecha_creacion, fecha_modificacion, usuario_creacion_id, usuario_modificacion_id, cantidad, carreraprograma_disponible, disponible, engestion, medicina_anos_inferiores, ocupadas, carreraprograma_id, nombre_servicio_id)
VALUES(4, '2022-01-01 00:00:00.000', '2022-01-01 00:00:00.000', 1, 1, 0, true, 0, 0, 0, 0, 4, 1);
