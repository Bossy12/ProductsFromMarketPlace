package sample.Utils;

public class EmployeeDiscount implements DiscountStrategy {
    @Override
    public double discount(double discount, double fullprice) {
        return discount * fullprice;
    }
}
