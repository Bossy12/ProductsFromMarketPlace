package sample.Utils;

public class EmployeeDiscountClient implements DiscountClientStrategy {
    private final double discount = 0.5d;

    @Override
    public double applyDiscount(double totalToPay) {
        return discount * totalToPay;
    }

    public double getDiscount() {
        return discount;
    }
}
