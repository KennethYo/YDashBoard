package com.yiche.ydashboard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.yiche.library.ydashboard.YDashBoard;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private static final int REQUEST_CODE_READ_PHONE_STATE = 1234431;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
      showInformation();
    } else {
      if (YDashBoard.hasReadPhoneState()) {
        showInformation();
      } else {
        if (shouldShowRequestPermissionRationale(Manifest.permission.READ_PHONE_STATE)) {
          Toast.makeText(this, "需要读取手机状态", Toast.LENGTH_LONG).show();
          requestPermissions(new String[] { Manifest.permission.READ_PHONE_STATE },
              REQUEST_CODE_READ_PHONE_STATE);
        } else {
          requestPermissions(new String[] { Manifest.permission.READ_PHONE_STATE },
              REQUEST_CODE_READ_PHONE_STATE);
        }
      }
    }
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CODE_READ_PHONE_STATE) {
      if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        showInformation();
      } else {
        Toast.makeText(this, "需要读取手机状态", Toast.LENGTH_LONG).show();
      }
    }
  }

  private void showInformation() {
    ListView listView = (ListView) findViewById(R.id.lv_info);

    long start = SystemClock.uptimeMillis();
    ArrayList<String> infos = new ArrayList<>();
    infos.add("version code : " + YDashBoard.getVersionCode());
    infos.add("version name : " + YDashBoard.getVersionName());
    infos.add("installer package name : " + YDashBoard.getInstallerPackageName());
    infos.add("language : " + YDashBoard.getLanguage());

    infos.add("manufacture : " + YDashBoard.getManufacture());
    infos.add("model : " + YDashBoard.getModel());
    infos.add("brand : " + YDashBoard.getBrand());

    infos.add("build tags : " + YDashBoard.getBuildTags());
    infos.add("build time : " + YDashBoard.getBuildTime());
    infos.add("build host : " + YDashBoard.getBuildHost());
    infos.add("build user : " + YDashBoard.getBuildUser());
    infos.add("build release : " + YDashBoard.getBuildRelease());
    infos.add("build code name : " + YDashBoard.getBuildCodeName());
    infos.add("build code incremental : " + YDashBoard.getBuildIncremental());
    infos.add("build sdk int : " + YDashBoard.getBuildSDKInt());
    infos.add("emulator : " + YDashBoard.isEmulator());

    infos.add("rooted : " + YDashBoard.isRooted());
    infos.add("orientation : " + YDashBoard.getOrientation());

    infos.add("time : " + YDashBoard.getTime());
    infos.add("format time : " + YDashBoard.getFormatTime());
    infos.add("format Chinese time : " + YDashBoard.getFormatChineseTime());
    infos.add("up time : " + YDashBoard.getUpTime());

    infos.add("device id : " + YDashBoard.getDeviceId());
    infos.add("serial : " + YDashBoard.getSerial());
    infos.add("sim serial number : " + YDashBoard.getSimSerialNumber());

    infos.add("has SD card : " + YDashBoard.hasSDCard());
    infos.add("ABIS : " + YDashBoard.getABIS());
    infos.add("support 32 bit ABIS : " + YDashBoard.getSupport32BitABIS());
    infos.add("support 64 bit ABIS : " + YDashBoard.getSupport64BitABIS());

    infos.add("network available : " + YDashBoard.isNetworkAvailable());
    infos.add("wifi enable : " + YDashBoard.isWifiEnable());
    infos.add("IPv4 : " + YDashBoard.getIPv4Address());
    infos.add("IPv6 : " + YDashBoard.getIPv6Address());
    infos.add("network type : " + YDashBoard.getNetworkType());
    infos.add("carrier : " + YDashBoard.getCarrier());

    Log.i("YDashBoard", "获取数据耗时 = " + (SystemClock.uptimeMillis() - start));

    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infos);
    listView.setAdapter(adapter);
  }
}
