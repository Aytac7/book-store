package az.spring.bookstore.entity;
import az.spring.bookstore.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "all_users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    UserRole userRole;
    LocalDate dateOfBirth;




    @Column(name = "fk_library_id")
    private String fkLibraryId;

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updatedAt;

    @PrePersist
    public void pre(){
        if(status==null){
            status="C";
        }
    }




}
