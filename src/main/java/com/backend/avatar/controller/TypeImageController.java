package com.backend.avatar.controller;

import com.backend.avatar.constant.Constant;
import com.backend.avatar.controller.error.ControllerCustomException;
import com.backend.avatar.dto.response.ControllerResponse;
import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.service.TypeImageService;
import com.backend.avatar.util.ValidationUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), this.typeImageService.findAll(), Constant.MESSAGE_SELECT));
    }

    @Operation(summary = "Devuelve el tipo de imagen consultado por uuid")
    @GetMapping("/{uuid}")
    public ResponseEntity<ControllerResponse<Optional<TypeImageEntity>>> findByUuid(@PathVariable UUID uuid) throws ControllerCustomException {
        log.debug("RestController --> types-images --> findByUuid()");
        Optional<TypeImageEntity> typeImageExistByUuid = ValidationUtil.existsByUuid(uuid, this.typeImageService::findByUuid, "El uuid");
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), typeImageExistByUuid, Constant.MESSAGE_SELECT));
    }

    @Operation(summary = "Devuelve un listado de los tipos de imagenes paginados")
    @GetMapping("/paginate")
    public ResponseEntity<ControllerResponse<Page<TypeImageEntity>>> findAllPageable(Pageable pageable) {
        log.debug("RestController --> types-images --> findAllPageable()");
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), this.typeImageService.findAllPageable(pageable), Constant.MESSAGE_SELECT));
    }

    @Operation(summary = "Inserta o actualizar un tipo de imagen")
    @PostMapping("/saveAndUpdate")
    public ResponseEntity<ControllerResponse<TypeImageEntity>> saveAndUpdate(@Valid @RequestBody TypeImageEntity typeImageEntity) throws ControllerCustomException {
        log.debug("RestController --> types-images --> saveAll()");
        Optional<TypeImageEntity> typeImageExistByUuidAndName = this.typeImageService.findByUuidAndName(typeImageEntity);
        if (typeImageExistByUuidAndName.isEmpty()) {
            ValidationUtil.existsByName(typeImageEntity.getName(), this.typeImageService::findByName, "El nombre");
        }
        return ResponseEntity.ok(new ControllerResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), this.typeImageService.saveAndUpdate(typeImageEntity), Constant.MESSAGE_INSERT_UPDATE ));
    }
}
