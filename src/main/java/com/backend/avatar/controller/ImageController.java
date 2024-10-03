package com.backend.avatar.controller;

import com.backend.avatar.entity.AvatarEntity;
import com.backend.avatar.service.ImageService;
import com.backend.avatar.util.ImageRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Operation(summary = "Devuelve una imagen codificada en base64")
    @PostMapping(value = "/encode", consumes = "multipart/form-data")
    public String imageBase64(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.imageBase64(file);
    }

    @Operation(summary = "Devuelve una imagen decodificada")
    @PostMapping("/decode")
    public ResponseEntity<byte[]> decodeImage(@RequestBody ImageRequest imageRequest, @RequestParam String fileName, @RequestParam String typeFile) {
        byte[] imageBytes = imageService.decodeBase64(imageRequest.getCodifyImage());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + imageService.file(fileName, typeFile));
        return ResponseEntity.ok().headers(headers).body(imageBytes);
    }
}
