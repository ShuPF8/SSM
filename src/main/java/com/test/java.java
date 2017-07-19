package com.test;



import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.util.*;

/**
 * @Author SPF
 * @Date 2017/5/31
 */
public class java{

    @SuppressWarnings("rawtypes")
    public static HashMap sensitiveWordMap;

    public static void main(String[] args) {
//        String str = UUID.randomUUID().toString();
//        System.out.println(str);
//        String str = DigestUtils.md5Hex("123456");
//        System.out.println(str);
        File file = new File("SSM");
        String path = file.getAbsolutePath();
        System.out.println(path.substring(0, path.lastIndexOf(File.separator)));
    }

}
