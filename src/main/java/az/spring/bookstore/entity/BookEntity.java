package az.spring.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

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

    @Column(name = "fk_user_id")
    Long fkUserId;

    @Column(name="fk_library_id")
    Long fkLibraryId;

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updatedAt;










}
