package com.backend.avatar.controller;

import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.service.TypeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extension")
public class TypeImageController {

    @Autowired
    private TypeImageService typeImageService;

    @GetMapping
    public List<TypeImageEntity> findAll() {
        return typeImageService.findAll();
    }

    @GetMapping("/paginate")
    public Page<TypeImageEntity> findAllPageable(Pageable pageable) {
        return typeImageService.findAllPageable(pageable);
    }

    @PostMapping("/saveAll")
    public List<TypeImageEntity> saveAll(@RequestBody List<TypeImageEntity> typeImageEntityList) {
        return typeImageService.saveAll(typeImageEntityList);
    }
}
