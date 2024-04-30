package az.spring.bookstore.controller;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import az.spring.bookstore.service.create.CreateUserService;
import az.spring.bookstore.service.delete.UserDelete.UserDeleteService;
import az.spring.bookstore.service.read.userRead.GetAllUserService;
import az.spring.bookstore.service.read.userRead.UserReadAllService;
import az.spring.bookstore.service.update.UserUpdate.UserUpdateService;
import az.spring.bookstore.wrapper.UserWrapper;
import jakarta.validation.Valid;
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
    private final UserUpdateService userUpdateService;
    private final UserDeleteService userDeleteService;


    @PostMapping("/create")
    public CreateUserResponse add(@RequestBody @Valid CreateUserRequest createUserRequest){
       return createUserService.saveUser(createUserRequest);
    }

    @GetMapping("/get")
    public List<CreateUserResponse> getData() {
        return getAllUserService.getAll();
    }


    @PostMapping("/read-all")
    public ResponseEntity <List<UserWrapper>> getAllUsers(){
        List<UserWrapper> users = userReadAllService.readAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public CreateUserResponse update( @PathVariable Long id, @RequestBody CreateUserRequest userRequest){
       return userUpdateService.update(id,userRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam Long id){
       userDeleteService.delete(id);
    }

}
