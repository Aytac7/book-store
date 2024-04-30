package az.spring.bookstore.service.delete.BookDelete;

import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.IdNotFoundException;
import az.spring.bookstore.exception.LibraryNotFoundException;
import az.spring.bookstore.exception.UnauthorizedAccessException;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.LibraryRepository;
import az.spring.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static az.spring.bookstore.enums.UserRole.LIBRARIAN;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteBookService {
   private final BookRepository bookRepository;
   private final LibraryRepository libraryRepository;
   private final UserRepository userRepository;

    public ResponseEntity<?> deleteBook( Long id){
        LibraryEntity libraryId=libraryRepository.findById(id).orElseThrow(()->new LibraryNotFoundException("Library not found"));
        UserEntity userId=userRepository.findByFkLibraryId(String.valueOf(libraryId.getId()));
        if (!LIBRARIAN.equals(userId.getUserRole())) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return new ResponseEntity<>("Book is deleted successfully", HttpStatus.NO_CONTENT);
        }
        else
            throw new IdNotFoundException(HttpStatus.BAD_REQUEST.name(), "Id dont exist");

    }else throw new UnauthorizedAccessException("You are not allowed");
    }

}
