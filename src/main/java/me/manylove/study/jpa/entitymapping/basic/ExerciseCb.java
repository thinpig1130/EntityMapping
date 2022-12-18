package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * TODO WITH 함께 해 봅시다.
 * 두 속성이 데이터 입력 시 끼치는 영향에 대해 테스트 해 봅시다.
 * 테스트 코드 : ExerciseCbTest
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class ExerciseCb {

    @Id
    private UUID id;

    private String name;

    @Column(updatable = false)
    private LocalDateTime createDate;

    @Column(insertable = false)
    private LocalDateTime notInsertDate;

    @Column(insertable = false, updatable = false)
    private LocalDateTime readOnlyDate;

}
