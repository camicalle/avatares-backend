package com.backend.avatar.controller;

import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.service.TypeImageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/types-images")
public class TypeImageController {

    @Autowired
    private TypeImageService typeImageService;

    @Operation(summary = "Devuelve un listado de los tipos de imagenes")
    @GetMapping
    public List<TypeImageEntity> findAll() {
        log.debug("RestController --> types-images --> findAll()");
        return typeImageService.findAll();
    }

    @Operation(summary = "Devuelve un listado de los imagenes paginados")
    @GetMapping("/paginate")
    public Page<TypeImageEntity> findAllPageable(Pageable pageable) {
        log.debug("RestController --> types-images --> findAllPageable()");
        return typeImageService.findAllPageable(pageable);
    }

    @Operation(summary = "Inserta varios tipos de imagenes")
    @PostMapping("/saveAll")
    public List<TypeImageEntity> saveAll(@RequestBody List<TypeImageEntity> typeImageEntityList) {
        log.debug("RestController --> types-images --> saveAll()");
        return typeImageService.saveAll(typeImageEntityList);
    }
}
