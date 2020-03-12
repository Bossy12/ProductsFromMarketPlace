package sample;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.entity.Product;
import sample.entity.User;

import java.util.List;

public class UserDao {
    private Session session = HibernateUtil.getSession();

    public List getAllUsers() {
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    public User getUser(int userId) {
        User user = session.get(User.class, userId);
        return user;
    }

    public void removeUser(User userToRemove) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(userToRemove);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        session.close();
    }

    public void addUser(User userToAdd) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(userToAdd);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        session.close();
    }

    public double buyProduct(User user, Product selectedProduct, int quantity) {
        ProductDao productDao;


        confirmPayment();
        return 1;
    }

    public void confirmPayment() {

    }


}
