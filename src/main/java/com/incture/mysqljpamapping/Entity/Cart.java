package com.incture.mysqljpamapping.Entity;



import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CART")
public class Cart implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   //@GeneratedValue
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;

  /*  Unidirectional @OneToMany with @JoinColumn
  * */

    @OneToMany(cascade = CascadeType.ALL)/*orphanRemoval = true*/
    @JoinColumn(name = "cart_id")
    private Set<Items> items = new HashSet<>();


 /*   Bidirectional @OneToMany*/

/*
 @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Items> items = new HashSet<>();

*/


    public Cart(long id, String name, double total) {
        super();
        this.id=id;
        this.name=name;
        this.total=total;
    }
}
