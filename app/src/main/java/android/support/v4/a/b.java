package android.support.v4.a;

import android.support.v4.g.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b<D> extends Object {
  int a;
  
  a<D> b;
  
  boolean c;
  
  boolean d;
  
  boolean e;
  
  boolean f;
  
  boolean g;
  
  public String a(D paramD) {
    StringBuilder stringBuilder = new StringBuilder(64);
    d.a(paramD, stringBuilder);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public final void a() {
    this.c = true;
    this.e = false;
    this.d = false;
    b();
  }
  
  public void a(a<D> parama) {
    a a1 = this.b;
    if (a1 != null) {
      if (a1 == parama) {
        this.b = null;
        return;
      } 
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    } 
    throw new IllegalStateException("No listener register");
  }
  
  @Deprecated
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.b);
    if (this.c || this.f || this.g) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.c);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.f);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.g);
    } 
    if (this.d || this.e) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.d);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.e);
    } 
  }
  
  protected void b() {}
  
  public boolean c() { return d(); }
  
  protected boolean d() { return false; }
  
  public void e() {
    this.c = false;
    f();
  }
  
  protected void f() {}
  
  public void g() {
    this.d = true;
    h();
  }
  
  protected void h() {}
  
  public void i() {
    j();
    this.e = true;
    this.c = false;
    this.d = false;
    this.f = false;
    this.g = false;
  }
  
  protected void j() {}
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(64);
    d.a(this, stringBuilder);
    stringBuilder.append(" id=");
    stringBuilder.append(this.a);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public static interface a<D> {}
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */