package az.spring.bookstore.response.create;

import az.spring.bookstore.enums.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateUserResponse {
    String name;
    String email;
    String surname;
    String address;
    String password;
    LocalDate dateOfBirth;
    UserRole userRole;


}
