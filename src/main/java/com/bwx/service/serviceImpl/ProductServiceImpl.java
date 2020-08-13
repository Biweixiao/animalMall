package com.bwx.service.serviceImpl;

import com.bwx.Entity.DO.CollectDO;
import com.bwx.Entity.DO.OrderInfoDO;
import com.bwx.Entity.DO.ProductDO;
import com.bwx.Entity.DO.ProductUpDO;
import com.bwx.mapper.CollectDOMapper;
import com.bwx.mapper.OrderInfoDOMapper;
import com.bwx.mapper.ProductDOMapper;
import com.bwx.mapper.ProductUpDOMapper;
import com.bwx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 14:44 20/4/15
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDOMapper productDOMapper;
    @Autowired
    private CollectDOMapper collectDOMapper;
    @Autowired
    private ProductUpDOMapper productUpDOMapper;
    @Autowired
    private OrderInfoDOMapper orderDOMapper;

    @Override
    public List<ProductDO> selectAllProduct() {
        return productDOMapper.selectAllProduct();
    }

    @Override
    public ProductDO selectById(String productId) {
        return productDOMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<CollectDO> selectCollectByPId(String productId) {
        return collectDOMapper.selectCollectByPId(productId);
    }

    @Override
    public List<ProductUpDO> selectUpById(String productId) {
        return productUpDOMapper.selectByProductId(productId);
    }

    @Override
    public void setCollectToFalse(String productId, String userId) {
        collectDOMapper.setCollectToFalse(productId, userId);
    }

    @Override
    public void setCollectToTrue(CollectDO collectDO) {
        collectDOMapper.setCollectToTrue(collectDO);
    }

    @Override
    public CollectDO selectCollectByPUId(String productId, String userId) {
        return collectDOMapper.selectCollectByPUId(productId, userId);
    }

    @Override
    public void deleteByPId(String productId) {
        productDOMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public List<ProductDO> selectByUserId(String userId) {
        return productDOMapper.selectByUserId(userId);
    }

    @Override
    public void insertProduct(ProductDO productDO) {
        productDOMapper.insert(productDO);
    }

    @Override
    public void update(ProductDO productDO) {
        productDOMapper.updateByPrimaryKey(productDO);
    }

    @Override
    public List<OrderInfoDO> selectOrderBy(String userId) {
        return orderDOMapper.selectOrderBy(userId);
    }

    @Override
    public List<OrderInfoDO> selectOrderSell(String userId) {
        return orderDOMapper.selectOrderSell(userId);
    }

    @Override
    public OrderInfoDO selectOrder(String userId, String productId) {
        return orderDOMapper.selectByPrimaryKey(Integer.parseInt(productId));
    }

    @Override
    public void updateOrder(OrderInfoDO orderInfoDO) {
        orderDOMapper.updateByPrimaryKey(orderInfoDO);
    }

    @Override
    public void setOrder(OrderInfoDO orderInfoDO) {
        orderDOMapper.insert(orderInfoDO);
    }

    @Override
    public OrderInfoDO selectUserOrder(String userId, String productId) {
        return orderDOMapper.selectUserOrder(userId, productId);
    }


}
