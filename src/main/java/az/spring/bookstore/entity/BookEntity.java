package az.spring.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "all_books")
public class BookEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;


    String name;
    String author;
    Integer price;
    String genre;
    String language;
    Integer numberOfPages;
    LocalDate publicationDate;

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updatedAt;


    //@Column(name = "user_id")
     Long userId;

    //@Column(name="library_id")
     Long libraryId;







}
