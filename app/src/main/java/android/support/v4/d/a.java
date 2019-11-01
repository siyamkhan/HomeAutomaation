package android.support.v4.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {
  void a(int paramInt, Bundle paramBundle);
  
  public static abstract class a extends Binder implements a {
    public a() { attachInterface(this, "android.support.v4.os.IResultReceiver"); }
    
    public static a a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
      return (iInterface != null && iInterface instanceof a) ? (a)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() { return this; }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      Bundle bundle;
      if (param1Int1 != 1) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString("android.support.v4.os.IResultReceiver");
        return true;
      } 
      param1Parcel1.enforceInterface("android.support.v4.os.IResultReceiver");
      int i = param1Parcel1.readInt();
      if (param1Parcel1.readInt() != 0) {
        bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
      } else {
        bundle = null;
      } 
      a(i, bundle);
      return true;
    }
    
    private static class a implements a {
      private IBinder a;
      
      a(IBinder param2IBinder) { this.a = param2IBinder; }
      
      public void a(int param2Int, Bundle param2Bundle) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
          parcel.writeInt(param2Int);
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(1, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public IBinder asBinder() { return this.a; }
    }
  }
  
  private static class a implements a {
    private IBinder a;
    
    a(IBinder param1IBinder) { this.a = param1IBinder; }
    
    public void a(int param1Int, Bundle param1Bundle) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
        parcel.writeInt(param1Int);
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(1, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public IBinder asBinder() { return this.a; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */