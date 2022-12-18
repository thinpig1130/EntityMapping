package me.manylove.study.jpa.entitymapping.relation.b.manytoone.twoway;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "ManyTwoWay")
@Table(name="MANY")
@Getter @Setter @NoArgsConstructor
public class Many {
    @Id
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ONE_ID")
    private One one;

    // 연관관계 편의 메소드
    public void setOne(One one){
        // 기존 관계 제거
        if (this.one != null && this.one.equals(one) ) {
            this.one.getManys().remove(this);
        }
        // one 셋팅
        this.one = one;
        one.addMany(this);
    }
}

/**
 * [ 코드를 통해 살펴 볼 내용 ]
 * 1. 연관관계가 있는 객체를 참조 할 수 있는 저장 필드가 있습니다.
 * 2. @JoinColumn 이 없으면 기본적으로 [참조객체명 + _ + 참조하는 테이블의 기본 컬럼명]을 이용해서 매핑을 진행합니다.
 * 3. @ManyToOne의 기본 페치 전략은 FetchType.EAGER 입니다.
 *    현재 코드에서는 FetchType.LAZY 로 설정 하였습니다.
 *    따라서, Many 객체를 조회해서 가져올 때 one에 있는 id 값만 셋팅되고,
 *    실제 코드에서 one의 값을 사용하려고 할 때 one을 조회하는 조회쿼리가 발생하게 됩니다.
 */