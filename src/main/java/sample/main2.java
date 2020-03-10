package sample;

import sample.entity.Product;
import sample.entity.User;

public class main2 {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Marius");
        user.setPassword("142536");
        UserVerifier userVerifier = new UserVerifier();

        userVerifier.userExist(user);
        System.out.println(userVerifier.userExist(user));
        userVerifier.isUserEmployeeType(user);
        System.out.println(userVerifier.isUserEmployeeType(user));

        Product product = new Product();
        product.setProductName("Tablet high");
        product.setProductId(5);
        product.setQuantity(100);
        product.setPrice(900);

        ProductUtil productUtil = new ProductUtil();
        // productUtil.removeProduct(product);
productUtil.addProduct(product);
    }
}
