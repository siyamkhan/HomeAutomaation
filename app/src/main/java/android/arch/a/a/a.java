package android.arch.a.a;

import java.util.concurrent.Executor;

public class a extends c {
  private static final Executor d = new Executor() {
      public void execute(Runnable param1Runnable) { a.a().b(param1Runnable); }
    };
  
  private static final Executor e = new Executor() {
      public void execute(Runnable param1Runnable) { a.a().a(param1Runnable); }
    };
  
  private c b = this.c;
  
  private c c = new b();
  
  public static a a() { // Byte code:
    //   0: getstatic android/arch/a/a/a.a : Landroid/arch/a/a/a;
    //   3: ifnull -> 10
    //   6: getstatic android/arch/a/a/a.a : Landroid/arch/a/a/a;
    //   9: areturn
    //   10: ldc android/arch/a/a/a
    //   12: monitorenter
    //   13: getstatic android/arch/a/a/a.a : Landroid/arch/a/a/a;
    //   16: ifnonnull -> 29
    //   19: new android/arch/a/a/a
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: putstatic android/arch/a/a/a.a : Landroid/arch/a/a/a;
    //   29: ldc android/arch/a/a/a
    //   31: monitorexit
    //   32: getstatic android/arch/a/a/a.a : Landroid/arch/a/a/a;
    //   35: areturn
    //   36: astore_0
    //   37: ldc android/arch/a/a/a
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   13	29	36	finally
    //   29	32	36	finally
    //   37	40	36	finally }
  
  public void a(Runnable paramRunnable) { this.b.a(paramRunnable); }
  
  public void b(Runnable paramRunnable) { this.b.b(paramRunnable); }
  
  public boolean b() { return this.b.b(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */