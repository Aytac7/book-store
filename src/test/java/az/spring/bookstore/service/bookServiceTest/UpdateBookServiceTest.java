//package az.spring.bookstore.service.bookServiceTest;
//
//import az.spring.bookstore.entity.BookEntity;
//import az.spring.bookstore.entity.LibraryEntity;
//import az.spring.bookstore.entity.UserEntity;
//import az.spring.bookstore.mapper.BookMapper;
//import az.spring.bookstore.repository.BookRepository;
//import az.spring.bookstore.repository.LibraryRepository;
//import az.spring.bookstore.repository.UserRepository;
//import az.spring.bookstore.request.create.CreateBookRequest;
//import az.spring.bookstore.response.create.CreateBookResponse;
//import az.spring.bookstore.service.update.BookUpdate.UpdateBookService;
//import az.spring.bookstore.util.BookUtil;
//import az.spring.bookstore.util.LibraryUtil;
//import az.spring.bookstore.util.UserUtil;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness= Strictness.LENIENT)
//
//public class UpdateBookServiceTest {
//
//    @Mock
//    private  BookRepository bookRepository;
//
//    @Mock
//    private  UserRepository userRepository;
//
//    @Mock
//    private  LibraryRepository libraryRepository;
//
//    @Mock
//    private  BookMapper bookMapper;
//
//    @InjectMocks
//    private UpdateBookService updateBookService;
//
//    @Test
//    public void testUpdateBookService_whenUpdate_shouldReturnCreateBookResponse(){
//        Long id=1l;
//        CreateBookRequest createBookRequest= BookUtil.createBookRequest();
//        CreateBookResponse createBookResponse=BookUtil.createBookResponse();
//        LibraryEntity libraryEntity= LibraryUtil.libraryEntity();
//        UserEntity userEntity= UserUtil.userEntity();
//        BookEntity bookEntity=BookUtil.bookEntity();
//        when(libraryRepository.findById(id)).thenReturn(Optional.of(libraryEntity));
//        when(userRepository.findByFkLibraryId(String.valueOf(libraryEntity.getId()))).thenReturn(userEntity);
//
//        when(bookRepository.findById(id)).thenReturn(Optional.of(bookEntity));
//        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
//        when(bookMapper.mapToBookResponse(bookEntity)).thenReturn(createBookResponse);
//
//    }
//}
