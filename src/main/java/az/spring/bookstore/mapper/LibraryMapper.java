package az.spring.bookstore.mapper;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.response.create.CreateLibraryResponse;
import az.spring.bookstore.response.read.LibraryReadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface  LibraryMapper {


    LibraryEntity mapToLibraryEntity(CreateLibraryRequest libraryRequest);

    CreateLibraryResponse mapToLibraryResponse(LibraryEntity libraryEntity);

    //TODO: bizim userId gore axtardigimiz kitablarin mentigine uygun olaraq bunu
    // yaziram normalda danismisiq ki bir userin sadece bir kitabxanasi olsun

    List<LibraryReadResponse>listEntityToListResponse(List<LibraryEntity> libraries);
}


