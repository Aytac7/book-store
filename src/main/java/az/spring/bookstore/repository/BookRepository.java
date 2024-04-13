package az.spring.bookstore.repository;

import az.spring.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

//    List<BookEntity> findAllByIdIn(List<Long> id);
}
