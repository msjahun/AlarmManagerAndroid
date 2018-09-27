package com.example.dc.alarmmanagerandroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
public TimePicker timePickerAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        timePickerAlarm = (TimePicker) findViewById(R.id.timePickerAlerm);

            findViewById(R.id.setAlermbtn).setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View view) {


                    Calendar calendar = Calendar.getInstance();
                    if(Build.VERSION.SDK_INT >23){
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePickerAlarm.getHour(),
                            timePickerAlarm.getMinute(),
                            0

                    );

                  }else{
                        calendar.set(
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH),
                                timePickerAlarm.getCurrentHour(),
                                timePickerAlarm.getCurrentMinute(),
                                0

                        );
                    }
setAlarm(calendar.getTimeInMillis());



                }
            });

    }

    private void setAlarm(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, MyAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);


        Toast.makeText(this, "Alarm set", Toast.LENGTH_SHORT).show();
    }
}
