package com.backend.avatar.dto.request;

import com.backend.avatar.constant.Constant;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ImageRequest {
    @NotBlank(message = Constant.NOT_BLANK)
    private String fileName;

    @NotBlank(message = Constant.NOT_BLANK)
    private String typeFile;

    @NotBlank(message = Constant.NOT_BLANK)
    private String codifyImage;

}
