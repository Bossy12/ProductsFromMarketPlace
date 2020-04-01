package sample.Utils;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sample.entity.Product;
import sample.entity.User;

import java.util.List;

@Data
public class ProductDao {
    private Session session = HibernateUtil.getSession();

    public List<Product> getAllProducts() {
        List<Product> products = session.createQuery("from Product").list();
        return products;
    }

    public Product getProduct(int productId) {
        Product product = session.get(Product.class, productId);
        return product;
    }

    public Product getProductByName(String productName) {
        Query<Product> query = session.createQuery(
                "select p from Product p where productName = :productName", Product.class);
        query.setParameter("productName", productName);
        return query.getSingleResult();
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
