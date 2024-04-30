package az.spring.bookstore.util;

import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.response.create.CreateLibraryResponse;


public class LibraryUtil {
    private LibraryUtil(){

    }

    public static LibraryEntity libraryEntity(){
        return LibraryEntity.builder()
                .name("test_name")
                .title("test_title")
                .build();
    }

    public static CreateLibraryRequest libraryRequest(){
        return CreateLibraryRequest.builder()
                .name("test_name")
                .fkUserId("1")
                .title("test_title")
                .build();
    }

    public static CreateLibraryResponse libraryResponse(){
        return CreateLibraryResponse .builder()
                .name("test_name")
                .title("test_title")
                .build();
    }

    public static LibraryEntity savedEntity(){
        return LibraryEntity.builder()
                .name("test_name")
                .title("test_title")
                .build();
    }
}
