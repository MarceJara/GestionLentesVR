--losprocedures para usuario

DELIMITER //

CREATE PROCEDURE insertar_usuario(
    OUT p_usuarioid INT,
    IN p_nombre VARCHAR(50),
    IN p_apellido VARCHAR(50),
    IN p_correo VARCHAR(254),
    IN p_contrasena VARCHAR(254),
    IN p_fechacreacion TIMESTAMP,
    IN p_activo CHAR(1),
    IN p_rol_rolid INT
)
BEGIN
    INSERT INTO usuario(usuarioid, nombre, apellido, correo, contrasena, fechacreacion, rol_rolid, activo)
    VALUES (p_usuarioid, p_nombre, p_apellido, p_correo, p_contrasena, p_fechacreacion, p_rol_rolid, p_activo);
END;
//

CREATE PROCEDURE actualizar_usuario(
    IN p_usuarioid INT,
    IN p_nombre VARCHAR(50),
    IN p_apellido VARCHAR(50),
    IN p_correo VARCHAR(254),
    IN p_contrasena VARCHAR(254),
    IN p_activo CHAR(1),
    IN p_rol_rolid INT
)
BEGIN
    UPDATE usuario
    SET nombre = p_nombre,
        apellido = p_apellido,
        correo = p_correo,
        contrasena = p_contrasena,
        activo = p_activo,
        rol_rolid = p_rol_rolid
    WHERE usuarioid = p_usuarioid;
END;
//

CREATE PROCEDURE eliminar_usuario(
    IN p_usuarioid INT
)
BEGIN
    UPDATE usuario SET activo = 'N' WHERE usuarioid = p_usuarioid;
END;
//

CREATE PROCEDURE listar_usuarios()
BEGIN
    SELECT * FROM usuario WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_usuario(
    IN p_usuarioid INT
)
BEGIN
    SELECT * FROM usuario WHERE usuarioid = p_usuarioid;
END;
//

DELIMITER ;


--los procedures para grupos
DELIMITER //

