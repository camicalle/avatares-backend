package com.backend.avatar.service;

import com.backend.avatar.entity.AvatarEntity;
import com.backend.avatar.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    public List<AvatarEntity> findAll() {
        return avatarRepository.findAll();
    }

    public Page<AvatarEntity> findAllPageable(Pageable pageable) {
        return avatarRepository.findAll(pageable);
    }

    public Optional<AvatarEntity> findById(UUID id) {
        return avatarRepository.findById(id);
    }

    public AvatarEntity save(AvatarEntity avatar){
        return avatarRepository.save(avatar);
    }

    public void deleteById(UUID id){
        avatarRepository.deleteById(id);
    }
}
