package az.spring.bookstore.response.read;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryReadResponse {

    Long id;
    String name;
    String title;
    String fkUserId;
    String fkBookId;
    String status;
}
