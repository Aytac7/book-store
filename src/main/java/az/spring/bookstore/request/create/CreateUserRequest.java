package az.spring.bookstore.request.create;

import az.spring.bookstore.constraint.validation.UniqueName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CreateUserRequest {
    @UniqueName
    String name;

    @NotNull(message = "Please enter name")
    String surname;

    @Email(message = "Please provide a valid email address")
    String email;

    @NotEmpty(message = "Please provide address")
    String address;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", message = "Password must be at least 8 characters long and contain at least one digit, one lowercase letter, one uppercase letter, and one special character.")
    String password;

    LocalDate dateOfBirth;

//    List<Long> books;


}
