package sample.Utils;

public class Discount {
    private DiscountStrategy discountStrategy;

    Discount(){}
    Discount(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void applyDiscount(double discount,double price) {
        discountStrategy.discount(discount,price);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}
