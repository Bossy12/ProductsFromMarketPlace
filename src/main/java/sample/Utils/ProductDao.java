package sample.Utils;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sample.entity.Product;

import java.util.List;

@Data
public class ProductDao {
    private Session session = HibernateUtil.getSession();

    public List<Product> getAllProducts() {
        return session.createQuery("from Product").list();
    }

    public Product getProduct(int productId) {
        return session.get(Product.class, productId);
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

    public int getStock(Product product) {
        product = getProductByName(product.getProductName());
        return product.getQuantity();
    }

    public void updateStock(Product product, int updateValue) {
        {
            Product product1 = getProductByName(product.getProductName());
            Session session = HibernateUtil.getSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                product1.setQuantity(product1.getQuantity() + updateValue);
                session.update(product1);
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
}
