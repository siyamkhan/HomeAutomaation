package a.a.a.a;

import a.a.a.a.a.b.s;
import a.a.a.a.a.c.d;
import a.a.a.a.a.c.l;
import android.content.Context;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class i<Result> extends Object implements Comparable<i> {
  c e;
  
  h<Result> f = new h(this);
  
  Context g;
  
  f<Result> h;
  
  s i;
  
  final d j = (d)getClass().getAnnotation(d.class);
  
  public int a(i parami) { return b(parami) ? 1 : (parami.b(this) ? -1 : ((u() && !parami.u()) ? 1 : ((!u() && parami.u()) ? -1 : 0))); }
  
  public abstract String a();
  
  void a(Context paramContext, c paramc, f<Result> paramf, s params) {
    this.e = paramc;
    this.g = new d(paramContext, b(), t());
    this.h = paramf;
    this.i = params;
  }
  
  protected void a(Result paramResult) {}
  
  public abstract String b();
  
  protected void b(Result paramResult) {}
  
  boolean b(i parami) {
    if (u()) {
      Class[] arrayOfClass = this.j.a();
      int k = arrayOfClass.length;
      for (byte b = 0; b < k; b++) {
        if (arrayOfClass[b].isAssignableFrom(parami.getClass()))
          return true; 
      } 
    } 
    return false;
  }
  
  protected boolean b_() { return true; }
  
  protected abstract Result e();
  
  final void p() {
    h h1 = this.f;
    ExecutorService executorService = this.e.e();
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = (Void)null;
    h1.a(executorService, arrayOfVoid);
  }
  
  protected s q() { return this.i; }
  
  public Context r() { return this.g; }
  
  public c s() { return this.e; }
  
  public String t() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(".Fabric");
    stringBuilder.append(File.separator);
    stringBuilder.append(b());
    return stringBuilder.toString();
  }
  
  boolean u() { return (this.j != null); }
  
  protected Collection<l> v() { return this.f.c(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */