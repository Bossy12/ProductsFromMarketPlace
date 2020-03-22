package sample;

import sample.Utils.ProductDao;
import sample.Utils.UserDao;

public class main2 {
    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("Marius");
//        user.setPassword("142536");
//        UserVerifier userVerifier = new UserVerifier();
//
//        userVerifier.userExist(user);
//        System.out.println(userVerifier.userExist(user));
//        userVerifier.isUserEmployeeType(user);
//        System.out.println(userVerifier.isUserEmployeeType(user));

//        Product product = new Product();
//        product.setProductName("Tablet high");
//        product.setProductId(15);
//        product.setQuantity(100);
//        product.setPrice(900);
//
        ProductDao productDao = new ProductDao();
        UserDao userDao = new UserDao();
//        productDao.addProduct(product);
//        productDao.removeProduct(product);
        productDao.getAllProducts();
        System.out.println();
        productDao.getProduct(10);
        userDao.getAllUsers();
        userDao.getUser(4);

    }
}
