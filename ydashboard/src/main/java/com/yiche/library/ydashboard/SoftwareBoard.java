package com.yiche.library.ydashboard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by kenneth on 2016/10/11.
 */

public final class SoftwareBoard {

  private Context context;
  private final TelephonyManager telephonyManager;

  public SoftwareBoard(Context context) {
    this.context = context;
    telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
  }

  public String getAndroidID() {
    return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
  }

  public String getInstallerPackageName() {
    return context.getPackageManager().getInstallerPackageName(context.getPackageName());
  }

  public String getLanguage() {
    return Locale.getDefault().getLanguage();
  }

  public int getVersionCode() {
    int versionCode = 0;
    try {
      versionCode =
          context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    }
    return versionCode;
  }

  public String getVersionName() {
    String versionName = null;
    try {
      versionName =
          context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    }
    return versionName;
  }

  public String getBuildHost() {
    return Build.HOST;
  }

  public String getBuildTags() {
    return Build.TAGS;
  }

  public String getBuildUser() {
    return Build.USER;
  }

  public long getBuildTime() {
    return Build.TIME;
  }

  public String getBuildRelease() {
    return Build.VERSION.RELEASE;
  }

  public String getBuildCodeName() {
    return Build.VERSION.CODENAME;
  }

  public String getBuildIncremental() {
    return Build.VERSION.INCREMENTAL;
  }

  public int getBuildSDKInt() {
    return Build.VERSION.SDK_INT;
  }

  public boolean isRooted() {
    String su = "su";
    String[] locations = {
        "/sbin/", "/system/bin/", "/system/xbin/", "/system/sd/xbin/", "/system/bin/failsafe/",
        "/data/local/xbin/", "/data/local/bin/", "/data/local/"
    };
    for (String location : locations) {
      if (new File(location + su).exists()) {
        return true;
      }
    }
    return false;
  }

  public int getOrientation() {
    return context.getResources().getConfiguration().orientation;
  }

  public long getTime() {
    return System.currentTimeMillis();
  }

  public String getFormatTime() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    return format.format(getTime());
  }

  public String getFormatChineseTime() {
    SimpleDateFormat format =
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
    return format.format(getTime());
  }

  public long getUpTime() {
    return SystemClock.uptimeMillis();
  }
}
