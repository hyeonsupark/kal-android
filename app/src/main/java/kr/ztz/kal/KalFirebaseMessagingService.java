package kr.ztz.kal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class KalFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "OsqFirebaseMessagingService";

    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> params = remoteMessage.getData();
        String title = params.get("title");
        String message = params.get("body");
        String url = params.get("url");
        sendPushNotification(title, message, url);
    }

    private void sendPushNotification(String title, String message, String url) {
//        Intent intent = new Intent(this, WebviewActivity.class);
//        intent.putExtra("url", url);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher) )
//                .setSmallIcon(R.drawable.ic_noti_small_icon)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri).setLights(000000255,500,2000)
//                .setContentIntent(pendingIntent);


//        Bitmap bitmap = null;
//        try {
//            bitmap = Picasso.with(this).load(OsqPrefs.getString(this,"aprofile"))
//                    .resize(160,160).centerCrop().transform(new CircleTransform()).get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
        PowerManager pm = (PowerManager) KalFirebaseMessagingService.this.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakelock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");
        wakelock.acquire(5000);

    }


}

}