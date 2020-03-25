package sample.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_name", unique = true, nullable = false, length = 30)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "user_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
