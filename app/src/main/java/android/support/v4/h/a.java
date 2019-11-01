package android.support.v4.h;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class a implements Parcelable {
  public static final Parcelable.Creator<a> CREATOR;
  
  public static final a d = new a() {
    
    };
  
  private final Parcelable a;
  
  static  {
    CREATOR = new Parcelable.ClassLoaderCreator<a>() {
        public a a(Parcel param1Parcel) { return a(param1Parcel, null); }
        
        public a a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
          if (param1Parcel.readParcelable(param1ClassLoader) == null)
            return a.d; 
          throw new IllegalStateException("superState must be null");
        }
        
        public a[] a(int param1Int) { return new a[param1Int]; }
      };
  }
  
  private a() { this.a = null; }
  
  protected a(Parcel paramParcel, ClassLoader paramClassLoader) {
    Parcelable parcelable = paramParcel.readParcelable(paramClassLoader);
    if (parcelable == null)
      parcelable = d; 
    this.a = parcelable;
  }
  
  protected a(Parcelable paramParcelable) {
    if (paramParcelable != null) {
      if (paramParcelable == d)
        paramParcelable = null; 
      this.a = paramParcelable;
      return;
    } 
    throw new IllegalArgumentException("superState must not be null");
  }
  
  public final Parcelable a() { return this.a; }
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) { paramParcel.writeParcelable(this.a, paramInt); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */