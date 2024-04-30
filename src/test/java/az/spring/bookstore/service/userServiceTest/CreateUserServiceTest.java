package az.spring.bookstore.service.userServiceTest;

import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.mapper.UserMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import az.spring.bookstore.service.create.CreateUserService;
import az.spring.bookstore.util.UserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateUserServiceTest {
    @Mock
    private  UserRepository userRepository;


    @Mock
    private  UserMapper userMapper;

    @InjectMocks
    private CreateUserService createUserService;

    @Test
    public void testCreateUserService_whenCreateUserRequest_shouldReturnCreateUserResponse(){
        CreateUserRequest userRequest=UserUtil.userRequest();
        CreateUserResponse userResponse=UserUtil.userResponse();
        UserEntity userEntity= UserUtil.userEntity();
        UserEntity saveUserEntity=UserUtil.saveUserEntity();

        when(userMapper.mapToUserEntity(userRequest)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(saveUserEntity);
        when(userMapper.mapToUserResponse(saveUserEntity)).thenReturn(userResponse);

        CreateUserResponse actual=createUserService.saveUser(userRequest);
        Assertions.assertEquals(userResponse.getName(),actual.getName());
        Assertions.assertEquals(userResponse.getSurname(),actual.getSurname());
        Assertions.assertNotNull(actual);
        verify(userMapper,times(1)).mapToUserEntity(userRequest);
        verify(userRepository,times(1)).save(userEntity);
        verify(userMapper,times(1)).mapToUserResponse(saveUserEntity);
    }



}
