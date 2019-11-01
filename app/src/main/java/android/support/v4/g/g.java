package android.support.v4.g;

import java.util.LinkedHashMap;

public class g<K, V> extends Object {
  private final LinkedHashMap<K, V> a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  public g(int paramInt) {
    if (paramInt > 0) {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int c(K paramK, V paramV) {
    int i = b(paramK, paramV);
    if (i >= 0)
      return i; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Negative size: ");
    stringBuilder.append(paramK);
    stringBuilder.append("=");
    stringBuilder.append(paramV);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public final V a(K paramK) { // Byte code:
    //   0: aload_1
    //   1: ifnull -> 161
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield a : Ljava/util/LinkedHashMap;
    //   10: aload_1
    //   11: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull -> 33
    //   19: aload_0
    //   20: iconst_1
    //   21: aload_0
    //   22: getfield g : I
    //   25: iadd
    //   26: putfield g : I
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: areturn
    //   33: aload_0
    //   34: iconst_1
    //   35: aload_0
    //   36: getfield h : I
    //   39: iadd
    //   40: putfield h : I
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore #4
    //   52: aload #4
    //   54: ifnonnull -> 59
    //   57: aconst_null
    //   58: areturn
    //   59: aload_0
    //   60: monitorenter
    //   61: aload_0
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield e : I
    //   67: iadd
    //   68: putfield e : I
    //   71: aload_0
    //   72: getfield a : Ljava/util/LinkedHashMap;
    //   75: aload_1
    //   76: aload #4
    //   78: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore #6
    //   83: aload #6
    //   85: ifnull -> 102
    //   88: aload_0
    //   89: getfield a : Ljava/util/LinkedHashMap;
    //   92: aload_1
    //   93: aload #6
    //   95: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: goto -> 118
    //   102: aload_0
    //   103: aload_0
    //   104: getfield b : I
    //   107: aload_0
    //   108: aload_1
    //   109: aload #4
    //   111: invokespecial c : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   114: iadd
    //   115: putfield b : I
    //   118: aload_0
    //   119: monitorexit
    //   120: aload #6
    //   122: ifnull -> 138
    //   125: aload_0
    //   126: iconst_0
    //   127: aload_1
    //   128: aload #4
    //   130: aload #6
    //   132: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   135: aload #6
    //   137: areturn
    //   138: aload_0
    //   139: aload_0
    //   140: getfield c : I
    //   143: invokevirtual a : (I)V
    //   146: aload #4
    //   148: areturn
    //   149: astore #5
    //   151: aload_0
    //   152: monitorexit
    //   153: aload #5
    //   155: athrow
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: new java/lang/NullPointerException
    //   164: dup
    //   165: ldc 'key == null'
    //   167: invokespecial <init> : (Ljava/lang/String;)V
    //   170: athrow
    // Exception table:
    //   from	to	target	type
    //   6	15	156	finally
    //   19	31	156	finally
    //   33	45	156	finally
    //   61	83	149	finally
    //   88	99	149	finally
    //   102	118	149	finally
    //   118	120	149	finally
    //   151	153	149	finally
    //   157	159	156	finally }
  
  public final V a(K paramK, V paramV) { // Byte code:
    //   0: aload_1
    //   1: ifnull -> 99
    //   4: aload_2
    //   5: ifnull -> 99
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: iconst_1
    //   12: aload_0
    //   13: getfield d : I
    //   16: iadd
    //   17: putfield d : I
    //   20: aload_0
    //   21: aload_0
    //   22: getfield b : I
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial c : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   31: iadd
    //   32: putfield b : I
    //   35: aload_0
    //   36: getfield a : Ljava/util/LinkedHashMap;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore #4
    //   46: aload #4
    //   48: ifnull -> 67
    //   51: aload_0
    //   52: aload_0
    //   53: getfield b : I
    //   56: aload_0
    //   57: aload_1
    //   58: aload #4
    //   60: invokespecial c : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   63: isub
    //   64: putfield b : I
    //   67: aload_0
    //   68: monitorexit
    //   69: aload #4
    //   71: ifnull -> 83
    //   74: aload_0
    //   75: iconst_0
    //   76: aload_1
    //   77: aload #4
    //   79: aload_2
    //   80: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   83: aload_0
    //   84: aload_0
    //   85: getfield c : I
    //   88: invokevirtual a : (I)V
    //   91: aload #4
    //   93: areturn
    //   94: astore_3
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_3
    //   98: athrow
    //   99: new java/lang/NullPointerException
    //   102: dup
    //   103: ldc 'key == null || value == null'
    //   105: invokespecial <init> : (Ljava/lang/String;)V
    //   108: athrow
    // Exception table:
    //   from	to	target	type
    //   10	46	94	finally
    //   51	67	94	finally
    //   67	69	94	finally
    //   95	97	94	finally }
  
  public void a(int paramInt) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : I
    //   6: iflt -> 142
    //   9: aload_0
    //   10: getfield a : Ljava/util/LinkedHashMap;
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifeq -> 26
    //   19: aload_0
    //   20: getfield b : I
    //   23: ifne -> 142
    //   26: aload_0
    //   27: getfield b : I
    //   30: iload_1
    //   31: if_icmple -> 139
    //   34: aload_0
    //   35: getfield a : Ljava/util/LinkedHashMap;
    //   38: invokevirtual isEmpty : ()Z
    //   41: ifeq -> 47
    //   44: goto -> 139
    //   47: aload_0
    //   48: getfield a : Ljava/util/LinkedHashMap;
    //   51: invokevirtual entrySet : ()Ljava/util/Set;
    //   54: invokeinterface iterator : ()Ljava/util/Iterator;
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: checkcast java/util/Map$Entry
    //   67: astore #6
    //   69: aload #6
    //   71: invokeinterface getKey : ()Ljava/lang/Object;
    //   76: astore #7
    //   78: aload #6
    //   80: invokeinterface getValue : ()Ljava/lang/Object;
    //   85: astore #8
    //   87: aload_0
    //   88: getfield a : Ljava/util/LinkedHashMap;
    //   91: aload #7
    //   93: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_0
    //   98: aload_0
    //   99: getfield b : I
    //   102: aload_0
    //   103: aload #7
    //   105: aload #8
    //   107: invokespecial c : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   110: isub
    //   111: putfield b : I
    //   114: aload_0
    //   115: iconst_1
    //   116: aload_0
    //   117: getfield f : I
    //   120: iadd
    //   121: putfield f : I
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_0
    //   127: iconst_1
    //   128: aload #7
    //   130: aload #8
    //   132: aconst_null
    //   133: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   136: goto -> 0
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: new java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial <init> : ()V
    //   149: astore_3
    //   150: aload_3
    //   151: aload_0
    //   152: invokevirtual getClass : ()Ljava/lang/Class;
    //   155: invokevirtual getName : ()Ljava/lang/String;
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_3
    //   163: ldc '.sizeOf() is reporting inconsistent results!'
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: new java/lang/IllegalStateException
    //   172: dup
    //   173: aload_3
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: invokespecial <init> : (Ljava/lang/String;)V
    //   180: athrow
    //   181: astore_2
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_2
    //   185: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	181	finally
    //   26	44	181	finally
    //   47	126	181	finally
    //   139	141	181	finally
    //   142	181	181	finally
    //   182	184	181	finally }
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  protected int b(K paramK, V paramV) { return 1; }
  
  protected V b(K paramK) { return null; }
  
  public final String toString() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : I
    //   6: aload_0
    //   7: getfield h : I
    //   10: iadd
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq -> 102
    //   16: bipush #100
    //   18: aload_0
    //   19: getfield g : I
    //   22: imul
    //   23: iload_2
    //   24: idiv
    //   25: istore_3
    //   26: goto -> 29
    //   29: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   32: astore #4
    //   34: iconst_4
    //   35: anewarray java/lang/Object
    //   38: astore #5
    //   40: aload #5
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield c : I
    //   47: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   50: aastore
    //   51: aload #5
    //   53: iconst_1
    //   54: aload_0
    //   55: getfield g : I
    //   58: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   61: aastore
    //   62: aload #5
    //   64: iconst_2
    //   65: aload_0
    //   66: getfield h : I
    //   69: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   72: aastore
    //   73: aload #5
    //   75: iconst_3
    //   76: iload_3
    //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   80: aastore
    //   81: aload #4
    //   83: ldc 'LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]'
    //   85: aload #5
    //   87: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore #6
    //   92: aload_0
    //   93: monitorexit
    //   94: aload #6
    //   96: areturn
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: iconst_0
    //   103: istore_3
    //   104: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   2	12	97	finally
    //   16	26	97	finally
    //   29	92	97	finally }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */