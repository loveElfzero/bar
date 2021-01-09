package com.mtp.bar.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Classname UUIDUtil
 * @Description TODO
 * @Date 2019/9/28 18:30
 * @Created by yuan jing
 */
public class UUIDUtil {


    public static String  getRandom(){

        return UUID.randomUUID().toString().replaceAll("-","");


    }


    public static String  getOrderNumberInfo(){
        /**
        * @Description: 得到20位唯一订单号
        * @Param: [userId]
        * @return: java.lang.String
        * @Author: YuanJing
        * @Date: 2019/11/4
        */
        int twoRandom = ThreadLocalRandom.current().ints(10, 99).distinct().limit(1).findFirst().getAsInt();
        int fourRandom = ThreadLocalRandom.current().ints(1000, 9999).distinct().limit(1).findFirst().getAsInt();

        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        return date+twoRandom+seconds+fourRandom;
    }

}
