package com.atguigu.gmall.pms.vo;


import com.atguigu.gmall.pms.entity.ProductCategory;
import lombok.Data;

import java.util.List;

/**
 */
@Data
public class PmsProductCategoryWithChildrenItemVo extends ProductCategory {
    private List<PmsProductCategoryWithChildrenItemVo> children;

}
