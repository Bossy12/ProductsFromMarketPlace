package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import sample.entity.User;

import java.util.List;


public class UserVerifier {

    private List<User> users;
    private Session session = HibernateUtil.getSession();

    public boolean userExist(User userToVerify) {

        Query<User> query = session.createQuery("select u from User u where username = :username and  password = :password", User.class);
        query.setParameter("username", userToVerify.getUsername());
        query.setParameter("password", userToVerify.getPassword());
       return query.getSingleResult()!=null;
    }


}
