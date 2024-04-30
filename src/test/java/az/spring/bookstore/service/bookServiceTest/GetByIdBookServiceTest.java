package az.spring.bookstore.service.bookServiceTest;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.exception.BookNotFoundException;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.service.read.bookRead.GetByIdBookService;
import az.spring.bookstore.util.BookUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness= Strictness.LENIENT)
public class GetByIdBookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private GetByIdBookService getByIdBookService;

    @Test
    public void testGetByIdBookService_whenBookIdCallBook_shouldReturnCreateBookResponse(){
        Long bookId=1L;
        BookEntity bookEntity= BookUtil.bookEntity();
        CreateBookResponse response=BookUtil.createBookResponse();

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(bookEntity));
        when(bookMapper.mapToBookResponse(bookEntity)).thenReturn(response);

        CreateBookResponse actual=getByIdBookService.getById(bookId);

        Assertions.assertEquals(response.getName(),actual.getName());
        Assertions.assertEquals(response.getLanguage(),actual.getLanguage());
        Assertions.assertNotNull(actual);

        verify(bookRepository,times(1)).findById(bookId);
        verify(bookMapper,times(1)).mapToBookResponse(bookEntity);
    }

    @Test
    public void testGetBooksDetails_whenBookDoesNotExists_shouldThrowsBookNotFoundException(){
        Long bookId=1L;
        BookEntity bookEntity= BookUtil.bookEntity();
        CreateBookResponse response=BookUtil.createBookResponse();

        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        Assertions.assertThrows(BookNotFoundException.class,()->getByIdBookService.getById(bookId));
    }

}

