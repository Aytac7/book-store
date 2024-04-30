package az.spring.bookstore.service.read.bookRead;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.exception.BookNotFoundException;

import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.response.create.CreateBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdBookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public CreateBookResponse getById(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(HttpStatus.NOT_FOUND.name(),"Book not found with ID: "));

        return bookMapper.mapToBookResponse(bookEntity);
    }
}
