package de.remk0.nachos;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends WakefulBroadcastReceiver {
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    public void activateAlarm(Context context) {
        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                0, AlarmManager.INTERVAL_HOUR, alarmIntent);

        ComponentName receiver = new ComponentName(context, BootAndReplaceReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    public void deactivateAlarm(Context context) {
        if (alarmManager != null) {
            alarmManager.cancel(alarmIntent);
        }

        ComponentName receiver = new ComponentName(context, BootAndReplaceReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, MonitoringService.class);

        startWakefulService(context, service);
    }
}
