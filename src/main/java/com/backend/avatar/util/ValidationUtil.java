package com.backend.avatar.util;

import com.backend.avatar.constant.Constant;
import com.backend.avatar.controller.error.ControllerCustomException;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.UUID;

public class ValidationUtil {
    @FunctionalInterface
    public interface EntityService<T, R> {
        Optional<T> execute(R input);
    }

    public static <T> Optional<T> existsByUuid(UUID uuid, EntityService<T, UUID> service, String text) throws ControllerCustomException {
        Optional<T> t = service.execute(uuid);
        if (t.isEmpty()) {
            throw new ControllerCustomException(
                    HttpStatus.NOT_FOUND.value(),
                    String.format(Constant.MESSAGE_NOT_FOUND, text),
                    Util.formatError(HttpStatus.NOT_FOUND.getReasonPhrase())
            );
        }
        return t;
    }

    public static <T> void existsByName(String name, EntityService<T, String> service, String text) throws ControllerCustomException {
        Optional<T> t = service.execute(name);
        if (t.isPresent()) {
            throw new ControllerCustomException(
                    HttpStatus.CONFLICT.value(),
                    String.format(Constant.MESSAGE_DUPLICATE, text),
                    Util.formatError(HttpStatus.CONFLICT.getReasonPhrase())
            );
        }
    }
}
