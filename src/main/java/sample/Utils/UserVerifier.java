package sample.Utils;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.entity.User;
import sample.entity.UserType;

public class UserVerifier {

    private Session session = HibernateUtil.getSession();

    public boolean userExist(User userToVerify) {
        Query<User> query = session.createQuery(
                "select u from User u where username = :username and  password = :password", User.class);
        query.setParameter("username", userToVerify.getUsername());
        query.setParameter("password", userToVerify.getPassword());
        return query.getResultList().size() > 0;
    }

    public boolean isUserEmployeeType(User userToVerify) {
        Query<User> query = session.createQuery(
                "select u from User u where username = :username and  password = :password", User.class);
        query.setParameter("username", userToVerify.getUsername());
        query.setParameter("password", userToVerify.getPassword());

        return query.getSingleResult().getUserType().equals(UserType.EMPLOYEE);
    }

}
