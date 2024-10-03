package com.backend.avatar.service;

import com.backend.avatar.entity.AvatarEntity;
import com.backend.avatar.entity.ExtensionEntity;
import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.repository.ExtensionRepository;
import com.backend.avatar.repository.TypeImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImageService {

    @Autowired
    private TypeImageRepository typeImageRepository;

    public List<TypeImageEntity> saveAll(List<TypeImageEntity> typeImageEntityList) {
        return typeImageRepository.saveAll(typeImageEntityList);
    }

    public List<TypeImageEntity> findAll() {
        return typeImageRepository.findAll();
    }

    public Page<TypeImageEntity> findAllPageable(Pageable pageable) {
        return typeImageRepository.findAll(pageable);
    }
}
