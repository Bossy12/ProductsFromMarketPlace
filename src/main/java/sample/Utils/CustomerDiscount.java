package sample.Utils;

public class CustomerDiscount implements DiscountStrategy {
    @Override
    public double discount(double discount, double fullprice) {
        return discount * fullprice;
    }
}
