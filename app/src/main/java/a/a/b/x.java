package a.a.a.a.a.b;

import android.util.Log;

public class x {
  private final String a;
  
  private final String b;
  
  private final boolean c;
  
  private long d;
  
  private long e;
  
  public x(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true ^ Log.isLoggable(paramString2, 2);
  }
  
  private void c() {
    String str = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(": ");
    stringBuilder.append(this.e);
    stringBuilder.append("ms");
    Log.v(str, stringBuilder.toString());
  }
  
  public void a() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic elapsedRealtime : ()J
    //   18: putfield d : J
    //   21: aload_0
    //   22: lconst_0
    //   23: putfield e : J
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally }
  
  public void b() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield e : J
    //   18: lstore_3
    //   19: lload_3
    //   20: lconst_0
    //   21: lcmp
    //   22: ifeq -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokestatic elapsedRealtime : ()J
    //   32: aload_0
    //   33: getfield d : J
    //   36: lsub
    //   37: putfield e : J
    //   40: aload_0
    //   41: invokespecial c : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	19	47	finally
    //   28	44	47	finally }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */