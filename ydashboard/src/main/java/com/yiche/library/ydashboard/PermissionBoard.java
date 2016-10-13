package com.yiche.library.ydashboard;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by kenneth on 2016/10/12.
 */

public final class PermissionBoard {
  private final Context context;

  public PermissionBoard(Context context) {
    this.context = context;
  }

  public boolean hasWriteContacts() {
    return checkSelfPermission(Manifest.permission.WRITE_CONTACTS);
  }

  public boolean hasGetAccounts() {
    return checkSelfPermission(Manifest.permission.GET_ACCOUNTS);
  }

  public boolean hasReadContacts() {
    return checkSelfPermission(Manifest.permission.READ_CONTACTS);
  }
  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public boolean hasCallLog() {
    return checkSelfPermission(Manifest.permission.READ_CALL_LOG);
  }
  public boolean hasReadPhoneState() {
    return checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
  }

  public boolean hasCallPhone() {
    return checkSelfPermission(Manifest.permission.CALL_PHONE);
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public boolean hasWriteCallLog() {
    return checkSelfPermission(Manifest.permission.WRITE_CALL_LOG);
  }

  public boolean hasUseSip() {
    return checkSelfPermission(Manifest.permission.USE_SIP);
  }

  public boolean hasProcessOutgoingCalls() {
    return checkSelfPermission(Manifest.permission.PROCESS_OUTGOING_CALLS);
  }

  public boolean hasAddVoicemall() {
    return checkSelfPermission(Manifest.permission.ADD_VOICEMAIL);
  }

  public boolean hasReadCalendar() {
    return checkSelfPermission(Manifest.permission.READ_CALENDAR);
  }

  public boolean hasWriteCalendar() {
    return checkSelfPermission(Manifest.permission.WRITE_CALENDAR);
  }

  public boolean hasCamera() {
    return checkSelfPermission(Manifest.permission.CAMERA);
  }

  @TargetApi(Build.VERSION_CODES.KITKAT_WATCH) public boolean hasBodySensors() {
    return checkSelfPermission(Manifest.permission.BODY_SENSORS);
  }

  public boolean hasAccessFindLocation() {
    return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
  }

  public boolean hasAccessCoarseLocation() {
    return checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public boolean hasReadExternalStorage() {
    return checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
  }

  public boolean hasWriteExternalStorage() {
    return checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
  }

  public boolean hasRecordAudio() {
    return checkSelfPermission(Manifest.permission.RECORD_AUDIO);
  }

  public boolean hasReadSMS() {
    return checkSelfPermission(Manifest.permission.READ_SMS);
  }

  public boolean hasReceiveWapPush() {
    return checkSelfPermission(Manifest.permission.RECEIVE_WAP_PUSH);
  }

  public boolean hasReceiveMMS() {
    return checkSelfPermission(Manifest.permission.RECEIVE_MMS);
  }

  public boolean hasReceiveSMS() {
    return checkSelfPermission(Manifest.permission.RECEIVE_SMS);
  }

  public boolean hasSendSMS() {
    return checkSelfPermission(Manifest.permission.SEND_SMS);
  }

  @TargetApi(Build.VERSION_CODES.M) private boolean checkSelfPermission(String permission) {
    return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
  }
}
