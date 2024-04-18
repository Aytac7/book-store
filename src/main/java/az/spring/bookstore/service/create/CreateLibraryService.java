package az.spring.bookstore.service.create;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.exception.UserNotFoundException;
import az.spring.bookstore.mapper.LibraryMapper;
import az.spring.bookstore.repository.BookRepository;
import az.spring.bookstore.repository.LibraryRepository;
import az.spring.bookstore.repository.UserRepository;
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
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateLibraryService {
   private final LibraryRepository libraryRepository;
   private  final UserRepository userRepository;
   private  final LibraryMapper libraryMapper;
   private  final BookRepository bookRepository;
   public CreateLibraryResponse create(CreateLibraryRequest libraryRequest){

       UserEntity userEntity = userRepository.findById(Long.valueOf(libraryRequest.getFkUserId())).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), "not found user: "));
       if (Objects.nonNull(userEntity)) {
           LibraryEntity libraryEntity = libraryRepository.findByNameOrFkUserIdAndStatusIn(libraryRequest.getName(), libraryRequest.getFkUserId(), List.of("C", "A"));
           if (Objects.nonNull(libraryEntity)) {
               throw new RuntimeException("kitabxana artiq movcuddur ...");
           } else {
               LibraryEntity savedLibrary = libraryMapper.mapToLibraryEntity(libraryRequest);
               LibraryEntity saved = libraryRepository.save(savedLibrary);
               userEntity.setFkLibraryId(String.valueOf(savedLibrary.getId()));
               userRepository.save(userEntity);

      }
   }

       Optional<BookEntity> optionalBookEntity = bookRepository.findById(Long.valueOf(libraryRequest.getFkBookId()));
       BookEntity bookEntity=optionalBookEntity.get();
       if(Objects.nonNull(bookEntity)){
           LibraryEntity libraryEntity2=libraryRepository.findByNameOrFkBookId(libraryRequest.getFkBookId(),libraryRequest.getName());
           if(Objects.nonNull(libraryEntity2)){
               throw new RuntimeException("Book isn't exist in the library");
           }
           else {
               LibraryEntity existingLibraryForBook = libraryRepository.findByFkBookId(String.valueOf(bookEntity.getId()));
               if (existingLibraryForBook != null) {
                   throw new RuntimeException("Book already exists in another library");
               }
               LibraryEntity saveLibrary2 = libraryMapper.mapToLibraryEntity(libraryRequest);
               LibraryEntity saved=libraryRepository.save(saveLibrary2);
               bookEntity.setFkLibraryId(saveLibrary2.getId());
               bookRepository.save(bookEntity);
               return libraryMapper.mapToLibraryResponse(saved);
           }
       }
       throw new RuntimeException("Book id not found");

   }

   //TODO : bu kitab ucun read service numunesidir sadece... bizde library one to one elaqesi ile gedecek
   public List<LibraryReadResponse> readAllSpecificLibrary(LibrarySpecificReadRequest request){

          return libraryMapper.listEntityToListResponse(libraryRepository.findByFkUserId(request.getFkUserId()));
   }



    //TODO : user id gore axtaririq ki db da var mi bele user ya yox..
    //TODO : yoxlamaq lazimdir ki yaradilacaq kitab adina ve user id gore db de var mi?
    // cunki dedik ki bir userin bir kitabi olmalidir

    //TODO: 38 bizim user yarandiqda onun fklari null dusurdu, bizim set prosesimiz burda aktuallasir..

}
