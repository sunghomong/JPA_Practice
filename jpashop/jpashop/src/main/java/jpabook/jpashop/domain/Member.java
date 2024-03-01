package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 참조 한다는 뜻
    private Address address;

    @OneToMany(mappedBy = "member") // member의 입장에서는 1:N 나는 멤버에의해서 메핑된 키야.
    private List<Order> orders = new ArrayList<>();

}
