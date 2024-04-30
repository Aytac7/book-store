package az.spring.bookstore.mapper;

import az.spring.bookstore.entity.UserEntity;
import az.spring.bookstore.request.create.CreateUserRequest;
import az.spring.bookstore.response.create.CreateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserEntity mapToUserEntity(CreateUserRequest userRequest);

    CreateUserResponse mapToUserResponse(UserEntity userEntity);
    List<CreateUserResponse> mapToListResponse(List<UserEntity> userEntityList);

    void  mapForUpdate(@MappingTarget UserEntity userEntity,CreateUserRequest userRequest);

}
