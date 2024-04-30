package az.spring.bookstore.repository;

import az.spring.bookstore.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity,Long> {
    //TODO: kitab statuslarini da hesaba qatmaq lazimdir .. statuslari a ve c olan  kitabxanalar movcud ola biler





    LibraryEntity findByNameOrFkUserIdAndStatusIn(String name, String fkUserId, List<String> statusList);
    List<LibraryEntity>findByFkUserId(String fkUserId);
    Optional<LibraryEntity> findByFkBookId(Long id);


//    LibraryEntity findAllByFkBookId


}
