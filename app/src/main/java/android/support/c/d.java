package android.support.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public abstract class d implements ServiceConnection {
  public abstract void a(ComponentName paramComponentName, b paramb);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) { a(paramComponentName, new b(this, g.a.a(paramIBinder), paramComponentName) {
        
        }); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */