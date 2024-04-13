package az.spring.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="library")
public class LibraryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String name;


    Long userId;
    Long bookId;

}
