package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.to.PmsProductParam;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;
import java.util.Map;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
public interface ProductService extends IService<Product> {

    Map<String,Object> pageProduct(Integer pageSize, Integer pageNum);

    /**
     * 给数据库商品保存信息
     * @param productParam
     */
    void create(@Valid PmsProductParam productParam);
}
