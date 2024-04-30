package az.spring.bookstore.util;

import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;

public class UserUtil {

    private UserUtil(){

    }

   public static UserEntity userEntity(){
        return UserEntity.builder()
                .name("test_name")
                .surname("test_surname")
                .build();
   }

    public static CreateUserResponse userResponse(){
        return CreateUserResponse.builder()
                .name("test_name")
                .surname("test_surname")
                .build();
    }

    public static CreateUserRequest userRequest(){
        return CreateUserRequest.builder()
                .name("test_name")
                .surname("test_surname")
                .build();
    }

    public static UserEntity saveUserEntity(){
        return UserEntity.builder()
                .name("test_name")
                .surname("test_surname")
                .fkLibraryId("1")
                .build();
    }
}
