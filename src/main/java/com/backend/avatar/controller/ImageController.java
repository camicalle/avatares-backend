package com.backend.avatar.controller;

import com.backend.avatar.service.ImageService;
import com.backend.avatar.dto.request.ImageRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Operation(summary = "Devuelve una imagen codificada en base64")
    @PostMapping(value = "/encode", consumes = "multipart/form-data")
    public String encodeImage(@RequestParam("file") MultipartFile file) throws IOException {
        log.debug("RestController --> image --> encodeImage()");
        return imageService.imageBase64(file);
    }

    @Operation(summary = "Devuelve una imagen decodificada")
    @PostMapping("/decode")
    public ResponseEntity<byte[]> decodeImage(@RequestBody ImageRequest imageRequest) {
        log.debug("RestController --> image --> decodeImage()");
        byte[] imageBytes = imageService.decodeBase64(imageRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + imageService.file(imageRequest));
        return ResponseEntity.ok().headers(headers).body(imageBytes);
    }
}
