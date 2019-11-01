package a.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class h<V> extends FutureTask<V> implements b<l>, i, l {
  final Object b;
  
  public h(Runnable paramRunnable, V paramV) {
    super(paramRunnable, paramV);
    this.b = a(paramRunnable);
  }
  
  public h(Callable<V> paramCallable) {
    super(paramCallable);
    this.b = a(paramCallable);
  }
  
  public <T extends b<l> & i & l> T a() { return (T)(b)this.b; }
  
  protected <T extends b<l> & i & l> T a(Object paramObject) { return j.a(paramObject) ? (T)(b)paramObject : (T)new j(); }
  
  public void a(l paraml) { ((b)a()).c(paraml); }
  
  public void a(Throwable paramThrowable) { ((l)a()).a(paramThrowable); }
  
  public e b() { return ((i)a()).b(); }
  
  public void b(boolean paramBoolean) { ((l)a()).b(paramBoolean); }
  
  public Collection<l> c() { return ((b)a()).c(); }
  
  public int compareTo(Object paramObject) { return ((i)a()).compareTo(paramObject); }
  
  public boolean d() { return ((b)a()).d(); }
  
  public boolean f() { return ((l)a()).f(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */