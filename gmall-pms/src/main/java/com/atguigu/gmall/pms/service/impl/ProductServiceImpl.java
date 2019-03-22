package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.pms.mapper.ProductMapper;
import com.atguigu.gmall.pms.service.ProductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author lyh
 * @since 2019-03-19
 */
@Service
@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public Map<String, Object> pageProduct(Integer pageSize, Integer pageNum) {
        Page<Product> productPage = new Page<>(pageNum,pageSize);
        IPage<Product> pageInfo = baseMapper.selectPage(productPage, null);

        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageSize);
        result.put("totalPage", pageInfo.getPages());
        result.put("total", pageInfo.getTotal());
        result.put("pageNum", pageInfo.getCurrent());
        result.put("list", pageInfo.getRecords());

        return result;
    }
}
