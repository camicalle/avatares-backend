package com.backend.avatar.util;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageRequest {
    @NotBlank
    private String codifyImage;
}
