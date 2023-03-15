package com.incture.mysqljpamapping.service;

import com.incture.mysqljpamapping.Entity.Cart;
import com.incture.mysqljpamapping.Entity.Items;
import com.incture.mysqljpamapping.dto.CartRequest;
import com.incture.mysqljpamapping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart findCartById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public List<Cart> findByName(String name) {
        return cartRepository.findByName(name);
    }


    public Cart saveCardDetails(Cart request) {
        Set<Items> SetOfItems = new HashSet<Items>();
        request.getItems().forEach(nextItems -> SetOfItems.add(nextItems));
        Cart cart = Cart.builder().total(request.getTotal())
                .name(request.getName())
                .items(SetOfItems)
                .build();

        return cartRepository.save(cart);
    }

    public Cart saveCardDetails1(CartRequest cartrequest) {
        Items i1 = new Items();
        i1.setItemId(cartrequest.getItemId());
        i1.setQuantity(cartrequest.getQuantity());
        i1.setItemTotal(cartrequest.getItemTotal());
        Set<Items> SetOfItems = new HashSet<Items>();
        SetOfItems.add(i1);
        Items i2 = new Items();
        i2.setItemId("ds");
        i2.setQuantity(21);
        i2.setItemTotal(3);
        SetOfItems.add(i2);
        Cart cart = Cart.builder().total(cartrequest.getTotal())
                .name(cartrequest.getName())
                .items(SetOfItems)
                .build();

        return cartRepository.save(cart);
    }
}
