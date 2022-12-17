package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * == C. 필드와 컬럼 매핑 =====================================================
 * JPA가 엔티티에 있는 속성 값에 접근하는 방법을 변경 할 수 있습니다.
 * @Id가 어노테이션이 어디에 붙어 있는지에 따라 기본접근방법이 결정됩니다.
 * @Id가 필드에 붙어있으면 필드접근법을 사용하며,
 * @Id가 메소드에 붙어있으면 프로퍼티접근법을 사용합니다.
 * 필드마다 접근법을 달리 설정할 수도 있습니다.
 *
 *  = @Access
 *    JPA가 엔티티에 접근하는 방식을 지정한다.
 *    - value                : 매핑 접근 방식
 *                            AccessType.PROPERTY / AccessType.FIELD
 * ==========================================================================
 **/

@Entity
@Table(name = "EXERCISE_CC")
public class ExerciseCcAccessField {

    @Id
    private UUID id;

    private String name;

    public UUID getId() {
        System.out.println("getId");
        return id;
    }

    public void setId(UUID id) {
        System.out.println("setId");
        this.id = id;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }
}
