package sample;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.entity.User;

public class UserVerifier {

    private static Session session = HibernateUtil.getSession();

    public boolean userExist(User userToVerify) {
        Query<User> query = session.createQuery(
                "select u from User u where username = :username and  password = :password and userType = 'employee'", User.class);
        query.setParameter("username", userToVerify.getUsername());
        query.setParameter("password", userToVerify.getPassword());
        return query.getResultList().size() > 0;
    }

    public static boolean isUserCustomerType(User userToVerify) {
        Query<User> query = session.createQuery(
                "select u from User u where username = :username and  password = :password and userType = 'customer'", User.class);
        query.setParameter("username", userToVerify.getUsername());
        query.setParameter("password", userToVerify.getPassword());
        //return query.getResultList().equals("customer");
       //return query.getSingleResult().getUserType().equals("customer");
        return query.getResultList().size() > 0;
    }
}
