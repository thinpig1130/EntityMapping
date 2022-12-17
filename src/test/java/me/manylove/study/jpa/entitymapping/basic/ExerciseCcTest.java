package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Commit
class ExerciseCcTest {

    @Autowired
    EntityManager em;

    UUID entityId = UUID.fromString("82a6dcaf-4269-4b37-a48c-2b9ed41db3a7");

    @Test
    @DisplayName("접근 테스트를 위한 샘플 입력")
    @Order(1)
    void insert(){
        ExerciseCcAccessField entity = new ExerciseCcAccessField();
        entity.setId(entityId);
        entity.setName("다애");
        em.persist(entity);
    };

    @Test
    @DisplayName("AccessType.FIELD")
    @Order(2)
    void findFieldAccess(){
        ExerciseCcAccessField entity = em.find(ExerciseCcAccessField.class, entityId);
    }

    @Test
    @DisplayName("AccessType.PROPERTY")
    @Order(3)
    void findPropertyAccess(){
        ExerciseCcAccessProperty entity = em.find(ExerciseCcAccessProperty.class, entityId);
    }

    @Test
    @DisplayName("AccessType COMPLEX")
    @Order(4)
    void findFi(){
        ExerciseCcAccessComplex entity = em.find(ExerciseCcAccessComplex.class, entityId);
    }

}

/**
 * [ 살펴볼 내용 ]
 * 1. 동일한 테이블을 여러 엔티티에 매핑 할 수 있습니다.
 *    엔티티명만 다르면 매핑이 가능하답니다.
 *    단, Auto DDL 기능은 사용할 수 없어요.
 * 2. @Id의 위치에 따라 기본 접근 방법이 달라집니다.
 *    Class 단위에 붙이는 @Access 과 @Id 의 위치는 일관성을 가져야 합니다.
 *    안그러면 에러가 발생합니다. 따라서, @Access 는 생략하여도 된답니다.
 * 3. 속성별로 접근 방법을 다르게 가져갈 수도 있습니다.
 */

/**
 * TODO 실무적으로 언제 유용할지 한번 생각해 볼 필요가 있겠네요!
 * 데이터 베이스에는 이름을 한번에 저장하지만, 성과 이름을 로직에서 구분해야 하는 경우 ?
 * 전화번호를 한번에 입력받지만, 데이터베이스에는 따로 저장하는 경우 ?
 * 이런 경우, 응용하여 활용해 볼수 있겠네요.
 */