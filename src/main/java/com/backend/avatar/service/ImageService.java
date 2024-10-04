package com.backend.avatar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
@Slf4j
public class ImageService {

    public String imageBase64(MultipartFile file) throws IOException {
        return Base64.getEncoder().encodeToString(file.getBytes());
    }

    public byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    public StringBuilder file(String fileName, String typeFile) {
        StringBuilder file = new StringBuilder();
        file.append(fileName);
        file.append(".");
        file.append(typeFile);
        return file;
    }

}
