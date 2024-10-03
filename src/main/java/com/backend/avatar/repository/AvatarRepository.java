package com.backend.avatar.repository;

import com.backend.avatar.entity.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvatarRepository extends JpaRepository<AvatarEntity, UUID> {
}
