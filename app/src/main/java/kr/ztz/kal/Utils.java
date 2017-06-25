package kr.ztz.kal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class Utils {
    private static SharedPreferences preferences;

    public static SharedPreferences getPrefs(Context context) {
        if(Utils.preferences == null ){
            Utils.preferences = context.getSharedPreferences("kal_pref", Context.MODE_PRIVATE);
        }
        return Utils.preferences;
    }

    public static String getDeviceUUID(final Context context) {
        SharedPreferences pref = Utils.getPrefs(context);
        String id = pref.getString("uuid", null);

        UUID uuid = null;
        if (id != null) {
            uuid = UUID.fromString(id);
        } else {
            final String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            try {
                if (!"9774d56d682e549c".equals(androidId)) {
                    uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8"));
                } else {
                    final String deviceId = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
                    uuid = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            Bundle bundle = new Bundle();
            bundle.putString("uuid", uuid.toString());
            pref.edit().putString("uuid", uuid.toString()).apply();
        }

        return uuid.toString();
    }
}
