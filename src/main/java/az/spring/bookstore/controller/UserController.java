package az.spring.bookstore.controller;

import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import az.spring.bookstore.service.create.CreateUserService;
import az.spring.bookstore.service.read.GetAllUserService;
import az.spring.bookstore.service.read.UserReadAllService;
import az.spring.bookstore.wrapper.UserWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private  final GetAllUserService getAllUserService;
    private final CreateUserService createUserService;
    private final UserReadAllService userReadAllService;


    @PostMapping
    public CreateUserResponse add(@RequestBody CreateUserRequest createUserRequest){
       return createUserService.saveUser(createUserRequest);
    }

    @GetMapping
    public List<CreateUserResponse> getData() {
        return getAllUserService.getAll();
    }


    @PostMapping("/read-all")
    public ResponseEntity <List<UserWrapper>> getAllUsers(){
        List<UserWrapper> users = userReadAllService.readAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


}
