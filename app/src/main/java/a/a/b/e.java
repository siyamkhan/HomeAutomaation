package a.a.a.a.a.b;

import a.a.a.a.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jd.gui.api.API;

class e implements f {
  private final Context a;
  
  public e(Context paramContext) { this.a = paramContext.getApplicationContext(); }
  
  public b a() {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      c.g().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
      return null;
    } 
    try {
      this.a.getPackageManager().getPackageInfo("com.android.vending", 0);
      a a1 = new a(null);
      Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
      intent.setPackage("com.google.android.gms");
      try {
        boolean bool = this.a.bindService(intent, a1, 1);
        if (bool) {
          API aPI;
          try {
            b b = new b(a1.a());
            b b1 = new b(b.a(), b.b());
            this.a.unbindService(a1);
            return b1;
          } catch (Exception exception) {
            c.g().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", exception);
            this.a.unbindService(a1);
            return null;
          } finally {}
          this.a.unbindService(a1);
          throw aPI;
        } 
        c.g().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        return null;
      } catch (Throwable throwable) {
        c.g().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", throwable);
        return null;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      c.g().a("Fabric", "Unable to find Google Play Services package name");
      return null;
    } catch (Exception exception) {
      c.g().a("Fabric", "Unable to determine if Google Play Services is available", exception);
      return null;
    } 
  }
  
  private static final class a implements ServiceConnection {
    private boolean a = false;
    
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);
    
    private a() {}
    
    public IBinder a() {
      if (this.a)
        c.g().e("Fabric", "getBinder already called"); 
      this.a = true;
      try {
        return (IBinder)this.b.poll(200L, TimeUnit.MILLISECONDS);
      } catch (InterruptedException interruptedException) {
        return null;
      } 
    }
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      try {
        this.b.put(param1IBinder);
      } catch (InterruptedException interruptedException) {}
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) { this.b.clear(); }
  }
  
  private static final class b implements IInterface {
    private final IBinder a;
    
    public b(IBinder param1IBinder) { this.a = param1IBinder; }
    
    public String a() {
      API aPI;
      Parcel parcel1;
      Parcel parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        String str = parcel2.readString();
        parcel2.recycle();
        parcel1.recycle();
        return str;
      } catch (Exception exception) {
        c.g().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        parcel2.recycle();
        parcel1.recycle();
        return null;
      } finally {}
      parcel2.recycle();
      parcel1.recycle();
      throw aPI;
    }
    
    public IBinder asBinder() { return this.a; }
    
    public boolean b() {
      Parcel parcel1;
      Parcel parcel2 = (parcel1 = Parcel.obtain()).obtain();
      boolean bool = false;
      try {
        parcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        parcel1.writeInt(1);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        bool = false;
        if (i != 0)
          bool = true; 
      } catch (Exception exception) {
        c.g().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
      } finally {
        API aPI;
      } 
      parcel2.recycle();
      parcel1.recycle();
      return bool;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */