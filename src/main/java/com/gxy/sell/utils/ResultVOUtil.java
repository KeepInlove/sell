package com.gxy.sell.utils;

import com.gxy.sell.vo.ResultVO;

/**
 * @author GUO
 * @Classname ResultVOUtil
 * @Description TODO
 * @Date 2020/9/20 23:53
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMsg("获取数据成功");
        return  resultVO;
    }
    public static ResultVO success(){
        return  success(null);
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
