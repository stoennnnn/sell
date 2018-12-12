package com.demo.utils;

import com.demo.VO.ResultVO;

/**
 * Created by 26725 on 2018/11/21.
 */
public class ResutVOUtil {
    public  static ResultVO success(){
        return  success();
    }
    /**
     * 查询成功
     * @param data
     * @return
     */
    public  static ResultVO success(Object data){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return  resultVO;
    }
    /**
     * 查询失败
     * @return
     */
    public  static  ResultVO failed(Integer code,String msg){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
