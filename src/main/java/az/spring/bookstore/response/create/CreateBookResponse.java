package az.spring.bookstore.response.create;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateBookResponse {

    String name;
    String author;
    Integer price;
    String genre;
    String language;
    Integer numberOfPages;
    LocalDate publicationDate;

}
