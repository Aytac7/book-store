package az.spring.bookstore.mapper;

import az.spring.bookstore.entity.BookEntity;
import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateBookResponse;
import az.spring.bookstore.response.create.CreateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserEntity mapToUserEntity(CreateUserRequest userRequest);

    CreateUserResponse mapToUserResponse(UserEntity userEntity);
    List<CreateUserResponse> mapToListResponse(List<UserEntity> userEntityList);

}
