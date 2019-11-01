package a.a.a.a.a.a;

import android.content.Context;

public abstract class a<T> extends Object implements c<T> {
  private final c<T> a;
  
  public a(c<T> paramc) { this.a = paramc; }
  
  private void b(Context paramContext, T paramT) {
    if (paramT != null) {
      a(paramContext, paramT);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected abstract T a(Context paramContext);
  
  public final T a(Context paramContext, d<T> paramd) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual a : (Landroid/content/Context;)Ljava/lang/Object;
    //   7: astore #4
    //   9: aload #4
    //   11: ifnonnull -> 57
    //   14: aload_0
    //   15: getfield a : La/a/a/a/a/a/c;
    //   18: ifnull -> 37
    //   21: aload_0
    //   22: getfield a : La/a/a/a/a/a/c;
    //   25: aload_1
    //   26: aload_2
    //   27: invokeinterface a : (Landroid/content/Context;La/a/a/a/a/a/d;)Ljava/lang/Object;
    //   32: astore #5
    //   34: goto -> 46
    //   37: aload_2
    //   38: aload_1
    //   39: invokeinterface a : (Landroid/content/Context;)Ljava/lang/Object;
    //   44: astore #5
    //   46: aload #5
    //   48: astore #4
    //   50: aload_0
    //   51: aload_1
    //   52: aload #4
    //   54: invokespecial b : (Landroid/content/Context;Ljava/lang/Object;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload #4
    //   61: areturn
    //   62: astore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	62	finally
    //   14	34	62	finally
    //   37	46	62	finally
    //   50	57	62	finally }
  
  protected abstract void a(Context paramContext, T paramT);
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */