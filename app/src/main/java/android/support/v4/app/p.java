package android.support.v4.app;

import android.arch.lifecycle.p;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

final class p implements Parcelable {
  public static final Parcelable.Creator<p> CREATOR = new Parcelable.Creator<p>() {
      public p a(Parcel param1Parcel) { return new p(param1Parcel); }
      
      public p[] a(int param1Int) { return new p[param1Int]; }
    };
  
  final String a;
  
  final int b;
  
  final boolean c;
  
  final int d;
  
  final int e;
  
  final String f;
  
  final boolean g;
  
  final boolean h;
  
  final Bundle i;
  
  final boolean j;
  
  Bundle k;
  
  g l;
  
  p(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    int m = paramParcel.readInt();
    boolean bool1 = true;
    if (m != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.c = bool2;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    this.g = bool3;
    if (paramParcel.readInt() != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    this.h = bool4;
    this.i = paramParcel.readBundle();
    if (paramParcel.readInt() == 0)
      bool1 = false; 
    this.j = bool1;
    this.k = paramParcel.readBundle();
  }
  
  p(g paramg) {
    this.a = paramg.getClass().getName();
    this.b = paramg.o;
    this.c = paramg.w;
    this.d = paramg.H;
    this.e = paramg.I;
    this.f = paramg.J;
    this.g = paramg.M;
    this.h = paramg.L;
    this.i = paramg.q;
    this.j = paramg.K;
  }
  
  public g a(k paramk, i parami, g paramg, n paramn, p paramp) {
    if (this.l == null) {
      g g2;
      Context context = paramk.g();
      Bundle bundle1 = this.i;
      if (bundle1 != null)
        bundle1.setClassLoader(context.getClassLoader()); 
      if (parami != null) {
        g2 = parami.a(context, this.a, this.i);
      } else {
        g2 = g.a(context, this.a, this.i);
      } 
      this.l = g2;
      Bundle bundle2 = this.k;
      if (bundle2 != null) {
        bundle2.setClassLoader(context.getClassLoader());
        this.l.l = this.k;
      } 
      this.l.a(this.b, paramg);
      g g3 = this.l;
      g3.w = this.c;
      g3.y = true;
      g3.H = this.d;
      g3.I = this.e;
      g3.J = this.f;
      g3.M = this.g;
      g3.L = this.h;
      g3.K = this.j;
      g3.B = paramk.b;
      if (m.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Instantiated fragment ");
        stringBuilder.append(this.l);
        Log.v("FragmentManager", stringBuilder.toString());
      } 
    } 
    g g1 = this.l;
    g1.E = paramn;
    g1.F = paramp;
    return g1;
  }
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeBundle(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeBundle(this.k);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */