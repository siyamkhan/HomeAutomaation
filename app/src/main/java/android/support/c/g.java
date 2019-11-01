package android.support.c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface g extends IInterface {
  int a(f paramf, String paramString, Bundle paramBundle);
  
  Bundle a(String paramString, Bundle paramBundle);
  
  boolean a(long paramLong);
  
  boolean a(f paramf);
  
  boolean a(f paramf, Uri paramUri);
  
  boolean a(f paramf, Uri paramUri, Bundle paramBundle, List<Bundle> paramList);
  
  boolean a(f paramf, Bundle paramBundle);
  
  public static abstract class a extends Binder implements g {
    public static g a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
      return (iInterface != null && iInterface instanceof g) ? (g)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() { return this; }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 != 1598968902) {
        int i6;
        Bundle bundle5;
        int i5;
        String str2;
        f f4;
        int i4;
        Uri uri2;
        int i3;
        f f3;
        int i2;
        Bundle bundle4;
        int i1;
        f f2;
        Bundle bundle3;
        Bundle bundle2;
        int n;
        String str1;
        int m;
        Bundle bundle1;
        int k;
        Uri uri1;
        f f1;
        int j;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 8:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            f4 = f.a.a(param1Parcel1.readStrongBinder());
            str2 = param1Parcel1.readString();
            i5 = param1Parcel1.readInt();
            bundle5 = null;
            if (i5 != 0)
              bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            i6 = a(f4, str2, bundle5);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(i6);
            return true;
          case 7:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            f3 = f.a.a(param1Parcel1.readStrongBinder());
            i3 = param1Parcel1.readInt();
            uri2 = null;
            if (i3 != 0)
              uri2 = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1); 
            i4 = a(f3, uri2);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(i4);
            return true;
          case 6:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            f2 = f.a.a(param1Parcel1.readStrongBinder());
            i1 = param1Parcel1.readInt();
            bundle4 = null;
            if (i1 != 0)
              bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            i2 = a(f2, bundle4);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(i2);
            return true;
          case 5:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            str1 = param1Parcel1.readString();
            n = param1Parcel1.readInt();
            bundle2 = null;
            if (n != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            bundle3 = a(str1, bundle2);
            param1Parcel2.writeNoException();
            if (bundle3 != null) {
              param1Parcel2.writeInt(1);
              bundle3.writeToParcel(param1Parcel2, 1);
              return true;
            } 
            param1Parcel2.writeInt(0);
            return true;
          case 4:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            f1 = f.a.a(param1Parcel1.readStrongBinder());
            if (param1Parcel1.readInt() != 0) {
              uri1 = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1);
            } else {
              uri1 = null;
            } 
            k = param1Parcel1.readInt();
            bundle1 = null;
            if (k != 0)
              bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            m = a(f1, uri1, bundle1, param1Parcel1.createTypedArrayList(Bundle.CREATOR));
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(m);
            return true;
          case 3:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            j = a(f.a.a(param1Parcel1.readStrongBinder()));
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(j);
            return true;
          case 2:
            break;
        } 
        param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        int i = a(param1Parcel1.readLong());
        param1Parcel2.writeNoException();
        param1Parcel2.writeInt(i);
        return true;
      } 
      param1Parcel2.writeString("android.support.customtabs.ICustomTabsService");
      return true;
    }
    
    private static class a implements g {
      private IBinder a;
      
      a(IBinder param2IBinder) { this.a = param2IBinder; }
      
      public int a(f param2f, String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2f != null) {
            iBinder = param2f.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle a(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            bundle = null;
          } 
          return bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(long param2Long) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          parcel1.writeLong(param2Long);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          bool = false;
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(f param2f) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2f != null) {
            iBinder = param2f.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          bool = false;
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(f param2f, Uri param2Uri) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2f != null) {
            iBinder = param2f.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          i = 1;
          if (param2Uri != null) {
            parcel1.writeInt(i);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          int j = parcel2.readInt();
          if (j == 0)
            i = 0; 
          return i;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(f param2f, Uri param2Uri, Bundle param2Bundle, List<Bundle> param2List) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2f != null) {
            iBinder = param2f.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          i = 1;
          if (param2Uri != null) {
            parcel1.writeInt(i);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(i);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeTypedList(param2List);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          int j = parcel2.readInt();
          if (j == 0)
            i = 0; 
          return i;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(f param2f, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2f != null) {
            iBinder = param2f.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          i = 1;
          if (param2Bundle != null) {
            parcel1.writeInt(i);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          int j = parcel2.readInt();
          if (j == 0)
            i = 0; 
          return i;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() { return this.a; }
    }
  }
  
  private static class a implements g {
    private IBinder a;
    
    a(IBinder param1IBinder) { this.a = param1IBinder; }
    
    public int a(f param1f, String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1f != null) {
          iBinder = param1f.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle a(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          bundle = null;
        } 
        return bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(long param1Long) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        parcel1.writeLong(param1Long);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        bool = false;
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(f param1f) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1f != null) {
          iBinder = param1f.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        bool = false;
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(f param1f, Uri param1Uri) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1f != null) {
          iBinder = param1f.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        i = 1;
        if (param1Uri != null) {
          parcel1.writeInt(i);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        int j = parcel2.readInt();
        if (j == 0)
          i = 0; 
        return i;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(f param1f, Uri param1Uri, Bundle param1Bundle, List<Bundle> param1List) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1f != null) {
          iBinder = param1f.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        i = 1;
        if (param1Uri != null) {
          parcel1.writeInt(i);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(i);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeTypedList(param1List);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        int j = parcel2.readInt();
        if (j == 0)
          i = 0; 
        return i;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(f param1f, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1f != null) {
          iBinder = param1f.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        i = 1;
        if (param1Bundle != null) {
          parcel1.writeInt(i);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        int j = parcel2.readInt();
        if (j == 0)
          i = 0; 
        return i;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() { return this.a; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */