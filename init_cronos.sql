-- Sequence: p00empresa_rowidempresa_seq

-- DROP SEQUENCE p00empresa_rowidempresa_seq;

CREATE SEQUENCE p00empresa_rowidempresa_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;


-- Sequence: p00menu_rowidmenu_seq

-- DROP SEQUENCE p00menu_rowidmenu_seq;

CREATE SEQUENCE p00menu_rowidmenu_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


-- Sequence: p00perfil_rowidperfil_seq

-- DROP SEQUENCE p00perfil_rowidperfil_seq;

CREATE SEQUENCE p00perfil_rowidperfil_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3
  CACHE 1;

-- Sequence: p00perfilmenu_rowidperfilmenu_seq

-- DROP SEQUENCE p00perfilmenu_rowidperfilmenu_seq;

CREATE SEQUENCE p00perfilmenu_rowidperfilmenu_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


-- Sequence: p00usuario_rowidusuario_seq1

-- DROP SEQUENCE p00usuario_rowidusuario_seq1;

CREATE SEQUENCE p00usuario_rowidusuario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;



-- Table: p00departamento

-- DROP TABLE p00departamento;

CREATE TABLE p00departamento
(
  iddepartamento serial NOT NULL, -- Identificador de departamento
  departamento character varying(4) NOT NULL, -- C�digo de departamento
  nombre character varying(50) NOT NULL, -- Nombre de departamento
  CONSTRAINT p00departamentopk PRIMARY KEY (iddepartamento)
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00departamento
  IS 'Departamentos/Estados del pa�s';
COMMENT ON COLUMN p00departamento.iddepartamento IS 'Identificador de departamento';
COMMENT ON COLUMN p00departamento.departamento IS 'C�digo de departamento';
COMMENT ON COLUMN p00departamento.nombre IS 'Nombre de departamento';


-- Index: p00departamento00

-- DROP INDEX p00departamento00;

CREATE UNIQUE INDEX p00departamento00
  ON p00departamento
  USING btree
  (departamento COLLATE pg_catalog."default");

-- Index: p00departamento01

-- DROP INDEX p00departamento01;

CREATE UNIQUE INDEX p00departamento01
  ON p00departamento
  USING btree
  (nombre COLLATE pg_catalog."default");

-- Table: p00municipio

-- DROP TABLE p00municipio;

CREATE TABLE p00municipio
(
  idmunicipio serial NOT NULL, -- Identificador de municipio
  iddepartamento integer NOT NULL, -- Identificador de departamento
  municipio character varying(5) NOT NULL, -- C�digo de municipio
  nombre character varying(50) NOT NULL, -- Nombre de municipio
  CONSTRAINT p00municipiopk PRIMARY KEY (idmunicipio),
  CONSTRAINT relation_204 FOREIGN KEY (iddepartamento)
      REFERENCES p00departamento (iddepartamento) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00municipio
  IS 'Municipios del pa�s
';
COMMENT ON COLUMN p00municipio.idmunicipio IS 'Identificador de municipio';
COMMENT ON COLUMN p00municipio.iddepartamento IS 'Identificador de departamento';
COMMENT ON COLUMN p00municipio.municipio IS 'C�digo de municipio';
COMMENT ON COLUMN p00municipio.nombre IS 'Nombre de municipio';


-- Index: p00municipio00

-- DROP INDEX p00municipio00;

CREATE UNIQUE INDEX p00municipio00
  ON p00municipio
  USING btree
  (municipio COLLATE pg_catalog."default");

-- Index: p00municipio01

-- DROP INDEX p00municipio01;

CREATE INDEX p00municipio01
  ON p00municipio
  USING btree
  (iddepartamento);

-- Index: p00municipio02

-- DROP INDEX p00municipio02;

CREATE INDEX p00municipio02
  ON p00municipio
  USING btree
  (nombre COLLATE pg_catalog."default");

-- Table: p00empresa

-- DROP TABLE p00empresa;

CREATE TABLE p00empresa
(
  rowidempresa integer NOT NULL DEFAULT nextval('p00empresa_rowidempresa_seq'::regclass),
  empresa character varying(20) NOT NULL,
  descripcion character varying(20) NOT NULL,
  nit character varying(20) NOT NULL,
  digitoverificacion smallint NOT NULL,
  direccion character varying(50),
  telefono character varying(50),
  correo character varying(100),
  habilita boolean NOT NULL,
  logo1 text,
  CONSTRAINT p00empresapk PRIMARY KEY (rowidempresa)
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00empresa
  IS 'Empresas en un sistema MultiEmpresa';

-- Index: p00empresa01

-- DROP INDEX p00empresa01;

CREATE UNIQUE INDEX p00empresa01
  ON p00empresa
  USING btree
  (empresa COLLATE pg_catalog."default");


-- Table: p00listaopcion

-- DROP TABLE p00listaopcion;

CREATE TABLE p00listaopcion
(
  rowidopcion serial NOT NULL, -- Identificador de registro de opci�n predefinida del sistema
  variable character varying(30) NOT NULL, -- Nombre de variable de origen
  descripcion character varying(60) NOT NULL, -- Descripci�n de la variable de origen
  valor integer NOT NULL, -- Valor de la opcion
  nombre character varying(60) NOT NULL, -- Nombre de la opci�n
  abreviacion character varying(4) DEFAULT NULL::character varying, -- Abreviaci�n del nombra de la opci�n
  condicion character varying(10) DEFAULT NULL::character varying, -- Condici�n de filtro para la opci�n
  habilita boolean NOT NULL, -- Opci�n habilitada para su uso en el sistema?
  validacion character varying(32) NOT NULL, -- Hash de validaci�n
  CONSTRAINT p00listaopcionpk PRIMARY KEY (rowidopcion)
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00listaopcion
  IS 'Tabla de lista de opciones del sistema';
COMMENT ON COLUMN p00listaopcion.rowidopcion IS 'Identificador de registro de opci�n predefinida del sistema';
COMMENT ON COLUMN p00listaopcion.variable IS 'Nombre de variable de origen';
COMMENT ON COLUMN p00listaopcion.descripcion IS 'Descripci�n de la variable de origen';
COMMENT ON COLUMN p00listaopcion.valor IS 'Valor de la opcion';
COMMENT ON COLUMN p00listaopcion.nombre IS 'Nombre de la opci�n';
COMMENT ON COLUMN p00listaopcion.abreviacion IS 'Abreviaci�n del nombra de la opci�n';
COMMENT ON COLUMN p00listaopcion.condicion IS 'Condici�n de filtro para la opci�n';
COMMENT ON COLUMN p00listaopcion.habilita IS 'Opci�n habilitada para su uso en el sistema?';
COMMENT ON COLUMN p00listaopcion.validacion IS 'Hash de validaci�n';


-- Index: p00listaopcion00

-- DROP INDEX p00listaopcion00;

CREATE UNIQUE INDEX p00listaopcion00
  ON p00listaopcion
  USING btree
  (variable COLLATE pg_catalog."default", valor);

-- Index: p00listaopcion01

-- DROP INDEX p00listaopcion01;

CREATE UNIQUE INDEX p00listaopcion01
  ON p00listaopcion
  USING btree
  (variable COLLATE pg_catalog."default", nombre COLLATE pg_catalog."default");

-- Table: p00menu

-- DROP TABLE p00menu;

CREATE TABLE p00menu
(
  rowidmenu integer NOT NULL DEFAULT nextval('p00menu_rowidmenu_seq'::regclass), -- Identificador de opci�n de men� del sistema
  indice character varying(20) NOT NULL, -- Indice de la opci�n de men�
  nombre character varying(80) NOT NULL, -- Nombre de la opci�n de men�
  imagen character varying(100) NOT NULL, -- Nombre de la im�gen del nodo
  habilita boolean NOT NULL, -- Opci�n de men� habilitada en el sistema?
  encabezado boolean NOT NULL, -- Es un root de �rbol de men�?
  componentes character varying(80) DEFAULT NULL::character varying, -- Componentes a los cuales se habilita la opci�n de men� (NULL=Se habilita siempre)
  expandido boolean NOT NULL, -- Item de men� expandido por defecto?
  instanciamultiple boolean NOT NULL, -- Permite multiples instancias del formulario adscrito a la opci�n de men�?
  validacion character varying(32) NOT NULL, -- Hash de validaci�n
  CONSTRAINT p00menupk PRIMARY KEY (rowidmenu)
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00menu
  IS 'Opciones de men� del sistema';
COMMENT ON COLUMN p00menu.rowidmenu IS 'Identificador de opci�n de men� del sistema';
COMMENT ON COLUMN p00menu.indice IS 'Indice de la opci�n de men�';
COMMENT ON COLUMN p00menu.nombre IS 'Nombre de la opci�n de men�';
COMMENT ON COLUMN p00menu.imagen IS 'Nombre de la im�gen del nodo';
COMMENT ON COLUMN p00menu.habilita IS 'Opci�n de men� habilitada en el sistema?';
COMMENT ON COLUMN p00menu.encabezado IS 'Es un root de �rbol de men�?';
COMMENT ON COLUMN p00menu.componentes IS 'Componentes a los cuales se habilita la opci�n de men� (NULL=Se habilita siempre)';
COMMENT ON COLUMN p00menu.expandido IS 'Item de men� expandido por defecto?';
COMMENT ON COLUMN p00menu.instanciamultiple IS 'Permite multiples instancias del formulario adscrito a la opci�n de men�?';
COMMENT ON COLUMN p00menu.validacion IS 'Hash de validaci�n';


-- Index: p00menu00

-- DROP INDEX p00menu00;

CREATE UNIQUE INDEX p00menu00
  ON p00menu
  USING btree
  (indice COLLATE pg_catalog."default");

-- Table: p00perfil

-- DROP TABLE p00perfil;

CREATE TABLE p00perfil
(
  rowidperfil integer NOT NULL DEFAULT nextval('p00perfil_rowidperfil_seq'::regclass), -- Identificador de perfil de usuario
  perfil character varying(4) NOT NULL, -- C�digo de perfil
  nombre character varying(60) NOT NULL, -- Nombre de perfil
  diasvigencia smallint NOT NULL DEFAULT 120, -- N�mero de d�as de vigencia de contrase�as
  habilita boolean NOT NULL, -- Perfil habilitado para su uso en el sistema?
  rowidempresa integer NOT NULL DEFAULT 0,
  CONSTRAINT p00perfilpk PRIMARY KEY (rowidperfil),
  CONSTRAINT "Relation_1819" FOREIGN KEY (rowidempresa)
      REFERENCES p00empresa (rowidempresa) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00perfil
  IS 'Perfil de usuarios';
COMMENT ON COLUMN p00perfil.rowidperfil IS 'Identificador de perfil de usuario';
COMMENT ON COLUMN p00perfil.perfil IS 'C�digo de perfil';
COMMENT ON COLUMN p00perfil.nombre IS 'Nombre de perfil';
COMMENT ON COLUMN p00perfil.diasvigencia IS 'N�mero de d�as de vigencia de contrase�as';
COMMENT ON COLUMN p00perfil.habilita IS 'Perfil habilitado para su uso en el sistema?';


-- Index: p00perfil02

-- DROP INDEX p00perfil02;

CREATE INDEX p00perfil02
  ON p00perfil
  USING btree
  (rowidempresa);

-- Table: p00perfilmenu

-- DROP TABLE p00perfilmenu;

CREATE TABLE p00perfilmenu
(
  rowidperfilmenu integer NOT NULL DEFAULT nextval('p00perfilmenu_rowidperfilmenu_seq'::regclass), -- Identificador de opci�n de men� por perfil
  rowidperfil integer NOT NULL, -- Identificador de perfil de usuario
  rowidmenu integer NOT NULL, -- Identificador de opci�n de men� del sistema
  CONSTRAINT p00perfilmenupk PRIMARY KEY (rowidperfilmenu),
  CONSTRAINT "Relation_1486" FOREIGN KEY (rowidmenu)
      REFERENCES p00menu (rowidmenu) MATCH FULL
      ON UPDATE RESTRICT ON DELETE CASCADE,
  CONSTRAINT relation_238 FOREIGN KEY (rowidperfil)
      REFERENCES p00perfil (rowidperfil) MATCH FULL
      ON UPDATE RESTRICT ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00perfilmenu
  IS 'Opciones de men� por perfil';
COMMENT ON COLUMN p00perfilmenu.rowidperfilmenu IS 'Identificador de opci�n de men� por perfil';
COMMENT ON COLUMN p00perfilmenu.rowidperfil IS 'Identificador de perfil de usuario';
COMMENT ON COLUMN p00perfilmenu.rowidmenu IS 'Identificador de opci�n de men� del sistema';


-- Index: p00perfilmenu00

-- DROP INDEX p00perfilmenu00;

CREATE UNIQUE INDEX p00perfilmenu00
  ON p00perfilmenu
  USING btree
  (rowidperfil, rowidmenu);

-- Index: p00perfilmenu02

-- DROP INDEX p00perfilmenu02;

CREATE INDEX p00perfilmenu02
  ON p00perfilmenu
  USING btree
  (rowidperfil);

-- Index: p00perfilmenu03

-- DROP INDEX p00perfilmenu03;

CREATE INDEX p00perfilmenu03
  ON p00perfilmenu
  USING btree
  (rowidmenu);

-- Table: p00usuario

-- DROP TABLE p00usuario;

CREATE TABLE p00usuario
(
  rowidusuario bigint NOT NULL DEFAULT nextval('p00usuario_rowidusuario_seq'::regclass), -- Identificador de cuenta de usuario en el sistema
  rowidempresa integer NOT NULL,
  usuario character varying(60) NOT NULL, -- Nombre de cuenta de usuario
  descripcion character varying(60) NOT NULL,
  rowidperfil integer NOT NULL, -- Identificador de perfil de usuario
  validacion character varying(32) DEFAULT NULL::character varying, -- Hash de validaci�n
  cambiacontrasena boolean NOT NULL, -- Usuario puede cambiar la contrase�a?
  fechacambio date, -- Fecha de pr�ximo cambio de contrase�a
  habilita boolean NOT NULL, -- Cuenta habilitada?
  CONSTRAINT p00usuariopk PRIMARY KEY (rowidusuario),
  CONSTRAINT "Relation_1802" FOREIGN KEY (rowidempresa)
      REFERENCES p00empresa (rowidempresa) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT relation_216 FOREIGN KEY (rowidperfil)
      REFERENCES p00perfil (rowidperfil) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p00usuario
  IS 'Cuentas de usuario del sistema';
COMMENT ON COLUMN p00usuario.rowidusuario IS 'Identificador de cuenta de usuario en el sistema';
COMMENT ON COLUMN p00usuario.usuario IS 'Nombre de cuenta de usuario';
COMMENT ON COLUMN p00usuario.rowidperfil IS 'Identificador de perfil de usuario';
COMMENT ON COLUMN p00usuario.validacion IS 'Hash de validaci�n';
COMMENT ON COLUMN p00usuario.cambiacontrasena IS 'Usuario puede cambiar la contrase�a?';
COMMENT ON COLUMN p00usuario.fechacambio IS 'Fecha de pr�ximo cambio de contrase�a';
COMMENT ON COLUMN p00usuario.habilita IS 'Cuenta habilitada?';


-- Index: p00usuario00

-- DROP INDEX p00usuario00;

CREATE UNIQUE INDEX p00usuario00
  ON p00usuario
  USING btree
  (rowidempresa, usuario COLLATE pg_catalog."default");

-- Index: p00usuario02

-- DROP INDEX p00usuario02;

CREATE INDEX p00usuario02
  ON p00usuario
  USING btree
  (rowidperfil);

-- Index: p00usuario03

-- DROP INDEX p00usuario03;

CREATE INDEX p00usuario03
  ON p00usuario
  USING btree
  (rowidempresa);

-- Table: p10clientes

-- DROP TABLE p10clientes;

CREATE TABLE p10clientes
(
  rowidcliente serial NOT NULL,
  rowidempresa integer NOT NULL,
  rowidtipocliente integer NOT NULL,
  rowidtipoidentificacion integer NOT NULL,
  numeroidentificacion character varying(60) NOT NULL,
  digitoverificacion character varying(2) NOT NULL,
  razonsocial character varying(120),
  nombres character varying(60) NOT NULL,
  apellidos character varying(60) NOT NULL,
  fechanacimiento date,
  rowidsexo integer NOT NULL,
  rowidestadocivil integer,
  direccion character varying(60),
  telefono character varying(60),
  correopersonal character varying(100),
  tienehijos boolean NOT NULL,
  rowidtipoprofesion integer NOT NULL,
  descripcionprofesion character varying(100),
  empresalabora character varying(100),
  direccionempresa character varying(60),
  telefonoempresa character varying(60),
  habilita boolean NOT NULL,
  celular character(200) DEFAULT ''::bpchar,
  correoinstitucional character(200) DEFAULT ''::bpchar,
  cantidadhijos smallint,
  titularvivienda smallint, -- 1:propia, 2:familiar, 3:con hipoteca, 4:alquilada
  rowidmunicipio integer,
  CONSTRAINT p10clientespk PRIMARY KEY (rowidcliente),
  CONSTRAINT "Relation_1428" FOREIGN KEY (rowidtipocliente)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1429" FOREIGN KEY (rowidtipoidentificacion)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1430" FOREIGN KEY (rowidsexo)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1431" FOREIGN KEY (rowidestadocivil)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1432" FOREIGN KEY (rowidtipoprofesion)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1434" FOREIGN KEY (rowidmunicipio)
      REFERENCES p00municipio (idmunicipio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Relation_1833" FOREIGN KEY (rowidempresa)
      REFERENCES p00empresa (rowidempresa) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p10clientes
  IS 'clientes';
COMMENT ON COLUMN p10clientes.titularvivienda IS '1:propia, 2:familiar, 3:con hipoteca, 4:alquilada';


-- Index: p10clientes00

-- DROP INDEX p10clientes00;

CREATE UNIQUE INDEX p10clientes00
  ON p10clientes
  USING btree
  (rowidempresa, numeroidentificacion COLLATE pg_catalog."default");

-- Table: p10vehiculos

-- DROP TABLE p10vehiculos;

CREATE TABLE p10vehiculos
(
  rowidvehiculos serial NOT NULL,
  rowidempresa integer NOT NULL,
  numeroplaca character varying(6) NOT NULL,
  codigofasecolda character varying(20),
  rowidcliente integer NOT NULL,
  rowidclasevehiculo integer NOT NULL,
  rowidtiposervicio integer NOT NULL,
  cilindraje character varying(10),
  modelo character varying(6),
  nropasajeros character varying(6),
  capacidadtoneladas integer,
  nromotor character varying(100),
  nrochasis character varying(100),
  CONSTRAINT p10vehiculospk PRIMARY KEY (rowidvehiculos),
  CONSTRAINT "Relation_1435" FOREIGN KEY (rowidcliente)
      REFERENCES p10clientes (rowidcliente) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1436" FOREIGN KEY (rowidclasevehiculo)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1437" FOREIGN KEY (rowidtiposervicio)
      REFERENCES p00listaopcion (rowidopcion) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1841" FOREIGN KEY (rowidempresa)
      REFERENCES p00empresa (rowidempresa) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p10vehiculos
  IS 'vehiculos';

-- Index: p10vehiculos00

-- DROP INDEX p10vehiculos00;

CREATE UNIQUE INDEX p10vehiculos00
  ON p10vehiculos
  USING btree
  (numeroplaca COLLATE pg_catalog."default", nromotor COLLATE pg_catalog."default", nrochasis COLLATE pg_catalog."default");

-- Table: p10soat

-- DROP TABLE p10soat;

CREATE TABLE p10soat
(
  rowidsoat serial NOT NULL,
  rowidvehiculo integer NOT NULL,
  habilita boolean NOT NULL,
  rowidtomador integer NOT NULL,
  fechaexpedicion date NOT NULL,
  fechainiciovigencia date NOT NULL,
  observaciones character varying(200),
  CONSTRAINT p10soatpk PRIMARY KEY (rowidsoat),
  CONSTRAINT "Relation_1846" FOREIGN KEY (rowidvehiculo)
      REFERENCES p10vehiculos (rowidvehiculos) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Relation_1847" FOREIGN KEY (rowidtomador)
      REFERENCES p10clientes (rowidcliente) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE p10soat
  IS 'soat ara los vehiculos';

-- Index: p10soat00

-- DROP INDEX p10soat00;

CREATE UNIQUE INDEX p10soat00
  ON p10soat
  USING btree
  (rowidvehiculo, fechainiciovigencia);


