package az.spring.bookstore.util;

import az.spring.bookstore.entity.UserEntity;

public class UserUtil {

    private UserUtil(){

    }

   public static UserEntity userEntity(){
        return UserEntity.builder()
                .name("test_name")
                .surname("test_surname")
                .build();
   }
}
