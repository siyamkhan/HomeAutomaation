package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.d.b;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
  static final boolean a = Log.isLoggable("MediaBrowserCompat", 3);
  
  private static class CustomActionResultReceiver extends b {
    private final String d;
    
    private final Bundle e;
    
    private final MediaBrowserCompat.a f;
    
    protected void a(int param1Int, Bundle param1Bundle) {
      StringBuilder stringBuilder;
      MediaBrowserCompat.a a1 = this.f;
      if (a1 == null)
        return; 
      switch (param1Int) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown result code: ");
          stringBuilder.append(param1Int);
          stringBuilder.append(" (extras=");
          stringBuilder.append(this.e);
          stringBuilder.append(", resultData=");
          stringBuilder.append(param1Bundle);
          stringBuilder.append(")");
          Log.w("MediaBrowserCompat", stringBuilder.toString());
          return;
        case 1:
          a1.a(this.d, this.e, param1Bundle);
          return;
        case 0:
          a1.b(this.d, this.e, param1Bundle);
          return;
        case -1:
          break;
      } 
      a1.c(this.d, this.e, param1Bundle);
    }
  }
  
  private static class ItemReceiver extends b {
    private final String d;
    
    private final MediaBrowserCompat.b e;
    
    protected void a(int param1Int, Bundle param1Bundle) {
      if (param1Bundle != null)
        param1Bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader()); 
      if (param1Int != 0 || param1Bundle == null || !param1Bundle.containsKey("media_item")) {
        this.e.a(this.d);
        return;
      } 
      Parcelable parcelable = param1Bundle.getParcelable("media_item");
      if (parcelable == null || parcelable instanceof MediaBrowserCompat.MediaItem) {
        this.e.a((MediaBrowserCompat.MediaItem)parcelable);
        return;
      } 
      this.e.a(this.d);
    }
  }
  
  public static class MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
        public MediaBrowserCompat.MediaItem a(Parcel param2Parcel) { return new MediaBrowserCompat.MediaItem(param2Parcel); }
        
        public MediaBrowserCompat.MediaItem[] a(int param2Int) { return new MediaBrowserCompat.MediaItem[param2Int]; }
      };
    
    private final int a;
    
    private final MediaDescriptionCompat b;
    
    MediaItem(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(param1Parcel);
    }
    
    public int describeContents() { return 0; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("MediaItem{");
      stringBuilder.append("mFlags=");
      stringBuilder.append(this.a);
      stringBuilder.append(", mDescription=");
      stringBuilder.append(this.b);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      this.b.writeToParcel(param1Parcel, param1Int);
    }
  }
  
  static final class null extends Object implements Parcelable.Creator<MediaItem> {
    public MediaBrowserCompat.MediaItem a(Parcel param1Parcel) { return new MediaBrowserCompat.MediaItem(param1Parcel); }
    
    public MediaBrowserCompat.MediaItem[] a(int param1Int) { return new MediaBrowserCompat.MediaItem[param1Int]; }
  }
  
  private static class SearchResultReceiver extends b {
    private final String d;
    
    private final Bundle e;
    
    private final MediaBrowserCompat.c f;
    
    protected void a(int param1Int, Bundle param1Bundle) {
      if (param1Bundle != null)
        param1Bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader()); 
      if (param1Int != 0 || param1Bundle == null || !param1Bundle.containsKey("search_results")) {
        this.f.a(this.d, this.e);
        return;
      } 
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("search_results");
      ArrayList arrayList = null;
      if (arrayOfParcelable != null) {
        arrayList = new ArrayList();
        int i = arrayOfParcelable.length;
        for (byte b1 = 0; b1 < i; b1++)
          arrayList.add((MediaBrowserCompat.MediaItem)arrayOfParcelable[b1]); 
      } 
      this.f.a(this.d, this.e, arrayList);
    }
  }
  
  public static abstract class a {
    public void a(String param1String, Bundle param1Bundle1, Bundle param1Bundle2) {}
    
    public void b(String param1String, Bundle param1Bundle1, Bundle param1Bundle2) {}
    
    public void c(String param1String, Bundle param1Bundle1, Bundle param1Bundle2) {}
  }
  
  public static abstract class b {
    public void a(MediaBrowserCompat.MediaItem param1MediaItem) {}
    
    public void a(String param1String) {}
  }
  
  public static abstract class c {
    public void a(String param1String, Bundle param1Bundle) {}
    
    public void a(String param1String, Bundle param1Bundle, List<MediaBrowserCompat.MediaItem> param1List) {}
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\media\MediaBrowserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */