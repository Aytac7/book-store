package az.spring.bookstore.request.read;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibrarySpecificReadRequest {
    @NotBlank(message = "daxili mesaji validasiya ile edersiniz")
    private  String fkUserId;
}
