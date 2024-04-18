package az.spring.bookstore.request.create;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateLibraryRequest {
    @NotBlank
    String name;
    String title;
    @NotBlank(message = "Please enter userId")
    String fkUserId;
    @NotBlank(message = "Please enter bookId")
    String fkBookId;
}
