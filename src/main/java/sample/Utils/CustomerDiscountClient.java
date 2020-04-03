package sample.Utils;

import sample.entity.User;

public class CustomerDiscountClient implements DiscountClientStrategy {

    private final double discount = 1d;


    @Override
    public double applyDiscount(double totalToPay) {
        return discount * totalToPay;
    }

    public double getDiscount() {
        return discount;
    }

    }

