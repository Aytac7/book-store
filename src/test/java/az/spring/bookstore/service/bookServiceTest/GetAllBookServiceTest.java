package az.spring.bookstore.service.bookServiceTest;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.mapper.BookMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.service.read.bookRead.GetAllBookService;
import az.spring.bookstore.util.BookUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GetAllBookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private GetAllBookService getAllBookService;

    @Test
    public void testGetAllBookService_whenGetAllBooks_shouldReturnCreateBookResponseList() {
        List<BookEntity> bookEntityList = BookUtil.bookEntities();
        List<CreateBookResponse> responses = BookUtil.getAll();


        when(bookRepository.findAll()).thenReturn(bookEntityList);
        when(bookMapper.mapToListResponse(bookEntityList)).thenReturn(responses);

        List<CreateBookResponse> actual = getAllBookService.getAll();
        Assertions.assertEquals(responses.size(), actual.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(responses.get(i).getName(), actual.get(i).getName());
            Assertions.assertEquals(responses.get(i).getAuthor(), actual.get(i).getAuthor());
        }
        Assertions.assertNotNull(actual);
        verify(bookRepository, times(1)).findAll();
        verify(bookMapper, times(1)).mapToListResponse(bookEntityList);
    }
}
