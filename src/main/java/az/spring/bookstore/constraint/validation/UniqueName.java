package az.spring.bookstore.constraint.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.internal.constraintvalidators.hv.UniqueElementsValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueElementsValidator.class)
@Size(min = 3,message = " Length of name must be at least 3 characters")
@NotBlank(message = "Please enter name")
@Documented
public @interface UniqueName {

    String message() default "Name is already in use";
    Class <?>[] groups() default {};
    Class<?extends Payload>[] payload() default{};
}
