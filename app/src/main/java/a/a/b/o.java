package a.a.a.a.a.b;

import a.a.a.a.c;
import a.a.a.a.l;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class o {
  public static ExecutorService a(String paramString) {
    ExecutorService executorService = Executors.newSingleThreadExecutor(c(paramString));
    a(paramString, executorService);
    return executorService;
  }
  
  private static final void a(String paramString, ExecutorService paramExecutorService) { a(paramString, paramExecutorService, 2L, TimeUnit.SECONDS); }
  
  public static final void a(String paramString, ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {
    Runtime runtime = Runtime.getRuntime();
    h h = new h(paramString, paramExecutorService, paramLong, paramTimeUnit) {
        public void a() {
          try {
            l l = c.g();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Executing shutdown hook for ");
            stringBuilder.append(this.a);
            l.a("Fabric", stringBuilder.toString());
            this.b.shutdown();
            if (!this.b.awaitTermination(this.c, this.d)) {
              l l1 = c.g();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(this.a);
              stringBuilder1.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
              l1.a("Fabric", stringBuilder1.toString());
              this.b.shutdownNow();
              return;
            } 
          } catch (InterruptedException interruptedException) {
            l l = c.g();
            Locale locale = Locale.US;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = this.a;
            l.a("Fabric", String.format(locale, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", arrayOfObject));
            this.b.shutdownNow();
          } 
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Crashlytics Shutdown Hook for ");
    stringBuilder.append(paramString);
    runtime.addShutdownHook(new Thread(h, stringBuilder.toString()));
  }
  
  public static ScheduledExecutorService b(String paramString) {
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(c(paramString));
    a(paramString, scheduledExecutorService);
    return scheduledExecutorService;
  }
  
  public static final ThreadFactory c(String paramString) { return new ThreadFactory(paramString, new AtomicLong(1L)) {
        public Thread newThread(Runnable param1Runnable) {
          Thread thread = Executors.defaultThreadFactory().newThread(new h(this, param1Runnable) {
                public void a() { this.a.run(); }
              });
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a);
          stringBuilder.append(this.b.getAndIncrement());
          thread.setName(stringBuilder.toString());
          return thread;
        }
      }; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */