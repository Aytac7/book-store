package az.spring.bookstore.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWrapper {
    Long id;
    String name;
    String surname;
    String password;
    String status;

    public UserWrapper(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UserWrapper(String name, String surname, String status) {
        this.name = name;
        this.surname = surname;
        this.status = status;
    }
}
