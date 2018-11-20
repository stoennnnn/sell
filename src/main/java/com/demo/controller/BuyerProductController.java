package com.demo.controller;

import com.demo.VO.ProductInfoVO;
import com.demo.VO.ProductVO;
import com.demo.VO.ResultVO;
import com.demo.dataobject.ProductInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  买家商品
 * Created by 26725 on 2018/11/20.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @GetMapping("/list")
    public ResultVO list() {
        ProductInfoVO productInfoVO = new ProductInfoVO();
        ProductVO productVO = new ProductVO<>();
        ResultVO resultVO = new ResultVO<>();
        productVO.setCategoryFoods(productInfoVO);
        resultVO.setMsg("成功");
        resultVO.setCode("0");
        resultVO.setData(productVO);
        return resultVO;
    }

}
