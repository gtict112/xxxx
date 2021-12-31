package com.example.test;


import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;



import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class xxxxx {
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception{
        SecretKey secretKey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(data);

        return plainBytes;
    }

    public static byte[] initKey() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        SecretKey secretKey = keyGen.generateKey();
        System.out.println("xxx"+secretKey.getEncoded().length);
        return secretKey.getEncoded();
    }

    /*
     * DES 加密
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }

    public static void jdkPBE(String string) {



            //加密
//            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt,100);
//            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
//            cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
//            byte[] result = cipher.doFinal(string.getBytes());
//
//
//            //解密
//            //初始化
//            cipher.init(Cipher.DECRYPT_MODE, key,pbeParameterSpec);
//            result = cipher.doFinal(result);
//            System.out.println("jdk PBE decrypt: " + new String(result));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static byte[] aesxxx(String string,Key key,Cipher cipher,PBEParameterSpec pbeParameterSpec) {

        byte[] result = new byte[0];
        try {


            cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
            result = cipher.doFinal(string.getBytes());


        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Key init(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
        Key key = factory.generateSecret(pbeKeySpec);
        return key;

    }

    public static Cipher factint() throws NoSuchPaddingException, NoSuchAlgorithmException {

        Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
        return  cipher;
    }

    public  static PBEParameterSpec initParameterSpec()
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = random.generateSeed(8);

        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
        return  pbeParameterSpec;
    }

    public static byte[]  derxxxx(byte[] xxxx,Cipher cipher,PBEParameterSpec pbeParameterSpec,Key key) throws BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
        byte[] result = new byte[0];
        cipher.init(Cipher.DECRYPT_MODE, key,pbeParameterSpec);
        result = cipher.doFinal(xxxx);
        return result;
    }
}
