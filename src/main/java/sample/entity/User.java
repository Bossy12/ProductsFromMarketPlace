package sample.entity;


import lombok.Data;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.HibernateUtil;


import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "user_name", unique = true, nullable = true, length = 30)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_type")
    private String userType;

    public double buyProduct(User user, Product selectedProduct, int quantity) {

        confirmPayment();
        return 1;
    }

    public void confirmPayment() {

    }

    public void addProduct(Product productToAdd, int quantity) {


        Session session = HibernateUtil.getSession();


        session.beginTransaction();


        Query<Product> query = session.createQuery("select p from Product p where productName = :productName", Product.class);
        query.setParameter("productName", productToAdd.getProductName());
        query.getSingleResult();


        session.save(productToAdd);
        session.getTransaction().commit();
        session.close();


    }

    public void removeProduct(Product productToRemove, int quantity) {

    }


}
