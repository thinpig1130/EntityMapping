# 객체와 테이블 매핑
매핑할 클래스 위에 붙는 @Table 속성들 중에는 매핑을 위한 매핑 속성과 테이블 생성을 위해서 사용되는 DDL속성으로 나누어 볼 수 있다.
name, catalog, schema 는 매핑을 위한 속성이며, uniqueConstraints, indexs 는 스키마 자동 생성 기능을 이용하여 테이블을 생성 할때 만 사용되는 DDL속성이다.

## @Table
매핑할 테이블을 지정한다.

| 속성                 |기능|기본값| 비고        |
|:-------------------|:---|:---|:----------|
| name               | 매핑할 테이블 이름 지정 |
| catalog            | catalog 기능이 있는 데이터베이스에서 catalog를 매핑 | | TODO 연구필요 |
| schema             | shema 기능이 있는 데이터베이스에서 shema를 매핑 | | TODO 연구필요 |
| uniqueConstranints | 유니크 제약조건을 만든다. | | DDL |
| indexs             | 테이블의 인덱스를 만든다. PK의 index는 자동생성 되므로 색인을 지정할 필요가 없다. | | DDL |


> FIXME  
> 유니크 생성 예제랑, 인덱스 생성 예제 코드도 만들어 주면 좋을 듯.

