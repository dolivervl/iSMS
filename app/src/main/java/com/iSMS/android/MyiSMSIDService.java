package com.iSMS.android;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by diego on 06/02/17.
 */

public class MyiSMSIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseInsIDService";

    @Override
    public void onTokenRefresh() {
        // Pega Token atualizado
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "New Token: " + refreshedToken);

        // O token pode ser salvo em outro servidor ou serviço para fazer outras coisas
        //sendRegistrationToServer(refreshedToken);
        // ADICIONAR AO TOPICO
        //FirebaseMessaging.getInstance().subscribeToTopic("todos");

    }
}
