package com.example.spock_learning.shared;

import java.math.BigDecimal;

public record Money(BigDecimal amount, String currency) {

    public static Money ofPLN(BigDecimal amount) {
        return new Money(amount, "PLN");
    }

    public static Money zero() {
        return ofPLN(BigDecimal.ZERO);
    }

    public Money add(Money other) {
        return ofPLN(this.amount.add(other.amount));
    }

    public Money multiply(int number) {
        return ofPLN(this.amount.multiply(BigDecimal.valueOf(number)));
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money money)) {
            return false;
        }

        return money.amount.equals(this.amount);
    }
}
