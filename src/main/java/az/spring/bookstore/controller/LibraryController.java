package az.spring.bookstore.controller;

import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.request.read.LibrarySpecificReadRequest;
import az.spring.bookstore.response.create.CreateLibraryResponse;
import az.spring.bookstore.response.read.LibraryReadResponse;
import az.spring.bookstore.service.create.CreateLibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libraries")
@RequiredArgsConstructor
public class LibraryController {
    private final CreateLibraryService createService;

    @PostMapping("/create")
    public ResponseEntity<CreateLibraryResponse> create(@RequestBody @Valid CreateLibraryRequest createRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(createService.create(createRequest));
    }

    @PostMapping("/read")
    public ResponseEntity<List<LibraryReadResponse>> create(@RequestBody @Valid LibrarySpecificReadRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(createService.readAllSpecificLibrary(request));
    }
}
