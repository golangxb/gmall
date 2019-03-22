package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.pms.mapper.ProductCategoryMapper;
import com.atguigu.gmall.pms.service.ProductCategoryService;
import com.atguigu.gmall.pms.vo.PmsProductCategoryWithChildrenItemVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@Service
@Component
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Override
    public List<PmsProductCategoryWithChildrenItemVo> selectAllList() {

        List<PmsProductCategoryWithChildrenItemVo> list = baseMapper.listChildren();

        return list;
    }


    //    @Override
//    public List<PmsProductCategoryWithChildrenItemVo> selectAllList() {
//        //创建返回的List
//        List<PmsProductCategoryWithChildrenItemVo> pmsProductCategoryWithChildrenItems = new ArrayList<>();
//
//        //获取一级分类，创建条件
//        QueryWrapper<ProductCategory> productCategoryQueryWrapper = new QueryWrapper<>();
//        productCategoryQueryWrapper.eq("parent_id",0);
//        //查询出一级分类
//        List<ProductCategory> list = baseMapper.selectList(productCategoryQueryWrapper);
//        //获取二级分类，创建条件
//        QueryWrapper<ProductCategory> productCategoryQueryWrapper1 = new QueryWrapper<>();
//        productCategoryQueryWrapper.ne("parent_id",0);
//        //查询出二级分类
//        List<ProductCategory> list2 = baseMapper.selectList(productCategoryQueryWrapper1);
//
//        //获取一级分类的长度，用来遍历
//        int size = list.size();
//        //获取一级分类的长度，用来遍历
//        int size2 = list2.size();
//        for (int i = 0; i < size; i++) {
//            //获取父类的信息
//            ProductCategory productCategory = list.get(i);
//            //创建子类
//            PmsProductCategoryWithChildrenItemVo pmsProductCategoryWithChildrenItemVomsProductCategoryWithChildrenItemVo = new PmsProductCategoryWithChildrenItemVo();
//            //把数据复制到子类
//            BeanUtils.copyProperties(productCategory,pmsProductCategoryWithChildrenItemVomsProductCategoryWithChildrenItemVo);
//            //获取父类的ID,根据父类ID查询
//            Long pid = pmsProductCategoryWithChildrenItemVomsProductCategoryWithChildrenItemVo.getId();
//            for (int i1 = 0; i1 < size2; i1++) {
//                QueryWrapper<ProductCategory> productCategoryQueryWrapper2 = new QueryWrapper<>();
//                productCategoryQueryWrapper.ne("id",pid);
//                List<ProductCategory> list3 = baseMapper.selectList(productCategoryQueryWrapper2);
//                pmsProductCategoryWithChildrenItemVomsProductCategoryWithChildrenItemVo.setChildren(list3);
//
//            }
//
//            pmsProductCategoryWithChildrenItems.add(pmsProductCategoryWithChildrenItemVomsProductCategoryWithChildrenItemVo);
//
//          }
//
//
//
//        return pmsProductCategoryWithChildrenItems;
//    }


//    @Override
//    public List<PmsProductCategoryWithChildrenItem> selectAllList() {
//        //创建返回的List
//        List<PmsProductCategoryWithChildrenItem> pmsProductCategoryWithChildrenItems = new ArrayList<>();
//
//        //获取一级分类，创建条件
//        QueryWrapper<ProductCategory> productCategoryQueryWrapper = new QueryWrapper<>();
//        productCategoryQueryWrapper.eq("parent_id",0);
//        //查询出一级分类
//        List<ProductCategory> list = baseMapper.selectList(productCategoryQueryWrapper);
//        //获取二级分类，创建条件
//        QueryWrapper<ProductCategory> productCategoryQueryWrapper1 = new QueryWrapper<>();
//        productCategoryQueryWrapper.ne("parent_id",0);
//        //查询出二级分类
//        List<ProductCategory> list2 = baseMapper.selectList(productCategoryQueryWrapper);
//
//        //获取一级分类的长度，用来遍历
//        int size = list.size();
//        //获取一级分类的长度，用来遍历
//        int size2 = list2.size();
//        for (int i = 0; i < size; i++) {
//            //获取父类的信息
//            ProductCategory productCategory = list.get(i);
//            //创建子类
//            PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenItem = new PmsProductCategoryWithChildrenItem();
//            //把数据复制到子类
//            BeanUtils.copyProperties(productCategory,pmsProductCategoryWithChildrenItem);
//            //获取父类的ID,根据父类ID查询
//            Long pid = pmsProductCategoryWithChildrenItem.getId();
//            for (int i1 = 0; i1 < size2; i1++) {
//                QueryWrapper<ProductCategory> productCategoryQueryWrapper2 = new QueryWrapper<>();
//                productCategoryQueryWrapper.ne("id",pid);
//                List<ProductCategory> list3 = baseMapper.selectList(productCategoryQueryWrapper2);
//                pmsProductCategoryWithChildrenItem.setChildren(list3);
//
//            }
//
//            pmsProductCategoryWithChildrenItems.add(pmsProductCategoryWithChildrenItem);
//
//
//
//          }
//
//
//
//        return pmsProductCategoryWithChildrenItems;
//    }

//    @Override
//    public List<PmsProductCategoryWithChildrenItem> selectAllList() {
//        List<PmsProductCategoryWithChildrenItem> a = new ArrayList<>();
//
//        //创建PmsProductCategoryWithChildrenItem
//        PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenItem = new PmsProductCategoryWithChildrenItem();
//        //查出一级分类的商品
//        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("parent_id",0);
//        List<ProductCategory> list = baseMapper.selectList(queryWrapper);
//
//        //遍历一级，查出一级分类下是否有子分类
//        for (ProductCategory productCategory : list) {
//            BeanUtils.copyProperties(productCategory,pmsProductCategoryWithChildrenItem);
//            Long id = pmsProductCategoryWithChildrenItem.getId();
//            //遍历查询的条件
//            QueryWrapper<ProductCategory> queryWrapper1 = new QueryWrapper<>();
//            queryWrapper1.eq("parent_id",id);
//            ProductCategory productCategory1 = baseMapper.selectOne(queryWrapper1);
//
//            //创建添加一级分分类的List
//            List<ProductCategory> list1 = new ArrayList<>();
//            //判断是否为空,如果不为空，添加进List
//            if(null!=productCategory1){
//
//                list1.add(productCategory1);
//            }
//
//            pmsProductCategoryWithChildrenItem.setChildren(list1);
//        }
//
//
//        return a;
//    }
}
