package com.example.dc.alarmmanagerandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;

public class MyAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);

        mediaPlayer.start();


        Intent i = new Intent(context, AlarmActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
             mediaPlayer.stop();
            }
        }, secondsDelayed * 9000);
    }
}
