package az.spring.bookstore.request.add;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryBookIdAddRequest {

    @NotNull(message = "BookId must not be blank")
    Long fkBookId;
    @NotNull
    Long libraryId;
    Long fkUserId;

}
