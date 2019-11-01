package a.a.a.a.a.g;

import a.a.a.a.a.b.l;
import a.a.a.a.a.b.s;
import a.a.a.a.a.e.e;
import a.a.a.a.c;
import a.a.a.a.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class q {
  private final AtomicReference<t> a = new AtomicReference();
  
  private final CountDownLatch b = new CountDownLatch(1);
  
  private s c;
  
  private boolean d = false;
  
  private q() {}
  
  public static q a() { return a.a(); }
  
  private void a(t paramt) {
    this.a.set(paramt);
    this.b.countDown();
  }
  
  public q a(i parami, s params, e parame, String paramString1, String paramString2, String paramString3, l paraml) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: istore #9
    //   8: iload #9
    //   10: ifeq -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: aload_0
    //   18: getfield c : La/a/a/a/a/g/s;
    //   21: ifnonnull -> 234
    //   24: aload_1
    //   25: invokevirtual r : ()Landroid/content/Context;
    //   28: astore #10
    //   30: aload_2
    //   31: invokevirtual c : ()Ljava/lang/String;
    //   34: astore #11
    //   36: new a/a/a/a/a/b/g
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: aload #10
    //   45: invokevirtual a : (Landroid/content/Context;)Ljava/lang/String;
    //   48: astore #12
    //   50: aload_2
    //   51: invokevirtual i : ()Ljava/lang/String;
    //   54: astore #13
    //   56: new a/a/a/a/a/b/w
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore #14
    //   65: new a/a/a/a/a/g/k
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: astore #15
    //   74: new a/a/a/a/a/g/i
    //   77: dup
    //   78: aload_1
    //   79: invokespecial <init> : (La/a/a/a/i;)V
    //   82: astore #16
    //   84: aload #10
    //   86: invokestatic k : (Landroid/content/Context;)Ljava/lang/String;
    //   89: astore #17
    //   91: new a/a/a/a/a/g/l
    //   94: dup
    //   95: aload_1
    //   96: aload #6
    //   98: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   101: ldc 'https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings'
    //   103: iconst_1
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload #11
    //   111: aastore
    //   112: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   115: aload_3
    //   116: invokespecial <init> : (La/a/a/a/i;Ljava/lang/String;Ljava/lang/String;La/a/a/a/a/e/e;)V
    //   119: astore #18
    //   121: aload_2
    //   122: invokevirtual g : ()Ljava/lang/String;
    //   125: astore #19
    //   127: aload_2
    //   128: invokevirtual f : ()Ljava/lang/String;
    //   131: astore #20
    //   133: aload_2
    //   134: invokevirtual e : ()Ljava/lang/String;
    //   137: astore #21
    //   139: aload_2
    //   140: invokevirtual b : ()Ljava/lang/String;
    //   143: astore #22
    //   145: iconst_1
    //   146: anewarray java/lang/String
    //   149: astore #23
    //   151: aload #23
    //   153: iconst_0
    //   154: aload #10
    //   156: invokestatic m : (Landroid/content/Context;)Ljava/lang/String;
    //   159: aastore
    //   160: aload #23
    //   162: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   165: astore #24
    //   167: aload #13
    //   169: invokestatic a : (Ljava/lang/String;)La/a/a/a/a/b/m;
    //   172: invokevirtual a : ()I
    //   175: istore #25
    //   177: new a/a/a/a/a/g/w
    //   180: dup
    //   181: aload #12
    //   183: aload #19
    //   185: aload #20
    //   187: aload #21
    //   189: aload #22
    //   191: aload #24
    //   193: aload #5
    //   195: aload #4
    //   197: iload #25
    //   199: aload #17
    //   201: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   204: astore #26
    //   206: new a/a/a/a/a/g/j
    //   209: dup
    //   210: aload_1
    //   211: aload #26
    //   213: aload #14
    //   215: aload #15
    //   217: aload #16
    //   219: aload #18
    //   221: aload #7
    //   223: invokespecial <init> : (La/a/a/a/i;La/a/a/a/a/g/w;La/a/a/a/a/b/k;La/a/a/a/a/g/v;La/a/a/a/a/g/g;La/a/a/a/a/g/x;La/a/a/a/a/b/l;)V
    //   226: astore #27
    //   228: aload_0
    //   229: aload #27
    //   231: putfield c : La/a/a/a/a/g/s;
    //   234: aload_0
    //   235: iconst_1
    //   236: putfield d : Z
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_0
    //   242: areturn
    //   243: astore #8
    //   245: aload_0
    //   246: monitorexit
    //   247: aload #8
    //   249: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	243	finally
    //   17	234	243	finally
    //   234	239	243	finally }
  
  public t b() {
    try {
      this.b.await();
      return (t)this.a.get();
    } catch (InterruptedException interruptedException) {
      c.g().e("Fabric", "Interrupted while waiting for settings data.");
      return null;
    } 
  }
  
  public boolean c() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : La/a/a/a/a/g/s;
    //   6: invokeinterface a : ()La/a/a/a/a/g/t;
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: invokespecial a : (La/a/a/a/a/g/t;)V
    //   17: aload_2
    //   18: ifnull -> 26
    //   21: iconst_1
    //   22: istore_3
    //   23: goto -> 28
    //   26: iconst_0
    //   27: istore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally }
  
  public boolean d() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : La/a/a/a/a/g/s;
    //   6: getstatic a/a/a/a/a/g/r.b : La/a/a/a/a/g/r;
    //   9: invokeinterface a : (La/a/a/a/a/g/r;)La/a/a/a/a/g/t;
    //   14: astore_2
    //   15: aload_0
    //   16: aload_2
    //   17: invokespecial a : (La/a/a/a/a/g/t;)V
    //   20: aload_2
    //   21: ifnonnull -> 37
    //   24: invokestatic g : ()La/a/a/a/l;
    //   27: ldc 'Fabric'
    //   29: ldc 'Failed to force reload of settings from Crashlytics.'
    //   31: aconst_null
    //   32: invokeinterface e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   37: aload_2
    //   38: ifnull -> 46
    //   41: iconst_1
    //   42: istore_3
    //   43: goto -> 48
    //   46: iconst_0
    //   47: istore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: iload_3
    //   51: ireturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	52	finally
    //   24	37	52	finally }
  
  static class a {
    private static final q a = new q(null);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */