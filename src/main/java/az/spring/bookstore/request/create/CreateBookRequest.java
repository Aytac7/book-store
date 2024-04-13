package az.spring.bookstore.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CreateBookRequest {
    @NotBlank
    String name;

    @NotEmpty
    String author;

    Integer price;
    String genre;
    String language;
    Integer numberOfPages;
    LocalDate publicationDate;


}
