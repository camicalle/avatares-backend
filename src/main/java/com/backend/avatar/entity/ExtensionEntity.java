package com.backend.avatar.entity;

import com.backend.avatar.constant.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "extensiones")
public class ExtensionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuidExtension;

    @NotNull(message = Constant.NOT_BLANK)
    private String name;

    private String description;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdate;

    private LocalDateTime dateInactivation;

    private String status = "A";

    @NotNull(message = Constant.NOT_BLANK)
    private String lastUser;

    @Schema(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "extension")
    private List<AvatarEntity> avatars;

    @ManyToOne
    @JoinColumn(name = "uuid_type_image")
    private  TypeImageEntity typeImage;
}
