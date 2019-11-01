package a.a.a.a.a.b;

import android.os.Process;

public abstract class h implements Runnable {
  protected abstract void a();
  
  public final void run() {
    Process.setThreadPriority(10);
    a();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */