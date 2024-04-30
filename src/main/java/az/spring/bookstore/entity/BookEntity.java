package az.spring.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "all_books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String name;
    String genre;
    String author;
    Integer price;
    String language;
    String bookStatus;
    Integer numberOfPages;
    LocalDate publicationDate;

    @Column(name = "fk_library_id")
    Long fkLibraryId;

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updatedAt;

//    @PrePersist
//    public void pre() {
//        if (bookStatus == null) {
//            bookStatus = "C";
//        }
   // }
}