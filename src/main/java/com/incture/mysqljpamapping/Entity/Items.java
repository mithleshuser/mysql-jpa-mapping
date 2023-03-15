package com.incture.mysqljpamapping.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ITEMS")
@Entity
public class Items implements Serializable {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_total")
    private double itemTotal;

    @Column(name = "quantity")
    private int quantity;

/*    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;*/


}
