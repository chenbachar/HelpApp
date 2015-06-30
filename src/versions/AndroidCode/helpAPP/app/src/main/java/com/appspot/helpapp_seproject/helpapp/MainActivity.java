package com.appspot.helpapp_seproject.helpapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity
{
    private WebView myWebView;
    private String urlStr;
    InputStream ins = null;
    String e = null;

    public class WebAppInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            mContext = c;

        }
        @JavascriptInterface
        public void showToast(String eml) {
            if(eml.contains("@")) {
                int idx = eml.indexOf(" ");
                e = eml.substring(0, idx);
            }
        }
    }

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //in case of notification entry
        urlStr = "http://helpapp-seproject.appspot.com/";

        Intent intent = getIntent();
        String userDirect = intent.getStringExtra("afterNtf");//going to direction "helpapp/.../connect"
        if(!(userDirect == null))
            urlStr = urlStr + userDirect;



        //open the website
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(urlStr);
    }

    @Override
    public void onPause() {
        super.onPause();
        //open the background thread

        Intent i = new Intent(this, popUpMessage.class);
        i.putExtra("email",e);
        System.out.println("on pause: " + e + " 1234");
//        System.out.println(urlStr + " 1234");
//        i.setData(Uri.parse(urlStr));
        startService(i);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
