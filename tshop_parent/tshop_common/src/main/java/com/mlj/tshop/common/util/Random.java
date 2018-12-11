package com.mlj.tshop.common.util;

/**
 * 2018/12/11：随机数工具类
 *
 * @author mlj
 */
public class Random {

    /**
     * create a user id
     * the method has problem,create same as same random
     * @return a randomness user id ,and it's length equals 16
     */
    public static long getLong(int length){
        Long id = null;

        while ((id = new Double(Math.random() * Math.pow(10, length)).longValue()).toString().length() != length);

        return id;
    }
}
