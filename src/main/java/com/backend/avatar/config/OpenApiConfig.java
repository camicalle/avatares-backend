package com.backend.avatar.config;

import com.backend.avatar.constant.OpenApiConstant;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = OpenApiConstant.NAME_API, version = OpenApiConstant.VERSION_API, description = OpenApiConstant.DESCRIPTION_API),
        servers = {
                @Server(url = OpenApiConstant.URL_SERVER_LOCAL, description = OpenApiConstant.DESCRIPTION_SERVER_LOCAL),
        },
        tags = {
                @Tag(name = OpenApiConstant.AVATAR_CONTROLLER, description = OpenApiConstant.TEXT_CONTROLLER + "avatares"),
                @Tag(name = OpenApiConstant.IMAGE_CONTROLLER, description = OpenApiConstant.TEXT_CONTROLLER + "imagenes"),
        }
)
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "Por favor, ingrese su token JWT en el formato 'Bearer <token>'"
)
public class OpenApiConfig {
}
