package com.iSMS.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;


/**
 * Created by diego on 06/02/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyiSMSMensageService";

    //private RemoteMessage remoteMessage;


    //private TextView shtitulo;
    //private TextView shcorpo;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        //Log.d(TAG, "FROM:" + remoteMessage.getFrom());

        //Verificar se a msg tem dados
        if (remoteMessage.getData().size() > 0) {
            //Log.d(TAG, "Message data: " + remoteMessage.getData());
            Log.d(TAG, "Message Titulo:" + remoteMessage.getData().get("title"));
            Log.d(TAG, "Message Texto:" + remoteMessage.getData().get("text"));
            //Log.d(TAG, "Message Texto2:" + remoteMessage.getData().get("text2"));
            //sendNotification(remoteMessage.getData().get("title"), remoteMessage.getData().get("text"));
            //Lendo.sendTela(remoteMessage.getData().get("title"), remoteMessage.getData().get("text"));
            String title = remoteMessage.getData().get("title");
            String message = remoteMessage.getData().get("text");
            String click_action = remoteMessage.getData().get("click_action");
            String message2 = remoteMessage.getData().get("NoClas");
            String message3 = remoteMessage.getData().get("Info");
            String message4 = remoteMessage.getData().get("Warn");
            String message5 = remoteMessage.getData().get("Aver");
            String message6 = remoteMessage.getData().get("High");
            String message7 = remoteMessage.getData().get("Disas");

            Log.d(TAG, title);
            Log.d(TAG, message);
            Log.d(TAG, message2);
            Intent intent = new Intent(this, Lendo.class);
            intent.putExtra("TITULO", title);
            intent.putExtra("MESSAGE", message);
            intent.putExtra("MESSAGE2", message2);
            intent.putExtra("MESSAGE3", message3);
            intent.putExtra("MESSAGE4", message4);
            intent.putExtra("MESSAGE5", message5);
            intent.putExtra("MESSAGE6", message6);
            intent.putExtra("MESSAGE7", message7);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0/*Request Code*/, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setSound(notificationSound);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0 /*ID da notificacao */, notifiBuilder.build()
            );
            Log.d(TAG, "MENSAGEM TITULO :" + intent.getStringExtra(title));
            Log.d(TAG, "MENSAGEM CORPO :" + intent.getStringExtra(message));
            // Log.d(TAG, "MENSAGEM CORPO2 :" + intent.getStringExtra(message2));

        }


        //Verificar se msg tem notificacao e titulo
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message body:" + remoteMessage.getNotification().getBody());
            Log.d(TAG, "Message Titulo:" + remoteMessage.getNotification().getTitle());
            String title = remoteMessage.getNotification().getTitle();
            String message = remoteMessage.getNotification().getBody();
            String click_action = remoteMessage.getNotification().getClickAction();

            Log.d(TAG, title);
            Log.d(TAG, message);
            Intent intent = new Intent(this, Lendo.class);
            intent.putExtra("TITULO", title);
            intent.putExtra("MESSAGE", message);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0/*Request Code*/, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setSound(notificationSound);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0 /*ID da notificacao */, notifiBuilder.build()
            );
            Log.d(TAG, "NOTIFICATION TITULO :" + intent.getStringExtra(title));
            Log.d(TAG, "NOTIFICATION CORPO :" + intent.getStringExtra(message));
        }



        /*

        //Verificar se msg tem rotulo
   //     if (remoteMessage.getMessageType() != null) {
     //       Log.d(TAG, "Message Type:" + remoteMessage.getMessageType().getBytes());
            //sendNotification(remoteMessage.getNotification().getBody());

       // }

        //Verificar se msg tem titulo
       /* if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Titulo:" + remoteMessage.getNotification().getTitle());
            sendNotification(null,remoteMessage.getNotification().getTitle());
        }*/


    }


    //intend.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

    //PendingIntent intent = PendingIntent.getActivity(this, 0, new Intent(this,Lendo.class));


    //Colocar som de notificacao


    //.setSubText()
    //;


    // notifiBuilder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, Lendo.class), PendingIntent.FLAG_UPDATE_CURRENT));

    //String titulo = title;
    //String corpo = body;


}