package com.backend.avatar.entity;

import com.backend.avatar.constant.Constant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "avatars")
public class AvatarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuidAvatar;

    @Lob
    @NotBlank(message = Constant.NOT_BLANK)
    private String image;

    private String name;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdate;

    private LocalDateTime dateInactivation;

    private String status = "A";

    @NotBlank(message = Constant.NOT_BLANK)
    private String lastUser;

    @ManyToOne
    @JoinColumn(name = "uuid_extension")
    private ExtensionEntity extension;
}
