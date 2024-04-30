package az.spring.bookstore.service.delete.UserDelete;

import az.spring.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

    private final UserRepository userRepository;

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
