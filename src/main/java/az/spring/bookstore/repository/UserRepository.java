package az.spring.bookstore.repository;

import az.spring.bookstore.wrapper.UserWrapper;
import az.spring.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    @Query("""
            select new az.spring.bookstore.wrapper.UserWrapper(u.name, u.surname,u.status) from UserEntity u
            where u.status='A'
""")
    List<UserWrapper> findByUserStatusA();
    UserEntity findByName(String name);

//    @Query("select u from UserEntity where u.status = 'A'")
//    //@Query(value = "select * from UserEntity where status = 'A'", nativeQuery = true)
//    List<UserEntity> findByStatus();
}
