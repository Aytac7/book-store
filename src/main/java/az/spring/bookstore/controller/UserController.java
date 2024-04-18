package az.spring.bookstore.controller;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.UserNotFoundException;
import az.spring.bookstore.mapper.UserMapper;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import az.spring.bookstore.service.create.CreateUserService;
import az.spring.bookstore.service.read.GetAllUserService;
import az.spring.bookstore.service.read.UserReadAllService;
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
    private final UserRepository userRepository;
    private final UserMapper userMapper;


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

    @PutMapping
    public CreateUserResponse update(Long id, CreateUserRequest userRequest){
        UserEntity userEntity=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(HttpStatus.NOT_FOUND.name(),"not found user: "));
        userMapper.mapForUpdate(userEntity,userRequest);
        userRepository.save(userEntity);
        return userMapper.mapToUserResponse(userEntity);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam Long id){
       userRepository.deleteById(id);
    }

}
