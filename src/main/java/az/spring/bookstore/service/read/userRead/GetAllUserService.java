package az.spring.bookstore.service.read.userRead;

import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.mapper.UserMapper;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.response.create.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class GetAllUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<CreateUserResponse> getAll() {
        List<UserEntity> users = userRepository.findAll();
        return userMapper.mapToListResponse(users);
    }
}
