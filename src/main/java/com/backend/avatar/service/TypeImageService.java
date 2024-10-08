package com.backend.avatar.service;

import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.repository.TypeImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TypeImageService {

    @Autowired
    private TypeImageRepository typeImageRepository;

    public TypeImageEntity saveAndUpdate(TypeImageEntity typeImageEntity) {

        if (typeImageEntity.getStatus().equals("I")) {
            typeImageEntity.setDateInactivation(LocalDateTime.now());
        }

        return typeImageRepository.save(typeImageEntity);
    }

    public List<TypeImageEntity> findAll() {
        return typeImageRepository.findAll();
    }

    public Page<TypeImageEntity> findAllPageable(Pageable pageable) {
        return typeImageRepository.findAll(pageable);
    }
}
