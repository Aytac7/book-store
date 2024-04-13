package az.spring.bookstore.response.create;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserResponse {
    String name;
    String email;
    String surname;
    String address;
    String password;
    LocalDate dateOfBirth;

}
