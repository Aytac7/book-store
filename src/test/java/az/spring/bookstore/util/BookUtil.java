package az.spring.bookstore.util;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;

import java.util.ArrayList;
import java.util.List;

public class BookUtil {

    private BookUtil(){

    }

    public static CreateBookRequest  createBookRequest(){
        return CreateBookRequest.builder()
                .name("test_name")
                .language("test_language")
                .build();
    }

    public static CreateBookResponse createBookResponse(){
        return CreateBookResponse.builder()
                .name("test_name")
                .language("test_language")
                .build();
    }

    public static BookEntity bookEntity(){
        return BookEntity.builder()
                .name("test_name")
                .language("test_language")
                .build();
    }

    public static BookEntity bookSave(){
        return BookEntity.builder()
                .name("test_name")
                .language("test_language")
                .build();
    }

    public static List<BookEntity>bookEntities(){
        List<BookEntity> books=new ArrayList<>();
        books.add(BookEntity.builder()
                        .name("test_name")
                        .author("test_author")
                .build());
        books.add(BookEntity.builder()
                .name("test_name")
                .author("test_author")
                .build());
        return books;
    }

    public static List<CreateBookResponse>getAll(){
        List<CreateBookResponse> books=new ArrayList<>();
        books.add(CreateBookResponse.builder()
                .name("test_name")
                .author("test_author")
                .build());
        books.add(CreateBookResponse.builder()
                .name("test_name")
                .author("test_author")
                .build());
        return books;
    }


}
