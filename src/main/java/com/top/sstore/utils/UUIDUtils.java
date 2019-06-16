package com.top.sstore.utils;

import java.util.UUID;
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static Integer getUUIDInOrderid(){
        Integer orderId=UUID.randomUUID().toString().hashCode();
        return orderId;
    }
}
