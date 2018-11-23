package com.demo.controller;

import com.demo.VO.ProductInfoVO;
import com.demo.VO.ProductVO;
import com.demo.VO.ResultVO;
import com.demo.dataobject.ProductCategory;
import com.demo.dataobject.ProductInfo;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import com.demo.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *  买家商品
 * Created by 26725 on 2018/11/20.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public ResultVO list() {
        //查询商品分类信息
        List<ProductCategory> categories = categoryService.findAll();
        //查询商品信息
        List<ProductInfo> productInfos = productService.findByProductStatus(0);
        //拼接数据
        ArrayList<ProductVO> productVOs = new ArrayList<>();
        for (ProductCategory category : categories) {
            ProductVO productVO = new ProductVO<>();
            ArrayList<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                    if (category.getCategoryType().equals(productInfo.getCategoryType())){
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo,productInfoVO);
                        productInfoVOS.add(productInfoVO);
                    }
                }
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            productVO.setCategoryFoods(productInfoVOS) ;
            productVOs.add(productVO);
        }
//        ResultVO resultVO = new ResultVO<>();
//        resultVO.setData(productVOs);
        return  ResultVOUtil.success(productVOs);
    }

}
