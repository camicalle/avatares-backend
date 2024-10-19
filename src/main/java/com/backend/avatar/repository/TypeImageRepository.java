package com.backend.avatar.repository;

import com.backend.avatar.entity.TypeImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeImageRepository extends JpaRepository<TypeImageEntity, UUID> {
    public Optional<TypeImageEntity> findByName(String name);

    public Optional<TypeImageEntity> findByUuidAndName(UUID uuidTypeImage, String name);
}
