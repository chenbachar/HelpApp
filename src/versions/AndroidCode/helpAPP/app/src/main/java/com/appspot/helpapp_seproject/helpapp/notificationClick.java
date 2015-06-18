package com.appspot.helpapp_seproject.helpapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class notificationClick extends Activity
{
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        System.out.println("on create get in 12345");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://helpapp-seproject.appspot.com/connect");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        System.out.println("on intent get in 12345");
        Intent i = new Intent(this, popUpMessage.class);
        i.setData(Uri.parse("http://helpapp-seproject.appspot.com/"));
        startService(i);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
