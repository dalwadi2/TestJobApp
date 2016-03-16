package in.vaksys.testjobapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Harsh on 16-03-2016.
 */
public class NotificationPublisher extends BroadcastReceiver {

    private static final String TAG = "broadcast";


    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: broadcast created");
        Intent service1 = new Intent(context, ShowNotification.class);
        context.startService(service1);
    }
}