package com.example.testtoken;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.netease.mobsec.xs.NECallback;
import com.netease.mobsec.xs.NTESCSConfig;
import com.netease.mobsec.xs.NTESCSDevice;
import com.netease.mobsec.xs.network.Result;

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
import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity {
    Button tokenbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tmp = "1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1x" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx" +
                "xx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx1xxx";
        byte[] by =  tmp.getBytes(StandardCharsets.UTF_8);
        long startTime1 = System.currentTimeMillis();
        byte[] afterBytes = null;
        byte[] gzipafterBytes = null;
//        for (int i = 0; i < 2000; i++) {
//            try {
//                afterBytes = lzcompress(by);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        long endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+afterBytes.length+"bytes");
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");
//        startTime1 = System.currentTimeMillis();
//        try {
//            System.out.println((new String(lzuncompress(afterBytes),"utf-8"))+"<>"+tmp.length());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            afterBytes = constxx.compress11(by);
////            System.out.println(Arrays.toString(afterBytes));
//        }
//
//        endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+afterBytes.length+"bytes");
//
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");
//        startTime1 = System.currentTimeMillis();
//        try {
//            System.out.println((new String(constxx.uncompress11(afterBytes),"utf-8"))+"<>"+tmp.length());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (DataFormatException e) {
//            e.printStackTrace();
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");

        //********************************************************************//
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            try {
//                afterBytes = constxx.lz4compress(by);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+afterBytes.length+"bytes");
//
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");
//
//        startTime1 = System.currentTimeMillis();
//        try {
//            System.out.println((new String(constxx.lz4uncompress(afterBytes),"utf-8"))+"<>"+tmp.length());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");

        //********************************************************************//
//        startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 2000; i++) {
//            try {
//                afterBytes = constxx.snappycompress(by);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            System.out.println(Arrays.toString(afterBytes));
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("len:"+afterBytes.length+"bytes");
//
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");
//
//        startTime1 = System.currentTimeMillis();
//        try {
//            System.out.println((new String(constxx.snappyuncompress(afterBytes),"utf-8"))+"<>"+tmp.length());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        endTime1 = System.currentTimeMillis();
//        System.out.println("sum:" + 2000 + ",time:"+(endTime1 - startTime1)
//                + "ms");


//        System.out.println((new String(uncompress(afterBytes),"utf-8")).length()+"<>"+tmp.length());


//        tokenbutton =findViewById(R.id.button);
//
//        if (getPackageName().equals(getCurProcessName(this))) {
//            Context mContext = getApplicationContext();
//            NTESCSConfig config = new NTESCSConfig();
//            config.setUrl("http://test-sec-device-id.wanyol.com/v1/ad/d");
//            boolean is = NTESCSDevice.get().init(this, "0166508e76d14462a8f31314ae36d450", "oppo", config);
//            Log.d("xxxx", " xxxxxxxxxxxx:" + config.getUrl() + " " + is);
//        }

//        WebView browser=(WebView)findViewById(R.id.c131_webkit);
//        WebSettings settings = browser .getSettings();
//        settings.setJavaScriptEnabled(true);// 让WebView能够执行javaScript
//        settings.setDomStorageEnabled(true);
//        settings.setJavaScriptCanOpenWindowsAutomatically(true);// 让JavaScript可以自动打开windows
//        settings.setAppCacheEnabled(true);      // 设置缓存
//        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式,一共有四种模式
//        settings.setSupportZoom(true);// 支持缩放(适配到当前屏幕)
//        settings.setUseWideViewPort(true);      // 将图片调整到合适的大小
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 支持内容重新布局,一共有四种方式 默认的是NARROW_COLUMNS
//        settings.setDisplayZoomControls(true);   // 设置可以被显示的屏幕控制
//        settings.setDefaultFontSize(12);   // 设置默认字体大小
//
//        browser.loadUrl("http://rc114.com");


        //实现：WebView里的链接，都在自身打开，不调用系统浏览器
//        browser.setWebViewClient(new WebViewClient() {
//                                     @Override
//                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                                         view.loadUrl(url);
//                                         return true;
//                                     }
//                                 });
//
//        browser.setOnKeyListener(new View.OnKeyListener() {
//                                     @Override
//                                     public boolean onKey(View v, int keyCode, KeyEvent event) {
//                                         if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                                             if (keyCode == KeyEvent.KEYCODE_BACK && browser.canGoBack()) {
//                                                 browser.goBack();
//                                                 return true;
//                                             }
//                                         }
//                                         return false;
//                                     }
//                                 });



//        tokenbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NTESCSDevice.get().getToken(new NECallback() {
//                    @Override
//                    public void onResult(Result result) {
//                        final int code = result.getCode();
//                        String token = result.getToken();
//                        Log.e("xxxx", ""+code+ " "+token);
//                    }
//                });
//            }
//    });
    }


    public static byte[] lzcompress(byte srcBytes[]) throws IOException {
        LzoCompressor compressor = LzoLibrary.getInstance().newCompressor(
                LzoAlgorithm.LZO1X, null);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        LzoOutputStream cs = new LzoOutputStream(os, compressor);
        cs.write(srcBytes);
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




        String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}