package az.spring.bookstore.service.update.BookUpdate;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.BookNotFoundException;
import az.spring.bookstore.exception.LibraryNotFoundException;
import az.spring.bookstore.exception.UnauthorizedAccessException;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.LibraryRepository;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static az.spring.bookstore.enums.UserRole.LIBRARIAN;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateBookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;


    public ResponseEntity<CreateBookResponse> update(Long id, CreateBookRequest bookRequest) {
        LibraryEntity libraryId=libraryRepository.findById(id).orElseThrow(()->new LibraryNotFoundException("Library not found"));
        UserEntity userId=userRepository.findByFkLibraryId(String.valueOf(libraryId.getId()));

        if (!LIBRARIAN.equals(userId.getUserRole())) {
            BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(HttpStatus.NOT_FOUND.name(), "Book not found"));
            bookMapper.mapForUpdate(bookEntity, bookRequest);
            bookRepository.save(bookEntity);
            CreateBookResponse response = bookMapper.mapToBookResponse(bookEntity);
            return ResponseEntity.ok(response);
        }
        else throw new UnauthorizedAccessException("You are not allowed");
    }



}