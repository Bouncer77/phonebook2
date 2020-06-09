package phone.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
 *   Created by Kosenkov Ivan on 09 8:27
 */
@Entity
@Table(name="USERR")
@Getter
@Setter
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Phone> phones;

    public User() {
        super();
    }

    public User(String name, List<Phone> phone) {
        this.name = name;
        this.phones = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
