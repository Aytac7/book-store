package az.spring.bookstore.request.read;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryBookIdReadRequest {

    String fkBookId;

}
