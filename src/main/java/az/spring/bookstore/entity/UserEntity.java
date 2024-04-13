package az.spring.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "all_users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String name;
    String email;
    String surname;
    String address;
    String status;
    String password;
    LocalDate dateOfBirth;

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updatedAt;


    private Long bookId;

    //@OneToOne(mappedBy = "userId")
    private Long libraryId;

}
