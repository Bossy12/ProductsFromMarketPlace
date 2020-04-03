package sample;

import sample.Utils.ShoppingCart;
import sample.Utils.ProductDao;
import sample.Utils.UserDao;
import sample.entity.Product;
import sample.entity.User;

public class main2 {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Norocosul");
        user.setPassword("000000");
//        user.setUserType(UserType.CUSTOMER);

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

        ProductDao productDao = new ProductDao();
        UserDao userDao = new UserDao();
//        productDao.addProduct(product);
//        productDao.removeProduct(product);
//        productDao.getAllProducts();
//        System.out.println();
//        productDao.getProduct(10);
//        userDao.getAllUsers();
//        userDao.getUser(4);
//        userDao.addUser(user);

        User client = userDao.getUserByUsername(user.getUsername());
        ShoppingCart shoppingCart = new ShoppingCart(client);
        Product product1 = productDao.getProductByName("Laptop");
        Product product2 = productDao.getProductByName("TV LCD");
        shoppingCart.addToBasketList(product1,2);
        shoppingCart.addToBasketList(product2,2);
        shoppingCart.getTotal();
        System.out.println(shoppingCart.getTotal());

    }
}
