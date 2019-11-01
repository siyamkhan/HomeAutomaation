package a.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class f<Params, Progress, Result> extends a<Params, Progress, Result> implements b<l>, i, l {
  private final j a = new j();
  
  public void a(l paraml) {
    if (v_() == a.d.a) {
      ((b)g()).c(paraml);
      return;
    } 
    throw new IllegalStateException("Must not add Dependency after task is running");
  }
  
  public void a(Throwable paramThrowable) { ((l)g()).a(paramThrowable); }
  
  public final void a(ExecutorService paramExecutorService, Params... paramVarArgs) { a(new a(paramExecutorService, this), paramVarArgs); }
  
  public e b() { return ((i)g()).b(); }
  
  public void b(boolean paramBoolean) { ((l)g()).b(paramBoolean); }
  
  public Collection<l> c() { return ((b)g()).c(); }
  
  public int compareTo(Object paramObject) { return e.a(this, paramObject); }
  
  public boolean d() { return ((b)g()).d(); }
  
  public boolean f() { return ((l)g()).f(); }
  
  public <T extends b<l> & i & l> T g() { return (T)this.a; }
  
  private static class a<Result> extends Object implements Executor {
    private final Executor a;
    
    private final f b;
    
    public a(Executor param1Executor, f param1f) {
      this.a = param1Executor;
      this.b = param1f;
    }
    
    public void execute(Runnable param1Runnable) { this.a.execute(new h<Result>(this, param1Runnable, null) {
            public <T extends b<l> & i & l> T a() { return (T)f.a.a(this.a); }
          }); }
  }
  
  class null extends h<Result> {
    null(f this$0, Runnable param1Runnable, Object param1Object) { super(param1Runnable, param1Object); }
    
    public <T extends b<l> & i & l> T a() { return (T)f.a.a(this.a); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */