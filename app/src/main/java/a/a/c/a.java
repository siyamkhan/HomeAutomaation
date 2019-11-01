package a.a.a.a.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<Params, Progress, Result> extends Object {
  private static final int a = Runtime.getRuntime().availableProcessors();
  
  public static final Executor b;
  
  public static final Executor c;
  
  private static final int d;
  
  private static final int e;
  
  private static final ThreadFactory f;
  
  private static final BlockingQueue<Runnable> g;
  
  private static final b h;
  
  private final e<Params, Result> j = new e<Params, Result>(this) {
      public Result call() {
        a.a(this.a).set(true);
        Process.setThreadPriority(10);
        a a1;
        return (Result)(a1 = this.a).a(a1, a1.a(this.b));
      }
    };
  
  private final FutureTask<Result> k = new FutureTask<Result>(this, this.j) {
      protected void done() {
        try {
          a.b(this.a, get());
          return;
        } catch (InterruptedException interruptedException) {
          Log.w("AsyncTask", interruptedException);
          return;
        } catch (ExecutionException executionException) {
          throw new RuntimeException("An error occured while executing doInBackground()", executionException.getCause());
        } catch (CancellationException cancellationException) {
          a.b(this.a, null);
          return;
        } 
      }
    };
  
  private final AtomicBoolean m = new AtomicBoolean();
  
  private final AtomicBoolean n = new AtomicBoolean();
  
  static  {
    int i1 = a;
    d = i1 + 1;
    e = 1 + i1 * 2;
    f = new ThreadFactory() {
        private final AtomicInteger a = new AtomicInteger(1);
        
        public Thread newThread(Runnable param1Runnable) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("AsyncTask #");
          stringBuilder.append(this.a.getAndIncrement());
          return new Thread(param1Runnable, stringBuilder.toString());
        }
      };
    g = new LinkedBlockingQueue(128);
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, g, f);
    b = threadPoolExecutor;
    c = new c(null);
    h = new b();
    i = c;
  }
  
  private void d(Result paramResult) {
    if (!this.n.get())
      e(paramResult); 
  }
  
  private Result e(Result paramResult) {
    h.obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  private void f(Result paramResult) {
    if (e()) {
      b(paramResult);
    } else {
      a(paramResult);
    } 
    this.l = d.c;
  }
  
  public final a<Params, Progress, Result> a(Executor paramExecutor, Params... paramVarArgs) {
    if (this.l != d.a) {
      switch (null.a[this.l.ordinal()]) {
        default:
          this.l = d.b;
          a();
          this.j.b = paramVarArgs;
          paramExecutor.execute(this.k);
          return this;
        case 2:
          throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        case 1:
          break;
      } 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    } 
  }
  
  protected abstract Result a(Params... paramVarArgs);
  
  protected void a() {}
  
  protected void a(Result paramResult) {}
  
  public final boolean a(boolean paramBoolean) {
    this.m.set(true);
    return this.k.cancel(paramBoolean);
  }
  
  protected void b(Result paramResult) { w_(); }
  
  protected void b(Progress... paramVarArgs) {}
  
  public final boolean e() { return this.m.get(); }
  
  public final d v_() { return this.l; }
  
  protected void w_() {}
  
  private static class a<Data> extends Object {
    final a a;
    
    final Data[] b;
    
    a(a param1a, Data... param1VarArgs) {
      this.a = param1a;
      this.b = param1VarArgs;
    }
  }
  
  private static class b extends Handler {
    public b() { super(Looper.getMainLooper()); }
    
    public void handleMessage(Message param1Message) {
      a.a a = (a.a)param1Message.obj;
      switch (param1Message.what) {
        default:
          return;
        case 2:
          a.a.b(a.b);
          return;
        case 1:
          break;
      } 
      a.c(a.a, a.b[0]);
    }
  }
  
  private static class c implements Executor {
    final LinkedList<Runnable> a = new LinkedList();
    
    Runnable b;
    
    private c() {}
    
    protected void a() { // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/LinkedList;
      //   6: invokevirtual poll : ()Ljava/lang/Object;
      //   9: checkcast java/lang/Runnable
      //   12: astore_2
      //   13: aload_0
      //   14: aload_2
      //   15: putfield b : Ljava/lang/Runnable;
      //   18: aload_2
      //   19: ifnull -> 34
      //   22: getstatic a/a/a/a/a/c/a.b : Ljava/util/concurrent/Executor;
      //   25: aload_0
      //   26: getfield b : Ljava/lang/Runnable;
      //   29: invokeinterface execute : (Ljava/lang/Runnable;)V
      //   34: aload_0
      //   35: monitorexit
      //   36: return
      //   37: astore_1
      //   38: aload_0
      //   39: monitorexit
      //   40: aload_1
      //   41: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	37	finally
      //   22	34	37	finally }
    
    public void execute(Runnable param1Runnable) { // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/LinkedList;
      //   6: new a/a/a/a/a/c/a$c$1
      //   9: dup
      //   10: aload_0
      //   11: aload_1
      //   12: invokespecial <init> : (La/a/a/a/a/c/a$c;Ljava/lang/Runnable;)V
      //   15: invokevirtual offer : (Ljava/lang/Object;)Z
      //   18: pop
      //   19: aload_0
      //   20: getfield b : Ljava/lang/Runnable;
      //   23: ifnonnull -> 30
      //   26: aload_0
      //   27: invokevirtual a : ()V
      //   30: aload_0
      //   31: monitorexit
      //   32: return
      //   33: astore_2
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_2
      //   37: athrow
      // Exception table:
      //   from	to	target	type
      //   2	30	33	finally }
  }
  
  class null implements Runnable {
    null(a this$0, Runnable param1Runnable) {}
    
    public void run() {
      try {
        this.a.run();
        return;
      } finally {
        this.b.a();
      } 
    }
  }
  
  public enum d {
    a, b, c;
    
    static  {
      d[] arrayOfd = new d[3];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      d = arrayOfd;
    }
  }
  
  private static abstract class e<Params, Result> extends Object implements Callable<Result> {
    Params[] b;
    
    private e() {}
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */