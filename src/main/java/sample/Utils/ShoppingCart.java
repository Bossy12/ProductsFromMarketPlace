package sample.Utils;

import sample.entity.Product;
import sample.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> basketProducts;
    private Client client;
    private double total;

    public ShoppingCart(User user) {
        this.basketProducts = new ArrayList<>();
        this.client = new Client(user);
    }

    public List<Product> getBasketProducts() {
        return this.basketProducts;
    }

    public void addToBasketList(Product product, int quantity) {
        this.basketProducts.add(product);
        product.setQuantity(quantity);
    }

    public void removeFromBasketList(Product product) {
        this.basketProducts.remove(product);
    }

    public double fullPrice() {
        double sum = 0;
        for (Product p : basketProducts) {
            sum += p.getPrice() * p.getQuantity();
        }
        return sum;
    }

    public void totalWithDiscount(ClientInterface clientInterface) {
        this.total = clientInterface.applyDiscount(fullPrice());
    }

    public double getTotal() {
        totalWithDiscount(client.getClientInterface());
        return total;
    }
}
