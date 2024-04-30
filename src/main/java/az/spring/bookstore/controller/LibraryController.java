package az.spring.bookstore.controller;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.LibraryRepository;
import az.spring.bookstore.request.add.LibraryBookIdAddRequest;
import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.request.read.LibrarySpecificReadRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.response.create.CreateLibraryResponse;
import az.spring.bookstore.response.read.LibraryReadResponse;
import az.spring.bookstore.service.create.CreateLibraryService;
import az.spring.bookstore.service.delete.BookDelete.DeleteFkBookIdLibraryService;
import az.spring.bookstore.service.read.libraryRead.GetAllBooksFromLibrary;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
@RequiredArgsConstructor
public class LibraryController {
    private final CreateLibraryService libraryService;
    private final LibraryRepository libraryRepository;
    private final DeleteFkBookIdLibraryService deleteFkBookIdLibraryService;
    private final GetAllBooksFromLibrary getAllBooksFromLibrary;
    private final BookMapper bookMapper;

    @PostMapping("/create")
    public ResponseEntity<CreateLibraryResponse> create(@RequestBody @Valid CreateLibraryRequest createRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.create(createRequest));
    }
    @PostMapping("/add/book")
    public ResponseEntity<LibraryBookIdAddRequest> addBookIdToLibrary(@RequestBody @Valid LibraryBookIdAddRequest libraryBookIdAddRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.addBookId(libraryBookIdAddRequest));
    }


    @PostMapping("/read/users")
    public ResponseEntity<List<LibraryReadResponse>> create(@RequestBody @Valid LibrarySpecificReadRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.readAllSpecificLibrary(request));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBookById(@RequestBody LibraryBookIdAddRequest libraryBookIdAddRequest){
        deleteFkBookIdLibraryService.deleteFkBookId(libraryBookIdAddRequest);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{libraryId}")
    public CreateBookResponse getBooksByLibrary(@PathVariable Long libraryId) {
        BookEntity book=getAllBooksFromLibrary.getBookByLibrary(libraryId);
        return  bookMapper.mapToBookResponse(book);
    }





}
