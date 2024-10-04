package com.backend.avatar.entity;

import com.backend.avatar.constant.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "types_image")
public class TypeImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuidTypeImage;

    @Column(unique = true)
    @NotBlank(message = Constant.NOT_BLANK)
    private String name;

    private String description;

    @Column(updatable=false, nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateUpdate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateInactivation;

    private String status = "A";

    @NotBlank(message = Constant.NOT_BLANK)
    private String lastUser;

    @Schema(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "typeImage")
    private List<ExtensionEntity> extension;

    @PrePersist
    public void prePersist() {
        this.dateUpdate = null;
    }

    @PreUpdate
    public void preUpdate() {
        this.dateUpdate = LocalDateTime.now();
    }
}
