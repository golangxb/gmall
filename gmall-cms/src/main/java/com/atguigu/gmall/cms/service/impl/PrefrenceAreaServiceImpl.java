package com.atguigu.gmall.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.cms.entity.PrefrenceArea;
import com.atguigu.gmall.cms.mapper.PrefrenceAreaMapper;
import com.atguigu.gmall.cms.service.PrefrenceAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 优选专区 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@Component
@Service
public class PrefrenceAreaServiceImpl extends ServiceImpl<PrefrenceAreaMapper, PrefrenceArea> implements PrefrenceAreaService {

    @Override
    public List<PrefrenceArea> getAllList() {

        List<PrefrenceArea> prefrenceAreas = baseMapper.selectList(null);

        return prefrenceAreas;
    }
}
