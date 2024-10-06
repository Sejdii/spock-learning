package com.example.spock_learning.order;

import com.example.spock_learning.shared.Money;
import java.util.List;
import lombok.Getter;

@Getter
public class Order {

    private OrderIdentifier identifier;
    private List<OrderLine> orderLines;

    public Order(List<OrderLine> orderLines) {
        identifier = OrderIdentifier.generateNew();
        this.orderLines = orderLines;
    }

    public Money getTotalPrice() {
        return orderLines.stream()
            .map(OrderLine::getPrice)
            .reduce(Money.zero(), Money::add);
    }
}
