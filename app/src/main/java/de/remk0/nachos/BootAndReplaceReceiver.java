/**
 * Nachos
 * Copyright (C) 2015 Remko Plantenga
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.remk0.nachos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootAndReplaceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmReceiver alarm = new AlarmReceiver();

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED") ||
                intent.getAction().equals("android.intent.action.ACTION_PACKAGE_REPLACED")) {
            alarm.activateAlarm(context);
        }
    }
}
