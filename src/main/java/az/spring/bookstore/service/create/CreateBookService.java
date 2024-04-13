package az.spring.bookstore.service.create;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public CreateBookResponse saveBook(CreateBookRequest createBookRequest){
        BookEntity bookEntity=bookMapper.mapToBookEntity(createBookRequest);
        BookEntity saveBookEntity=bookRepository.save(bookEntity);
        return bookMapper.mapToBookResponse(saveBookEntity);
    }
}
