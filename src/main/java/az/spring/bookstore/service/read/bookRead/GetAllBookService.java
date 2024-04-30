package az.spring.bookstore.service.read.bookRead;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.response.create.CreateBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class GetAllBookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public List<CreateBookResponse> getAll() {
        List<BookEntity> books = bookRepository.findAll();
        return bookMapper.mapToListResponse(books);
    }
}
