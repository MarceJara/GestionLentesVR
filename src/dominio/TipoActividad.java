package com.vregister.domain;

/**
 * Enumeración que representa los tipos de actividades que pueden realizarse en el sistema
 */
public enum TipoActividad {
    INICIO_SESION("Inicio de Sesión"),
    CIERRE_SESION("Cierre de Sesión"),
    REGISTRO_DISPOSITIVO("Registro de Dispositivo"),
    ACTUALIZACION_FIRMWARE("Actualización de Firmware"),
    INSTALACION_APLICACION("Instalación de Aplicación"),
    DESINSTALACION_APLICACION("Desinstalación de Aplicación"),
    CONFIGURACION_DISPOSITIVO("Configuración de Dispositivo"),
    CAMBIO_ESTADO_DISPOSITIVO("Cambio de Estado de Dispositivo"),
    ASIGNACION_GRUPO("Asignación a Grupo"),
    CREACION_USUARIO("Creación de Usuario"),
    MODIFICACION_USUARIO("Modificación de Usuario"),
    CREACION_GRUPO("Creación de Grupo"),
    MODIFICACION_GRUPO("Modificación de Grupo");
    
    private final String descripcion;
    
    TipoActividad(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}