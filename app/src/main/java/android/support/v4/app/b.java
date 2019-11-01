package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

public final class b {
  public static int a(Context paramContext, String paramString1, String paramString2) { return (Build.VERSION.SDK_INT >= 23) ? ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, paramString2) : 1; }
  
  public static String a(String paramString) { return (Build.VERSION.SDK_INT >= 23) ? AppOpsManager.permissionToOp(paramString) : null; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */