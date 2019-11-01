package android.support.c;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

public final class e {
  private final Object a = new Object();
  
  private final g b;
  
  private final f c;
  
  private final ComponentName d;
  
  e(g paramg, f paramf, ComponentName paramComponentName) {
    this.b = paramg;
    this.c = paramf;
    this.d = paramComponentName;
  }
  
  IBinder a() { return this.c.asBinder(); }
  
  public boolean a(Uri paramUri, Bundle paramBundle, List<Bundle> paramList) {
    try {
      return this.b.a(this.c, paramUri, paramBundle, paramList);
    } catch (RemoteException remoteException) {
      return false;
    } 
  }
  
  ComponentName b() { return this.d; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */