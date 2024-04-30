package az.spring.bookstore.service.read.libraryRead;

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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static az.spring.bookstore.enums.UserRole.STUDENT;

@Service
@RequiredArgsConstructor
public class GetAllBooksFromLibrary {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookEntity getBookByLibrary(Long libraryId) {
        LibraryEntity library = libraryRepository.findById(libraryId).orElseThrow(() -> new LibraryNotFoundException("Library not found"));
        UserEntity userId=userRepository.findByFkLibraryId(String.valueOf(library.getId()));
        if(STUDENT.equals(userId.getUserRole())){
            if(!Objects.equals(library.getFkUserId(),String.valueOf(userId))) {
                throw new UnauthorizedAccessException("You are not authorized to access this library");
            }
        }
        //Eger LIBRARIAN olsa userId-i  yoxlamayacaq istenilen halda libraryId ile getirecek

        BookEntity book = null;
        if (Objects.nonNull(library)) {
            if (Objects.nonNull(library.getFkBookId())) {
                book = bookRepository.findById(library.getFkBookId()).orElseThrow(() -> new BookNotFoundException("Book not found", HttpStatus.NOT_FOUND.name()));
            }
        }
        return book;



    }
}


