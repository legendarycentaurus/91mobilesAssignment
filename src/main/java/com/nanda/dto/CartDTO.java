package com.nanda.dto;

import java.util.List;
import com.nanda.model.Cart;

public interface CartDTO {
public boolean addProduct(Cart cart);
public List<Cart> listCart(String emailId);

}
