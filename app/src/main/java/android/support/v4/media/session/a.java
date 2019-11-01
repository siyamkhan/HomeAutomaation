package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface a extends IInterface {
  void a();
  
  void a(int paramInt);
  
  void a(Bundle paramBundle);
  
  void a(MediaMetadataCompat paramMediaMetadataCompat);
  
  void a(ParcelableVolumeInfo paramParcelableVolumeInfo);
  
  void a(PlaybackStateCompat paramPlaybackStateCompat);
  
  void a(CharSequence paramCharSequence);
  
  void a(String paramString, Bundle paramBundle);
  
  void a(List<MediaSessionCompat.QueueItem> paramList);
  
  void a(boolean paramBoolean);
  
  void b(int paramInt);
  
  void b(boolean paramBoolean);
  
  public static abstract class a extends Binder implements a {
    public a() { attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback"); }
    
    public static a a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
      return (iInterface != null && iInterface instanceof a) ? (a)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() { return this; }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 != 1598968902) {
        boolean bool2;
        int i3;
        boolean bool1;
        int i2;
        ParcelableVolumeInfo parcelableVolumeInfo;
        int i1;
        Bundle bundle2;
        int n;
        CharSequence charSequence;
        int m;
        MediaMetadataCompat mediaMetadataCompat;
        int k;
        PlaybackStateCompat playbackStateCompat;
        int j;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 12:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            b(param1Parcel1.readInt());
            return true;
          case 11:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            i3 = param1Parcel1.readInt();
            bool2 = false;
            if (i3 != 0)
              bool2 = true; 
            b(bool2);
            return true;
          case 10:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            i2 = param1Parcel1.readInt();
            bool1 = false;
            if (i2 != 0)
              bool1 = true; 
            a(bool1);
            return true;
          case 9:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a(param1Parcel1.readInt());
            return true;
          case 8:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            i1 = param1Parcel1.readInt();
            parcelableVolumeInfo = null;
            if (i1 != 0)
              parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(param1Parcel1); 
            a(parcelableVolumeInfo);
            return true;
          case 7:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            n = param1Parcel1.readInt();
            bundle2 = null;
            if (n != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            a(bundle2);
            return true;
          case 6:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            m = param1Parcel1.readInt();
            charSequence = null;
            if (m != 0)
              charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(param1Parcel1); 
            a(charSequence);
            return true;
          case 5:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a(param1Parcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
          case 4:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            k = param1Parcel1.readInt();
            mediaMetadataCompat = null;
            if (k != 0)
              mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(param1Parcel1); 
            a(mediaMetadataCompat);
            return true;
          case 3:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            j = param1Parcel1.readInt();
            playbackStateCompat = null;
            if (j != 0)
              playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(param1Parcel1); 
            a(playbackStateCompat);
            return true;
          case 2:
            param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        String str = param1Parcel1.readString();
        int i = param1Parcel1.readInt();
        Bundle bundle1 = null;
        if (i != 0)
          bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
        a(str, bundle1);
        return true;
      } 
      param1Parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
      return true;
    }
    
    private static class a implements a {
      private IBinder a;
      
      a(IBinder param2IBinder) { this.a = param2IBinder; }
      
      public void a() {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          this.a.transact(2, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(int param2Int) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeInt(param2Int);
          this.a.transact(9, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(Bundle param2Bundle) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(7, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(MediaMetadataCompat param2MediaMetadataCompat) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2MediaMetadataCompat != null) {
            parcel.writeInt(1);
            param2MediaMetadataCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(4, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(ParcelableVolumeInfo param2ParcelableVolumeInfo) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2ParcelableVolumeInfo != null) {
            parcel.writeInt(1);
            param2ParcelableVolumeInfo.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(8, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(PlaybackStateCompat param2PlaybackStateCompat) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2PlaybackStateCompat != null) {
            parcel.writeInt(1);
            param2PlaybackStateCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(3, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(CharSequence param2CharSequence) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2CharSequence != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(param2CharSequence, parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(6, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(String param2String, Bundle param2Bundle) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeString(param2String);
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
      
      public void a(List<MediaSessionCompat.QueueItem> param2List) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeTypedList(param2List);
          this.a.transact(5, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(boolean param2Boolean) {
        parcel = Parcel.obtain();
        try {
          byte b;
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2Boolean) {
            b = 1;
          } else {
            b = 0;
          } 
          parcel.writeInt(b);
          this.a.transact(10, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public IBinder asBinder() { return this.a; }
      
      public void b(int param2Int) {
        parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeInt(param2Int);
          this.a.transact(12, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void b(boolean param2Boolean) {
        parcel = Parcel.obtain();
        try {
          byte b;
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2Boolean) {
            b = 1;
          } else {
            b = 0;
          } 
          parcel.writeInt(b);
          this.a.transact(11, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  private static class a implements a {
    private IBinder a;
    
    a(IBinder param1IBinder) { this.a = param1IBinder; }
    
    public void a() {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        this.a.transact(2, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(int param1Int) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeInt(param1Int);
        this.a.transact(9, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(Bundle param1Bundle) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(7, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(MediaMetadataCompat param1MediaMetadataCompat) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1MediaMetadataCompat != null) {
          parcel.writeInt(1);
          param1MediaMetadataCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(4, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(ParcelableVolumeInfo param1ParcelableVolumeInfo) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1ParcelableVolumeInfo != null) {
          parcel.writeInt(1);
          param1ParcelableVolumeInfo.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(8, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(PlaybackStateCompat param1PlaybackStateCompat) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1PlaybackStateCompat != null) {
          parcel.writeInt(1);
          param1PlaybackStateCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(3, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(CharSequence param1CharSequence) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1CharSequence != null) {
          parcel.writeInt(1);
          TextUtils.writeToParcel(param1CharSequence, parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(6, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(String param1String, Bundle param1Bundle) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeString(param1String);
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
    
    public void a(List<MediaSessionCompat.QueueItem> param1List) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeTypedList(param1List);
        this.a.transact(5, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(boolean param1Boolean) {
      parcel = Parcel.obtain();
      try {
        byte b;
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1Boolean) {
          b = 1;
        } else {
          b = 0;
        } 
        parcel.writeInt(b);
        this.a.transact(10, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public IBinder asBinder() { return this.a; }
    
    public void b(int param1Int) {
      parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeInt(param1Int);
        this.a.transact(12, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void b(boolean param1Boolean) {
      parcel = Parcel.obtain();
      try {
        byte b;
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1Boolean) {
          b = 1;
        } else {
          b = 0;
        } 
        parcel.writeInt(b);
        this.a.transact(11, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\media\session\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */