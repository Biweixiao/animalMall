package com.bwx.mapper;

import com.bwx.Entity.DO.ProductDO;

import java.util.List;

public interface ProductDOMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductDO record);

    int insertSelective(ProductDO record);

    ProductDO selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(ProductDO record);

    int updateByPrimaryKey(ProductDO record);

    List<ProductDO> selectAllProduct();

    List<ProductDO> selectByUserId(String userId);
}