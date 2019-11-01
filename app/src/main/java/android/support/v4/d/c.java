package android.support.v4.d;

import android.os.Build;
import android.os.Trace;

public final class c {
  public static void a() {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.endSection(); 
  }
  
  public static void a(String paramString) {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.beginSection(paramString); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */