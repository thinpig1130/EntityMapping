package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * == A. 엔티티 매핑 최소단위 =====================================================
 * 테아블과 매핑되어 JPA에서 관리하는 객체를 엔티티라고 한다.
 * 이런 엔티티클래스를 만들기 위해서는 테이블과 클래스를 매핑하는 엔티티 매핑을 해야한다.
 * 엔티티 매핑을 하기 위한 최소 기준인 @Entity, @Id 애노테이션이다.
 *
 *  - @Entity
 *      테이블을 매핑해야 하는 JPA 관리대상 클래스에 필수로 붙여야하는 어노테이션이다.
 *      @Entity가 붙은 클래스는 JPA가 관리하는 클래스이며, 엔티티라 부른다.
 *          - name : 엔티티 이름, 쿼리에서 엔티티를 참조하는데 사용된다.
 *               만약, 다른 패키지에 이름이 같은 엔티티 클래스가 있다면 이름을 지정해서 충동하지 않도록 해야한다.
 *               보통 기본 값인 클래스 이름을 사용한다.
 *  - @Id
 *      Primary Key를 클래스에 매핑한다.
 *
 * 엔티티를 테이블에 매핑할 때, 테이블 이름과 필드이름을 따로 지정하지 않으면
 * 기본 매핑 규칙에 맞춰 이름을 변환해서 매핑한다.
 * 스프링 부트 프레임워크에서 사용하는 기본 매핑 규칙 : 파스칼 or 카멜 -> 스네이크
 *
 * ==========================================================================
 **/

@Entity
@Getter @Setter
public class ExerciseAa {
    @Id
    private UUID id;
    private String userName;
}

/**
 * [ 코드를 통해 살펴 볼 내용 ]
 * 1. 테이블이름 자동 매핑, 필드이름 자동 매핑 살펴보기
 *   - ExerciseAa -> excercise_aa
 *   - userName -> user_name
 * 2. 테이블 식별자(@Id)는 매핑 필수
 *   - 매핑 누락 시, org.springframework.beans.factory.BeanCreationException 발생
 */