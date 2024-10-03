package com.backend.avatar.controller;

import com.backend.avatar.entity.ExtensionEntity;
import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.service.TypeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/extension")
public class TypeImageController {

    @Autowired
    private TypeImageService typeImageService;

    @PostMapping("/saveAll")
    public List<TypeImageEntity> saveAll(@RequestBody List<TypeImageEntity> typeImageEntityList) {
        return typeImageService.saveAll(typeImageEntityList);
    }
}
