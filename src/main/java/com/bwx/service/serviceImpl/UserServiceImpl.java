package com.bwx.service.serviceImpl;

import com.bwx.Entity.DO.CollectDO;
import com.bwx.Entity.DO.UserDO;
import com.bwx.mapper.CollectDOMapper;
import com.bwx.mapper.UserDOMapper;
import com.bwx.service.IFileService;
import com.bwx.service.IUserService;
import com.bwx.utils.FTPUtil;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author:Biweixiao
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private CollectDOMapper collectDOMapper;


    @Override
    public List<CollectDO> selectCollect(String userId) {
        return collectDOMapper.selectByUserId(userId);
    }

    @Override
    public UserDO selectById(String userId) {
        return userDOMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserDO selectByOpenId(String openId) {
        return userDOMapper.selectByOpenId(openId);
    }
}
