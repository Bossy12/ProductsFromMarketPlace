package sample;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sample.entity.Product;

public class ProductUtil {
    private Session session = HibernateUtil.getSession();

    public void increaseProductQuantity() {

    }

    public void removeProduct(Product productToRemove) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
/*            String hql = "delete FROM Product p where p.id = :pId ";
            Query query = session.createQuery(hql);
            query.setParameter("pId", productToRemove.getProductId());*/
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
