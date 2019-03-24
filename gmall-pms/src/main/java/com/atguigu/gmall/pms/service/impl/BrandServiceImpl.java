package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.mapper.BrandMapper;
import com.atguigu.gmall.pms.service.BrandService;
import com.atguigu.gmall.to.PmsBrandParam;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Brand> listAll() {
        List<Brand> brands = baseMapper.selectList(null);

        return brands;
    }

    @Override
    public void addBrand(PmsBrandParam pmsBrand) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(pmsBrand,brand);
        baseMapper.insert(brand);

    }

    @Override
    public Brand updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        Brand brand1 = baseMapper.selectById(id);

        Brand brand = new Brand();
        BeanUtils.copyProperties(pmsBrandParam,brand);
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        int update = baseMapper.update(brand,wrapper);
        return brand1;
    }

    @Override
    public void deleteBrand(Long id) {
        baseMapper.deleteById(id);
    }
}
