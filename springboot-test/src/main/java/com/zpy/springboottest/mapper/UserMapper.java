package com.zpy.springboottest.mapper;

import com.zpy.springboottest.model.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(UserDomain record);

    void deleteUserById(@Param("userId") Integer userId);

    void updateUser(UserDomain userDomain);

    List<UserDomain> selectUsers();
}
