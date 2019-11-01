package android.support.v4.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

public class b implements Parcelable {
  public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
      public b a(Parcel param1Parcel) { return new b(param1Parcel); }
      
      public b[] a(int param1Int) { return new b[param1Int]; }
    };
  
  final boolean a = false;
  
  final Handler b = null;
  
  a c;
  
  b(Parcel paramParcel) { this.c = a.a.a(paramParcel.readStrongBinder()); }
  
  protected void a(int paramInt, Bundle paramBundle) {}
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Landroid/support/v4/d/a;
    //   6: ifnonnull -> 21
    //   9: aload_0
    //   10: new android/support/v4/d/b$a
    //   13: dup
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/support/v4/d/b;)V
    //   18: putfield c : Landroid/support/v4/d/a;
    //   21: aload_1
    //   22: aload_0
    //   23: getfield c : Landroid/support/v4/d/a;
    //   26: invokeinterface asBinder : ()Landroid/os/IBinder;
    //   31: invokevirtual writeStrongBinder : (Landroid/os/IBinder;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	37	finally
    //   21	36	37	finally
    //   38	40	37	finally }
  
  class a extends a.a {
    a(b this$0) {}
    
    public void a(int param1Int, Bundle param1Bundle) {
      if (this.a.b != null) {
        this.a.b.post(new b.b(this.a, param1Int, param1Bundle));
        return;
      } 
      this.a.a(param1Int, param1Bundle);
    }
  }
  
  class b implements Runnable {
    final int a;
    
    final Bundle b;
    
    b(b this$0, int param1Int, Bundle param1Bundle) {
      this.a = param1Int;
      this.b = param1Bundle;
    }
    
    public void run() { this.c.a(this.a, this.b); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */