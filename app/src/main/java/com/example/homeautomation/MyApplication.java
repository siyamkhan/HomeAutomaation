package com.salyantech.homecontrolpanel;

import a.a.a.a.c;
import a.a.a.a.i;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.crashlytics.android.a;
import com.google.android.gms.ads.h;

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) { b.a().b(); }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onCreate() {
    super.onCreate();
    i[] arrayOfi = new i[1];
    arrayOfi[0] = new a();
    c.a(this, arrayOfi);
    h.a(this, getResources().getString(2131755050));
    b.a().a(getApplicationContext());
    registerActivityLifecycleCallbacks(this);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\MyApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */