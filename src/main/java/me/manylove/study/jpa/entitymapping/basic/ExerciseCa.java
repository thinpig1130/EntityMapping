package me.manylove.study.jpa.entitymapping.basic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.manylove.study.jpa.entitymapping.util.ExType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * == C. 컬럼 매핑 =====================================================
 * 자바속성과 데이터베이스의 컬럼은 어떻게 매핑 할 수 있을까?
 * 컬럼매핑을 위해 사용되는 어노테이션의 종류와 속성들에 대해서 알아봅니다.
 *
 *  = @Column
 *    컬럼을 매핑한다.
 *    - name : 매핑할 컬럼 이름
 *    - insertable : false 생성 후 저장할 때는 해당 속성은 넣지 않는다.
 *    - updatable : false 생성 후에 수정할 때는 해당 필드를 수정하지 않는다.
 *    - table : 하나의 엔티티를 두 개 이상의 테이블에 매핑 할 때 사용한다.
 *    - unique, nullable, insertable, updatable, columnDefinition, length, precision, scale -> DDL 관련 속성
 *
 *  - @Enumerated
 *    enum 타입 컬럼
 *    - value : 타입을 데이터 베이스에 매핑하는 방법
 *
 *  - @Temporal
 *    자바의 Date 타입과 Calendar 타입을 데이터베이스에서 사용하는 특정 타입과 매핑한다.
 *    - value : 매핑할 타입
 *
 *  - @Lob
 *    BLOB, CLOB 타입을 매핑한다.
 *
 *  - @Transient
 *    특정 필드를 데이터베이스에 매핑하지 않는다.
 *
 * 엔티티를 테이블에 매핑할 때, 테이블 이름과 필드이름을 따로 지정하지 않으면
 * 기본 매핑 규칙에 맞춰 이름을 변환해서 매핑한다.
 * 스프링 부트 프레임워크에서 사용하는 기본 매핑 규칙 : 파스칼 or 카멜 -> 스네이크
 *
 * ==========================================================================
 **/

@Entity
@Getter @Setter
public class ExerciseCa {

    @Id
    private UUID id;

    /** 문자열 타입 컬럼 매핑 **/
    private String P01_StringDefault;

    @Lob
    private String P02_stringLob;

    @Column(length = 500)
    private String P03_stringLength500;

    @Column(length = 20)
    private int P03_intLength20;

    /** 정수 타입 매핑 **/

    private int P04_intDefault;

    private long P0_longDefault;

    private BigInteger P0_bigInteger;

    @Column(precision = 20)
    private BigInteger P0_bigIntegerPrecision;

    /** 실수 타입 매핑 **/

    private float P0_floatDefault;

    private double P0_doubleDefault;

    private BigDecimal P0_bigDecimal;

    @Column(precision = 10, scale = 2)
    private BigDecimal P0_bigDecimalPrecisionScale;

    /** enum type 컬럼 매핑 **/

    private ExType P0_enumDefault;

    @Enumerated
    private ExType P0_enumerated;

    @Enumerated(EnumType.ORDINAL)
    private ExType P0_enumeratedTypeOrdinal;

    @Enumerated(EnumType.STRING)
    private ExType P0_enumeratedTypeString;

    /** 날짜/시간 관련 컬럼 매핑 **/

    private LocalDate P0_localDate;

    private LocalDateTime P0_localDateTime;

    private Date P0_date;

    @Temporal(TemporalType.DATE)
    private Date P0_dateTemporalTypeDate;

    @Temporal(TemporalType.TIME)
    private Date P0_dateTemporalTypeTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date P0_dateTemporalTypeTimestamp;

    private Calendar P0_calendar;

    @Temporal(TemporalType.DATE)
    private Calendar P0_calendarTemporalTypeDate;

    @Temporal(TemporalType.TIME)
    private Calendar P0_calendarTemporalTypeTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar P0_calendarTemporalTypeTimestamp;

    /** UUID 타입 매핑 **/

    private UUID P0_UuidDefault;

    /** 매핑 제외 **/

    @Transient
    private String P0_transientProperty;
}

/**
 * [ 코드를 통해 살펴 볼 내용 ]
 * 1. 변경된 엔티티명이 테이블 매핑에 영향을 주어서, 매핑된 테이블 이름이 달라진 것을 볼 수 있다.
 */