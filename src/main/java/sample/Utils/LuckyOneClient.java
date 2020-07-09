package sample.Utils;

public class LuckyOneClient implements ClientInterface {
    private final double discount = 0.4d;

    @Override
    public double applyDiscount(double totalToPay) {
        return discount * totalToPay;
    }

    public double getDiscount() {
        return discount;
    }
}

