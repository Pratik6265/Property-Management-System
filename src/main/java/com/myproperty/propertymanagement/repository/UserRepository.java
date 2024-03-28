package com.myproperty.propertymanagement.repository;
import com.myproperty.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {


}
