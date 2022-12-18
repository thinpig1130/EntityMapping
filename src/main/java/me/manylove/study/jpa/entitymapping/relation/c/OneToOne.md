# [ 실전매핑 No.1 ] 1:N, N:1 매핑

## 매핑에 사용되는 주요 어노테이션
 1:N, N:1 매핑에 사용되는 어노테이션은 @JoinColumn, @ManyToOne, @OneToMany 이다. 

### @JoinColumn
외래키를 매핑할 때 사용하는 속성이다.
일반적으로 외래키가 위치한 테이블과 매핑된 엔티티 매핑컬럼에 붙는다.

| 속성                   | 기능                     | 기본값                        | 비고  |
|:---------------------|:-----------------------|:---------------------------|:----|
| name                 | 매핑할 외래키 이름             | 필드명 +_+ 참조하는 테이블의 기본 키 컬럼명 | |
| referencedColumnName | 외래 키가 참조하는 대상 테이블의 컬럼명 | 참조하는 테이블의 기본키 컬럼명          | |
| unique               | @Column 속성과 동일         |                            | DDL |
| nullable             | @Column 속성과 동일         |                            | DDL |
| insertable           | @Column 속성과 동일         |                            |     |
| updatable            | @Column 속성과 동일         |                            |     |
| columnDefinition     | @Column 속성과 동일         |                            | DDL |
| table                | @Column 속성과 동일         |                            |     |
| foreignKey           | 외래키 제약조건을 직접 지정할 수 있다. |                            | DDL |

### @ManyToOne
| 속성                   | 기능                                                                 | 기본값                                                   | 비고  |
|:---------------------|:-------------------------------------------------------------------|:------------------------------------------------------|:----|
| targetEntity | 연관된 엔티티의 타입 정보를 설정한다. 컬렉션을 사용해도 제네릭으로 타입정보를 알수 있기 때문에 거의 사용하지 않는다. |                                                       |     |
| cascade | 영속성 전이 기능을 사용한다.                                                   |                                                       |     |
| fetch | 글로벌 페치 전략을 사용한다.                                                   | @ManyToOne=FetchType.EAGER, @OneToMany=FetchType.LAZY | |
| optional | false로 설정하면 연관된 엔티티가 항상 있어야 한다.                                    | true                                                  |

### @OneToMany
| 속성           | 기능                | 기본값 | 비고  |
|:-------------|:------------------|:----|:----|
| targetEntity | @ManyToOne 속성과 동일 |     |     |
| cascade      | @ManyToOne 속성과 동일 |     |     |
| cascade      | @ManyToOne 속성과 동일 |     |     |
| fetch        | @ManyToOne 속성과 동일 |     |     |
| mappedBy     |                   |     |     |
| orphanRemoval | | | |



---
#### @OneToOne
| 속성                   | 기능  | 기본값 | 비고 |
|:---------------------|:----|:----|:---|

#### @ManyToMany
| 속성                   | 기능  | 기본값 | 비고 |
|:---------------------|:----|:----|:---|


