package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded // 내장이기에
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINAL은 숫자 형태 꼭 스트링으로 써야한다.
    private DeliveryStatus delivery; // READY, COMP

    public DeliveryStatus getStatus() {
        return this.delivery = delivery;
    }
}
