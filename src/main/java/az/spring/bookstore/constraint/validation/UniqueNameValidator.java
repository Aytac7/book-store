package az.spring.bookstore.constraint.validation;

import az.spring.bookstore.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,String> {


    private final UserRepository userRepository;

    public UniqueNameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        // Initialize logic, if needed
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        boolean isNameUnique = userRepository.findByName(name) == null;
        return isNameUnique;
    }
}
