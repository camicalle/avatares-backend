package com.backend.avatar.service;

import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.repository.TypeImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TypeImageService {

    @Autowired
    private TypeImageRepository typeImageRepository;

    public TypeImageEntity saveAndUpdate(TypeImageEntity typeImageEntity) {

        if (typeImageEntity.getStatus().equals("I")) {
            typeImageEntity.setDateInactivation(LocalDateTime.now());
        } else if (typeImageEntity.getStatus().equals("A")) {
            typeImageEntity.setDateInactivation(null);
        }

        return typeImageRepository.save(typeImageEntity);
    }

    public List<TypeImageEntity> findAll() {
        return typeImageRepository.findAll();
    }

    public Page<TypeImageEntity> findAllPageable(Pageable pageable) {
        return typeImageRepository.findAll(pageable);
    }

    public Optional<TypeImageEntity> findByName(String name) {
        return typeImageRepository.findByName(name);
    }

    public Optional<TypeImageEntity> findByUuidAndName(TypeImageEntity typeImageEntity) {
        return typeImageRepository.findByUuidAndName(typeImageEntity.getUuid(), typeImageEntity.getName());
    }

    public Optional<TypeImageEntity> findByUuid(UUID uuid) {
        return typeImageRepository.findById(uuid);
    }
}
