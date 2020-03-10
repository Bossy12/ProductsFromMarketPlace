package sample;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.entity.Product;
import sample.entity.User;

import java.util.List;

public class UserDao {

    private Session session = HibernateUtil.getSession();

    public double buyProduct(User user, Product selectedProduct, int quantity) {

        confirmPayment();
        return 1;
    }

    public void confirmPayment() {

    }


}
