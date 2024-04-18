package az.spring.bookstore.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@Table(name="library")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String name;
    String title;
    String status;


    @Column(name = "fk_user_id")
    String fkUserId;

    @Column(name="fk_book_id")
    String fkBookId;

    @PrePersist
    public void prePersist(){
        if(status==null){
            status="C";
        }
    }
}
