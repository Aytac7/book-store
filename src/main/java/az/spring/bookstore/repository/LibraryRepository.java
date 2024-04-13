package az.spring.bookstore.repository;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity,Long> {

}
