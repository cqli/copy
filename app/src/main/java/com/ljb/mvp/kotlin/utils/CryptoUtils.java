package com.ljb.mvp.kotlin.utils;

import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
    public static final int ALGORIGHM_AES = 1;
    public static final int ALGORIGHM_DES = 0;
    static final String HEXES = "0123456789ABCDEF";
    Cipher cipher = null;
    Cipher decipher = null;
    String key = "TongliforniaJohnson";
    byte[] keyBytes = {74, 111, 104, 110, 115, 111, 110, 77, 97, 74, 105, 70, 97, 110, 103, 74, 101, 114, 118, 105, 115, 76, 105, 117, 76, 105, 117, 83, 104, 97, 111, 90};

    public static byte[] fromHexString(String paramString) {
        int i = paramString.length();
        byte[] arrayOfByte = new byte[i / 2];
        for (int j = 0; j < i; j += 2)
            arrayOfByte[(j / 2)] = (byte) ((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16));
        return arrayOfByte;
    }

    public static String getHex(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null)
            return null;
        StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfByte.length);
        int i = paramArrayOfByte.length;
        for (int j = 0; j < i; j++) {
            int k = paramArrayOfByte[j];
            localStringBuilder.append("0123456789ABCDEF".charAt((k & 0xF0) >> 4)).append("0123456789ABCDEF".charAt(k & 0xF));
        }
        return localStringBuilder.toString();
    }

    public byte[] decrypt(byte[] paramArrayOfByte)
            throws Exception {
        return this.decipher.doFinal(paramArrayOfByte);
    }

    public String decryptBase64String(String paramString)
            throws Exception {
        return new String(decrypt(Base64.decode(paramString, 0)), "UTF-8");
    }

    public byte[] encrypt(String paramString)
            throws Exception {
        byte[] arrayOfByte = paramString.getBytes("UTF-8");
        return this.cipher.doFinal(arrayOfByte);
    }

    public byte[] encrypt(byte[] paramArrayOfByte)
            throws Exception {
        return this.cipher.doFinal(paramArrayOfByte);
    }

    public String encryptBase64String(String paramString)
            throws Exception {
        return new String(Base64.encode(encrypt(paramString), 0));
    }

    public void init(int paramInt) {
        if (paramInt == 0) {
            initDES();
            return;
        }
        initAES();
    }

    public void initAES() {
        try {
            this.cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.keyBytes, "AES");
            this.cipher.init(1, localSecretKeySpec);
            this.decipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            this.decipher.init(2, localSecretKeySpec);
            Log.d("encrypt", "initital for AES");
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void initDES() {
        try {
            this.keyBytes = Arrays.copyOf(MessageDigest.getInstance("md5").digest(this.key.getBytes("utf-8")), 24);
            int i = 16;
            int m;
            for (int j = 0; j < 8; j = m) {
                byte[] arrayOfByte1 = this.keyBytes;
                int k = i + 1;
                byte[] arrayOfByte2 = this.keyBytes;
                m = j + 1;
                arrayOfByte1[i] = arrayOfByte2[j];
                i = k;
            }
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.keyBytes, "DESede");
            IvParameterSpec localIvParameterSpec = new IvParameterSpec(new byte[8]);
            this.cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            this.cipher.init(1, localSecretKeySpec, localIvParameterSpec);
            this.decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            this.decipher.init(2, localSecretKeySpec, localIvParameterSpec);
            Log.d("encrypt", "initital for DES");
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}
