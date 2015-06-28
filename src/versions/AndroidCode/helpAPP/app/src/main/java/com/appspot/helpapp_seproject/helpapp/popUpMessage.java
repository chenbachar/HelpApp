package com.appspot.helpapp_seproject.helpapp;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
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
        HttpGet httpP;
        HttpResponse httpR;
        HttpEntity httpE;
        boolean ntfFlag = false;

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
                httpC = new DefaultHttpClient();
//                httpP = new HttpPost("http://ephemeraltech.com/demo/android_tutorial20.php");
                httpP = new HttpGet("http://helpapp-seproject.appspot.com/get_notification");
                httpR = httpC.execute(httpP);
                httpE = httpR.getEntity();
                ins = httpE.getContent();



                // Create a local instance of cookie store
                CookieStore cookieStore = (CookieStore) new BasicCookieStore();

                // Create local HTTP context
                HttpContext localContext = new BasicHttpContext();
                // Bind custom cookie store to the local context
                localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

                HttpGet httpget = new HttpGet("http://www.google.com/", localContext);



                List<Cookie> cookies = ((AbstractHttpClient) httpC).cookieStore().getCookies();
                //List<Cookie> cookies = httpC.getCookieStore().getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }

                HttpPost httpost = new HttpPost("https://portal.sun.com/amserver/UI/Login?" +
                        "org=self_registered_users&" +
                        "goto=/portal/dt&" +
                        "gotoOnFail=/portal/dt?error=true");
            }
            catch (Exception e)
            {
                Log.e("log", "ERROR cant connect to the server: " + e.toString());
            }

            try //convert httpR to string
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(ins, "iso-8859-1"));
//                StringBuilder sb =new StringBuilder();
//                String line = null;
//                while((line = reader.readLine()) != null)
//                    sb.append(line + "\n");
//                String helpRequest = sb.toString();
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

        String intentData = intent.getDataString();



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
