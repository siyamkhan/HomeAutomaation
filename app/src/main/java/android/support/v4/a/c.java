package android.support.v4.a;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.b;

public final class c {
  public static int a(Context paramContext, String paramString) { return a(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName()); }
  
  public static int a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2) {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1)
      return -1; 
    String str = b.a(paramString1);
    if (str == null)
      return 0; 
    if (paramString2 == null) {
      String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt2);
      if (arrayOfString != null) {
        if (arrayOfString.length <= 0)
          return -1; 
        paramString2 = arrayOfString[0];
      } else {
        return -1;
      } 
    } 
    return (b.a(paramContext, str, paramString2) != 0) ? -2 : 0;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */