package com.example.test;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AesEntriptor {
    private Cipher encryptCipher;
    private Cipher decryptCipher;
    public AesEntriptor(String rules) throws Exception {
        // 1.实例化AES算法密钥生成器
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        // 2.根据传入的字节数组,生成一个128位的随机源
        keygen.init(128, new SecureRandom(rules.getBytes()));
        // 3.生成密钥
        SecretKey secretKey = keygen.generateKey();
        // 4.生成Cipher对象,指定其支持AES算法
        encryptCipher = Cipher.getInstance("AES");
        decryptCipher = Cipher.getInstance("AES");
        // 5.初始化加密对象及解密对象
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
    }

    public byte[] encrypt(byte[] source) throws Exception {
        return encryptCipher.doFinal(source);
    }

    public byte[] decrypt(byte[] source) throws Exception {
        return decryptCipher.doFinal(source);
    }
}
