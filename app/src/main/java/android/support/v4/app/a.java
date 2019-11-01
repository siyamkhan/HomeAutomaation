package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.a.a;

public class a extends a {
  private static b a;
  
  public static b a() { return a; }
  
  public static void a(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.finishAffinity();
      return;
    } 
    paramActivity.finish();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    } 
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    b b1 = a;
    if (b1 != null && b1.a(paramActivity, paramArrayOfString, paramInt))
      return; 
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramActivity instanceof c)
        ((c)paramActivity).a(paramInt); 
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    } 
    if (paramActivity instanceof a)
      (new Handler(Looper.getMainLooper())).post(new Runnable(paramArrayOfString, paramActivity, paramInt) {
            public void run() {
              int[] arrayOfInt = new int[this.a.length];
              PackageManager packageManager = this.b.getPackageManager();
              String str = this.b.getPackageName();
              int i = this.a.length;
              for (byte b1 = 0; b1 < i; b1++)
                arrayOfInt[b1] = packageManager.checkPermission(this.a[b1], str); 
              ((a.a)this.b).onRequestPermissionsResult(this.c, this.a, arrayOfInt);
            }
          }); 
  }
  
  public static interface a {
    void onRequestPermissionsResult(int param1Int, String[] param1ArrayOfString, int[] param1ArrayOfInt);
  }
  
  public static interface b {
    boolean a(Activity param1Activity, int param1Int1, int param1Int2, Intent param1Intent);
    
    boolean a(Activity param1Activity, String[] param1ArrayOfString, int param1Int);
  }
  
  public static interface c {
    void a(int param1Int);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */