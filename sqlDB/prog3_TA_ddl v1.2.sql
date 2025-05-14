CREATE TABLE actividad (
    actividadid               INTEGER NOT NULL,
    fechahora                 TIMESTAMP,
    descripcion               VARCHAR(254 ),
    detallestecnicos          VARCHAR(254 ),
    usuario_usuarioid         INTEGER NOT NULL,
    dispositivo_dispositivoid INTEGER NOT NULL,
    dispositivo_grupo_grupoid INTEGER NOT NULL,
    activo			          CHAR(1)
);

ALTER TABLE actividad ADD CONSTRAINT actividad_pk PRIMARY KEY ( actividadid );

CREATE TABLE aplicacion (
    aplicacionid     INTEGER NOT NULL,
    nombre           VARCHAR(100),
    version          VARCHAR(254),
    desarrollador    VARCHAR(254),
    fechalanzamiento TIMESTAMP,
    descripcion      VARCHAR(254 ),
    tamanomb         DOUBLE(10, 2),
    rutainstalador   VARCHAR(254),
    activo			 CHAR(1)
);

ALTER TABLE aplicacion ADD CONSTRAINT aplicacion_pk PRIMARY KEY ( aplicacionid );

CREATE TABLE configuracion (
    configuracionid   INTEGER NOT NULL,
    nombre            VARCHAR(254),
    descripcion       VARCHAR(254),
    fechacreacion     TIMESTAMP,
    valor             VARCHAR(254),
    usuario_usuarioid INTEGER NOT NULL,
    activo			  CHAR(1)
);

ALTER TABLE configuracion ADD CONSTRAINT configuracion_pk PRIMARY KEY ( configuracionid,
                                                                        usuario_usuarioid );

CREATE TABLE disp_app (
    dispositivo_dispositivoid INTEGER NOT NULL,
    dispositivo_grupoid       INTEGER NOT NULL,
    aplicacion_aplicacionid   INTEGER NOT NULL
);

ALTER TABLE disp_app
    ADD CONSTRAINT disp_app_pk PRIMARY KEY ( dispositivo_dispositivoid,
                                             dispositivo_grupoid,
                                             aplicacion_aplicacionid );

CREATE TABLE disp_conf (
    configuracion_configuracionid INTEGER NOT NULL,
    configuracion_usuarioid       INTEGER NOT NULL,
    dispositivo_dispositivoid     INTEGER NOT NULL,
    dispositivo_grupoid           INTEGER NOT NULL
);

ALTER TABLE disp_conf
    ADD CONSTRAINT disp_conf_pk
        PRIMARY KEY ( configuracion_configuracionid,
                      configuracion_usuarioid,
                      dispositivo_dispositivoid,
                      dispositivo_grupoid );

CREATE TABLE dispositivo (
    dispositivoid  INTEGER NOT NULL,
    nombre         VARCHAR(90 ),
    modelo         VARCHAR(254 ),
    numeroserie    VARCHAR(254 ),
    fecharegistro  TIMESTAMP,
    ubicacion      VARCHAR(254),
    activo         CHAR(1),
    nivelbateria   INTEGER,
    ultimaconexion TIMESTAMP,
    grupo_grupoid  INTEGER NOT NULL
);

ALTER TABLE dispositivo ADD CONSTRAINT dispositivo_pk PRIMARY KEY ( dispositivoid,
                                                                    grupo_grupoid );

CREATE TABLE firmware (
    firmwareid                INTEGER NOT NULL,
    nombre                    VARCHAR(254 ),
    version                   VARCHAR(254 ),
    fechalanzamiento          TIMESTAMP,
    descripcion               VARCHAR(254 ),
    rutaarchivo               VARCHAR(254 ),
    dispositivo_dispositivoid INTEGER NOT NULL,
    dispositivo_grupo_grupoid INTEGER NOT NULL,
    activo			          CHAR(1)
);

CREATE UNIQUE INDEX firmware__idx ON
    firmware (
        dispositivo_dispositivoid
    ASC,
        dispositivo_grupo_grupoid
    ASC );

ALTER TABLE firmware ADD CONSTRAINT firmware_pk PRIMARY KEY ( firmwareid );

