package com.backend.avatar.controller;

import com.backend.avatar.dto.response.ControllerResponse;
import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.service.TypeImageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ControllerResponse<List<TypeImageEntity>>> findAll() {
        log.debug("RestController --> types-images --> findAll()");
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), typeImageService.findAll(), HttpStatus.OK.getReasonPhrase()));
    }

    @Operation(summary = "Devuelve un listado de los imagenes paginados")
    @GetMapping("/paginate")
    public ResponseEntity<ControllerResponse<Page<TypeImageEntity>>> findAllPageable(Pageable pageable) {
        log.debug("RestController --> types-images --> findAllPageable()");
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), typeImageService.findAllPageable(pageable), HttpStatus.OK.getReasonPhrase()));
    }

    @Operation(summary = "Inserta varios tipos de imagenes")
    @PostMapping("/saveAll")
    public ResponseEntity<ControllerResponse<List<TypeImageEntity>>> saveAll(@RequestBody List<TypeImageEntity> typeImageEntityList) {
        log.debug("RestController --> types-images --> saveAll()");
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), typeImageService.saveAll(typeImageEntityList), HttpStatus.OK.getReasonPhrase()));
    }
}
