package com.example.spock_learning.order;

import java.util.UUID;

public record OrderIdentifier(UUID identifier) {

    public static OrderIdentifier generateNew() {
        return new OrderIdentifier(UUID.randomUUID());
    }
}
