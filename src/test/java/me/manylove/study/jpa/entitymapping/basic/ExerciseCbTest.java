package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Commit
class ExerciseCbTest {

    @Autowired
    EntityManager em;

    UUID entityId = UUID.fromString("40d9f800-e64b-49f9-8654-a46b4d177af6");

    @Test
    @DisplayName("입력 시 쿼리 내용 확인")
    @Order(1)
    void  insert(){
        ExerciseCb entity = ExerciseCb.builder()
                .id(entityId)
                .name("권다애")
                .createDate(LocalDateTime.now())
                .notInsertDate(LocalDateTime.now())
                .readOnlyDate(LocalDateTime.now())
                .build();

        em.persist(entity);
    }

    @Test
    @DisplayName("수정 시 쿼리 내용 확인")
    @Order(2)
    void update(){
        ExerciseCb entity = em.find(ExerciseCb.class, entityId);

        entity.setName("바꾸자");
        entity.setCreateDate(LocalDateTime.now());
        entity.setNotInsertDate(LocalDateTime.now());
        entity.setReadOnlyDate(LocalDateTime.now());

    }

    @Test
    @DisplayName("updatable = false 인 속성 값만 바꾼다면 쿼리가 실행될까?")
    @Order(3)
    void update2(){
        ExerciseCb entity = em.find(ExerciseCb.class, entityId);

        entity.setCreateDate(LocalDateTime.now());
        entity.setReadOnlyDate(LocalDateTime.now());
    }

}

/**
 * [ 살펴볼 내용 ]
 * 1. insert 문을 실행할 때는 insertable = false 가 설정된 notInsertDate, readOnlyDate 는 입력되지 않는다.
 * 2. update 문을 실행할 때는 updatable = false 가 설정된 createDate, readOnlyDate는 입력되지 않는다.
 * 3. 읽기전용 속성을 만들기 위해서는 insertable = false 와 updatable = false 가 둘다 설정되어 있어야 한다.
 * 4. updatable = false 속성만 변경된다면 수정 쿼리는 날아가지 않는다.
 */