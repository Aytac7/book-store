package az.spring.bookstore.mapper;
import az.spring.bookstore.entity.LibraryEntity;
import az.spring.bookstore.request.create.CreateLibraryRequest;
import az.spring.bookstore.response.create.CreateLibraryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LibraryMapper {

    LibraryEntity mapToLibraryEntity(CreateLibraryRequest libraryRequest);
    CreateLibraryResponse mapToLibraryResponse(LibraryEntity libraryEntity);
}


