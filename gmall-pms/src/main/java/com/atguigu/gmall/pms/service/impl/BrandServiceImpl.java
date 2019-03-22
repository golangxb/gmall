package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.mapper.BrandMapper;
import com.atguigu.gmall.pms.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@Service
@Component
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Override
    public Map<String, Object> pageBrand(String keyword, Integer pageNum, Integer pageSize) {
        QueryWrapper<Brand> wrapper = null;
        Page<Brand> brandPage = new Page<>(pageNum,pageSize);
        if(!StringUtils.isEmpty(keyword)){
            wrapper = new QueryWrapper<>();
            wrapper.like("name",keyword)
                    .eq("first_letter",keyword);
        }

        baseMapper.selectPage(brandPage,wrapper );

        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageSize);
        result.put("totalPage", brandPage.getPages());
        result.put("total", brandPage.getTotal());
        result.put("pageNum", brandPage.getCurrent());
        result.put("list", brandPage.getRecords());

        return result;
    }
}
