package sample;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.entity.Product;
import sample.entity.User;

public class UserUtil {

    private Session session = HibernateUtil.getSession();

    public double buyProduct(User user, Product selectedProduct, int quantity) {

        confirmPayment();
        return 1;
    }

    public void confirmPayment() {

    }

    // TODO: 3/8/2020  
    public void addProduct(Product productToAdd, int quantity) {

        session.beginTransaction();

        Query query = session.createQuery("update Product p set p.quantity = p.quantity + : increment where p.productName = :productName");
        query.setParameter("increment", productToAdd.getQuantity() + quantity);
        query.setParameter("productName",productToAdd.getProductName());
        session.save(productToAdd);
        session.getTransaction().commit();
        session.close();

    }

    public void removeProduct(Product productToRemove, int quantity) {

    }

}
