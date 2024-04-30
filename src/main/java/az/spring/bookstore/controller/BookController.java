package az.spring.bookstore.controller;

import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.service.create.CreateBookService;
import az.spring.bookstore.service.delete.BookDelete.DeleteBookService;
import az.spring.bookstore.service.read.bookRead.GetAllBookService;
import az.spring.bookstore.service.read.bookRead.GetByIdBookService;
import az.spring.bookstore.service.update.BookUpdate.UpdateBookService;
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

    private final GetByIdBookService getByIdBookService;
    private final DeleteBookService deleteBookService;
    private  final UpdateBookService updateBookService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> add(@RequestBody CreateBookRequest createBookRequest){
         createBookService.saveBook(createBookRequest);
        return new ResponseEntity<>("Book created successfully", HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    public List<CreateBookResponse> getAllBooks() {
        return  getAllBookService.getAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateBookResponse> update(@PathVariable Long id,
                                                     @RequestBody CreateBookRequest bookRequest){

        return updateBookService.update(id,bookRequest);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteBook(@RequestParam Long id){
        return deleteBookService.deleteBook(id);
    }

    @GetMapping("/getBookById")
    public CreateBookResponse getBook(@RequestParam Long id){
        return getByIdBookService.getById(id);
    }
}
