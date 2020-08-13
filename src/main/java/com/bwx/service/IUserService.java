package com.bwx.service;

import com.bwx.Entity.DO.BannerDO;
import com.bwx.Entity.DO.CollectDO;
import com.bwx.Entity.DO.UserDO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 17:31 20/4/14
 */

public interface IUserService {


    List<CollectDO> selectCollect(String userId);

    UserDO selectById(String userId);

    UserDO selectByOpenId(String openId);
}
