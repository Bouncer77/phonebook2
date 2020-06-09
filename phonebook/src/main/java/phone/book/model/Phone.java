package phone.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
 *   Created by Kosenkov Ivan on 09 8:29
 */
@Entity
@Table(name = "PHONE")
@Getter
@Setter
public class Phone {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;

    public Phone() {
        super();
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
