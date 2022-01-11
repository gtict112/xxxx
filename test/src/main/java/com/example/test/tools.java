package com.example.test;

import static com.example.test.gzip.byteToHexString;
import static com.example.test.gzip.unGzip;

import static java.nio.ByteBuffer.allocate;

import com.google.gson.JsonObject;

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
import java.util.Base64;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

import javax.crypto.Cipher;
import javax.crypto.spec.PBEParameterSpec;

public class tools {
    public static void main(String[] args) throws Exception {
//        String tmp = "appPackage=com.opos.ads" +
//                "&appSign=ea754608c75cb9ca3f4753c6de9a639f" +
//                "&appTrusted=false" +
//                "&appUUID=2118C2D93B41451F841465A61168D462" +
//                "&bizApkSize=2430939" +
//                "&bizApkStatus=400" +
//                "&bizApkVersion=1.7.2" +
//                "&bizNo=1000007" +
//                "&bizSystemApk=true" +
//                "&brand=OPPO" +
//                "&calDeviceType=phone" +
//                "&clientApkVersion=1.1.15" +
//                "&deviceType=phone" +
//                "&osVersion=9" +
//                "&otaVersion=R11_11_C.19" +
//                "&ouid=914B143CECFE494D957ECDF1CFF7024Dd7982d2da64471075f457f5e4b7b031c" +
//                "&sign=36fa0c321281c9572e0e77e287faa3c9" +
//                "&timestamp=1640915293226";
        String tmp = "appCode=sdl-client-4&branchName=null&versionName=oppomarket#_2382dev_db12345_2022110.&businessFeature=-1&commitId=db12345&apkInfoList=[{\"apkName\":\"oppomarket#_2382dev_db12345_2022110_1641796145020.apks\",\"apkUrl\":\"http://s3v2.ocs-cn-south.wanyol.com/columbus-file-repo/columbus-repo-202201/oppomarket%23_2382dev_db12345_2022110_1641796145020.apks?AWSAccessKeyId=8TPTcPsER0xGr_3Vwmb5CffcgE2lZqjpqL-IxXuD&Expires=1641909988&Signature=k8Vju5S9NP%2Bn38wjWDN%2BVC0uuCY%3D\",\"apkPackageName\":\"com.oppo.market\",\"apkHash\":\"_715220\",\"apkVersion\":\"2382009dev_dynamicl\",\"publishArea\":null}]";
        System.out.println("orglen:"+tmp.getBytes().length+"bytes"+"--"+tmp.length());
                JsonObject father = new JsonObject();
                father.addProperty("appPackage", "com.opos.ads");
                father.addProperty("appSign", "ea754608c75cb9ca3f4753c6de9a639f");
                father.addProperty("appTrusted", "false");
                father.addProperty("appUUID", "2118C2D93B41451F841465A61168D462");
                father.addProperty("bizApkSize", "2430939");
                father.addProperty("bizApkStatus", "400");
                father.addProperty("bizApkVersion", "1.7.2");
                father.addProperty("bizNo", "1000007");
                father.addProperty("bizSystemApk", "true");
                father.addProperty("brand", "OPPO");
                father.addProperty("calDeviceType", "phone");
                father.addProperty("clientApkVersion", "1.1.15");
                father.addProperty("deviceType", "phone");
                father.addProperty("osVersion", "9");
                father.addProperty("otaVersion", "R11_11_C.19");
                father.addProperty("ouid", "914B143CECFE494D957ECDF1CFF7024Dd7982d2da64471075f457f5e4b7b031c");
                father.addProperty("sign", "36fa0c321281c9572e0e77e287faa3c9");
                father.addProperty("timestamp", "1640915293226");
                System.out.println(father);
                System.out.println(father.toString().length());



        byte[ ] bytes=tmp.getBytes();
        byte[ ] gzipBytes = new byte[0];
        byte[ ] uzipBytes = new byte[0];
        long Time1 = System.currentTimeMillis();
        long Time2 = System.currentTimeMillis();

        for (int i = 0; i < 2000; i++) {
           gzipBytes=gzip.gzip(tmp.getBytes(StandardCharsets.UTF_8));
        }
        Time2 = System.currentTimeMillis();
        System.out.println("jiamitime:"+(Time2 - Time1) + "ms"+"--"+gzipBytes.length);
        System.out.println("333->"+byteToHexString(gzipBytes));
        Time1 = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            uzipBytes=gzip.unGzip(gzipBytes);
        }
        Time2 = System.currentTimeMillis();
        System.out.println("jiemitime:"+(Time2 - Time1) + "ms"+"--"+uzipBytes.length);

        System.out.println("441->"+new String(uzipBytes));

        System.out.println("2>>1111111111111111");
        String msg=Base64.getEncoder().encodeToString(tmp.getBytes());
        System.out.println("1>>"+msg);
        System.out.println(msg.length());

        byte[] byteArr=Base64.getDecoder().decode(msg);
        String msg2=new String(byteArr);
        System.out.println("2>>"+msg2);

        Time1 = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            gzipBytes=gzip.gzip(msg.getBytes(StandardCharsets.UTF_8));
        }
        Time2 = System.currentTimeMillis();
        System.out.println("jiamitime:"+(Time2 - Time1) + "ms"+"--"+gzipBytes.length);


        Time1 = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            uzipBytes=gzip.unGzip(gzipBytes);
        }
        Time2 = System.currentTimeMillis();
        System.out.println("jeyatime:"+(Time2 - Time1) + "ms"+"--"+uzipBytes.length);

        System.out.println("pppp"+(new String(uzipBytes)));
//
        byteArr=Base64.getDecoder().decode(uzipBytes);
        msg2=new String(byteArr);
        System.out.println("22>>"+msg2);





    }

}