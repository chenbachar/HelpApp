package com.appspot.helpapp_seproject.helpapp;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.cookie.Cookie;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieStore;
import java.util.List;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;



public class popUpMessage extends IntentService
{
    public popUpMessage()
    {
        super("popUpMessage1");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        InputStream ins = null;
        HttpClient httpC;
        HttpGet httpG;
        HttpResponse httpR;
        HttpEntity httpE;
        boolean ntfFlag = false;

        String email = intent.getStringExtra("email");
        System.out.println("popUpMessage: " + email + " 1234");


        while(!ntfFlag)
        {
            try
            {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try//connect to the server
            {
                //send cookies
                httpC = new DefaultHttpClient();
                System.out.println("before get: " + email + " 1234");
                httpG = new HttpGet("http://helpapp-seproject.appspot.com/get_notification?user="+email);
                httpR = httpC.execute(httpG);//maybe throw ClientProtocolException and IOException thrown.
                httpE = httpR.getEntity();
                ins = httpE.getContent();
                System.out.println("response: " + httpR + "1234");

                //get information if there's a notification to send
            }
            catch (Exception e)
            {
                Log.e("log", "ERROR cant connect to the server: " + e.toString());
            }

            try //convert httpR to string
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(ins, "iso-8859-1"));

                String helpRequest = reader.readLine();
                ins.close();
                System.out.println("helpRequest:" + helpRequest+ "1234");
//                if(helpRequest.contains("\"TUTORIAL 20 WORKED, WE GOT CONNECTION\" "))
                if(helpRequest.contains("True"))
                    ntfFlag = true;
            }
            catch (Exception e)
            {
                Log.e("log", "ERROR cant convert the response: " + e.toString());
            }
        }

//        String intentData = intent.getDataString();

        if (intent != null)
        {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle("HelpApp")
                    .setContentText("You got a new notification");




            Intent resultIntent = new Intent(this, MainActivity.class);
            resultIntent.putExtra("afterNtf", "connect");
// Because clicking the notification opens a new ("special") activity, there's
// no need to create an artificial back stack.
            PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);

            // Sets an ID for the notification
            int mNotificationId = 001;
// Gets an instance of the NotificationManager service
            NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

           
// Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());

        }
    }
}
