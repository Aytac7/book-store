package az.spring.bookstore.mapper;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.request.create.CreateBookRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    BookEntity mapToBookEntity(CreateBookRequest bookRequest);
    CreateBookResponse mapToBookResponse(BookEntity bookEntity);

    void mapForUpdate( @MappingTarget BookEntity bookEntity ,CreateBookRequest bookRequest );

    List<CreateBookResponse> mapToListResponse(List<BookEntity> bookEntityList);

}
