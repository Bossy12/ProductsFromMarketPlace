package sample;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.entity.Product;

@Data
public class ProductDao {

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
