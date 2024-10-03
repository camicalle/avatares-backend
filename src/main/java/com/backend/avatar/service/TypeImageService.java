package com.backend.avatar.service;

import com.backend.avatar.entity.ExtensionEntity;
import com.backend.avatar.entity.TypeImageEntity;
import com.backend.avatar.repository.ExtensionRepository;
import com.backend.avatar.repository.TypeImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImageService {

    @Autowired
    private TypeImageRepository typeImageRepository;

    public List<TypeImageEntity> saveAll(List<TypeImageEntity> typeImageEntityList) {
        return typeImageRepository.saveAll(typeImageEntityList);
    }
}
