package android.support.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;

public class b {
  private final g a;
  
  private final ComponentName b;
  
  b(g paramg, ComponentName paramComponentName) {
    this.a = paramg;
    this.b = paramComponentName;
  }
  
  public static boolean a(Context paramContext, String paramString, d paramd) {
    Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
    if (!TextUtils.isEmpty(paramString))
      intent.setPackage(paramString); 
    return paramContext.bindService(intent, paramd, 33);
  }
  
  public e a(a parama) {
    f.a a1 = new f.a(this, parama) {
        private Handler c = new Handler(Looper.getMainLooper());
        
        public void a(int param1Int, Bundle param1Bundle) {
          if (this.a == null)
            return; 
          this.c.post(new Runnable(this, param1Int, param1Bundle) {
                public void run() { this.c.a.a(this.a, this.b); }
              });
        }
        
        public void a(Bundle param1Bundle) {
          if (this.a == null)
            return; 
          this.c.post(new Runnable(this, param1Bundle) {
                public void run() { this.b.a.a(this.a); }
              });
        }
        
        public void a(String param1String, Bundle param1Bundle) {
          if (this.a == null)
            return; 
          this.c.post(new Runnable(this, param1String, param1Bundle) {
                public void run() { this.c.a.a(this.a, this.b); }
              });
        }
        
        public void b(String param1String, Bundle param1Bundle) {
          if (this.a == null)
            return; 
          this.c.post(new Runnable(this, param1String, param1Bundle) {
                public void run() { this.c.a.b(this.a, this.b); }
              });
        }
      };
    e e = null;
    try {
      boolean bool = this.a.a(a1);
      if (!bool)
        return null; 
      e = new e(this.a, a1, this.b);
    } catch (RemoteException remoteException) {}
    return e;
  }
  
  public boolean a(long paramLong) {
    try {
      return this.a.a(paramLong);
    } catch (RemoteException remoteException) {
      return false;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */