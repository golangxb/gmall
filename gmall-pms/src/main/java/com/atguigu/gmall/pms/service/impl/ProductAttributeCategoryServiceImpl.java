package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.pms.entity.ProductAttributeCategory;
import com.atguigu.gmall.pms.mapper.ProductAttributeCategoryMapper;
import com.atguigu.gmall.pms.service.ProductAttributeCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@Service
@Component
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements ProductAttributeCategoryService {



    @Override
    public Map<String, Object> pageAttributeCategory(Integer pageSize, Integer pageNum) {
        Page<ProductAttributeCategory> categoryPage = new Page<>(pageNum,pageSize);
        IPage<ProductAttributeCategory> productAttributeCategoryIPage = baseMapper.selectPage(categoryPage, null);

        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageSize);
        result.put("totalPage", productAttributeCategoryIPage.getPages());
        result.put("total", productAttributeCategoryIPage.getTotal());
        result.put("pageNum", productAttributeCategoryIPage.getCurrent());
        result.put("list", productAttributeCategoryIPage.getRecords());
        return result;
    }
}
