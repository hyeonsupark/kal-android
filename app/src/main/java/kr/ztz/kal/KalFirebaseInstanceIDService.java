package kr.ztz.kal;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class KalFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "OsqFirebaseIIDService";

    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + token);

        registerServer(token);

    }


    private void registerServer(String token) {

    }
}