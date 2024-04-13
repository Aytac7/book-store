package az.spring.bookstore.service.read;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.exception.handler.CustomerException;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor

public class GetByIdBookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CustomerException customerException;

//    public CreateBookResponse getById(CreateBookRequest createBookRequest){
//       BookEntity bookEntity= bookMapper.mapToBookEntity(createBookRequest);
//       bookRepository.findById(bookEntity).orElseThrow(()-> new CustomerException())
//
//    }


}