CREATE PROCEDURE insertar_grupo(
    OUT p_grupoid INT,
    IN p_nombre VARCHAR(80),
    IN p_descripcion VARCHAR(254),
    IN p_fechacreacion TIMESTAMP,
    IN p_ubicacion VARCHAR(254),
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO grupo(grupoid, nombre, descripcion, fechacreacion, ubicacion, activo)
    VALUES (p_grupoid, p_nombre, p_descripcion, p_fechacreacion, p_ubicacion, p_activo);
END;
//

CREATE PROCEDURE actualizar_grupo(
    IN p_grupoid INT,
    IN p_nombre VARCHAR(80),
    IN p_descripcion VARCHAR(254),
    IN p_fechacreacion TIMESTAMP,
    IN p_ubicacion VARCHAR(254),
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE grupo
    SET nombre = p_nombre,
        descripcion = p_descripcion,
        fechacreacion = p_fechacreacion,
        ubicacion = p_ubicacion,
        activo = p_activo
    WHERE grupoid = p_grupoid;
END;
//

CREATE PROCEDURE eliminar_grupo(
    IN p_grupoid INT
)
BEGIN
    UPDATE grupo SET activo = 'N' WHERE grupoid = p_grupoid;
END;
//

CREATE PROCEDURE listar_grupo()
BEGIN
    SELECT * FROM grupo WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_grupo(
    IN p_grupoid INT
)
BEGIN
    SELECT * FROM grupo WHERE grupoid = p_grupoid;
END;
//

DELIMITER ;

--los procedures para dispositivos
DELIMITER //

CREATE PROCEDURE insertar_dispositivo(
    OUT p_dispositivoid INT,
    IN p_nombre VARCHAR(90),
    IN p_modelo VARCHAR(254),
    IN p_numeroserie VARCHAR(254),
    IN p_fecharegistro TIMESTAMP,
    IN p_ubicacion VARCHAR(254),
    IN p_activo CHAR(1),
    IN p_nivelbateria INT,
    IN p_ultimaconexion TIMESTAMP,
    IN p_grupo_grupoid INT
)
BEGIN
    INSERT INTO dispositivo(dispositivoid, nombre, modelo, numeroserie, fecharegistro, ubicacion, activo, nivelbateria, ultimaconexion, grupo_grupoid)
    VALUES (p_dispositivoid, p_nombre, p_modelo, p_numeroserie, p_fecharegistro, p_ubicacion, p_activo, p_nivelbateria, p_ultimaconexion, p_grupo_grupoid);
END;
//

CREATE PROCEDURE actualizar_dispositivo(
    IN p_dispositivoid INT,
    IN p_nombre VARCHAR(90),
    IN p_modelo VARCHAR(254),
    IN p_numeroserie VARCHAR(254),
    IN p_fecharegistro TIMESTAMP,
    IN p_ubicacion VARCHAR(254),
    IN p_activo CHAR(1),
    IN p_nivelbateria INT,
    IN p_ultimaconexion TIMESTAMP,
    IN p_grupo_grupoid INT
)
BEGIN
    UPDATE dispositivo
    SET nombre = p_nombre,
        modelo = p_modelo,
        numeroserie = p_numeroserie,
        fecharegistro = p_fecharegistro,
        ubicacion = p_ubicacion,
        activo = p_activo,
        nivelbateria = p_nivelbateria,
        ultimaconexion = p_ultimaconexion
    WHERE dispositivoid = p_dispositivoid AND grupo_grupoid = p_grupo_grupoid;
END;
//

CREATE PROCEDURE eliminar_dispositivo(
    IN p_dispositivoid INT, IN p_grupo_grupoid INT
)
BEGIN
    UPDATE dispositivo 
    SET activo = 'N' 
    WHERE dispositivoid = p_dispositivoid 
		AND grupo_grupoid = p_grupo_grupoid;
END;
//

CREATE PROCEDURE listar_dispositivo()
BEGIN
    SELECT * 
    FROM dispositivo 
    WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_dispositivo(
    IN p_dispositivoid INT, IN p_grupo_grupoid INT
)
BEGIN
    SELECT * 
    FROM dispositivo 
    WHERE dispositivoid = p_dispositivoid AND grupo_grupoid = p_grupo_grupoid;
END;
//

DELIMITER ;

--los procedures para actividades

DELIMITER //

CREATE PROCEDURE insertar_actividad(
    OUT p_actividadid INT,
    IN p_fechahora TIMESTAMP,
    IN p_descripcion VARCHAR(254),
    IN p_detallestecnicos VARCHAR(254),
    IN p_usuario_usuarioid INT,
    IN p_dispositivo_dispositivoid INT,
    IN p_dispositivo_grupo_grupoid INT,
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO actividad(actividadid, fechahora, descripcion, detallestecnicos, usuario_usuarioid, dispositivo_dispositivoid, dispositivo_grupo_grupoid, activo)
    VALUES (p_actividadid, p_fechahora, p_descripcion, p_detallestecnicos, p_usuario_usuarioid, p_dispositivo_dispositivoid, p_dispositivo_grupo_grupoid, p_activo);
END;
//

CREATE PROCEDURE actualizar_actividad(
    IN p_actividadid INT,
    IN p_fechahora TIMESTAMP,
    IN p_descripcion VARCHAR(254),
    IN p_detallestecnicos VARCHAR(254),
    IN p_usuario_usuarioid INT,
    IN p_dispositivo_dispositivoid INT,
    IN p_dispositivo_grupo_grupoid INT,
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE actividad
    SET fechahora = p_fechahora,
        descripcion = p_descripcion,
        detallestecnicos = p_detallestecnicos,
        usuario_usuarioid = p_usuario_usuarioid,
        dispositivo_dispositivoid = p_dispositivo_dispositivoid,
        dispositivo_grupo_grupoid = p_dispositivo_grupo_grupoid,
        activo = p_activo
    WHERE actividadid = p_actividadid;
END;
//

CREATE PROCEDURE eliminar_actividad(
    IN p_actividadid INT
)
BEGIN
    UPDATE actividad SET activo = 'N' WHERE actividadid = p_actividadid;
END;
//

CREATE PROCEDURE listar_actividad()
BEGIN
    SELECT * FROM actividad WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_actividad(
    IN p_actividadid INT
)
BEGIN
    SELECT * FROM actividad WHERE actividadid = p_actividadid;
END;
//

DELIMITER ;

--los procedures para aplicaciones

DELIMITER //

CREATE PROCEDURE insertar_aplicacion(
    OUT p_aplicacionid INT,
    IN p_nombre VARCHAR(100),
    IN p_version VARCHAR(254),
    IN p_desarrollador VARCHAR(254),
    IN p_fechalanzamiento TIMESTAMP,
    IN p_descripcion VARCHAR(254),
    IN p_tamanomb DECIMAL(10,2),
    IN p_rutainstalador VARCHAR(254),
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO aplicacion(aplicacionid, nombre, version, desarrollador, fechalanzamiento, descripcion, tamanomb, rutainstalador, activo)
    VALUES (p_aplicacionid, p_nombre, p_version, p_desarrollador, p_fechalanzamiento, p_descripcion, p_tamanomb, p_rutainstalador, p_activo);
END;
//

CREATE PROCEDURE actualizar_aplicacion(
    IN p_aplicacionid INT,
    IN p_nombre VARCHAR(100),
    IN p_version VARCHAR(254),
    IN p_desarrollador VARCHAR(254),
    IN p_fechalanzamiento TIMESTAMP,
    IN p_descripcion VARCHAR(254),
    IN p_tamanomb DECIMAL(10,2),
    IN p_rutainstalador VARCHAR(254),
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE aplicacion
    SET nombre = p_nombre,
        version = p_version,
        desarrollador = p_desarrollador,
        fechalanzamiento = p_fechalanzamiento,
        descripcion = p_descripcion,
        tamanomb = p_tamanomb,
        rutainstalador = p_rutainstalador,
        activo = p_activo
    WHERE aplicacionid = p_aplicacionid;
END;
//

CREATE PROCEDURE eliminar_aplicacion(
    IN p_aplicacionid INT
)
BEGIN
    UPDATE aplicacion 
    SET activo = 'N' 
    WHERE aplicacionid = p_aplicacionid;
END;
//

CREATE PROCEDURE listar_aplicacion()
BEGIN
    SELECT * FROM aplicacion WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_aplicacion(
    IN p_aplicacionid INT
)
BEGIN
    SELECT * 
    FROM aplicacion 
    WHERE aplicacionid = p_aplicacionid;
END;
//

DELIMITER ;

--los procedures para configuraciones

DELIMITER //

CREATE PROCEDURE insertar_configuracion(
    OUT p_configuracionid INT,
    IN p_nombre VARCHAR(254),
    IN p_descripcion VARCHAR(254),
    IN p_fechacreacion TIMESTAMP,
    IN p_valor VARCHAR(254),
    IN p_usuario_usuarioid INT,
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO configuracion(configuracionid, nombre, descripcion, fechacreacion, valor, usuario_usuarioid, activo)
    VALUES (p_configuracionid, p_nombre, p_descripcion, p_fechacreacion, p_valor, p_usuario_usuarioid, p_activo);
END;
//

CREATE PROCEDURE actualizar_configuracion(
    IN p_configuracionid INT,
    IN p_nombre VARCHAR(254),
    IN p_descripcion VARCHAR(254),
    IN p_fechacreacion TIMESTAMP,
    IN p_valor VARCHAR(254),
    IN p_usuario_usuarioid INT,
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE configuracion
    SET nombre = p_nombre,
        descripcion = p_descripcion,
        fechacreacion = p_fechacreacion,
        valor = p_valor,
        activo = p_activo
    WHERE configuracionid = p_configuracionid AND usuario_usuarioid = p_usuario_usuarioid;
END;
//

CREATE PROCEDURE eliminar_configuracion(
    IN p_configuracionid INT, IN p_usuario_usuarioid INT
)
BEGIN
    UPDATE configuracion 
    SET activo = 'N' 
    WHERE configuracionid = p_configuracionid 
		AND usuario_usuarioid = p_usuario_usuarioid;
END;
//

CREATE PROCEDURE listar_configuracion()
BEGIN
    SELECT * 
    FROM configuracion 
    WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_configuracion(
    IN p_configuracionid INT, IN p_usuario_usuarioid INT
)
BEGIN
    SELECT * 
    FROM configuracion 
    WHERE configuracionid = p_configuracionid 
		AND usuario_usuarioid = p_usuario_usuarioid;
END;
//

DELIMITER ;

--los procedures para firmware

DELIMITER //

CREATE PROCEDURE insertar_firmware(
    OUT p_firmwareid INT,
    IN p_nombre VARCHAR(254),
    IN p_version VARCHAR(254),
    IN p_fechalanzamiento TIMESTAMP,
    IN p_descripcion VARCHAR(254),
    IN p_rutaarchivo VARCHAR(254),
    IN p_dispositivo_dispositivoid INT,
    IN p_dispositivo_grupo_grupoid INT,
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO firmware(firmwareid, nombre, version, fechalanzamiento, descripcion, rutaarchivo, dispositivo_dispositivoid, dispositivo_grupo_grupoid, activo)
    VALUES (p_firmwareid, p_nombre, p_version, p_fechalanzamiento, p_descripcion, p_rutaarchivo, p_dispositivo_dispositivoid, p_dispositivo_grupo_grupoid, p_activo);
END;
//

CREATE PROCEDURE actualizar_firmware(
    IN p_firmwareid INT,
    IN p_nombre VARCHAR(254),
    IN p_version VARCHAR(254),
    IN p_fechalanzamiento TIMESTAMP,
    IN p_descripcion VARCHAR(254),
    IN p_rutaarchivo VARCHAR(254),
    IN p_dispositivo_dispositivoid INT,
    IN p_dispositivo_grupo_grupoid INT,
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE firmware
    SET nombre = p_nombre,
        version = p_version,
        fechalanzamiento = p_fechalanzamiento,
        descripcion = p_descripcion,
        rutaarchivo = p_rutaarchivo,
        dispositivo_dispositivoid = p_dispositivo_dispositivoid,
        dispositivo_grupo_grupoid = p_dispositivo_grupo_grupoid,
        activo = p_activo
    WHERE firmwareid = p_firmwareid;
END;
//

CREATE PROCEDURE eliminar_firmware(
    IN p_firmwareid INT
)
BEGIN
    UPDATE firmware 
    SET activo = 'N' 
    WHERE firmwareid = p_firmwareid;
END;
//

CREATE PROCEDURE listar_firmware()
BEGIN
    SELECT * 
    FROM firmware 
    WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_firmware(
    IN p_firmwareid INT
)
BEGIN
    SELECT * 
    FROM firmware 
    WHERE firmwareid = p_firmwareid;
END;
//

DELIMITER ;

--los procedures para méticas de uso

DELIMITER //

CREATE PROCEDURE insertar_metricauso(
    OUT p_metricaid INT,
    IN p_fecharegistro TIMESTAMP,
    IN p_tiempousominutos INT,
    IN p_nivelbateriainicial INT,
    IN p_nivelbateriafinal INT,
    IN p_usuario_usuarioid INT,
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO metricauso(metricaid, fecharegistro, tiempousominutos, nivelbateriainicial, nivelbateriafinal, usuario_usuarioid, activo)
    VALUES (p_metricaid, p_fecharegistro, p_tiempousominutos, p_nivelbateriainicial, p_nivelbateriafinal, p_usuario_usuarioid, p_activo);
END;
//

CREATE PROCEDURE actualizar_metricauso(
    IN p_metricaid INT,
    IN p_fecharegistro TIMESTAMP,
    IN p_tiempousominutos INT,
    IN p_nivelbateriainicial INT,
    IN p_nivelbateriafinal INT,
    IN p_usuario_usuarioid INT,
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE metricauso
    SET fecharegistro = p_fecharegistro,
        tiempousominutos = p_tiempousominutos,
        nivelbateriainicial = p_nivelbateriainicial,
        nivelbateriafinal = p_nivelbateriafinal,
        activo = p_activo
    WHERE metricaid = p_metricaid AND usuario_usuarioid = p_usuario_usuarioid;
END;
//

CREATE PROCEDURE eliminar_metricauso(
    IN p_metricaid INT, IN p_usuario_usuarioid INT
)
BEGIN
    UPDATE metricauso 
    SET activo = 'N' 
    WHERE metricaid = p_metricaid 
		AND usuario_usuarioid = p_usuario_usuarioid;
END;
//

CREATE PROCEDURE listar_metricauso()
BEGIN
    SELECT * 
    FROM metricauso 
    WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_metricauso(
    IN p_metricaid INT, IN p_usuario_usuarioid INT
)
BEGIN
    SELECT * 
    FROM metricauso 
    WHERE metricaid = p_metricaid 
		AND usuario_usuarioid = p_usuario_usuarioid;
END;
//

DELIMITER ;

--los procedures para rol

DELIMITER //

CREATE PROCEDURE insertar_rol(
    OUT p_rolid INT,
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(254),
    IN p_activo CHAR(1)
)
BEGIN
    INSERT INTO rol(rolid, nombre, descripcion, activo)
    VALUES (p_rolid, p_nombre, p_descripcion, p_activo);
END;
//

CREATE PROCEDURE actualizar_rol(
    IN p_rolid INT,
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(254),
    IN p_activo CHAR(1)
)
BEGIN
    UPDATE rol
    SET nombre = p_nombre,
        descripcion = p_descripcion,
        activo = p_activo
    WHERE rolid = p_rolid;
END;
//

CREATE PROCEDURE eliminar_rol(
    IN p_rolid INT
)
BEGIN
    UPDATE rol 
    SET activo = 'N' 
    WHERE rolid = p_rolid;
END;
//

CREATE PROCEDURE listar_rol()
BEGIN
    SELECT * 
    FROM rol 
    WHERE activo = 'S';
END;
//

CREATE PROCEDURE obtener_rol(
    IN p_rolid INT
)
BEGIN
    SELECT * FROM rol WHERE rolid = p_rolid;
END;
//

DELIMITER ;
