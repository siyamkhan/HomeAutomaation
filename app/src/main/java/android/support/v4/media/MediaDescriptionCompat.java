package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
      public MediaDescriptionCompat a(Parcel param1Parcel) { return (Build.VERSION.SDK_INT < 21) ? new MediaDescriptionCompat(param1Parcel) : MediaDescriptionCompat.a(a.a(param1Parcel)); }
      
      public MediaDescriptionCompat[] a(int param1Int) { return new MediaDescriptionCompat[param1Int]; }
    };
  
  private final String a;
  
  private final CharSequence b;
  
  private final CharSequence c;
  
  private final CharSequence d;
  
  private final Bitmap e;
  
  private final Uri f;
  
  private final Bundle g;
  
  private final Uri h;
  
  private Object i;
  
  MediaDescriptionCompat(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.c = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.d = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.e = (Bitmap)paramParcel.readParcelable(null);
    this.f = (Uri)paramParcel.readParcelable(null);
    this.g = paramParcel.readBundle();
    this.h = (Uri)paramParcel.readParcelable(null);
  }
  
  MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2) {
    this.a = paramString;
    this.b = paramCharSequence1;
    this.c = paramCharSequence2;
    this.d = paramCharSequence3;
    this.e = paramBitmap;
    this.f = paramUri1;
    this.g = paramBundle;
    this.h = paramUri2;
  }
  
  public static MediaDescriptionCompat a(Object paramObject) {
    Bundle bundle1;
    MediaDescriptionCompat mediaDescriptionCompat = null;
    if (paramObject != null) {
      int j = Build.VERSION.SDK_INT;
      mediaDescriptionCompat = null;
      if (j >= 21) {
        Uri uri;
        a a1 = new a();
        a1.a(a.a(paramObject));
        a1.a(a.b(paramObject));
        a1.b(a.c(paramObject));
        a1.c(a.d(paramObject));
        a1.a(a.e(paramObject));
        a1.a(a.f(paramObject));
        bundle1 = a.g(paramObject);
        if (bundle1 == null) {
          uri = null;
        } else {
          uri = (Uri)bundle1.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } 
        if (uri != null) {
          Bundle bundle;
          if (bundle1.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundle1.size() == 2) {
            bundle = null;
          } else {
            bundle1.remove("android.support.v4.media.description.MEDIA_URI");
            bundle1.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundle1;
          } 
          a1.a(bundle);
          if (uri != null) {
            a1.b(uri);
          } else if (Build.VERSION.SDK_INT >= 23) {
            a1.b(b.h(paramObject));
          } 
          mediaDescriptionCompat = a1.a();
          mediaDescriptionCompat.i = paramObject;
          return mediaDescriptionCompat;
        } 
      } else {
        return mediaDescriptionCompat;
      } 
    } else {
      return mediaDescriptionCompat;
    } 
    Bundle bundle2 = bundle1;
  }
  
  public Object a() {
    if (this.i != null || Build.VERSION.SDK_INT < 21)
      return this.i; 
    Object object = a.a.a();
    a.a.a(object, this.a);
    a.a.a(object, this.b);
    a.a.b(object, this.c);
    a.a.c(object, this.d);
    a.a.a(object, this.e);
    a.a.a(object, this.f);
    Bundle bundle = this.g;
    if (Build.VERSION.SDK_INT < 23 && this.h != null) {
      if (bundle == null) {
        bundle = new Bundle();
        bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      } 
      bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
    } 
    a.a.a(object, bundle);
    if (Build.VERSION.SDK_INT >= 23)
      b.a.b(object, this.h); 
    this.i = a.a.a(object);
    return this.i;
  }
  
  public int describeContents() { return 0; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append(", ");
    stringBuilder.append(this.c);
    stringBuilder.append(", ");
    stringBuilder.append(this.d);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    if (Build.VERSION.SDK_INT < 21) {
      paramParcel.writeString(this.a);
      TextUtils.writeToParcel(this.b, paramParcel, paramInt);
      TextUtils.writeToParcel(this.c, paramParcel, paramInt);
      TextUtils.writeToParcel(this.d, paramParcel, paramInt);
      paramParcel.writeParcelable(this.e, paramInt);
      paramParcel.writeParcelable(this.f, paramInt);
      paramParcel.writeBundle(this.g);
      paramParcel.writeParcelable(this.h, paramInt);
      return;
    } 
    a.a(a(), paramParcel, paramInt);
  }
  
  public static final class a {
    private String a;
    
    private CharSequence b;
    
    private CharSequence c;
    
    private CharSequence d;
    
    private Bitmap e;
    
    private Uri f;
    
    private Bundle g;
    
    private Uri h;
    
    public a a(Bitmap param1Bitmap) {
      this.e = param1Bitmap;
      return this;
    }
    
    public a a(Uri param1Uri) {
      this.f = param1Uri;
      return this;
    }
    
    public a a(Bundle param1Bundle) {
      this.g = param1Bundle;
      return this;
    }
    
    public a a(CharSequence param1CharSequence) {
      this.b = param1CharSequence;
      return this;
    }
    
    public a a(String param1String) {
      this.a = param1String;
      return this;
    }
    
    public MediaDescriptionCompat a() { return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h); }
    
    public a b(Uri param1Uri) {
      this.h = param1Uri;
      return this;
    }
    
    public a b(CharSequence param1CharSequence) {
      this.c = param1CharSequence;
      return this;
    }
    
    public a c(CharSequence param1CharSequence) {
      this.d = param1CharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\media\MediaDescriptionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */