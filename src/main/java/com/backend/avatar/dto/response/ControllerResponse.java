package com.backend.avatar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ControllerResponse<T> {
    private int code;
    private T data;
    private String message;
}
