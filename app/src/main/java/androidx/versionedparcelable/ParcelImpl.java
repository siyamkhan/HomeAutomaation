package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
      public ParcelImpl a(Parcel param1Parcel) { return new ParcelImpl(param1Parcel); }
      
      public ParcelImpl[] a(int param1Int) { return new ParcelImpl[param1Int]; }
    };
  
  private final c a;
  
  protected ParcelImpl(Parcel paramParcel) { this.a = (new b(paramParcel)).h(); }
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) { (new b(paramParcel)).a(this.a); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\androidx\versionedparcelable\ParcelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */