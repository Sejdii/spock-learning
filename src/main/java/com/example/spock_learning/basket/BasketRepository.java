package com.example.spock_learning.basket;

import java.util.Optional;

public interface BasketRepository {

    Optional<Basket> find();
    void save(Basket basket);
}
