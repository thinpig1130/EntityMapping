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

@Entity
@Getter @Setter
public class ExerciseCa {

    @Id
    private UUID id;

    /** 문자열 타입 컬럼 매핑 **/
    private String P01_string;

    @Lob
    private String P02_stringLob;

    @Column(length = 500)
    private String P03_stringLength500;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 1. @Column 의 length 속성은 문자열 타입에만 사용되는 DDL 속성이다.
     *    다른 타입에는 길이를 지정해도 별 영향을 미치지 않는다.
     * 2. @Lob 은 BLOB, CLOB 과 같은 대형 크기의 DATABASE 타입을 매핑한다.
     */

    /** 정수 타입 매핑 **/

    private int P10_int;

    private Integer P11_Integer;

    private long P12_longPrimitive;

    private Long P13_LongReference;

    private BigInteger P14_bigInteger;

    @Column(precision = 20)
    private BigInteger P15_bigIntegerPrecision;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 3. 자바객체 타입의 길이에 맞게 데이터 베이스 유형이 결정되어 생성된다.
     * 4. BigInteger 타입의 경우, precision 값으로 생성되는 숫자의 길이를 결정할 수 있다.
     */

    /** 실수 타입 매핑 **/

    private float P20_float;

    private double P21_double;

    private BigDecimal P23_bigDecimal;

    @Column(precision = 10, scale = 2)
    private BigDecimal P24_bigDecimalPrecisionScale;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 5. 자바객체 타입의 길이에 맞게 데이터 베이스 유형이 결정되어 생성된다.
     * 6. BigDecimal 타입의 경우, precision 값과 scale 값을 지정하여 생성되는 타입의 길이를 결정할 수 있다.
     */

    /** enum type 컬럼 매핑 **/

    private ExType P30_enum;

    @Enumerated
    private ExType P31_enumerated;

    @Enumerated(EnumType.ORDINAL)
    private ExType P32_enumeratedTypeOrdinal;

    @Enumerated(EnumType.STRING)
    private ExType P33_enumeratedTypeString;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 7. 위의 3개는 같은 결과를 같는다.
     * 8. EnumType.STRING 은 타입명을 문자로 저장할때 사용한다.
     * 9. EnumType.ORDINAL의 경우, enum의 순서가 변경되면 기존 데이터에 영향을 주게되는 단점이 있다.
     */

    /** 날짜/시간 관련 컬럼 매핑 **/

    private LocalDate P40_localDate;

    private LocalDateTime P41_localDateTime;

    private Date P42_date;

    @Temporal(TemporalType.DATE)
    private Date P44_dateTemporalTypeDate;

    @Temporal(TemporalType.TIME)
    private Date P45_dateTemporalTypeTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date P46_dateTemporalTypeTimestamp;

    private Calendar P47_calendar;

    @Temporal(TemporalType.DATE)
    private Calendar P48_calendarTemporalTypeDate;

    @Temporal(TemporalType.TIME)
    private Calendar P49_calendarTemporalTypeTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar P50_calendarTemporalTypeTimestamp;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 10. @Temporal 년,월,일,시,분,초 가 있는 자바의 Date 타입과
     *     날짜, 시간, 날짜와 시간이라는 3가지 데이터 타입이 존재하는 DATABASE의 타입을 매핑하기 위해 사용된다.
     */

    /** 불리언 타입 매핑 **/
    private boolean P60_booleanPrimitive;

    private Boolean P60_booleanReference;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 11. 불리언 타입의 경우, 데이터베이스에 따라 저장하는 유형이 제각각이다.
     */

    /** UUID 타입 매핑 **/
    private UUID P65_UuidDefault;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 12. UUID 의 경우, 데이터베이스에 따라 저장하는 유형이 제각각이다.
     */

    /** 매핑 제외 **/
    @Transient
    private String P70_transientProperty;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 12. 해당 속성과 매칭되는 필드는 데이터베이스에 존재하지 않는다.
     */


    /** Primitive Type VS Reference Type **/

    private int P71_primitive;

    private Integer P72_reference;

    @Column
    private int P73_primitiveColumn;

    @Column
    private Integer P74_referenceColumn;

    @Column(nullable = false)
    private int P75_primitiveNotNull;

    @Column(nullable = false)
    private Integer P74_referenceNotNull;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 13. Primitive type의 경우 기본적으로 Not Null 제약조건이 추가된다.
     * 14. 하지만, @Column의 nullable 타입의 기본속성이 true 이므로 @Column을 붙이면 Not Null 제약조건이 사라진다.
     * 15. nullable 속성의 값을 넣어주면, Primitive Type 인지 Reference Type 인지와 무관하게 값에 따른 제약조건을 적용된다.
     */

    /** 그 밖의 속성 살펴보기 **/

    @Column(name="P80_CHANGE_COLUMN_NAME")
    private String changeColumnName;

    @Column(nullable = false)
    private String P81_addNotNull;

    @Column(unique = true)
    private String P82_addUnique;

    @Column(columnDefinition = "NUMERIC(20) UNIQUE")
    private int P83_addColumnDefinition;

    /**
     * [ 코드를 통해 살펴 볼 내용 ]
     * 16. 객체와 필드명과 관계없이 필드명을 직접 입력하여 매핑 할 수도 있다.
     * 17. Not Null 제약조건을 설정할 수 있다.
     * 18. Unique 제약조건을 설정할 수 있다.
     * 19. 컬럼의 정보를 직접 작성할 수 있다.
     */
}
