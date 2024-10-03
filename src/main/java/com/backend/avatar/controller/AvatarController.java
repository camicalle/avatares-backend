package com.backend.avatar.controller;

import com.backend.avatar.entity.AvatarEntity;
import com.backend.avatar.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @GetMapping
    public List<AvatarEntity> findAll() {
        return avatarService.findAll();
    }

    @GetMapping("/paginado")
    public Page<AvatarEntity> findAllPageable(@RequestParam Integer page, @RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return avatarService.findAllPageable(pageRequest);
    }

    @GetMapping("{id}")
    public Optional<AvatarEntity> findById(@PathVariable UUID id) {
        return avatarService.findById(id);
    }

    @PostMapping()
    public AvatarEntity save(@RequestBody AvatarEntity avatar) {
        return avatarService.save(avatar);
    }

    @DeleteMapping()
    public void deleteById(@RequestParam UUID id) {
        avatarService.deleteById(id);
    }
}
