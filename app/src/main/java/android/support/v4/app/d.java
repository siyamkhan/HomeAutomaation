package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class d implements Parcelable {
  public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
      public d a(Parcel param1Parcel) { return new d(param1Parcel); }
      
      public d[] a(int param1Int) { return new d[param1Int]; }
    };
  
  final int[] a;
  
  final int b;
  
  final int c;
  
  final String d;
  
  final int e;
  
  final int f;
  
  final CharSequence g;
  
  final int h;
  
  final CharSequence i;
  
  final ArrayList<String> j;
  
  final ArrayList<String> k;
  
  final boolean l;
  
  public d(Parcel paramParcel) {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.h = paramParcel.readInt();
    this.i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.j = paramParcel.createStringArrayList();
    this.k = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.l = bool;
  }
  
  public d(c paramc) {
    int m = paramc.b.size();
    this.a = new int[m * 6];
    if (paramc.i) {
      byte b1 = 0;
      byte b2;
      for (b2 = 0; b1 < m; b2 = b4) {
        byte b3;
        c.a a1 = (c.a)paramc.b.get(b1);
        int[] arrayOfInt1 = this.a;
        boolean bool1 = b2 + true;
        arrayOfInt1[b2] = a1.a;
        int[] arrayOfInt2 = this.a;
        boolean bool2 = bool1 + true;
        if (a1.b != null) {
          b3 = a1.b.o;
        } else {
          b3 = -1;
        } 
        arrayOfInt2[bool1] = b3;
        int[] arrayOfInt3 = this.a;
        boolean bool3 = bool2 + true;
        arrayOfInt3[bool2] = a1.c;
        int[] arrayOfInt4 = this.a;
        boolean bool4 = bool3 + true;
        arrayOfInt4[bool3] = a1.d;
        int[] arrayOfInt5 = this.a;
        boolean bool5 = bool4 + true;
        arrayOfInt5[bool4] = a1.e;
        int[] arrayOfInt6 = this.a;
        byte b4 = bool5 + true;
        arrayOfInt6[bool5] = a1.f;
        b1++;
      } 
      this.b = paramc.g;
      this.c = paramc.h;
      this.d = paramc.k;
      this.e = paramc.m;
      this.f = paramc.n;
      this.g = paramc.o;
      this.h = paramc.p;
      this.i = paramc.q;
      this.j = paramc.r;
      this.k = paramc.s;
      this.l = paramc.t;
      return;
    } 
    throw new IllegalStateException("Not on back stack");
  }
  
  public c a(m paramm) {
    c c1 = new c(paramm);
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < this.a.length) {
      Object object;
      c.a a1 = new c.a();
      int[] arrayOfInt1 = this.a;
      boolean bool1 = b1 + true;
      a1.a = arrayOfInt1[b1];
      if (m.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Instantiate ");
        stringBuilder.append(c1);
        stringBuilder.append(" op #");
        stringBuilder.append(b2);
        stringBuilder.append(" base fragment #");
        stringBuilder.append(this.a[bool1]);
        Log.v("FragmentManager", stringBuilder.toString());
      } 
      int[] arrayOfInt2 = this.a;
      boolean bool2 = bool1 + true;
      int n = arrayOfInt2[bool1];
      if (n >= 0) {
        object = (g)paramm.f.get(n);
      } else {
        object = null;
      } 
      a1.b = object;
      int[] arrayOfInt3 = this.a;
      boolean bool3 = bool2 + true;
      a1.c = arrayOfInt3[bool2];
      boolean bool4 = bool3 + true;
      a1.d = arrayOfInt3[bool3];
      boolean bool5 = bool4 + true;
      a1.e = arrayOfInt3[bool4];
      byte b3 = bool5 + true;
      a1.f = arrayOfInt3[bool5];
      c1.c = a1.c;
      c1.d = a1.d;
      c1.e = a1.e;
      c1.f = a1.f;
      c1.a(a1);
      b2++;
      b1 = b3;
    } 
    c1.g = this.b;
    c1.h = this.c;
    c1.k = this.d;
    c1.m = this.e;
    c1.i = true;
    c1.n = this.f;
    c1.o = this.g;
    c1.p = this.h;
    c1.q = this.i;
    c1.r = this.j;
    c1.s = this.k;
    c1.t = this.l;
    c1.a(1);
    return c1;
  }
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
    paramParcel.writeStringList(this.j);
    paramParcel.writeStringList(this.k);
    paramParcel.writeInt(this.l);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */