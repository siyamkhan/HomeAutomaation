package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public interface b extends IInterface {
  void a(int paramInt);
  
  void a(int paramInt1, int paramInt2, String paramString);
  
  void a(long paramLong);
  
  void a(Uri paramUri, Bundle paramBundle);
  
  void a(MediaDescriptionCompat paramMediaDescriptionCompat);
  
  void a(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt);
  
  void a(RatingCompat paramRatingCompat);
  
  void a(RatingCompat paramRatingCompat, Bundle paramBundle);
  
  void a(a parama);
  
  void a(String paramString, Bundle paramBundle);
  
  void a(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper);
  
  void a(boolean paramBoolean);
  
  boolean a();
  
  boolean a(KeyEvent paramKeyEvent);
  
  String b();
  
  void b(int paramInt);
  
  void b(int paramInt1, int paramInt2, String paramString);
  
  void b(long paramLong);
  
  void b(Uri paramUri, Bundle paramBundle);
  
  void b(MediaDescriptionCompat paramMediaDescriptionCompat);
  
  void b(a parama);
  
  void b(String paramString, Bundle paramBundle);
  
  void b(boolean paramBoolean);
  
  String c();
  
  void c(int paramInt);
  
  void c(String paramString, Bundle paramBundle);
  
  PendingIntent d();
  
  void d(String paramString, Bundle paramBundle);
  
  long e();
  
  void e(String paramString, Bundle paramBundle);
  
  ParcelableVolumeInfo f();
  
  MediaMetadataCompat g();
  
  PlaybackStateCompat h();
  
  List<MediaSessionCompat.QueueItem> i();
  
  CharSequence j();
  
  Bundle k();
  
  int l();
  
  boolean m();
  
  int n();
  
  boolean o();
  
  int p();
  
  void q();
  
  void r();
  
  void s();
  
  void t();
  
  void u();
  
  void v();
  
  void w();
  
  void x();
  
  public static abstract class a extends Binder implements b {
    public static b a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
      return (iInterface != null && iInterface instanceof b) ? (b)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() { return this; }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      RatingCompat ratingCompat;
      if (param1Int1 != 51) {
        if (param1Int1 != 1598968902) {
          int i18;
          boolean bool2;
          int i17;
          int i16;
          MediaDescriptionCompat mediaDescriptionCompat3;
          int i15;
          MediaDescriptionCompat mediaDescriptionCompat2;
          int i14;
          MediaDescriptionCompat mediaDescriptionCompat1;
          int i13;
          boolean bool1;
          int i12;
          int i11;
          int i10;
          Bundle bundle9;
          int i9;
          Uri uri2;
          Bundle bundle8;
          int i8;
          String str8;
          Bundle bundle7;
          int i7;
          String str7;
          int i6;
          Bundle bundle6;
          CharSequence charSequence;
          List list;
          PlaybackStateCompat playbackStateCompat;
          MediaMetadataCompat mediaMetadataCompat;
          Bundle bundle5;
          int i5;
          String str6;
          RatingCompat ratingCompat1;
          int i4;
          Bundle bundle4;
          int i3;
          Uri uri1;
          Bundle bundle3;
          int i2;
          String str5;
          Bundle bundle2;
          int i1;
          String str4;
          ParcelableVolumeInfo parcelableVolumeInfo;
          long l;
          PendingIntent pendingIntent;
          String str3;
          String str2;
          int n;
          int m;
          KeyEvent keyEvent;
          int k;
          Bundle bundle1;
          switch (param1Int1) {
            default:
              return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
            case 48:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              c(param1Parcel1.readInt());
              param1Parcel2.writeNoException();
              return true;
            case 47:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i18 = p();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(i18);
              return true;
            case 46:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i17 = param1Parcel1.readInt();
              bool2 = false;
              if (i17 != 0)
                bool2 = true; 
              a(bool2);
              param1Parcel2.writeNoException();
              return true;
            case 45:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i16 = m();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(i16);
              return true;
            case 44:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              a(param1Parcel1.readInt());
              param1Parcel2.writeNoException();
              return true;
            case 43:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i15 = param1Parcel1.readInt();
              mediaDescriptionCompat3 = null;
              if (i15 != 0)
                mediaDescriptionCompat3 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(param1Parcel1); 
              b(mediaDescriptionCompat3);
              param1Parcel2.writeNoException();
              return true;
            case 42:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i14 = param1Parcel1.readInt();
              mediaDescriptionCompat2 = null;
              if (i14 != 0)
                mediaDescriptionCompat2 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(param1Parcel1); 
              a(mediaDescriptionCompat2, param1Parcel1.readInt());
              param1Parcel2.writeNoException();
              return true;
            case 41:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i13 = param1Parcel1.readInt();
              mediaDescriptionCompat1 = null;
              if (i13 != 0)
                mediaDescriptionCompat1 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(param1Parcel1); 
              a(mediaDescriptionCompat1);
              param1Parcel2.writeNoException();
              return true;
            case 40:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i12 = param1Parcel1.readInt();
              bool1 = false;
              if (i12 != 0)
                bool1 = true; 
              b(bool1);
              param1Parcel2.writeNoException();
              return true;
            case 39:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              b(param1Parcel1.readInt());
              param1Parcel2.writeNoException();
              return true;
            case 38:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i11 = o();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(i11);
              return true;
            case 37:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i10 = n();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(i10);
              return true;
            case 36:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              if (param1Parcel1.readInt() != 0) {
                uri2 = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1);
              } else {
                uri2 = null;
              } 
              i9 = param1Parcel1.readInt();
              bundle9 = null;
              if (i9 != 0)
                bundle9 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              a(uri2, bundle9);
              param1Parcel2.writeNoException();
              return true;
            case 35:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str8 = param1Parcel1.readString();
              i8 = param1Parcel1.readInt();
              bundle8 = null;
              if (i8 != 0)
                bundle8 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              b(str8, bundle8);
              param1Parcel2.writeNoException();
              return true;
            case 34:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str7 = param1Parcel1.readString();
              i7 = param1Parcel1.readInt();
              bundle7 = null;
              if (i7 != 0)
                bundle7 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              a(str7, bundle7);
              param1Parcel2.writeNoException();
              return true;
            case 33:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              q();
              param1Parcel2.writeNoException();
              return true;
            case 32:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i6 = l();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(i6);
              return true;
            case 31:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              bundle6 = k();
              param1Parcel2.writeNoException();
              if (bundle6 != null) {
                param1Parcel2.writeInt(1);
                bundle6.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 30:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              charSequence = j();
              param1Parcel2.writeNoException();
              if (charSequence != null) {
                param1Parcel2.writeInt(1);
                TextUtils.writeToParcel(charSequence, param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 29:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              list = i();
              param1Parcel2.writeNoException();
              param1Parcel2.writeTypedList(list);
              return true;
            case 28:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              playbackStateCompat = h();
              param1Parcel2.writeNoException();
              if (playbackStateCompat != null) {
                param1Parcel2.writeInt(1);
                playbackStateCompat.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 27:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              mediaMetadataCompat = g();
              param1Parcel2.writeNoException();
              if (mediaMetadataCompat != null) {
                param1Parcel2.writeInt(1);
                mediaMetadataCompat.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 26:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str6 = param1Parcel1.readString();
              i5 = param1Parcel1.readInt();
              bundle5 = null;
              if (i5 != 0)
                bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              e(str6, bundle5);
              param1Parcel2.writeNoException();
              return true;
            case 25:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              i4 = param1Parcel1.readInt();
              ratingCompat1 = null;
              if (i4 != 0)
                ratingCompat1 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(param1Parcel1); 
              a(ratingCompat1);
              param1Parcel2.writeNoException();
              return true;
            case 24:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              b(param1Parcel1.readLong());
              param1Parcel2.writeNoException();
              return true;
            case 23:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              x();
              param1Parcel2.writeNoException();
              return true;
            case 22:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              w();
              param1Parcel2.writeNoException();
              return true;
            case 21:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              v();
              param1Parcel2.writeNoException();
              return true;
            case 20:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              u();
              param1Parcel2.writeNoException();
              return true;
            case 19:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              t();
              param1Parcel2.writeNoException();
              return true;
            case 18:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              s();
              param1Parcel2.writeNoException();
              return true;
            case 17:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              a(param1Parcel1.readLong());
              param1Parcel2.writeNoException();
              return true;
            case 16:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              if (param1Parcel1.readInt() != 0) {
                uri1 = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1);
              } else {
                uri1 = null;
              } 
              i3 = param1Parcel1.readInt();
              bundle4 = null;
              if (i3 != 0)
                bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              b(uri1, bundle4);
              param1Parcel2.writeNoException();
              return true;
            case 15:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str5 = param1Parcel1.readString();
              i2 = param1Parcel1.readInt();
              bundle3 = null;
              if (i2 != 0)
                bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              d(str5, bundle3);
              param1Parcel2.writeNoException();
              return true;
            case 14:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str4 = param1Parcel1.readString();
              i1 = param1Parcel1.readInt();
              bundle2 = null;
              if (i1 != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
              c(str4, bundle2);
              param1Parcel2.writeNoException();
              return true;
            case 13:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              r();
              param1Parcel2.writeNoException();
              return true;
            case 12:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              b(param1Parcel1.readInt(), param1Parcel1.readInt(), param1Parcel1.readString());
              param1Parcel2.writeNoException();
              return true;
            case 11:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              a(param1Parcel1.readInt(), param1Parcel1.readInt(), param1Parcel1.readString());
              param1Parcel2.writeNoException();
              return true;
            case 10:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              parcelableVolumeInfo = f();
              param1Parcel2.writeNoException();
              if (parcelableVolumeInfo != null) {
                param1Parcel2.writeInt(1);
                parcelableVolumeInfo.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 9:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              l = e();
              param1Parcel2.writeNoException();
              param1Parcel2.writeLong(l);
              return true;
            case 8:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              pendingIntent = d();
              param1Parcel2.writeNoException();
              if (pendingIntent != null) {
                param1Parcel2.writeInt(1);
                pendingIntent.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 7:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str3 = c();
              param1Parcel2.writeNoException();
              param1Parcel2.writeString(str3);
              return true;
            case 6:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              str2 = b();
              param1Parcel2.writeNoException();
              param1Parcel2.writeString(str2);
              return true;
            case 5:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              n = a();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(n);
              return true;
            case 4:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              b(a.a.a(param1Parcel1.readStrongBinder()));
              param1Parcel2.writeNoException();
              return true;
            case 3:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              a(a.a.a(param1Parcel1.readStrongBinder()));
              param1Parcel2.writeNoException();
              return true;
            case 2:
              param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
              k = param1Parcel1.readInt();
              keyEvent = null;
              if (k != 0)
                keyEvent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(param1Parcel1); 
              m = a(keyEvent);
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(m);
              return true;
            case 1:
              break;
          } 
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
          String str1 = param1Parcel1.readString();
          if (param1Parcel1.readInt() != 0) {
            bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
          } else {
            bundle1 = null;
          } 
          int j = param1Parcel1.readInt();
          MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper = null;
          if (j != 0)
            resultReceiverWrapper = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(param1Parcel1); 
          a(str1, bundle1, resultReceiverWrapper);
          param1Parcel2.writeNoException();
          return true;
        } 
        param1Parcel2.writeString("android.support.v4.media.session.IMediaSession");
        return true;
      } 
      param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (param1Parcel1.readInt() != 0) {
        ratingCompat = (RatingCompat)RatingCompat.CREATOR.createFromParcel(param1Parcel1);
      } else {
        ratingCompat = null;
      } 
      int i = param1Parcel1.readInt();
      Bundle bundle = null;
      if (i != 0)
        bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
      a(ratingCompat, bundle);
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static class a implements b {
      private IBinder a;
      
      a(IBinder param2IBinder) { this.a = param2IBinder; }
      
      public void a(int param2Int) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeInt(param2Int);
          this.a.transact(44, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int1, int param2Int2, String param2String) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeString(param2String);
          this.a.transact(11, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(long param2Long) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeLong(param2Long);
          this.a.transact(17, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(Uri param2Uri, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(36, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(MediaDescriptionCompat param2MediaDescriptionCompat) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2MediaDescriptionCompat != null) {
            parcel1.writeInt(1);
            param2MediaDescriptionCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(41, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(MediaDescriptionCompat param2MediaDescriptionCompat, int param2Int) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2MediaDescriptionCompat != null) {
            parcel1.writeInt(1);
            param2MediaDescriptionCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeInt(param2Int);
          this.a.transact(42, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(RatingCompat param2RatingCompat) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2RatingCompat != null) {
            parcel1.writeInt(1);
            param2RatingCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(25, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(RatingCompat param2RatingCompat, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2RatingCompat != null) {
            parcel1.writeInt(1);
            param2RatingCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(51, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(a param2a) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2a != null) {
            iBinder = param2a.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(3, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(34, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(String param2String, Bundle param2Bundle, MediaSessionCompat.ResultReceiverWrapper param2ResultReceiverWrapper) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ResultReceiverWrapper != null) {
            parcel1.writeInt(1);
            param2ResultReceiverWrapper.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(boolean param2Boolean) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          byte b1;
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2Boolean) {
            b1 = 1;
          } else {
            b1 = 0;
          } 
          parcel1.writeInt(b1);
          this.a.transact(46, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(5, parcel1, parcel2, 0);
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
      
      public boolean a(KeyEvent param2KeyEvent) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          i = 1;
          if (param2KeyEvent != null) {
            parcel1.writeInt(i);
            param2KeyEvent.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(2, parcel1, parcel2, 0);
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
      
      public String b() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(int param2Int) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeInt(param2Int);
          this.a.transact(39, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(int param2Int1, int param2Int2, String param2String) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeString(param2String);
          this.a.transact(12, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(long param2Long) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeLong(param2Long);
          this.a.transact(24, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(Uri param2Uri, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(16, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(MediaDescriptionCompat param2MediaDescriptionCompat) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2MediaDescriptionCompat != null) {
            parcel1.writeInt(1);
            param2MediaDescriptionCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(43, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(a param2a) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2a != null) {
            iBinder = param2a.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(35, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(boolean param2Boolean) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          byte b1;
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          if (param2Boolean) {
            b1 = 1;
          } else {
            b1 = 0;
          } 
          parcel1.writeInt(b1);
          this.a.transact(40, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String c() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void c(int param2Int) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeInt(param2Int);
          this.a.transact(48, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void c(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(14, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public PendingIntent d() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2);
          } else {
            pendingIntent = null;
          } 
          return pendingIntent;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void d(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(15, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public long e() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readLong();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void e(String param2String, Bundle param2Bundle) {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(26, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public ParcelableVolumeInfo f() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel2);
          } else {
            parcelableVolumeInfo = null;
          } 
          return parcelableVolumeInfo;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public MediaMetadataCompat g() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(27, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel2);
          } else {
            mediaMetadataCompat = null;
          } 
          return mediaMetadataCompat;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public PlaybackStateCompat h() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(28, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel2);
          } else {
            playbackStateCompat = null;
          } 
          return playbackStateCompat;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<MediaSessionCompat.QueueItem> i() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(29, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public CharSequence j() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(30, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
          } else {
            charSequence = null;
          } 
          return charSequence;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle k() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(31, parcel1, parcel2, 0);
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
      
      public int l() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(32, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean m() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(45, parcel1, parcel2, 0);
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
      
      public int n() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(37, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean o() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(38, parcel1, parcel2, 0);
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
      
      public int p() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(47, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void q() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(33, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void r() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(13, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void s() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(18, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void t() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(19, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void u() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(20, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void v() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(21, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void w() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(22, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void x() {
        parcel2 = (parcel1 = Parcel.obtain()).obtain();
        try {
          parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
          this.a.transact(23, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class a implements b {
    private IBinder a;
    
    a(IBinder param1IBinder) { this.a = param1IBinder; }
    
    public void a(int param1Int) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeInt(param1Int);
        this.a.transact(44, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int1, int param1Int2, String param1String) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeString(param1String);
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(long param1Long) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeLong(param1Long);
        this.a.transact(17, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(Uri param1Uri, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(36, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(MediaDescriptionCompat param1MediaDescriptionCompat) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1MediaDescriptionCompat != null) {
          parcel1.writeInt(1);
          param1MediaDescriptionCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(41, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1MediaDescriptionCompat != null) {
          parcel1.writeInt(1);
          param1MediaDescriptionCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeInt(param1Int);
        this.a.transact(42, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(RatingCompat param1RatingCompat) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1RatingCompat != null) {
          parcel1.writeInt(1);
          param1RatingCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(25, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(RatingCompat param1RatingCompat, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1RatingCompat != null) {
          parcel1.writeInt(1);
          param1RatingCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(51, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(a param1a) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1a != null) {
          iBinder = param1a.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(3, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(34, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(String param1String, Bundle param1Bundle, MediaSessionCompat.ResultReceiverWrapper param1ResultReceiverWrapper) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ResultReceiverWrapper != null) {
          parcel1.writeInt(1);
          param1ResultReceiverWrapper.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(boolean param1Boolean) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        byte b1;
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1Boolean) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        parcel1.writeInt(b1);
        this.a.transact(46, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(5, parcel1, parcel2, 0);
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
    
    public boolean a(KeyEvent param1KeyEvent) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        i = 1;
        if (param1KeyEvent != null) {
          parcel1.writeInt(i);
          param1KeyEvent.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(2, parcel1, parcel2, 0);
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
    
    public String b() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(int param1Int) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeInt(param1Int);
        this.a.transact(39, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(int param1Int1, int param1Int2, String param1String) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeString(param1String);
        this.a.transact(12, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(long param1Long) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeLong(param1Long);
        this.a.transact(24, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(Uri param1Uri, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(16, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(MediaDescriptionCompat param1MediaDescriptionCompat) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1MediaDescriptionCompat != null) {
          parcel1.writeInt(1);
          param1MediaDescriptionCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(43, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(a param1a) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1a != null) {
          iBinder = param1a.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(35, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(boolean param1Boolean) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        byte b1;
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (param1Boolean) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        parcel1.writeInt(b1);
        this.a.transact(40, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String c() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void c(int param1Int) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeInt(param1Int);
        this.a.transact(48, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void c(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(14, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public PendingIntent d() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2);
        } else {
          pendingIntent = null;
        } 
        return pendingIntent;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void d(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(15, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public long e() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readLong();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void e(String param1String, Bundle param1Bundle) {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(26, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public ParcelableVolumeInfo f() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel2);
        } else {
          parcelableVolumeInfo = null;
        } 
        return parcelableVolumeInfo;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public MediaMetadataCompat g() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(27, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel2);
        } else {
          mediaMetadataCompat = null;
        } 
        return mediaMetadataCompat;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public PlaybackStateCompat h() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(28, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel2);
        } else {
          playbackStateCompat = null;
        } 
        return playbackStateCompat;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<MediaSessionCompat.QueueItem> i() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(29, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public CharSequence j() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(30, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        } else {
          charSequence = null;
        } 
        return charSequence;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle k() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(31, parcel1, parcel2, 0);
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
    
    public int l() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(32, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean m() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(45, parcel1, parcel2, 0);
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
    
    public int n() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(37, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean o() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(38, parcel1, parcel2, 0);
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
    
    public int p() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(47, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void q() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(33, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void r() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(13, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void s() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(18, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void t() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(19, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void u() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(20, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void v() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(21, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void w() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(22, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void x() {
      parcel2 = (parcel1 = Parcel.obtain()).obtain();
      try {
        parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        this.a.transact(23, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\media\session\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */