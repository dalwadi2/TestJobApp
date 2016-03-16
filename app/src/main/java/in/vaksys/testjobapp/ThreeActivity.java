package in.vaksys.testjobapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThreeActivity extends AppCompatActivity {

    private static final String TAG = "harsh";
    String mystring = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        mystring = getIntent().getExtras().getString("hello");
        Log.e(TAG, "onCreate: " + mystring);
        if (mystring.equalsIgnoreCase("hellllooooooooo")) {
            stopService(new Intent(ThreeActivity.this, ShowNotification.class));
            Intent notificationIntent = new Intent(this, NotificationPublisher.class);
            PendingIntent contentIntent = PendingIntent.getBroadcast(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                    + 10000, contentIntent);
        }
    }
}
