package com.vogella.android.exercise04;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class notificationAlert_fragment extends android.app.Fragment {
    int timeValue = 0;

    class MyTimerTask extends TimerTask {
         public void run() {
             generateNotification(getContext());
         }
    }

    private void generateNotification(Context context) {
        int icon = R.drawable.ic_stat_small_kitten_meowing;
        long when = System.currentTimeMillis();
        String appname = context.getResources().getString(R.string.app_name);
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        int currentapiVersion = Build.VERSION.SDK_INT;
        Notification notification;
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, notificationAlert_fragment.class), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        notification = builder.setContentIntent(contentIntent)
                .setSmallIcon(icon).setTicker(appname).setWhen(0).setAutoCancel(true)
                .setContentText("YOU ARE AWESOME").build();
        notificationManager.notify((int) when, notification);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification_alert_fragment, container, false);
        NumberPicker np = (NumberPicker) view.findViewById(R.id.numberpicker);
        np.setMinValue(0);
        np.setMaxValue(10);
        np.setValue(0);
        np.setWrapSelectorWheel(true);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                timeValue = newVal;
            }
        });
        Button go_button = (Button) view.findViewById(R.id.go_button);
        go_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(timeValue == 0) {
                    Toast.makeText(getContext(), "please pick a valid number of minutes!", Toast.LENGTH_SHORT).show();
                }
                else {
                    MyTimerTask notification_task = new MyTimerTask();
                    Timer timer = new Timer();
                    timer.schedule(notification_task, timeValue * 60000, timeValue * 60000);
                }
            }
        });
        return view;
    }
}