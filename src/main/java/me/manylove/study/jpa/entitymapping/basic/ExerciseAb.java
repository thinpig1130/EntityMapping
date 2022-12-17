package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name="ExcerciseAbSecondMapping")
@Getter @Setter
public class ExerciseAb {
    @Id
    private UUID id;

    private String userName;
}
/**
 * [ 코드를 통해 살펴 볼 내용 ]
 * 1. 변경된 엔티티명이 테이블 매핑에 영향을 주어서,매핑된 테이블 이름이 달라진 것을 볼 수 있다.
 */