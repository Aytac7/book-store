package az.spring.bookstore.repository;

import az.spring.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    BookEntity findByNameAndBookStatus(String name,String status);

}
