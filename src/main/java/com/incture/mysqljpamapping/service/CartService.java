package com.incture.mysqljpamapping.service;

import com.incture.mysqljpamapping.Entity.Cart;
import com.incture.mysqljpamapping.Entity.Employee;
import com.incture.mysqljpamapping.Entity.Items;
import com.incture.mysqljpamapping.dto.CartRequest;

import java.util.List;
import java.util.Set;

public interface CartService {
    Cart findCartById(Long id);
    List<Cart> findByName(String name);
  //  String saveCardDetails(CartRequest request);
}
