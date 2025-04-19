CREATE TABLE actividad (
    actividadid               NUMBER NOT NULL,
    fechahora                 TIMESTAMP,
    descripcion               VARCHAR2(254 CHAR),
    detallestecnicos          VARCHAR2(254 CHAR),
    usuario_usuarioid         NUMBER NOT NULL,
    dispositivo_dispositivoid NUMBER NOT NULL,
    dispositivo_grupoid       NUMBER NOT NULL
);

ALTER TABLE actividad ADD CONSTRAINT actividad_pk PRIMARY KEY ( actividadid );

CREATE TABLE aplicacion (
    aplicacionid     NUMBER NOT NULL,
    nombre           VARCHAR2(100 CHAR),
    version          VARCHAR2(254 CHAR),
    desarrollador    VARCHAR2(254 CHAR),
    fechalanzamiento TIMESTAMP,
    descripcion      VARCHAR2(254 CHAR),
    tamanomb         NUMBER(2, 10),
    rutainstalador   VARCHAR2(254 CHAR)
);

ALTER TABLE aplicacion ADD CONSTRAINT aplicacion_pk PRIMARY KEY ( aplicacionid );

CREATE TABLE configuracion (
    configuracionid   NUMBER NOT NULL,
    nombre            VARCHAR2(254 CHAR),
    descripcion       VARCHAR2(254 CHAR),
    fechacreacion     TIMESTAMP,
    valor             VARCHAR2(254 CHAR),
    usuario_usuarioid NUMBER NOT NULL
);

ALTER TABLE configuracion ADD CONSTRAINT configuracion_pk PRIMARY KEY ( configuracionid,
                                                                        usuario_usuarioid );

CREATE TABLE disp_app (
    dispositivo_dispositivoid NUMBER NOT NULL,
    dispositivo_grupoid       NUMBER NOT NULL,
    aplicacion_aplicacionid   NUMBER NOT NULL
);

ALTER TABLE disp_app
    ADD CONSTRAINT disp_app_pk PRIMARY KEY ( dispositivo_dispositivoid,
                                             dispositivo_grupoid,
                                             aplicacion_aplicacionid );

CREATE TABLE disp_conf (
    configuracion_configuracionid NUMBER NOT NULL,
    configuracion_usuarioid       NUMBER NOT NULL,
    dispositivo_dispositivoid     NUMBER NOT NULL,
    dispositivo_grupoid           NUMBER NOT NULL
);

ALTER TABLE disp_conf
    ADD CONSTRAINT disp_conf_pk
        PRIMARY KEY ( configuracion_configuracionid,
                      configuracion_usuarioid,
                      dispositivo_dispositivoid,
                      dispositivo_grupoid );

CREATE TABLE dispositivo (
    dispositivoid  NUMBER NOT NULL,
    nombre         VARCHAR2(90 CHAR),
    modelo         VARCHAR2(254 CHAR),
    numeroserie    VARCHAR2(254 CHAR),
    fecharegistro  TIMESTAMP,
    ubicacion      VARCHAR2(254 CHAR),
    activo         CHAR(1),
    nivelbateria   NUMBER,
    ultimaconexion TIMESTAMP,
    grupo_grupoid  NUMBER NOT NULL
);

ALTER TABLE dispositivo ADD CONSTRAINT dispositivo_pk PRIMARY KEY ( dispositivoid,
                                                                    grupo_grupoid );

CREATE TABLE firmware (
    firmwareid                NUMBER NOT NULL,
    nombre                    VARCHAR2(254 CHAR),
    version                   VARCHAR2(254 CHAR),
    fechalanzamiento          TIMESTAMP,
    descripcion               VARCHAR2(254 CHAR),
    rutaarchivo               VARCHAR2(254 BYTE),
    dispositivo_dispositivoid NUMBER NOT NULL,
    dispositivo_grupoid       NUMBER NOT NULL
);

CREATE UNIQUE INDEX firmware__idx ON
    firmware (
        dispositivo_dispositivoid
    ASC,
        dispositivo_grupoid
    ASC );

ALTER TABLE firmware ADD CONSTRAINT firmware_pk PRIMARY KEY ( firmwareid );

CREATE TABLE grupo (
    grupoid       NUMBER NOT NULL,
    nombre        VARCHAR2(80 CHAR),
    descripcion   VARCHAR2(254 CHAR),
    fechacreacion TIMESTAMP,
    ubicacion     VARCHAR2(254 CHAR)
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( grupoid );

CREATE TABLE metricauso (
    metricaid           NUMBER NOT NULL,
    fecharegistro       TIMESTAMP,
    tiempousominutos    NUMBER,
    nivelbateriainicial NUMBER,
    nivelbateriafinal   NUMBER,
    usuario_usuarioid   NUMBER NOT NULL
);

ALTER TABLE metricauso ADD CONSTRAINT metricauso_pk PRIMARY KEY ( metricaid,
                                                                  usuario_usuarioid );

CREATE TABLE rol (
    rolid             NUMBER NOT NULL,
    nombre            VARCHAR2(50 CHAR),
    descripcion       VARCHAR2(254 CHAR),
    usuario_usuarioid NUMBER NOT NULL
);

CREATE UNIQUE INDEX rol__idx ON
    rol (
        usuario_usuarioid
    ASC );

ALTER TABLE rol ADD CONSTRAINT rol_pk PRIMARY KEY ( rolid );

CREATE TABLE usuario (
    usuarioid     NUMBER NOT NULL,
    nombre        VARCHAR2(50 CHAR),
    apellido      VARCHAR2(50 CHAR),
    correo        VARCHAR2(254 CHAR),
    contrasena    VARCHAR2(254 CHAR),
    fechacreacion TIMESTAMP,
    activo        CHAR(1)
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( usuarioid );

ALTER TABLE actividad
    ADD CONSTRAINT actividad_dispositivo_fk
        FOREIGN KEY ( dispositivo_dispositivoid,
                      dispositivo_grupoid )
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
                      dispositivo_grupoid )
            REFERENCES dispositivo ( dispositivoid,
                                     grupo_grupoid );

ALTER TABLE metricauso
    ADD CONSTRAINT metricauso_usuario_fk FOREIGN KEY ( usuario_usuarioid )
        REFERENCES usuario ( usuarioid );

ALTER TABLE rol
    ADD CONSTRAINT rol_usuario_fk FOREIGN KEY ( usuario_usuarioid )
        REFERENCES usuario ( usuarioid );

