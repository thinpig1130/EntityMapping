package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * == C. 필드와 컬럼 매핑 =====================================================
 * 엔티티 객체 속성에 붙은 @Column 어노테이션의 속성 중에서
 * insertable 과 updatable 속성은 데이터를 입력할 때 영향을 주는 특별한 속성입니다.
 * 입력 데이터를 입력하고, 수정하는 과정에 영향을 주는 속성으로, 흔하게 사용되지는 않습니다.
 *
 * 저의 개인적인 경험상,
 * 필드가 데이터베이스 자체에서 자동으로 채워지는 경우 읽기전용 속성으로 만들기 위해 사용합니다.
 * 또 처음 값이 입력되면 변경되면 안되는 속성의 경우, updatable = false 를 사용하기도 합니다.
 * JPA가 클래스 유형에 따라 채워주는 상속 매핑에 사용되는 DTYPE관 같은 속성 또한,
 * insertable과 updatable을 false로 설정해야 합니다.
 * 매핑을 하지 않고, JPA가 자동 컨트롤하게 두면 상관없지만, 읽기 전용으로 어플리케이션에 값을 불러오고 싶다면 말입니다.
 *
 *  = @Column
 *    - insertable          : 생성시 속성 입력값 데이터 베이스 저장 여부
 *                            true (기본값) / false
 *    - updatable           : 업데이트 시 변경 값 데이터 베이스 저장 여부
 *                            true (기본값) / false
 * ==========================================================================
 **/

/**
 * TODO 함께 해 봅시다.
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
