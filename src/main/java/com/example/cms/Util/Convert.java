package com.example.cms.Util;

/**
 * @ClassName Convert
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-04 22:33
 * @Version 1.0
 */
public class Convert {

    private Convert(){}

    /**
    *  @Description: 将string类型转化为int数组
    *  @Param [roleId]
    *  @Return java.lang.Integer[]
    */
    public static Integer[] toIntRoleArray(String s) {
       String [] StrArr = s.split(",");
        Integer [] IntArr = new Integer[StrArr.length];
        for(int i = 0;i < StrArr.length;i++){
            IntArr[i] = Integer.valueOf(StrArr[i]);
            System.out.println(IntArr[i]);
        }
        return IntArr;
    }
}

