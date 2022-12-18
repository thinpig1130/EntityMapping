package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "ExerciseAc")
@Table(name = "EXERCISE_AC_NAME_SETTING")
@Getter @Setter
public class ExerciseBa {
    @Id
    private UUID id;

    private String userName;
}

/**
 * [ 코드를 통해 살펴 볼 내용 ]
 * 1. 엔티티명과 상관없이 DB의 테이블명이 테이블에 매핑된 것을 볼 수 있다.
 */
