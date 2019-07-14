package com.junbao.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author 小笨蛋
 */
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(6) + inputPass + salt.charAt(1);
        return md5(str);
    }

    public static String fromPassToDBPass(String fromPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(6) + fromPass + salt.charAt(1);
        return md5(str);
    }

    public static String inputPassToDbPass(String input, String saltDB) {
        String formPass = inputPassFormPass(input);
        String dbPass = fromPassToDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
//        System.out.println(inputPassFormPass("123456"));
//        System.out.println(fromPassToDBPass("123456", "12236544"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
    }

}
