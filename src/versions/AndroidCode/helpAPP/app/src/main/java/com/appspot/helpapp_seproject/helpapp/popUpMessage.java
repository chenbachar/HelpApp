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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        HttpPost httpP;
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
                //httpP = new HttpPost("http://ephemeraltech.com/demo/android_tutorial20.php");
                httpP = new HttpPost("http://helpapp-seproject.appspot.com/get_notification");
                httpR = httpC.execute(httpP);
                httpE = httpR.getEntity();
                ins = httpE.getContent();
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
                System.out.println("helpRequest: " + helpRequest+ " 1234");
//              if(helpRequest.equals("\"TUTORIAL 20 WORKED, WE GOT CONNECTION\" "))
                if(helpRequest.equals("true"))
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

            Intent resultIntent = new Intent(this, notificationClick.class);
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
