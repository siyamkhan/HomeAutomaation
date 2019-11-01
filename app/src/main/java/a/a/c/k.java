package a.a.a.a.a.c;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k extends ThreadPoolExecutor {
  private static final int a = Runtime.getRuntime().availableProcessors();
  
  private static final int b;
  
  private static final int c;
  
  static  {
    int i = a;
    b = i + 1;
    c = 1 + i * 2;
  }
  
  <T extends Runnable & b & l & i> k(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, c<T> paramc, ThreadFactory paramThreadFactory) {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramc, paramThreadFactory);
    prestartAllCoreThreads();
  }
  
  public static k a() { return a(b, c); }
  
  public static <T extends Runnable & b & l & i> k a(int paramInt1, int paramInt2) { return new k(paramInt1, paramInt2, 1L, TimeUnit.SECONDS, new c(), new a(10)); }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {
    l l = (l)paramRunnable;
    l.b(true);
    l.a(paramThrowable);
    b().d();
    super.afterExecute(paramRunnable, paramThrowable);
  }
  
  public c b() { return (c)super.getQueue(); }
  
  @TargetApi(9)
  public void execute(Runnable paramRunnable) {
    if (!j.a(paramRunnable))
      paramRunnable = newTaskFor(paramRunnable, null); 
    super.execute(paramRunnable);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT) { return new h(paramRunnable, paramT); }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable) { return new h(paramCallable); }
  
  protected static final class a implements ThreadFactory {
    private final int a;
    
    public a(int param1Int) { this.a = param1Int; }
    
    public Thread newThread(Runnable param1Runnable) {
      Thread thread = new Thread(param1Runnable);
      thread.setPriority(this.a);
      thread.setName("Queue");
      return thread;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */