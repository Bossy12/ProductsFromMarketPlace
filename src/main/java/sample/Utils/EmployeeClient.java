package sample.Utils;

public class EmployeeClient implements ClientInterface {
    private final double discount = 0.5d;

    @Override
    public double applyDiscount(double totalToPay) {
        return discount * totalToPay;
    }

    public double getDiscount() {
        return discount;
    }
}
