package com.bwx.service;

import com.bwx.Entity.DO.CollectPastureDO;
import com.bwx.Entity.DO.PastureDO;
import com.bwx.Entity.DO.PastureUpDO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 22:56 20/4/17
 */

public interface IPastureService {
    List<PastureDO> selectAll();

    PastureDO selectById(String pastureId);

    List<PastureUpDO> selectUpById(String pastureId);

    CollectPastureDO selectCollectByPUId(String pastureId, String userId);
}
