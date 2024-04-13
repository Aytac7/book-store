package az.spring.bookstore.service.create;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.mapper.UserMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final UserMapper userMapper;


    public CreateUserResponse saveUser(CreateUserRequest createUserRequest){
        UserEntity userEntity=userMapper.mapToUserEntity(createUserRequest);
//        List<BookEntity> bookEntityList = bookRepository.findAllByIdIn(createUserRequest.getBooks());
//        userEntity.setBooks(bookEntityList);
        UserEntity saveUserEntity=userRepository.save(userEntity);
        return userMapper.mapToUserResponse(saveUserEntity);
    }
}
