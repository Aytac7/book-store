package az.spring.bookstore.mapper;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.request.add.LibraryBookIdAddRequest;
import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.response.create.CreateLibraryResponse;
import az.spring.bookstore.response.read.LibraryReadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface  LibraryMapper {


    LibraryEntity mapToLibraryEntity(CreateLibraryRequest libraryRequest);
    LibraryEntity mapForBookIdLibraryEntity(LibraryBookIdAddRequest libraryBookIdAddRequest);

    CreateLibraryResponse mapToLibraryResponse(LibraryEntity libraryEntity);
    @Mapping(target = "libraryId",source = "id")
    LibraryBookIdAddRequest mapForBookIdLibraryResponse(LibraryEntity libraryEntity);

    //TODO: bizim userId gore axtardigimiz kitablarin mentigine uygun olaraq bunu
    // yaziram normalda danismisiq ki bir userin sadece bir kitabxanasi olsun

    List<LibraryReadResponse>listEntityToListResponse(List<LibraryEntity> libraries);
}


