CREATE TABLE public.institucion (
	id bigserial NOT NULL,
	acronimo varchar(255) NULL,
	nombre varchar(255) NULL,
	tipo_institucion_id int4 NULL references tipo_institucion(id),
	CONSTRAINT institucion_pkey PRIMARY KEY (id)
);