package az.spring.bookstore.service.bookServiceTest;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.service.create.CreateBookService;
import az.spring.bookstore.util.BookUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
 @ExtendWith(MockitoExtension.class)
 @MockitoSettings(strictness = Strictness.LENIENT)

public class CreateBookServiceTest {
     @Mock
    private BookMapper bookMapper;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private CreateBookService createBookService;

    @Test
    public void testCreateBookService_whenCreateBookRequest_shouldReturnCreateBookResponse(){
        CreateBookRequest request= BookUtil.createBookRequest();
        CreateBookResponse response=BookUtil.createBookResponse();
        BookEntity bookEntity=BookUtil.bookEntity();
        BookEntity savedBook=BookUtil.bookSave();

        when(bookMapper.mapToBookEntity(request)).thenReturn(bookEntity);
        when(bookRepository.save(bookEntity)).thenReturn(savedBook);
        when(bookMapper.mapToBookResponse(savedBook)).thenReturn(response);

        CreateBookResponse actual=createBookService.saveBook(request);

        Assertions.assertEquals(response.getName(),actual.getName());
        Assertions.assertEquals(response.getLanguage(),actual.getLanguage());
        Assertions.assertNotNull(actual);

        verify(bookMapper,times(1)).mapToBookEntity(request);
        verify(bookRepository,times(1)).save(bookEntity);
        verify(bookMapper,times(1)).mapToBookResponse(savedBook);
    }

}
