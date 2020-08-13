package com.bwx.mapper;

import com.bwx.Entity.DO.UserDO;

public interface UserDOMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO selectByTel(String userTel);

    UserDO selectByOpenId(String openId);
}