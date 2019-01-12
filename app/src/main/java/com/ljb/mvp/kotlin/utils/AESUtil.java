package com.ljb.mvp.kotlin.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;


public class AESUtil {
    private static AESUtil instance    = null;
    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    //private String         sKey        = "ab1defghij123451"; //key，可自行修改
    private static String  sKey        = "TongliforniaJohnson";
    private static String  ivParameter = "0123456789ABCDEF"; //偏移量,可自行修改

    private AESUtil() {

    }

    public static AESUtil getInstance() {
        if (instance == null)
            instance = new AESUtil();
        return instance;
    }

    public static String encrypt(String encData, String secretKey, String vector) throws Exception {

        if (secretKey == null) {
            return null;
        }
        if (secretKey.length() != 16) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = secretKey.getBytes();
        byte[] keyBytes = { 74, 111, 104, 110, 115, 111, 110, 77, 97, 74, 105, 70, 97, 110, 103, 74, 101, 114, 118, 105, 115, 76, 105, 117, 76, 105, 117, 83, 104, 97, 111, 90 };
        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(encData.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
    }

    public static String encodeBytes(byte[] bytes) {
        StringBuffer strBuf = new StringBuffer();

        for (int i = 0; i < bytes.length; i++) {
            strBuf.append((char) (((bytes[i] >> 4) & 0xF) + ((int) 'a')));
            strBuf.append((char) (((bytes[i]) & 0xF) + ((int) 'a')));
        }

        return strBuf.toString();
    }

    public static void main(String[] args) throws Exception {
        // 需要加密的字串
        String cSrc = "{" + "\"_id\": \"7441_8888_20181125\"," + "\"comment\": 0,"
                      + "\"commentCount\": 0," + "\"c\": 0," + "\"praise\": 0," + "\"share\": 0,"
                      + "\"day\": 20181125" + "}";

        // 加密
        long lStart = System.currentTimeMillis();
        //        String enString = AESUtil.getInstance().encrypt(cSrc);
        //        System.out.println("加密后的字串是：" + enString);
        //        System.out.println("加密后的字串长度是：" + enString.length());
        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();
        String ene = "FGJG22TxVflFOq7nqBBniZDBOHoB/Z+UTssCHFw32cTK/Xhg84Ek70sNl41I20xY55QPiRo1ee45MoQlz91m8vohvGPyDTHxW+RyRsRccpCHnzak5IH6zoJh0LQpG+ssOQh17ckZoaJnoXQmQBre8sr0jub7uo6DlA/AOoWkooQLOSQXriyL4pcPds68RUflSmOyngxllG3+zNERVY/Ru2L8kQwQicKSctigeBSq9zLfWBPu+/gQ9lt385Sa+jGY";
        String DeString = AESUtil.getInstance().decrypt(ene);
        System.out.println("解密后的字串是：" + DeString);
        String enString = AESUtil.getInstance().encrypt(DeString);
        System.out.println("加密后的字串是：" + enString);
        System.out.println("加密后的字串长度是：" + enString.length());
        String DeString1 = AESUtil.getInstance().decrypt(enString);
        System.out.println("解密后的字串是：" + DeString1);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }

    // 加密
    public static String encrypt(String sSrc) throws Exception {
        //        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //        byte[] raw = sKey.getBytes();
        //        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        //        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        //        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        //return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
        return encrypt(sSrc, sKey, ivParameter);
    }

    // 解密
    public static String decrypt(String sSrc) {
        //            byte[] raw = sKey.getBytes("ASCII");
        //            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
        //            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        //            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
        //            byte[] original = cipher.doFinal(encrypted1);
        //            String originalString = new String(original, "utf-8");
        return decrypt(sSrc, sKey, ivParameter);
    }

    public static String decrypt(String sSrc, String key, String ivs) {
        try {
            byte[] raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivs.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
}
