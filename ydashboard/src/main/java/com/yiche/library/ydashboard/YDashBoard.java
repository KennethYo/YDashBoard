package com.yiche.library.ydashboard;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;

/**
 * Created by kenneth on 2016/10/11.
 */

public final class YDashBoard {

  private static SoftwareBoard softwareBoard;
  private static HardwareBoard hardwareBoard;
  private static PermissionBoard permissionBoard;

  public static void init(Application app) {
    softwareBoard = new SoftwareBoard(app.getApplicationContext());
    hardwareBoard = new HardwareBoard(app.getApplicationContext());
    permissionBoard = new PermissionBoard(app.getApplicationContext());
  }

  public static int getVersionCode() {
    return softwareBoard.getVersionCode();
  }

  public static String getVersionName() {
    return softwareBoard.getVersionName();
  }

  public static String getAndroidID() {
    return softwareBoard.getAndroidID();
  }

  /**
   * 安装应用的市场
   */
  public static String getInstallerPackageName() {
    return softwareBoard.getInstallerPackageName();
  }

  public static String getLanguage() {
    return softwareBoard.getLanguage();
  }

  /**
   * release-keys 或测试的 test-keys
   */
  public static String getBuildTags() {
    return softwareBoard.getBuildTags();
  }

  /**
   * 时间
   */
  public static long getBuildTime() {
    return softwareBoard.getBuildTime();
  }

  public static String getBuildHost() {
    return softwareBoard.getBuildHost();
  }

  public static String getBuildUser() {
    return softwareBoard.getBuildUser();
  }

  /**
   * Android version name
   */
  public static String getBuildRelease() {
    return softwareBoard.getBuildRelease();
  }

  /**
   * 开发代号
   */
  public static String getBuildCodeName() {
    return softwareBoard.getBuildCodeName();
  }

  /**
   * 系统源代码 git id
   */
  public static String getBuildIncremental() {
    return softwareBoard.getBuildIncremental();
  }

  /**
   * 系统 api code
   */
  public static int getBuildSDKInt() {
    return softwareBoard.getBuildSDKInt();
  }

  /**
   * 是否 ROOT
   */
  public static boolean isRooted() {
    return softwareBoard.isRooted();
  }

  /**
   * {@link Configuration#ORIENTATION_LANDSCAPE} =2, {@link Configuration#ORIENTATION_PORTRAIT} =1.
   */
  public static int getOrientation() {
    return softwareBoard.getOrientation();
  }

  /**
   * 时间戳
   */
  public static long getTime() {
    return softwareBoard.getTime();
  }

  /**
   * 格式化时间
   */
  public static String getFormatTime() {
    return softwareBoard.getFormatTime();
  }

  /**
   * 格式化中国时间
   */
  public static String getFormatChineseTime() {
    return softwareBoard.getFormatChineseTime();
  }

  /**
   * 开机时间
   */
  public static long getUpTime() {
    return softwareBoard.getUpTime();
  }

  public static String getDeviceId() {
    return hardwareBoard.getDeviceId();
  }

  public static String getSerial() {
    return hardwareBoard.getSerial();
  }

  public static String getSimSerialNumber() {
    return hardwareBoard.getSimSerialNumber();
  }

  /**
   * 设备制造厂
   */
  public static String getManufacture() {
    return hardwareBoard.getManufacture();
  }

  /**
   * 设备型号
   */
  public static String getModel() {
    return hardwareBoard.getModel();
  }

  /**
   * 品牌商
   */
  public static String getBrand() {
    return hardwareBoard.getBrand();
  }

  /**
   * 是否挂载了 SD 卡
   */
  public static boolean hasSDCard() {
    return hardwareBoard.hasSDCard();
  }

  /**
   * 是否是虚拟机
   */
  public static boolean isEmulator() {
    return hardwareBoard.isEmulator();
  }

  /**
   * 获得ABI
   */
  public static String getABIS() {
    return hardwareBoard.getABIS();
  }

  /**
   * 获得32ABI
   */
  public static String getSupport32BitABIS() {
    return hardwareBoard.getSupport32BitABIS();
  }

  /**
   * 获得64ABI
   */
  public static String getSupport64BitABIS() {
    return hardwareBoard.getSupport64BitABIS();
  }

  public static boolean isNetworkAvailable() {
    return hardwareBoard.isNetworkAvailable();
  }

  public static boolean isWifiEnable() {
    return hardwareBoard.isWifiEnable();
  }

  public static String getIPv4Address() {
    return hardwareBoard.getIPv4Address();
  }

  public static String getIPv6Address() {
    return hardwareBoard.getIPv6Address();
  }

  /**
   * 上网类型
   */
  public static String getNetworkType() {
    return hardwareBoard.getNetworkType();
  }

  /**
   * 获取运营商
   */
  public static String getCarrier() {
    return hardwareBoard.getCarrier();
  }

  public static boolean hasWriteContacts() {
    return permissionBoard.hasWriteContacts();
  }

  public static boolean hasGetAccounts() {
    return permissionBoard.hasGetAccounts();
  }

  public static boolean hasReadContacts() {
    return permissionBoard.hasReadContacts();
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public static boolean hasCallLog() {
    return permissionBoard.hasCallLog();
  }

  public static boolean hasReadPhoneState() {
    return permissionBoard.hasReadPhoneState();
  }

  public static boolean hasCallPhone() {
    return permissionBoard.hasCallPhone();
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public static boolean hasWriteCallLog() {
    return permissionBoard.hasWriteCallLog();
  }

  public static boolean hasUseSip() {
    return permissionBoard.hasUseSip();
  }

  public static boolean hasProcessOutgoingCalls() {
    return permissionBoard.hasProcessOutgoingCalls();
  }

  public static boolean hasAddVoicemall() {
    return permissionBoard.hasAddVoicemall();
  }

  public static boolean hasReadCalendar() {
    return permissionBoard.hasReadCalendar();
  }

  public static boolean hasWriteCalendar() {
    return permissionBoard.hasWriteCalendar();
  }

  public static boolean hasCamera() {
    return permissionBoard.hasCamera();
  }

  @TargetApi(Build.VERSION_CODES.KITKAT_WATCH) public static boolean hasBodySensors() {
    return permissionBoard.hasBodySensors();
  }

  public static boolean hasAccessFindLocation() {
    return permissionBoard.hasAccessFindLocation();
  }

  public static boolean hasAccessCoarseLocation() {
    return permissionBoard.hasAccessCoarseLocation();
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public static boolean hasReadExternalStorage() {
    return permissionBoard.hasReadExternalStorage();
  }

  public static boolean hasWriteExternalStorage() {
    return permissionBoard.hasWriteExternalStorage();
  }

  public static boolean hasRecordAudio() {
    return permissionBoard.hasRecordAudio();
  }

  public static boolean hasReadSMS() {
    return permissionBoard.hasReadSMS();
  }

  public static boolean hasReceiveWapPush() {
    return permissionBoard.hasReceiveWapPush();
  }

  public static boolean hasReceiveMMS() {
    return permissionBoard.hasReceiveMMS();
  }

  public static boolean hasReceiveSMS() {
    return permissionBoard.hasReceiveSMS();
  }

  public static boolean hasSendSMS() {
    return permissionBoard.hasSendSMS();
  }
}
