package com.appspot.helpapp_seproject.helpapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity
{
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String host = "https://accounts.google.com/ServiceLogin?service=ah&passive=true&continue=https%3A%2F%2Fappengine.google.com%2F_ah%2Fconflogin%3Fcontinue%3Dhttp%3A%2F%2Fhelpapp-seproject.appspot.com%2Fvolunteer&ltmpl=gm&shdf=Ch0LEgZhaG5hbWUaEWhlbHBhcHAtc2Vwcm9qZWN0DBICYWgiFEK4pWOvEQU3Mj5EzWNEwt5VZdp_KAEyFHuf-cjnHl2y_M40zx1JNHNe6da-";
        String realm = "helpApp";
        //in case of notification entry
        String urlStr = "http://helpapp-seproject.appspot.com/";
        Intent intent = getIntent();
        String userDirect = intent.getStringExtra("afterNtf");//going to direction "helpapp/.../connect"
        if(!(userDirect == null))
          urlStr = urlStr + userDirect;

        //open the website
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(urlStr);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());


        String[] result = instance.getHttpAuthUsernamePassword(host, realm);


        //open the background thread
        Intent i = new Intent(this, popUpMessage.class);
        System.out.println(urlStr + " 1234");
        i.setData(Uri.parse(urlStr));
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
