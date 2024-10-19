package com.backend.avatar.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Constant {
    public static final String ERROR                    = "::ERROR::";

    //Mensajes @Valid
    public static final String NOT_BLANK                = "El campo %s es obligatorio";
    public static final String MESSAGE_STATUS           = "El estado debe ser 'A' o 'I'";
    public static final String MESSAGE_DUPLICATE        = "%s ya existe";
    public static final String MESSAGE_NOT_FOUND        = "%s no existe";

    //Mensajes de repuesta exitosas
    public static final String MESSAGE_SELECT           = "Consulta ejecutada con exito";
    public static final String MESSAGE_INSERT_UPDATE    = "Registro insertado o actualizado con exito";

    //Mensajes y status documentacion api
    public static final String MEDIA_TYPE           = "application/json";

    public static final String STATUS_200           = "200";
    public static final String STATUS_400           = "400";
    public static final String STATUS_404           = "404";
    public static final String STATUS_409           = "409";
    public static final String STATUS_500           = "500";

    public static final String TEXT_STATUS_200      = "Operación exitosa";
    public static final String TEXT_STATUS_400      = "Solicitud incorrecta";
    public static final String TEXT_STATUS_404      = "Recurso no encontrado";
    public static final String TEXT_STATUS_409      = "Conflicto de Duplicación";
    public static final String TEXT_STATUS_500      = "Error interno del servidor";
}
