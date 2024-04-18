package az.spring.bookstore.response.create;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CreateLibraryResponse {
    Long id;
    String name;
    String title;
    String fkUserId;
    String fkBookId;
    String status;
}
