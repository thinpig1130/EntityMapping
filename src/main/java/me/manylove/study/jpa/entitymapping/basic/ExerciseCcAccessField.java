package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * TODO WITH 함께 해 봅시다.
 * 설정한 Access 방법이 동작하는지 확인 해 봅시다.
 * 테스트 코드 : ExerciseCcTest
 */
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
