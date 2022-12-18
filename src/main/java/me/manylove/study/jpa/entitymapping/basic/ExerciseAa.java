package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

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