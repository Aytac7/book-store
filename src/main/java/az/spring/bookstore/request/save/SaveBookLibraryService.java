package az.spring.bookstore.request.save;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.UserNotFoundException;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class SaveBookLibraryService {
   private final UserRepository userRepository;
   private final BookRepository bookRepository ;
    public void save(BookEntity bookEntity, Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), "User not found!"));

        userEntity.setStatus("A");
        userRepository.save(userEntity);

        bookEntity.setBookStatus("A");
        bookRepository.save(bookEntity);
    }
}
