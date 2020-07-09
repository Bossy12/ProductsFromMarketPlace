package sample.Utils;

public class CustomerClient implements ClientInterface {
    private final double discount = 1d;

    @Override
    public double applyDiscount(double totalToPay) {
        return discount * totalToPay;
    }

    public double getDiscount() {
        return discount;
    }
}

