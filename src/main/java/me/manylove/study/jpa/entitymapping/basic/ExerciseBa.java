package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * == B. 테이블 매핑 커스텀  ================================================================
 * 매핑할 클래스 위에 붙는 @Table 속성들 중에는
 * 매핑을 위한 매핑 속성과 테이블 생성을 위해서 사용되는 DDL속성으로 나누어 볼 수 있다.
 * name, catalog, schema 는 매핑을 위한 속성이며,
 * uniqueConstraints, indexs 는 스키마 자동 생성 기능을 이용하여 테이블을 생성 할때 만 사용되는 DDL속성이다.
 *
 *  = @Table
 *    매핑할 테이블을 지정한다.
 *    - name : 매핑할 테이블 이름 지정
 *    - catalog : catalog 기능이 있는 데이터베이스에서 catalog를 매핑. TODO 연구필요
 *    - schema : shema 기능이 있는 데이터베이스에서 shema를 매핑. TODO 연구필요
 *    - uniqueConstranints : [DDL] 유니크 제약조건을 만든다.
 *    - indexs : [DDL] 테이블의 인덱스를 만든다. PK의 index는 자동생성 되므로 색인을 지정할 필요가 없다.
 *
 * =======================================================================================
 **/

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

/** TODO 이 코드에 유니크 생성 코드랑, 인덱스 생성 코드도 넣어 예제를 완성해 봅시다. */