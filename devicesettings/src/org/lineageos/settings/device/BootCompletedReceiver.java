/*
 * Copyright (C) 2018 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.provider.Settings;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

import org.lineageos.settings.device.haptic.HapticUtils;

import androidx.preference.PreferenceManager;
import org.lineageos.settings.device.flashlight.FlashlightUtils;
import org.lineageos.settings.device.kprofiles.KProfilesUtils;
import org.lineageos.settings.device.thermal.ThermalUtils;
import org.lineageos.settings.device.refreshrate.RefreshUtils;
import org.lineageos.settings.device.audioamplification.AudioAmplificationUtils;

import org.lineageos.settings.device.Constants;
import org.lineageos.settings.device.dirac.DiracUtils;
import org.lineageos.settings.device.utils.DisplayUtils;

public class BootCompletedReceiver extends BroadcastReceiver {
    private static final boolean DEBUG = false;
    private static final String TAG = "DeviceSettings";

    @Override
    public void onReceive(final Context context, Intent intent) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        DisplayUtils.setDcDimmingStatus(sharedPreferences.getBoolean(Constants.KEY_DC_DIMMING, false));
        DisplayUtils.updateRefreshRateSettings(context);
        if (DEBUG)
            Log.d(TAG, "Received boot completed intent");
        try {
            DiracUtils.getInstance(context);
        } catch (Exception e) {
            Log.d(TAG, "Dirac is not present in system");
        }
        HapticUtils.restoreLevel(context);
        FlashlightUtils.restoreBrightness(context);
        ThermalUtils.startService(context);
        RefreshUtils.startService(context);
        AudioAmplificationUtils.restoreAudioAmplification(context);
        KProfilesUtils.restoreKProfiles(context);
    }
}
