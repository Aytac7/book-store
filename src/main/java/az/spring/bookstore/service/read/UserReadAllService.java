package az.spring.bookstore.service.read;

import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.wrapper.UserWrapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserReadAllService {
    UserRepository userRepository;

    public List<UserWrapper> readAllUsers(){
        return userRepository.findByUserStatusA();
    }

}
