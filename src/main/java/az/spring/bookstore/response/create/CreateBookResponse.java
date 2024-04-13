package az.spring.bookstore.response.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateBookResponse {

    String name;
    String author;
    Integer price;
    String genre;
    String language;
    Integer numberOfPages;
    LocalDate publicationDate;

}
