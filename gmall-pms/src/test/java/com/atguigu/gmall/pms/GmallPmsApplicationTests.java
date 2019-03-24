package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.mapper.ProductCategoryMapper;
import com.atguigu.gmall.pms.vo.PmsProductCategoryWithChildrenItemVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Test
    public void contextLoads() {

        List<PmsProductCategoryWithChildrenItemVo> pmsProductCategoryWithChildrenItemVos = productCategoryMapper.listChildren(0);
        System.out.println(pmsProductCategoryWithChildrenItemVos);

    }

}
