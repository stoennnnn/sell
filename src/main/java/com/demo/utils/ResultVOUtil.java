package com.demo.utils;

import com.demo.VO.ResultVO;

/**
 * Created by 张启磊 on 2018-11-21.
 */
public class ResultVOUtil {
        public static ResultVO success(Object object) {
            ResultVO resultVO = new ResultVO();
            resultVO.setData(object);
            resultVO.setCode(0);
            resultVO.setMsg("成功");
            return resultVO;
        }

        public static ResultVO success() {
            return success(null);
        }

        public static ResultVO error(Integer code, String msg) {
            ResultVO resultVO = new ResultVO();
            resultVO.setCode(code);
            resultVO.setMsg(msg);
            return resultVO;
        }

}
