package sample.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name", unique = true, nullable = true, length = 30)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_type")
    private String userType;
}
