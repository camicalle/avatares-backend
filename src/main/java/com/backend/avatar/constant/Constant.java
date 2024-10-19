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
}
