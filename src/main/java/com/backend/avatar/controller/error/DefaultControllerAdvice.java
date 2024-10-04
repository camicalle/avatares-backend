package com.backend.avatar.controller.error;

import com.backend.avatar.constant.Constant;
import com.backend.avatar.dto.response.ControllerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class DefaultControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ControllerCustomException.class})
    protected ResponseEntity<Object> handleAppException(ControllerCustomException ex, WebRequest request) {
        logger.error(Constant.ERROR, ex);
        HttpStatus httpStatus = HttpStatus.valueOf(ex.getResponse().getStatus());
        return handleExceptionInternal(ex, ex.getResponse(), new HttpHeaders(), httpStatus, request);
    }

    @ExceptionHandler( Exception.class )
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        logger.error(Constant.ERROR, ex);
        return new ResponseEntity<>(
                new ControllerResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null, ex.getMessage()),
                HttpStatus.OK
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            logger.error(Constant.ERROR, ex);
            errors.append(String.format(Objects.requireNonNull(fieldError.getDefaultMessage()), fieldError.getField() ) ).append(" | ");
        });
        return handleExceptionInternal(ex, new ControllerResponse<>(HttpStatus.BAD_REQUEST.value(), null, errors.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
                new HttpHeaders(), HttpStatus.OK, request);
    }
}
