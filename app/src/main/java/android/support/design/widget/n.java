package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class n {
  private static n a;
  
  private final Object b = new Object();
  
  private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          if (param1Message.what != 0)
            return false; 
          this.a.a((n.b)param1Message.obj);
          return true;
        }
      });
  
  private b d;
  
  private b e;
  
  static n a() {
    if (a == null)
      a = new n(); 
    return a;
  }
  
  private boolean a(b paramb, int paramInt) {
    a a1 = (a)paramb.a.get();
    if (a1 != null) {
      this.c.removeCallbacksAndMessages(paramb);
      a1.a(paramInt);
      return true;
    } 
    return false;
  }
  
  private void b() {
    b b1 = this.e;
    if (b1 != null) {
      this.d = b1;
      this.e = null;
      a a1 = (a)this.d.a.get();
      if (a1 != null) {
        a1.a();
        return;
      } 
      this.d = null;
    } 
  }
  
  private void b(b paramb) {
    if (paramb.b == -2)
      return; 
    int i = 2750;
    if (paramb.b > 0) {
      i = paramb.b;
    } else if (paramb.b == -1) {
      i = 1500;
    } 
    this.c.removeCallbacksAndMessages(paramb);
    Handler handler = this.c;
    handler.sendMessageDelayed(Message.obtain(handler, 0, paramb), i);
  }
  
  private boolean f(a parama) {
    b b1 = this.d;
    return (b1 != null && b1.a(parama));
  }
  
  private boolean g(a parama) {
    b b1 = this.e;
    return (b1 != null && b1.a(parama));
  }
  
  public void a(a parama) {
    synchronized (this.b) {
      if (f(parama)) {
        this.d = null;
        if (this.e != null)
          b(); 
      } 
      return;
    } 
  }
  
  public void a(a parama, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial f : (Landroid/support/design/widget/n$a;)Z
    //   12: ifeq -> 32
    //   15: aload_0
    //   16: getfield d : Landroid/support/design/widget/n$b;
    //   19: astore #5
    //   21: aload_0
    //   22: aload #5
    //   24: iload_2
    //   25: invokespecial a : (Landroid/support/design/widget/n$b;I)Z
    //   28: pop
    //   29: goto -> 49
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial g : (Landroid/support/design/widget/n$a;)Z
    //   37: ifeq -> 49
    //   40: aload_0
    //   41: getfield e : Landroid/support/design/widget/n$b;
    //   44: astore #5
    //   46: goto -> 21
    //   49: aload_3
    //   50: monitorexit
    //   51: return
    //   52: astore #4
    //   54: aload_3
    //   55: monitorexit
    //   56: aload #4
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   7	21	52	finally
    //   21	29	52	finally
    //   32	46	52	finally
    //   49	51	52	finally
    //   54	56	52	finally }
  
  void a(b paramb) {
    synchronized (this.b) {
      if (this.d == paramb || this.e == paramb)
        a(paramb, 2); 
      return;
    } 
  }
  
  public void b(a parama) {
    synchronized (this.b) {
      if (f(parama))
        b(this.d); 
      return;
    } 
  }
  
  public void c(a parama) {
    synchronized (this.b) {
      if (f(parama) && !this.d.c) {
        this.d.c = true;
        this.c.removeCallbacksAndMessages(this.d);
      } 
      return;
    } 
  }
  
  public void d(a parama) {
    synchronized (this.b) {
      if (f(parama) && this.d.c) {
        this.d.c = false;
        b(this.d);
      } 
      return;
    } 
  }
  
  public boolean e(a parama) {
    synchronized (this.b) {
      if (f(parama) || g(parama))
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  static interface a {
    void a();
    
    void a(int param1Int);
  }
  
  private static class b {
    final WeakReference<n.a> a;
    
    int b;
    
    boolean c;
    
    boolean a(n.a param1a) { return (param1a != null && this.a.get() == param1a); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */