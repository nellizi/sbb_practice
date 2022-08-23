package workspaces.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpaceDto {

    /**
     * 데이터 전달 모델 클래스
     * Data Transfer Object
     */
    private Long workspaceCid;

    private UUID workspaceId;

    @Setter
    private String title;

    @Setter
    private String body;

    @Setter
    private Long userCid;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;


    public static WorkSpaceDto toDto(WorkSpaceEntity entity) {
        WorkSpaceDto dto = WorkSpaceDto.builder()
                .workspaceId(entity.getWorkspaceId())
                .title(entity.getTitle())
                .body(entity.getBody())
                .userCid(entity.getUserCid())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();

        return dto;
    }

}

