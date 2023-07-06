package Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;


@Entity
@Table(name = "userinfo")
public class Users
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;
}
