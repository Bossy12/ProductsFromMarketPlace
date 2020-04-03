package sample.Utils;

public class LuckyOneDiscountClient implements DiscountClientStrategy {

    private final double discount = 0.4d;

    @Override
    public double applyDiscount(double totalToPay) {
        return discount * totalToPay;
    }

    public double getDiscount() {
        return discount;
    }

    }

