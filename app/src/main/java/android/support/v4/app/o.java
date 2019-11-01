package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

final class o implements Parcelable {
  public static final Parcelable.Creator<o> CREATOR = new Parcelable.Creator<o>() {
      public o a(Parcel param1Parcel) { return new o(param1Parcel); }
      
      public o[] a(int param1Int) { return new o[param1Int]; }
    };
  
  p[] a;
  
  int[] b;
  
  d[] c;
  
  int d = -1;
  
  int e;
  
  public o() {}
  
  public o(Parcel paramParcel) {
    this.a = (p[])paramParcel.createTypedArray(p.CREATOR);
    this.b = paramParcel.createIntArray();
    this.c = (d[])paramParcel.createTypedArray(d.CREATOR);
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedArray(this.a, paramInt);
    paramParcel.writeIntArray(this.b);
    paramParcel.writeTypedArray(this.c, paramInt);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */