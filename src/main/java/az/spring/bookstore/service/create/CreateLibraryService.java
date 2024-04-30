package az.spring.bookstore.service.create;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.*;
import az.spring.bookstore.mapper.LibraryMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.LibraryRepository;
import az.spring.bookstore.repository.UserRepository;
import az.spring.bookstore.request.add.LibraryBookIdAddRequest;
import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.request.read.LibrarySpecificReadRequest;
import az.spring.bookstore.response.create.CreateLibraryResponse;
import az.spring.bookstore.response.read.LibraryReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class CreateLibraryService {
   private final LibraryRepository libraryRepository;
   private  final UserRepository userRepository;
   private  final LibraryMapper libraryMapper;
   private  final BookRepository bookRepository;

    public CreateLibraryResponse create(CreateLibraryRequest libraryRequest) {

       UserEntity userEntity = userRepository.findById(Long.valueOf(libraryRequest.getFkUserId())).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), "Not found user "));
       if (Objects.nonNull(userEntity)) {
           LibraryEntity libraryEntity = libraryRepository.findByNameOrFkUserIdAndStatusIn(libraryRequest.getName(), libraryRequest.getFkUserId(), List.of("C", "A"));
           if (Objects.nonNull(libraryEntity)) {
               throw new LibraryAlreadyExistsException(HttpStatus.CONFLICT.name(), "Libraries already exist");
           } else {
               LibraryEntity entity = libraryMapper.mapToLibraryEntity(libraryRequest);
               LibraryEntity savedLibrary = libraryRepository.save(entity);
               userEntity.setFkLibraryId(String.valueOf(entity.getId()));
               userRepository.save(userEntity);
               return libraryMapper.mapToLibraryResponse(savedLibrary);

           }
       }
       throw new UserNotFoundException(HttpStatus.NOT_FOUND.name(),"Not found user" );
   }
   public LibraryBookIdAddRequest addBookId(LibraryBookIdAddRequest libraryBookIdAddRequest) {
      BookEntity bookEntity = bookRepository.findById(Long.valueOf(libraryBookIdAddRequest.getFkBookId()))
              .orElseThrow(()->new BookNotFoundException("Book not found!",HttpStatus.NOT_FOUND.name()));

           LibraryEntity libraryEntity = libraryRepository.findById(libraryBookIdAddRequest.getLibraryId())
                   .orElseThrow(()->new LibraryNotFoundException("Library not found"));

           if(Objects.isNull(libraryEntity.getFkBookId())){

               libraryEntity.setFkBookId(libraryBookIdAddRequest.getFkBookId());
               bookEntity.setFkLibraryId(libraryEntity.getId());
               bookRepository.save(bookEntity);
           }
           else throw new BookAlreadyExistsException("You have book in library,if you get new book retrieve exist book",HttpStatus.BAD_REQUEST.name());

       save(bookEntity, libraryBookIdAddRequest.getFkUserId());

       return libraryMapper.mapForBookIdLibraryResponse(libraryEntity);
           }

           public void save(BookEntity bookEntity, Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), "User not found!"));

        userEntity.setStatus("A");
        userRepository.save(userEntity);

        bookEntity.setBookStatus("A");
        bookRepository.save(bookEntity);
    }



    //TODO : bu kitab ucun read service numunesidir sadece... bizde library one to one elaqesi ile gedecek
   public List<LibraryReadResponse> readAllSpecificLibrary(LibrarySpecificReadRequest request){

          return libraryMapper.listEntityToListResponse(libraryRepository.findByFkUserId(request.getFkUserId()));
   }


}
