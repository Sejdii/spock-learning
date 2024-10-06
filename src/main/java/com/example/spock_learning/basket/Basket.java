package com.example.spock_learning.basket;

import com.example.spock_learning.order.Order;
import com.example.spock_learning.order.OrderLine;
import com.example.spock_learning.product.Product;
import com.example.spock_learning.shared.Money;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Basket {

    private final List<OrderLine> orderLines = new ArrayList<>();

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, int amount) {
        var orderLine = new OrderLine(amount, product);
        orderLines.add(orderLine);
    }

    public Money getTotalPrice() {
        return orderLines.stream()
            .map(OrderLine::getPrice)
            .reduce(Money.zero(), Money::add);
    }

    public Order toOrder() {
        return new Order(orderLines);
    }
}
