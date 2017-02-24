package com.iSMS.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;

public class Lendo extends Activity {
    private static final String TAG = "Lendo";

    //Criando telas
    //private TextView shtitulo;
    // private TextView shcorpo;

    TextView shtitulo = null;
    TextView shcorpo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Bundle extras = getIntent().getExtras();
        String titulo1 = extras.getString("TITULO");
        Log.d(TAG, "SAIDA TITULO 1: " + titulo1);
        String corpo1 = extras.getString("MESSAGE");
        Log.d(TAG, "SAIDA MENSAGEM 1: " + corpo1);

        //Bundle extras2 = getIntent().getExtras();
        //Toast.makeText(this,"SAIDA TITULO 1: ", Toast.LENGTH_LONG).show();
        // Log.d(TAG,  "SAIDA EXTRAS: " + extras);

        if (extras != null) {
            //Toast.makeText(this,"SAIDA TITULO 2: ", Toast.LENGTH_LONG).show();

            //if (extras.containsKey("TITULO")) { //&& extras.containsKey("MESSAGE")) {

            setContentView(R.layout.activity_lendo);
            String titulo = extras.getString("TITULO");
            Log.d(TAG, "SAIDA TITULO : " + titulo);
            String corpo = extras.getString("MESSAGE");
            Log.d(TAG, "SAIDA MENSAGEM : " + corpo);

            shtitulo = (TextView) findViewById(R.id.titleid);
            shcorpo = (TextView) findViewById(R.id.bodyid);

            shtitulo.setText(titulo);
            shcorpo.setText(corpo);

            Log.d(TAG, "SAIDA TITULO 2: " + titulo);
            Log.d(TAG, "SAIDA CORPO 2: " + corpo);

            //Toast.makeText(this,"SAIDA TITULO 3: ", Toast.LENGTH_LONG).show();
            //}

        }


    }


    //public static void sendTela(String xbody, String xtitle) {
    // MyFirebaseMessagingService titulo = new MyFirebaseMessagingService().sendNotification();


    //MyFirebaseMessagingService shtitulo = new MyFirebaseMessagingService(title);

    // Iniciando telas

        /*shcorpo = (TextView) findViewById(R.id.bodyid);

        String titulo = shtitulo.getText().toString().trim();
        String corpo = shcorpo.getText().toString().trim();*/

    //shtitulo = (TextView) findViewById(R.id.tituloid);

    //  String titulo = xtitle.toString().trim();
    //String corpo = xbody.toString().trim();

    //shtitulo  = (TextView)


    //  if (body != null){
    //     System.out.print(corpo);
    // }


    //}


//from.setOnClickListener(this);


}