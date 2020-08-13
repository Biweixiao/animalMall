package com.bwx.service;

import com.bwx.Entity.DO.CollectDO;
import com.bwx.Entity.DO.OrderInfoDO;
import com.bwx.Entity.DO.ProductDO;
import com.bwx.Entity.DO.ProductUpDO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 14:43 20/4/15
 */

public interface IProductService {
    List<ProductDO> selectAllProduct();

    ProductDO selectById(String productId);

    List<CollectDO> selectCollectByPId(String productId);

    List<ProductUpDO> selectUpById(String productId);

    void setCollectToFalse(String productId, String userId);

    void setCollectToTrue(CollectDO collectDO);

    CollectDO selectCollectByPUId(String productId, String userId);

    void deleteByPId(String productId);

    List<ProductDO> selectByUserId(String userId);

    void insertProduct(ProductDO productDO);

    void update(ProductDO productDO);


    List<OrderInfoDO> selectOrderBy(String userId);

    List<OrderInfoDO> selectOrderSell(String userId);

    OrderInfoDO selectOrder(String userId, String productId);

    void updateOrder(OrderInfoDO orderInfoDO);

    void setOrder(OrderInfoDO orderInfoDO);

    OrderInfoDO selectUserOrder(String userId, String productId);
}
