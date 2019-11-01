package android.support.design.i;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.g.l;
import android.support.v4.h.a;

public class a extends a {
  public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() {
      public a a(Parcel param1Parcel) { return new a(param1Parcel, null, null); }
      
      public a a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new a(param1Parcel, param1ClassLoader, null); }
      
      public a[] a(int param1Int) { return new a[param1Int]; }
    };
  
  public final l<String, Bundle> a;
  
  private a(Parcel paramParcel, ClassLoader paramClassLoader) {
    super(paramParcel, paramClassLoader);
    int i = paramParcel.readInt();
    String[] arrayOfString = new String[i];
    paramParcel.readStringArray(arrayOfString);
    Bundle[] arrayOfBundle = new Bundle[i];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.a = new l(i);
    for (byte b = 0; b < i; b++)
      this.a.put(arrayOfString[b], arrayOfBundle[b]); 
  }
  
  public a(Parcelable paramParcelable) {
    super(paramParcelable);
    this.a = new l();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ExtendableSavedState{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" states=");
    stringBuilder.append(this.a);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.a.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    for (byte b = 0; b < i; b++) {
      arrayOfString[b] = (String)this.a.b(b);
      arrayOfBundle[b] = (Bundle)this.a.c(b);
    } 
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */