package com.incture.mysqljpamapping.controllers;

import com.incture.mysqljpamapping.Entity.Cart;
import com.incture.mysqljpamapping.Entity.Items;
import com.incture.mysqljpamapping.dto.CartRequest;
import com.incture.mysqljpamapping.exception.CartException;
import com.incture.mysqljpamapping.exception.ResourceNotFoundException;
import com.incture.mysqljpamapping.repository.CartRepository;
import com.incture.mysqljpamapping.service.CartService;
import com.incture.mysqljpamapping.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("card-v1")
public class ErpController {


    @Autowired
    CartServiceImpl cartServiceImpl;
    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

    @GetMapping
    public @ResponseBody String getInfo() {
        return "My app testing pass";
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Cart getCart(@PathVariable Long id) {
        return cartServiceImpl.findCartById(id);
    }

    @PostMapping("/saveCart")
    public ResponseEntity<Cart> saveCardDetails(@RequestBody Cart cartRequest) {
        try {
            Set<Items> SetOfItems = new HashSet<Items>();
            cartRequest.getItems().forEach(nextItems -> SetOfItems.add(nextItems));
            Cart cart = Cart.builder()
                    .total(cartRequest.getTotal())
                    .name(cartRequest.getName())
                    .items(SetOfItems)
                    .build();

            Cart cartResponse = cartRepository.save(cart);
            return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cart> updateItems(@PathVariable long id, @RequestBody Cart cartRequest) {
        Cart updateCart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to fetch Cart details or not exist with id: " + id));
        Set<Items> SetOfItems = new HashSet<Items>();
        cartRequest.getItems().forEach(nextItems -> SetOfItems.add(nextItems));
        updateCart.setTotal(cartRequest.getTotal());
        updateCart.setName(cartRequest.getName());
        updateCart.setItems(SetOfItems);
        cartRepository.save(updateCart);

        return ResponseEntity.ok(updateCart);
    }

    @DeleteMapping("/deleteCart/{id}")
    public Map<String, Boolean> deleteCart(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Map<String, Boolean> response;
        try {
            Cart deleteCart = cartRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Unable to fetch Cart details or not exist with id::" + id));
            cartRepository.delete(deleteCart);
            response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Unable to fetch Cart details or not exist with id::" + exception + id);
        }
        return response;
    }

    @PatchMapping("/cart/{id}/{nane}")
    public ResponseEntity<Cart> updateCardName(@PathVariable Long id, @PathVariable String name) {
        try {
            Cart cart = cartRepository.findById(id).get();
            cart.setName(name);
            return new ResponseEntity<Cart>(cartRepository.save(cart), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/all-cart")
    public ResponseEntity<List<Cart>> getAllEmployees(@RequestParam(required = false) String name) {
        try {
            List<Cart> carts = new ArrayList<Cart>();
            if (name == null)
                cartRepository.findAll().forEach(carts::add);
            else
                cartService.findByName(name).forEach(carts::add);
            if (carts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


/*
    @GetMapping("/saveCart1")
    public @ResponseBody
    ResponseEntity saveCardDetails1(@RequestBody CartRequest cartrequest) throws CartException {
        if (!ObjectUtils.isEmpty(cartrequest)) {
            Cart cart = cartServiceImpl.saveCardDetails1(cartrequest);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save into database.");
    }
*/

/*
    @GetMapping("/saveCart2")
    public @ResponseBody
    ResponseEntity saveCardDetails2(@RequestBody Cart cartrequest) throws CartException {
        if (!ObjectUtils.isEmpty(cartrequest)) {
            Cart cart = cartServiceImpl.saveCardDetails(cartrequest);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save into database.");
    }
*/


}

