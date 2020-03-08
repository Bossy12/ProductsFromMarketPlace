package sample.entity;


import lombok.Data;

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



    }

    public void removeProduct(Product productToRemove, int quantity) {

    }


}
