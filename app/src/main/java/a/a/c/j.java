package a.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class j extends Object implements b<l>, i, l {
  private final List<l> a = new ArrayList();
  
  private final AtomicBoolean b = new AtomicBoolean(false);
  
  private final AtomicReference<Throwable> c = new AtomicReference(null);
  
  public static boolean a(Object paramObject) { // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: checkcast a/a/a/a/a/c/b
    //   6: astore_3
    //   7: aload_0
    //   8: checkcast a/a/a/a/a/c/l
    //   11: astore #4
    //   13: aload_0
    //   14: checkcast a/a/a/a/a/c/i
    //   17: astore #5
    //   19: aload_3
    //   20: ifnull -> 38
    //   23: aload #4
    //   25: ifnull -> 38
    //   28: aload #5
    //   30: ifnull -> 38
    //   33: iconst_1
    //   34: istore_1
    //   35: goto -> 39
    //   38: pop
    //   39: iload_1
    //   40: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	19	38	java/lang/ClassCastException }
  
  public void a(l paraml) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally }
  
  public void a(Throwable paramThrowable) { this.c.set(paramThrowable); }
  
  public e b() { return e.b; }
  
  public void b(boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iload_1
    //   7: invokevirtual set : (Z)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally }
  
  public Collection<l> c() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: invokestatic unmodifiableCollection : (Ljava/util/Collection;)Ljava/util/Collection;
    //   9: astore_2
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_2
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally }
  
  public int compareTo(Object paramObject) { return e.a(this, paramObject); }
  
  public boolean d() {
    Iterator iterator = c().iterator();
    while (iterator.hasNext()) {
      if (!((l)iterator.next()).f())
        return false; 
    } 
    return true;
  }
  
  public boolean f() { return this.b.get(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */