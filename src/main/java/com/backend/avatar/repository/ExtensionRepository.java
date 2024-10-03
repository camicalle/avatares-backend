package com.backend.avatar.repository;

import com.backend.avatar.entity.ExtensionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExtensionRepository extends JpaRepository<ExtensionEntity, UUID> {
}