CREATE TABLE grupo (
    grupoid       INTEGER NOT NULL,
    nombre        VARCHAR(80 ),
    descripcion   VARCHAR(254 ),
    fechacreacion TIMESTAMP,
    ubicacion     VARCHAR(254 ),
    activo		  CHAR(1)
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( grupoid );

CREATE TABLE metricauso (
    metricaid           INTEGER NOT NULL,
    fecharegistro       TIMESTAMP,
    tiempousominutos    INTEGER,
    nivelbateriainicial INTEGER,
    nivelbateriafinal   INTEGER,
    usuario_usuarioid   INTEGER NOT NULL,
    dispositivo_dispositivoid INTEGER NOT NULL,
    activo			    CHAR(1)
);


CREATE TABLE rol (
    rolid             INTEGER NOT NULL,
    nombre            VARCHAR(50 ),
    descripcion       VARCHAR(254 ),
    activo			  CHAR(1)
);

ALTER TABLE rol ADD CONSTRAINT rol_pk PRIMARY KEY ( rolid );

CREATE TABLE usuario (
    usuarioid     INTEGER NOT NULL,
    nombre        VARCHAR(50 ),
    apellido      VARCHAR(50 ),
    correo        VARCHAR(254 ),
    contrasena    VARCHAR(254 ),
    fechacreacion TIMESTAMP,
	rol_rolid INTEGER NOT NULL,
    activo        CHAR(1)
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( usuarioid );
ALTER TABLE usuario ADD CONSTRAINT usuario_rol_fk FOREIGN KEY ( rol_rolid ) REFERENCES rol (rolid);

ALTER TABLE actividad
    ADD CONSTRAINT actividad_dispositivo_fk
        FOREIGN KEY ( dispositivo_dispositivoid,
                      dispositivo_grupo_grupoid )
            REFERENCES dispositivo ( dispositivoid,
                                     grupo_grupoid );

ALTER TABLE actividad
    ADD CONSTRAINT actividad_usuario_fk FOREIGN KEY ( usuario_usuarioid )
        REFERENCES usuario ( usuarioid );

ALTER TABLE configuracion
    ADD CONSTRAINT configuracion_usuario_fk FOREIGN KEY ( usuario_usuarioid )
        REFERENCES usuario ( usuarioid );

ALTER TABLE disp_app
    ADD CONSTRAINT disp_app_aplicacion_fk FOREIGN KEY ( aplicacion_aplicacionid )
        REFERENCES aplicacion ( aplicacionid );

ALTER TABLE disp_app
    ADD CONSTRAINT disp_app_dispositivo_fk
        FOREIGN KEY ( dispositivo_dispositivoid,
                      dispositivo_grupoid )
            REFERENCES dispositivo ( dispositivoid,
                                     grupo_grupoid );

ALTER TABLE disp_conf
    ADD CONSTRAINT disp_conf_configuracion_fk
        FOREIGN KEY ( configuracion_configuracionid,
                      configuracion_usuarioid )
            REFERENCES configuracion ( configuracionid,
                                       usuario_usuarioid );

ALTER TABLE disp_conf
    ADD CONSTRAINT disp_conf_dispositivo_fk
        FOREIGN KEY ( dispositivo_dispositivoid,
                      dispositivo_grupoid )
            REFERENCES dispositivo ( dispositivoid,
                                     grupo_grupoid );

ALTER TABLE dispositivo
    ADD CONSTRAINT dispositivo_grupo_fk FOREIGN KEY ( grupo_grupoid )
        REFERENCES grupo ( grupoid );

ALTER TABLE firmware
    ADD CONSTRAINT firmware_dispositivo_fk
        FOREIGN KEY ( dispositivo_dispositivoid,
                      dispositivo_grupo_grupoid )
            REFERENCES dispositivo ( dispositivoid,
                                     grupo_grupoid );

ALTER TABLE metricauso ADD CONSTRAINT metricauso_usuario_fk FOREIGN KEY (usuario_usuarioid) REFERENCES usuario(usuarioid);
ALTER TABLE metricauso ADD CONSTRAINT metricauso_dispositivo_fk FOREIGN KEY (dispositivo_dispositivoid) REFERENCES dispositivo(dispositivoid);

