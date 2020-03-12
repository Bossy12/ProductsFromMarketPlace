package sample;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.entity.Product;

import java.util.List;

@Data
public class ProductDao {
    private Session session = HibernateUtil.getSession();

    public List getAllProducts() {
        List<Product> products = session.createQuery("from Product").list();
        return products;
    }

    public Product getProduct(int productId) {
        Product product = session.get(Product.class, productId);
        return product;
    }

    public void removeProduct(Product productToRemove) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(productToRemove);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        session.close();
    }

    public void addProduct(Product productToAdd) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(productToAdd);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        session.close();
    }
}
