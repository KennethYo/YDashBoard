package com.yiche.library.ydashboard;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by kenneth on 2016/10/11.
 */

public final class HardwareBoard {

  private TelephonyManager telephonyManager;
  private Context context;

  public HardwareBoard(Context context) {
    this.context = context;
    telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
  }

  public String getDeviceId() {
    return telephonyManager.getDeviceId();
  }

  public String getSimSerialNumber() {
    return telephonyManager.getSimSerialNumber();
  }

  public String getSerial() {
    return Build.SERIAL;
  }

  public String getManufacture() {
    return Build.MANUFACTURER;
  }

  public String getModel() {
    return Build.MODEL;
  }

  public String getBrand() {
    return Build.BRAND;
  }

  public boolean hasSDCard() {
    return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
  }

  public boolean isEmulator() {
    boolean isGenyMotion = Build.MANUFACTURER.contains("Genymotion")
        || Build.PRODUCT.contains("vbox86p")
        || Build.DEVICE.contains("vbox86p")
        || Build.HARDWARE.contains("vbox86");
    boolean isGenericEmulator = Build.BRAND.contains("generic")
        || Build.DEVICE.contains("generic")
        || Build.PRODUCT.contains("sdk")
        || Build.HARDWARE.contains("goldfish");

    return isGenericEmulator || isGenyMotion;
  }

  public String getABIS() {
    String abis = null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      String[] supportedAbis = Build.SUPPORTED_ABIS;
      if (supportedAbis != null && supportedAbis.length > 0) {
        abis = TextUtils.join(",", supportedAbis);
      }
    } else {
      abis = Build.CPU_ABI;
    }
    return abis;
  }

  public String getSupport32BitABIS() {
    String abis = null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      abis = TextUtils.join(",", Build.SUPPORTED_32_BIT_ABIS);
    }
    return abis;
  }

  public String getSupport64BitABIS() {
    String abis = null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      abis = TextUtils.join(",", Build.SUPPORTED_64_BIT_ABIS);
    }
    return abis;
  }

  public boolean isWifiEnable() {
    WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    return wifiManager != null && wifiManager.isWifiEnabled();
  }

  public final boolean isNetworkAvailable() {
    ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext()
        .getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    return netInfo != null && netInfo.isConnected();
  }

  public final String getIPv4Address() {
    String result = null;
    try {
      List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
      for (NetworkInterface intf : interfaces) {
        List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
        for (InetAddress addr : addrs) {
          if (!addr.isLoopbackAddress()) {
            String sAddr = addr.getHostAddress().toUpperCase();
            boolean isIPv4 = addr instanceof Inet4Address;
            if (isIPv4) {
              result = sAddr;
            }
          }
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    }
    return result;
  }

  public final String getIPv6Address() {
    String result = null;
    try {
      List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
      for (NetworkInterface intf : interfaces) {
        List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
        for (InetAddress addr : addrs) {
          if (!addr.isLoopbackAddress()) {
            String sAddr = addr.getHostAddress().toUpperCase();
            boolean isIPv4 = addr instanceof Inet4Address;
            if (!isIPv4) {
              int delim = sAddr.indexOf('%'); // drop ip6 port suffix
              result = delim < 0 ? sAddr : sAddr.substring(0, delim);
            }
          }
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    }
    return result;
  }

  public final String getNetworkType() {
    String result = "unknown";
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (activeNetwork == null) {
      result = "unknown";
    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
        || activeNetwork.getType() == ConnectivityManager.TYPE_WIMAX) {
      result = "wifi";
    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
      if (telephonyManager != null
          && telephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY) {
        switch (telephonyManager.getNetworkType()) {
          case TelephonyManager.NETWORK_TYPE_UNKNOWN:
            result = "unknown";
            break;
          case TelephonyManager.NETWORK_TYPE_EDGE:
          case TelephonyManager.NETWORK_TYPE_GPRS:
          case TelephonyManager.NETWORK_TYPE_CDMA:
          case TelephonyManager.NETWORK_TYPE_IDEN:
          case TelephonyManager.NETWORK_TYPE_1xRTT:
            result = "2G";
            break;
          case TelephonyManager.NETWORK_TYPE_UMTS:
          case TelephonyManager.NETWORK_TYPE_HSDPA:
          case TelephonyManager.NETWORK_TYPE_HSPA:
          case TelephonyManager.NETWORK_TYPE_HSPAP:
          case TelephonyManager.NETWORK_TYPE_HSUPA:
          case TelephonyManager.NETWORK_TYPE_EVDO_0:
          case TelephonyManager.NETWORK_TYPE_EVDO_A:
          case TelephonyManager.NETWORK_TYPE_EVDO_B:
            result = "3G";
            break;
          case TelephonyManager.NETWORK_TYPE_LTE:
            result = "4G";
            break;
          default:
            result = "unknown";
            break;
        }
      }
    }
    return result;
  }

  public final String getCarrier() {
    String result = null;
    if (telephonyManager != null
        && telephonyManager.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) {
      result = telephonyManager.getNetworkOperatorName().toLowerCase(Locale.getDefault());
    }
    return result;
  }
}
