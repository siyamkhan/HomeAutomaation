package com.salyantech.homecontrolpanel.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.c;
import com.salyantech.homecontrolpanel.b;
import com.salyantech.homecontrolpanel.c;

public class SplashActivity extends c {
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492896);
    (new Handler()).postDelayed(new Runnable(this) {
          public void run() {
            Class clazz;
            SplashActivity splashActivity;
            if ((b.a()).b.d) {
              splashActivity = this.a;
              clazz = PanelActivity.class;
            } else {
              splashActivity = this.a;
              clazz = DeviceList.class;
            } 
            c.a(splashActivity, clazz);
            this.a.finish();
          }
        }3500L);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\activity\SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */