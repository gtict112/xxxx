package com.example.test;

import org.anarres.lzo.LzoAlgorithm;
import org.anarres.lzo.LzoCompressor;
import org.anarres.lzo.LzoDecompressor;
import org.anarres.lzo.LzoInputStream;
import org.anarres.lzo.LzoLibrary;
import org.anarres.lzo.LzoOutputStream;
import org.xerial.snappy.Snappy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

import javax.crypto.Cipher;
import javax.crypto.spec.PBEParameterSpec;

public class tools {
    public static void main(String[] args) throws Exception {
        String tmp = "appPackage=com.opos.ads&appSign=ea754608c75cb9ca3f4753c6de9a639f" +
                "&appTrusted=false&appUUID=2118C2D93B41451F841465A61168D462&bizApkSize=2" +
                "430939&bizApkStatus=400&bizApkVersion=1.7.2&bizNo=1000007&bizSystemApk=" +
                "true&brand=OPPO&calDeviceType=phone&clientApkVersion=1.1.15&deviceType=pho" +
                "ne&osVersion=9&otaVersion=R11_11_C.19&ouid=914B143CECFE494D957ECDF1CFF7024Dd7982d2" +
                "da64471075f457f5e4b7b031c&sign=36fa0c321281c9572e0e77" +
                "e287faa3c9&timestamp=1640915293226";
//        System.out.println("orglen:"+tmp.getBytes().length+"bytes"+"--"+tmp.length());
//        byte[] desKey = xxxxx.initKey();
//        System.out.println("DES KEY : "+new String(desKey,"UTF-8"));
//        byte[] desResult = new byte[0];
//        byte[] desPlain = new byte[0];
//        long startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            desResult = xxxxx.encrypt(tmp.getBytes() , desKey);
//        }
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//        System.out.println(">>>des lenth>>>"+desResult.length) ;
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            desPlain = xxxxx.decrypt(desResult, desKey);
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//        System.out.println(">>>jiemiDES >>>" + new String(desPlain));
//        /////////////////////////////////////PBE
//        startTime1 = System.currentTimeMillis();
//        Cipher xx = xxxxx.factint();
//        PBEParameterSpec yy =xxxxx.initParameterSpec();
//        Key key = xxxxx.init("xxxx");
//        for (int i = 0; i < 2000; i++) {
//
//            desResult= xxxxx.aesxxx(tmp,key,xx,yy);
//        }
//        System.out.println("PBE decrypt: " + " " + desResult.length);
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//
//           desPlain= xxxxx.derxxxx(desResult ,xx,yy,key);
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("2222222: " + new String(desPlain));
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        AesEntriptor aesEntriptor = new AesEntriptor("123456");
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//
//            desResult = aesEntriptor.encrypt(tmp.getBytes());
//        }
//        System.out.println("aes decrypt: " + " " + desResult.length);
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//
//            desPlain = aesEntriptor.decrypt(desResult);
//        }
//        System.out.println("2222222: " + new String(desPlain));
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");


//
        byte[] by =  tmp.getBytes(StandardCharsets.UTF_8);
        byte[] compressed = new byte[0];
        byte[] uncompressed = new byte[0];
        String result = null;
        System.out.println("orglen:"+by.length+"bytes"+"--"+tmp.length());
        long startTime1 = System.currentTimeMillis();  //Snappy
//        for (int i = 0; i < 2000; i++) {
//            compressed = Snappy.compress(by);
//        }
        long endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+compressed.length+"bytes");
//
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//        startTime1 = System.currentTimeMillis();
//        for (int i= 0 ;i<2000;i++)
//        {
//            try {
//                uncompressed = Snappy.uncompress(compressed);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sninnpyjieya:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        try {
//            result = new String(uncompressed, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);
//
//
//        ////////////////////////////////////////////////Lzo
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            try {
//                compressed = lzcompress(by);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+compressed.length+"bytes");
//
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        startTime1 = System.currentTimeMillis();
//        for (int i= 0 ;i<2000;i++)
//        {
//            try {
//                uncompressed = lzuncompress(compressed);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("lz0jieya:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        try {
//            result = new String(uncompressed, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);

//------------------------------------------------------------------3333 DEFLATE
        startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            compressed = constxx.compress(by);
        }
        endTime1 = System.currentTimeMillis();
        System.out.println("len:"+compressed.length+"bytes");
        System.out.println("sum:" + 2000 + ",jiamitime:"+(endTime1 - startTime1) + "ms");
        startTime1 = System.currentTimeMillis();
        for (int i= 0 ;i<200000;i++)
        {
            uncompressed = constxx.uncompress(compressed,i);
//            result = new String(uncompressed, "UTF-8");
//            System.out.println(result);
        }
        endTime1 = System.currentTimeMillis();
        System.out.println("defjieya:" + 2000 + ",jieyatime:"+(endTime1 - startTime1) + "ms");

        try {
            result = new String(uncompressed, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        //------------------------------------------------------------------444 lz4
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            compressed = constxx.lz4compress(by);
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+compressed.length+"bytes");
//
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//
//
//        startTime1 = System.currentTimeMillis();
//        for (int i= 0 ;i<2000;i++)
//        {
//            uncompressed = constxx.lz4uncompress(compressed);
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("lz4jieya:" + 2000 + ",time:"+(endTime1 - startTime1) + "ms");
//
//        try {
//            result = new String(uncompressed, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);

    }

    public static byte[] lzcompress(byte srcBytes[]) throws IOException {
        LzoCompressor compressor = LzoLibrary.getInstance().newCompressor(
                LzoAlgorithm.LZO1X, null);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        LzoOutputStream cs = new LzoOutputStream(os, compressor);
        cs.write(srcBytes);
        System.out.println("xxxxx");
        cs.close();

        return os.toByteArray();
    }


    public static byte[] lzuncompress(byte[] bytes) throws IOException {
        LzoDecompressor decompressor = LzoLibrary.getInstance()
                .newDecompressor(LzoAlgorithm.LZO1X, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        LzoInputStream us = new LzoInputStream(is, decompressor);
        int count;
        byte[] buffer = new byte[2048];
        while ((count = us.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        return baos.toByteArray();
    }


    public static byte[] hexToByteArray(String inHex){
        byte[] result =  inHex.getBytes();
        return result;
    }


}