package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class d extends BroadcastReceiver {
  private static final SparseArray<PowerManager.WakeLock> a = new SparseArray();
  
  private static int b = 1;
  
  public static boolean a(Intent paramIntent) {
    int i = paramIntent.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0)
      return false; 
    synchronized (a) {
      PowerManager.WakeLock wakeLock = (PowerManager.WakeLock)a.get(i);
      if (wakeLock != null) {
        wakeLock.release();
        a.remove(i);
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No active wake lock id #");
      stringBuilder.append(i);
      Log.w("WakefulBroadcastReceiv.", stringBuilder.toString());
      return true;
    } 
  }
  
  public static ComponentName a_(Context paramContext, Intent paramIntent) {
    synchronized (a) {
      int i = b;
      b = 1 + b;
      if (b <= 0)
        b = 1; 
      paramIntent.putExtra("android.support.content.wakelockid", i);
      ComponentName componentName = paramContext.startService(paramIntent);
      if (componentName == null)
        return null; 
      PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("androidx.core:wake:");
      stringBuilder.append(componentName.flattenToShortString());
      PowerManager.WakeLock wakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
      wakeLock.setReferenceCounted(false);
      wakeLock.acquire(60000L);
      a.put(i, wakeLock);
      return componentName;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */