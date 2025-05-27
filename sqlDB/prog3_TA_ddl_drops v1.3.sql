SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP TABLE IF EXISTS `grupo` ;

CREATE TABLE IF NOT EXISTS `grupo` (
  `grupoid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NULL DEFAULT NULL,
  `descripcion` VARCHAR(254) NULL DEFAULT NULL,
  `fechacreacion` TIMESTAMP NULL DEFAULT NULL,
  `ubicacion` VARCHAR(254) NULL DEFAULT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`grupoid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dispositivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dispositivo` ;

CREATE TABLE IF NOT EXISTS `dispositivo` (
  `dispositivoid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(90) NULL DEFAULT NULL,
  `modelo` VARCHAR(254) NULL DEFAULT NULL,
  `numeroserie` VARCHAR(254) NULL DEFAULT NULL,
  `fecharegistro` TIMESTAMP NULL DEFAULT NULL,
  `ubicacion` VARCHAR(254) NULL DEFAULT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  `nivelbateria` INT NULL DEFAULT NULL,
  `ultimaconexion` TIMESTAMP NULL DEFAULT NULL,
  `grupo_grupoid` INT NOT NULL,
  PRIMARY KEY (`dispositivoid`, `grupo_grupoid`),
  INDEX `dispositivo_grupo_fk` (`grupo_grupoid` ASC) VISIBLE,
  CONSTRAINT `dispositivo_grupo_fk`
    FOREIGN KEY (`grupo_grupoid`)
    REFERENCES `grupo` (`grupoid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rol` ;

CREATE TABLE IF NOT EXISTS `rol` (
  `rolid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(254) NULL DEFAULT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`rolid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario` ;

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuarioid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido` VARCHAR(50) NULL DEFAULT NULL,
  `correo` VARCHAR(254) NULL DEFAULT NULL,
  `contrasena` VARCHAR(254) NULL DEFAULT NULL,
  `fechacreacion` TIMESTAMP NULL DEFAULT NULL,
  `rol_rolid` INT NOT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`usuarioid`),
  INDEX `usuario_rol_fk` (`rol_rolid` ASC) VISIBLE,
  CONSTRAINT `usuario_rol_fk`
    FOREIGN KEY (`rol_rolid`)
    REFERENCES `rol` (`rolid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `actividad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `actividad` ;

CREATE TABLE IF NOT EXISTS `actividad` (
  `actividadid` INT NOT NULL AUTO_INCREMENT,
  `fechahora` TIMESTAMP NULL DEFAULT NULL,
  `descripcion` VARCHAR(254) NULL DEFAULT NULL,
  `detallestecnicos` VARCHAR(254) NULL DEFAULT NULL,
  `usuario_usuarioid` INT NOT NULL,
  `dispositivo_dispositivoid` INT NOT NULL,
  `dispositivo_grupo_grupoid` INT NOT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`actividadid`),
  INDEX `actividad_dispositivo_fk` (`dispositivo_dispositivoid` ASC, `dispositivo_grupo_grupoid` ASC) VISIBLE,
  INDEX `actividad_usuario_fk` (`usuario_usuarioid` ASC) VISIBLE,
  CONSTRAINT `actividad_dispositivo_fk`
    FOREIGN KEY (`dispositivo_dispositivoid` , `dispositivo_grupo_grupoid`)
    REFERENCES `dispositivo` (`dispositivoid` , `grupo_grupoid`),
  CONSTRAINT `actividad_usuario_fk`
    FOREIGN KEY (`usuario_usuarioid`)
    REFERENCES `usuario` (`usuarioid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aplicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aplicacion` ;

CREATE TABLE IF NOT EXISTS `aplicacion` (
  `aplicacionid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `version` VARCHAR(254) NULL DEFAULT NULL,
  `desarrollador` VARCHAR(254) NULL DEFAULT NULL,
  `fechalanzamiento` TIMESTAMP NULL DEFAULT NULL,
  `descripcion` VARCHAR(254) NULL DEFAULT NULL,
  `tamanomb` DOUBLE(10,2) NULL DEFAULT NULL,
  `rutainstalador` VARCHAR(254) NULL DEFAULT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`aplicacionid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `configuracion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `configuracion` ;

CREATE TABLE IF NOT EXISTS `configuracion` (
  `configuracionid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(254) NULL DEFAULT NULL,
  `descripcion` VARCHAR(254) NULL DEFAULT NULL,
  `fechacreacion` TIMESTAMP NULL DEFAULT NULL,
  `valor` VARCHAR(254) NULL DEFAULT NULL,
  `usuario_usuarioid` INT NOT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`configuracionid`, `usuario_usuarioid`),
  INDEX `configuracion_usuario_fk` (`usuario_usuarioid` ASC) VISIBLE,
  CONSTRAINT `configuracion_usuario_fk`
    FOREIGN KEY (`usuario_usuarioid`)
    REFERENCES `usuario` (`usuarioid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `disp_app`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disp_app` ;

CREATE TABLE IF NOT EXISTS `disp_app` (
  `dispositivo_dispositivoid` INT NOT NULL,
  `dispositivo_grupoid` INT NOT NULL,
  `aplicacion_aplicacionid` INT NOT NULL,
  PRIMARY KEY (`dispositivo_dispositivoid`, `dispositivo_grupoid`, `aplicacion_aplicacionid`),
  INDEX `disp_app_aplicacion_fk` (`aplicacion_aplicacionid` ASC) VISIBLE,
  CONSTRAINT `disp_app_aplicacion_fk`
    FOREIGN KEY (`aplicacion_aplicacionid`)
    REFERENCES `aplicacion` (`aplicacionid`),
  CONSTRAINT `disp_app_dispositivo_fk`
    FOREIGN KEY (`dispositivo_dispositivoid` , `dispositivo_grupoid`)
    REFERENCES `dispositivo` (`dispositivoid` , `grupo_grupoid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `disp_conf`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disp_conf` ;

CREATE TABLE IF NOT EXISTS `disp_conf` (
  `configuracion_configuracionid` INT NOT NULL,
  `configuracion_usuarioid` INT NOT NULL,
  `dispositivo_dispositivoid` INT NOT NULL,
  `dispositivo_grupoid` INT NOT NULL,
  PRIMARY KEY (`configuracion_configuracionid`, `configuracion_usuarioid`, `dispositivo_dispositivoid`, `dispositivo_grupoid`),
  INDEX `disp_conf_dispositivo_fk` (`dispositivo_dispositivoid` ASC, `dispositivo_grupoid` ASC) VISIBLE,
  CONSTRAINT `disp_conf_configuracion_fk`
    FOREIGN KEY (`configuracion_configuracionid` , `configuracion_usuarioid`)
    REFERENCES `configuracion` (`configuracionid` , `usuario_usuarioid`),
  CONSTRAINT `disp_conf_dispositivo_fk`
    FOREIGN KEY (`dispositivo_dispositivoid` , `dispositivo_grupoid`)
    REFERENCES `dispositivo` (`dispositivoid` , `grupo_grupoid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `firmware`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `firmware` ;

CREATE TABLE IF NOT EXISTS `firmware` (
  `firmwareid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(254) NULL DEFAULT NULL,
  `version` VARCHAR(254) NULL DEFAULT NULL,
  `fechalanzamiento` TIMESTAMP NULL DEFAULT NULL,
  `descripcion` VARCHAR(254) NULL DEFAULT NULL,
  `rutaarchivo` VARCHAR(254) NULL DEFAULT NULL,
  `dispositivo_dispositivoid` INT NOT NULL,
  `dispositivo_grupo_grupoid` INT NOT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`firmwareid`),
  UNIQUE INDEX `firmware__idx` (`dispositivo_dispositivoid` ASC, `dispositivo_grupo_grupoid` ASC) VISIBLE,
  CONSTRAINT `firmware_dispositivo_fk`
    FOREIGN KEY (`dispositivo_dispositivoid` , `dispositivo_grupo_grupoid`)
    REFERENCES `dispositivo` (`dispositivoid` , `grupo_grupoid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `metricauso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metricauso` ;

CREATE TABLE IF NOT EXISTS `metricauso` (
  `metricaid` INT NOT NULL AUTO_INCREMENT,
  `fecharegistro` TIMESTAMP NULL DEFAULT NULL,
  `tiempousominutos` INT NULL DEFAULT NULL,
  `nivelbateriainicial` INT NULL DEFAULT NULL,
  `nivelbateriafinal` INT NULL DEFAULT NULL,
  `usuario_usuarioid` INT NOT NULL,
  `activo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`metricaid`, `usuario_usuarioid`),
  INDEX `metricauso_usuario_fk` (`usuario_usuarioid` ASC) VISIBLE,
  CONSTRAINT `metricauso_usuario_fk`
    FOREIGN KEY (`usuario_usuarioid`)
    REFERENCES `usuario` (`usuarioid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;