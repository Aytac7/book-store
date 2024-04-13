package az.spring.bookstore.controller;

import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.response.create.CreateUserResponse;
import az.spring.bookstore.service.create.CreateBookService;
import az.spring.bookstore.service.read.GetAllBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final CreateBookService createBookService;
    private final GetAllBookService getAllBookService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateBookResponse add(@RequestBody CreateBookRequest createBookRequest){
        return createBookService.saveBook(createBookRequest);
    }

    @GetMapping
    public List<CreateBookResponse> getData() {
        return  getAllBookService.getAll();
    }
}
