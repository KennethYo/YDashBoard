package com.yiche.ydashboard;

import android.app.Application;
import com.yiche.library.ydashboard.YDashBoard;

/**
 * Created by kenneth on 2016/10/12.
 */

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    YDashBoard.init(this);
  }
}
