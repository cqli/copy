package com.ljb.mvp.kotlin.utils;

import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.util.logging.Logger;

public class MD5Utils {
    public static String MD5(String paramString) {
        char[] arrayOfChar1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        try {
            byte[] arrayOfByte1 = paramString.getBytes();
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(arrayOfByte1);
            byte[] arrayOfByte2 = localMessageDigest.digest();
            char[] arrayOfChar2 = new char[2 * arrayOfByte2.length];
            int i = arrayOfByte2.length;
            int j = 0;
            int k = 0;
            while (j < i) {
                int m = arrayOfByte2[j];
                int n = k + 1;
                arrayOfChar2[k] = arrayOfChar1[(0xF & m >>> 4)];
                k = n + 1;
                arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
                j++;
            }
            String str = new String(arrayOfChar2);
            return str;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String code = "/LcKInJyqJBlki7eo3GGozt+qxPUF+njGCEMhYNItSifKgVYUyyvLtKelONDBveDp1ZqUAD6OJv9Mtv+BVy7CEpKJgPtUH+OCIzwlPGsOq3Pj63u+4W2GsDm982+EGNs+yUZteeQ2CDxVx0wjozhbnZyQKU5uyMEWAyUJMiku2HoCfxwLwu8z5gzTF011VvG0mwbIPCGj6ocC4xJTeve8QVS5lVdDRIJNTRJvAWBGxQF8XX5dHCmWos7J7VrWjuC";
        String s = MD5("");
//        Log.e("lcq", s);
        byte[] bytes = CryptoUtils.fromHexString(code);
        System.out.print(new String(bytes));

    }

}
