package az.spring.bookstore.controller;
import az.spring.bookstore.exception.IdNotFoundException;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.service.create.CreateBookService;
import az.spring.bookstore.service.read.GetAllBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final CreateBookService createBookService;
    private final GetAllBookService getAllBookService;
    private final BookRepository bookRepository;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> add(@RequestBody CreateBookRequest createBookRequest){
         createBookService.saveBook(createBookRequest);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);

    }

    @GetMapping
    public List<CreateBookResponse> getData() {
        return  getAllBookService.getAll();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteData(Long id){
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return new ResponseEntity<>("Book is deleted successfully", HttpStatus.NO_CONTENT);
        }
        else
          throw new IdNotFoundException(HttpStatus.BAD_REQUEST.name(), "Id dont exist");

    }
}
