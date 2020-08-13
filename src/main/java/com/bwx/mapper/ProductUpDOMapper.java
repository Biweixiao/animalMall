package com.bwx.mapper;

import com.bwx.Entity.DO.ProductUpDO;

import java.util.List;

public interface ProductUpDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductUpDO record);

    int insertSelective(ProductUpDO record);

    ProductUpDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductUpDO record);

    int updateByPrimaryKey(ProductUpDO record);

    List<ProductUpDO> selectByProductId(String productId);
}