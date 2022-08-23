package workspaces.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "workspaces")
public class WorkSpaceEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workspace_cid")
    @Setter
    private Long workspaceCid;

    @Type(type = "uuid-char")
    @Column(name = "workspace_id")
    private UUID workspaceId;


    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;


    @Column(name = "user_cid")
    private Long userCid;

    @Setter
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Setter
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    public static WorkSpaceEntity toEntity(WorkSpaceDto dto) {
        WorkSpaceEntity entity = WorkSpaceEntity.builder()
                .workspaceId(dto.getWorkspaceId())
                .title(dto.getTitle())
                .body(dto.getBody())
                .userCid(dto.getUserCid())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();

        return entity;
    }

}
