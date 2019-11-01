package android.support.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface f extends IInterface {
  void a(int paramInt, Bundle paramBundle);
  
  void a(Bundle paramBundle);
  
  void a(String paramString, Bundle paramBundle);
  
  void b(String paramString, Bundle paramBundle);
  
  public static abstract class a extends Binder implements f {
    public a() { attachInterface(this, "android.support.customtabs.ICustomTabsCallback"); }
    
    public static f a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
      return (iInterface != null && iInterface instanceof f) ? (f)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() { return this; }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 != 1598968902) {
        Bundle bundle4;
        int n;
        String str2;
        Bundle bundle3;
        int m;
        Bundle bundle2;
        int k;
        String str1;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 5:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            str2 = param1Parcel1.readString();
            n = param1Parcel1.readInt();
            bundle4 = null;
            if (n != 0)
              bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            b(str2, bundle4);
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            m = param1Parcel1.readInt();
            bundle3 = null;
            if (m != 0)
              bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            a(bundle3);
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            str1 = param1Parcel1.readString();
            k = param1Parcel1.readInt();
            bundle2 = null;
            if (k != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            a(str1, bundle2);
            param1Parcel2.writeNoException();
            return true;
          case 2:
            break;
        } 
        param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        int i = param1Parcel1.readInt();
        int j = param1Parcel1.readInt();
        Bundle bundle1 = null;
        if (j != 0)
          bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
        a(i, bundle1);
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
      return true;
    }
    
    private static class a implements f {
      private IBinder a;
      
      a(IBinder param2IBinder) { this.a = param2IBinder; }
      
      public void a(int param2Int, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          parcel1.writeInt(param2Int);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() { return this.a; }
      
      public void b(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class a implements f {
    private IBinder a;
    
    a(IBinder param1IBinder) { this.a = param1IBinder; }
    
    public void a(int param1Int, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        parcel1.writeInt(param1Int);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() { return this.a; }
    
    public void b(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */