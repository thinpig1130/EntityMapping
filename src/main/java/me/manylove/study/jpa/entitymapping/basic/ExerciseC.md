# 필드와 컬럼 매핑
자바속성과 데이터베이스의 컬럼은 어떻게 매핑 할 수 있을까?
컬럼매핑을 위해 사용되는 어노테이션의 종류와 속성들에 대해서 알아봅니다.

## @Column
컬럼을 매핑한다.

| 속성                    | 기능                    | 기본값   | 비고                                    |
|:----------------------|:----------------------|:------|:--------------------------------------|
| name                  | 매핑할 컬럼 이름             |       |                                       |
| unique                | unique 제약조건이 추가 여부    | false | DDL                                   |
| nullable              | Null 관련 제약조건 설정       | true  | DDL                                   |
| insertable            | 생성시 속성 입력값 데이터 베이스 저장 여부 | true  |                                       |
| updatable             | 업데이트 시 변경 값 데이터 베이스 저장 여부 | true |                                       |
| columnDefinition      | 데이터베이스 컬럼 정보를 직접 입력 | | DDL                                   |
| table                 | 하나의 엔티티를 두 개 이상의 테이블에 매핑 할 때 사용 | | 연구필요                                  |
| length                | 문자길이 제약 조건. | | DDL, String 전용                        |
| precision             | 소수점을 포함한 전체 자리 수 |  | DDL, BigDecimal , BigInteger 전용       |
| scale                 | 소수의 자리수 | | DDL, BigDecimal , BigInteger 전용 |

### insertable 과  updatable 속성
> insertable 과 updatable 속성은 데이터를 입력할 때 영향을 주는 특별한 속성입니다.
> 입력 데이터를 입력하고, 수정하는 과정에 영향을 주는 속성으로, 흔하게 사용되지는 않습니다.    
> 저의 개인적인 경험상, 필드가 데이터베이스 자체에서 자동으로 채워지는 경우 읽기전용 속성으로 만들기 위해 사용합니다.
> 또, 처음 값이 입력되면 변경되면 안되는 속성의 경우, updatable = false 를 사용하기도 합니다.
> JPA가 클래스 유형에 따라 채워주는 상속 매핑에 사용되는 DTYPE관 같은 속성 또한,
> insertable과 updatable을 false로 설정해야 합니다. 
> 매핑을 하지 않고, JPA가 자동 컨트롤하게 두면 상관없지만, 엔티티 내용에 DTYPE의 값을 불러오고 싶다면 두 속성을 false로 설정해야 합니다.
> ( 자세한 내용은 상속매핑 예제에서 코드로 보여드립죠 ! )


## @Enumerated
enum 타입 컬럼

| 속성                    | 기능                    | 기본값   | 비고                                    |
|:----------------------|:----------------------|:------|:--------------------------------------|
| value                | 저장 방법 설정 | EnumType.ORDINAL |  |

## @Temporal
자바의 Date 타입과 Calendar 타입을 데이터베이스에서 사용하는 특정 타입과 매핑한다.

| 속성                    | 기능                    | 기본값   | 비고                                    |
|:----------------------|:----------------------|:------|:--------------------------------------|
|value                | 매핑할 타입 | TemporalType.TIMESTAMP | |

## @Lob
BLOB, CLOB 타입을 매핑한다.

## @Transient
특정 필드를 데이터베이스에 매핑하지 않는다.

## @Access
JPA가 엔티티에 접근하는 방식을 지정한다.

| 속성                    | 기능                    | 기본값   | 비고                                    |
|:----------------------|:----------------------|:------|:--------------------------------------|
| value                 | 매핑 접근 방식 | @Id 가 붙어있는 위치에 의해 결정 | |

> 엔티티에 있는 속성 값에 접근하는 방법을 변경 할 수 있습니다.   
> @Id가 어노테이션이 어디에 붙어 있는지에 따라 기본접근방법이 결정됩니다. 
> @Id가 변수에 붙어있다면 AccessType.FIELD 방식을, get 메소드에 붙어있다면 AccessType.PROPERTY 접근방식을 사용합니다.
> 하지만 필요한 경우 필드마다 접근법을 달리 설정할 수도 있습니다.
