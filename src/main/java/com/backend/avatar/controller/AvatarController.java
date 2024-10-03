package com.backend.avatar.controller;

import com.backend.avatar.entity.AvatarEntity;
import com.backend.avatar.service.AvatarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @Operation(summary = "Devuelve un listado de avatares")
    @GetMapping
    public List<AvatarEntity> findAll() {
        log.debug("RestController --> avatar --> findAll()");
        return avatarService.findAll();
    }

    @Operation(summary = "Devuelve un listado de avatares")
    @GetMapping("/paginate")
    public Page<AvatarEntity> findAllPageable(@RequestParam Integer page, @RequestParam Integer size) {
        log.debug("RestController --> avatar --> findAllPageable()");
        PageRequest pageRequest = PageRequest.of(page, size);
        return avatarService.findAllPageable(pageRequest);
    }

    @Operation(summary = "Devuelve un avatar buscado por id")
    @GetMapping("{id}")
    public Optional<AvatarEntity> findById(@PathVariable UUID id) {
        log.debug("RestController --> avatar --> findById()");
        return avatarService.findById(id);
    }

    @Operation(summary = "Inserta un nuevo avatar")
    @PostMapping()
    public AvatarEntity save(@RequestBody AvatarEntity avatar) {
        log.debug("RestController --> avatar --> save()");
        return avatarService.save(avatar);
    }

    @Operation(summary = "Elimina un avatar con un id en especifico")
    @DeleteMapping()
    public void deleteById(@RequestParam UUID id) {
        log.debug("RestController --> avatar --> deleteById()");
        avatarService.deleteById(id);
    }
}
