package me.manylove.study.jpa.entitymapping.relation.b.manytoone.twoway;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name="OneTwoWay")
@Table(name = "ONE")
@Getter @Setter @NoArgsConstructor
public class One {
    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "one")
    private List<Many> manys = new ArrayList<>();

    // 연관관계 편의 메소드
    public void addMany(Many many){
        if(many.getOne() != this) {
            many.setOne(this);
        }
        if( ! this.manys.contains(many) ){
            manys.add(many);
        }
    }
}
