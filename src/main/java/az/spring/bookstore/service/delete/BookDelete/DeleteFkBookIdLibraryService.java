package az.spring.bookstore.service.delete.BookDelete;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.BookNotFoundException;
import az.spring.bookstore.exception.LibraryNotFoundException;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.LibraryRepository;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.add.LibraryBookIdAddRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DeleteFkBookIdLibraryService {

    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    private final UserRepository userRepository;
    public void deleteFkBookId(LibraryBookIdAddRequest libraryBookIdAddRequest){
        Optional<BookEntity> bookId = bookRepository.findById(Long.valueOf(libraryBookIdAddRequest.getFkBookId()));
        BookEntity bookEntity = bookId.get();
        LibraryEntity fkBookId = libraryRepository.findByFkBookId(libraryBookIdAddRequest.getFkBookId())
                .orElseThrow(()->new RuntimeException("Library not found!"));
        if(Objects.nonNull(fkBookId)){
            libraryRepository.delete(fkBookId);
            bookEntity.setFkLibraryId(null); // Və ya əgər lazımsa, bookEntity.setLibraryId(null);

            LibraryEntity libraryId=libraryRepository.findById(bookId.get().getId()).orElseThrow(()->new LibraryNotFoundException("Library not found"));
            UserEntity userEntity=userRepository.findByFkLibraryId(String.valueOf(libraryId.getId()));
            userEntity.setStatus("C");
            userRepository.save(userEntity);

            bookEntity.setBookStatus("C");
        }
        else throw new BookNotFoundException(HttpStatus.NOT_FOUND.name(),"book not exists");
    }
}
