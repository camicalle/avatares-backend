package com.backend.avatar.service;

import com.backend.avatar.dto.request.ImageRequest;
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

    public byte[] decodeBase64(ImageRequest imageRequest) {
        return Base64.getDecoder().decode(imageRequest.getCodifyImage());
    }

    public StringBuilder file(ImageRequest imageRequest) {
        StringBuilder file = new StringBuilder();
        file.append(imageRequest.getFileName());
        file.append(".");
        file.append(imageRequest.getTypeFile());
        return file;
    }

}
