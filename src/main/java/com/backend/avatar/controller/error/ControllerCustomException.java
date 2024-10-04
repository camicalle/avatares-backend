package com.backend.avatar.controller.error;

import com.backend.avatar.dto.response.ControllerResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ControllerCustomException extends Exception {
    private int status;
    private String code;
    private String message;

    public ControllerResponse<Object> getResponse() {
        return new ControllerResponse<>(status, code, null, message);
    }
}
