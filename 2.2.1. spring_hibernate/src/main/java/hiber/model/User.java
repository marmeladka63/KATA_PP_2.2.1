package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @MapsId
    private Car car;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public String toString() {
        return
                "id =" + id +
                        ", firstName: " + firstName +
                        ", lastName:" + lastName +
                        ", email: " + email + car;

    }
}

