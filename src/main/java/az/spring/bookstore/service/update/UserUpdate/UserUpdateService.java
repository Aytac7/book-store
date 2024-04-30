package az.spring.bookstore.service.update.UserUpdate;

import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.UserNotFoundException;
import az.spring.bookstore.mapper.UserMapper;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public CreateUserResponse update(Long id, CreateUserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), "not found user: "));
        userMapper.mapForUpdate(userEntity, userRequest);
        userRepository.save(userEntity);
        return userMapper.mapToUserResponse(userEntity);
    }
}
