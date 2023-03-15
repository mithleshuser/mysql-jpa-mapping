package com.incture.mysqljpamapping.repository;

import com.incture.mysqljpamapping.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {
    //@Query("select * from cart")
   Optional<Cart> findById(Long id);
    List<Cart> findByName(String name);

    //@Query("select * from cart")
    //void saveCardDetails(CartRequest request);

}
