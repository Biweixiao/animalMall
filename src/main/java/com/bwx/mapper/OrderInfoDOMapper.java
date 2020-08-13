package com.bwx.mapper;

import com.bwx.Entity.DO.OrderInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfoDO record);

    int insertSelective(OrderInfoDO record);

    OrderInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfoDO record);

    int updateByPrimaryKey(OrderInfoDO record);

    List<OrderInfoDO> selectOrderBy(String bid);

    List<OrderInfoDO> selectOrderSell(String sid);

    OrderInfoDO selectUserOrder(@Param("userId") String userId, @Param("productId") String productId);
}