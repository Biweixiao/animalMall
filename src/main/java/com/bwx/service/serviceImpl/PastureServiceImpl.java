package com.bwx.service.serviceImpl;

import com.bwx.Entity.DO.CollectPastureDO;
import com.bwx.Entity.DO.PastureDO;
import com.bwx.Entity.DO.PastureUpDO;
import com.bwx.mapper.CollectPastureDOMapper;
import com.bwx.mapper.PastureDOMapper;
import com.bwx.mapper.PastureUpDOMapper;
import com.bwx.mapper.ProductUpDOMapper;
import com.bwx.service.IPastureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 22:56 20/4/17
 */
@Service
public class PastureServiceImpl implements IPastureService {
    @Autowired
    private PastureDOMapper pastureDOMapper;
    @Autowired
    private PastureUpDOMapper pastureUpDOMapper;
    @Autowired
    private CollectPastureDOMapper collectPastureDOMapper;

    @Override
    public List<PastureDO> selectAll() {
        return pastureDOMapper.selectAll();
    }

    @Override
    public PastureDO selectById(String pastureId) {
        return pastureDOMapper.selectById(pastureId);
    }

    @Override
    public List<PastureUpDO> selectUpById(String pastureId) {
        return pastureUpDOMapper.selectUpById(pastureId);
    }

    @Override
    public CollectPastureDO selectCollectByPUId(String pastureId, String userId) {
        return collectPastureDOMapper.selectCollectByPUId(pastureId, userId);
    }
}
