package sample.Utils;

import sample.entity.Product;
import sample.entity.User;
import sample.entity.UserType;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> basketProducts = new ArrayList<>();
    Discount discount = new Discount();
    CustomerDiscount customerDiscount = new CustomerDiscount();
    EmployeeDiscount employeeDiscount = new EmployeeDiscount();

    public Basket(User user) {
        if (user.getUserType().equals(UserType.CUSTOMER)) {
            discount.setDiscountStrategy(customerDiscount);
        }
        discount.setDiscountStrategy(employeeDiscount);
    }

    public void addToBasketList(Product product, int quantity) {
        basketProducts.add(product);
        product.setQuantity(quantity);
    }

    public void removeFromBasketList(Product product) {
        basketProducts.remove(product);
    }

    public double fullPrice(List<Product> basketProducts) {
        double sum = 0;
        for (Product p : basketProducts) {
            double productPrice = p.getPrice();
            int productQuantity = p.getQuantity();
            sum += productPrice*productQuantity;
        }
        return sum;
    }

    public List<Product> getBasketProducts() {
        return basketProducts;
    }
}
