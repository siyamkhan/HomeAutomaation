package android.support.v4.g;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class l<K, V> extends Object {
  static Object[] b;
  
  static int c;
  
  static Object[] d;
  
  static int e;
  
  int[] f;
  
  Object[] g;
  
  int h;
  
  public l() {
    this.f = c.a;
    this.g = c.c;
    this.h = 0;
  }
  
  public l(int paramInt) {
    if (paramInt == 0) {
      this.f = c.a;
      this.g = c.c;
    } else {
      e(paramInt);
    } 
    this.h = 0;
  }
  
  public l(l<K, V> paraml) {
    this();
    if (paraml != null)
      a(paraml); 
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
    try {
      return c.a(paramArrayOfInt, paramInt1, paramInt2);
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      throw new ConcurrentModificationException();
    } 
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 76
    //   7: ldc android/support/v4/g/a
    //   9: monitorenter
    //   10: getstatic android/support/v4/g/l.e : I
    //   13: bipush #10
    //   15: if_icmpge -> 64
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/g/l.d : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: ishl
    //   31: iconst_1
    //   32: isub
    //   33: istore #6
    //   35: iload #6
    //   37: iconst_2
    //   38: if_icmplt -> 52
    //   41: aload_1
    //   42: iload #6
    //   44: aconst_null
    //   45: aastore
    //   46: iinc #6, -1
    //   49: goto -> 35
    //   52: aload_1
    //   53: putstatic android/support/v4/g/l.d : [Ljava/lang/Object;
    //   56: iconst_1
    //   57: getstatic android/support/v4/g/l.e : I
    //   60: iadd
    //   61: putstatic android/support/v4/g/l.e : I
    //   64: ldc android/support/v4/g/a
    //   66: monitorexit
    //   67: return
    //   68: astore #5
    //   70: ldc android/support/v4/g/a
    //   72: monitorexit
    //   73: aload #5
    //   75: athrow
    //   76: aload_0
    //   77: arraylength
    //   78: iconst_4
    //   79: if_icmpne -> 149
    //   82: ldc android/support/v4/g/a
    //   84: monitorenter
    //   85: getstatic android/support/v4/g/l.c : I
    //   88: bipush #10
    //   90: if_icmpge -> 139
    //   93: aload_1
    //   94: iconst_0
    //   95: getstatic android/support/v4/g/l.b : [Ljava/lang/Object;
    //   98: aastore
    //   99: aload_1
    //   100: iconst_1
    //   101: aload_0
    //   102: aastore
    //   103: iload_2
    //   104: iconst_1
    //   105: ishl
    //   106: iconst_1
    //   107: isub
    //   108: istore #4
    //   110: iload #4
    //   112: iconst_2
    //   113: if_icmplt -> 127
    //   116: aload_1
    //   117: iload #4
    //   119: aconst_null
    //   120: aastore
    //   121: iinc #4, -1
    //   124: goto -> 110
    //   127: aload_1
    //   128: putstatic android/support/v4/g/l.b : [Ljava/lang/Object;
    //   131: iconst_1
    //   132: getstatic android/support/v4/g/l.c : I
    //   135: iadd
    //   136: putstatic android/support/v4/g/l.c : I
    //   139: ldc android/support/v4/g/a
    //   141: monitorexit
    //   142: return
    //   143: astore_3
    //   144: ldc android/support/v4/g/a
    //   146: monitorexit
    //   147: aload_3
    //   148: athrow
    //   149: return
    // Exception table:
    //   from	to	target	type
    //   10	28	68	finally
    //   41	46	68	finally
    //   52	64	68	finally
    //   64	67	68	finally
    //   70	73	68	finally
    //   85	103	143	finally
    //   116	121	143	finally
    //   127	139	143	finally
    //   139	142	143	finally
    //   144	147	143	finally }
  
  private void e(int paramInt) { // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 89
    //   6: ldc android/support/v4/g/a
    //   8: monitorenter
    //   9: getstatic android/support/v4/g/l.d : [Ljava/lang/Object;
    //   12: ifnull -> 75
    //   15: getstatic android/support/v4/g/l.d : [Ljava/lang/Object;
    //   18: astore #5
    //   20: aload_0
    //   21: aload #5
    //   23: putfield g : [Ljava/lang/Object;
    //   26: aload #5
    //   28: iconst_0
    //   29: aaload
    //   30: checkcast [Ljava/lang/Object;
    //   33: checkcast [Ljava/lang/Object;
    //   36: putstatic android/support/v4/g/l.d : [Ljava/lang/Object;
    //   39: aload_0
    //   40: aload #5
    //   42: iconst_1
    //   43: aaload
    //   44: checkcast [I
    //   47: checkcast [I
    //   50: putfield f : [I
    //   53: aload #5
    //   55: iconst_1
    //   56: aconst_null
    //   57: aastore
    //   58: aload #5
    //   60: iconst_0
    //   61: aconst_null
    //   62: aastore
    //   63: getstatic android/support/v4/g/l.e : I
    //   66: iconst_1
    //   67: isub
    //   68: putstatic android/support/v4/g/l.e : I
    //   71: ldc android/support/v4/g/a
    //   73: monitorexit
    //   74: return
    //   75: ldc android/support/v4/g/a
    //   77: monitorexit
    //   78: goto -> 169
    //   81: astore #4
    //   83: ldc android/support/v4/g/a
    //   85: monitorexit
    //   86: aload #4
    //   88: athrow
    //   89: iload_1
    //   90: iconst_4
    //   91: if_icmpne -> 169
    //   94: ldc android/support/v4/g/a
    //   96: monitorenter
    //   97: getstatic android/support/v4/g/l.b : [Ljava/lang/Object;
    //   100: ifnull -> 157
    //   103: getstatic android/support/v4/g/l.b : [Ljava/lang/Object;
    //   106: astore_3
    //   107: aload_0
    //   108: aload_3
    //   109: putfield g : [Ljava/lang/Object;
    //   112: aload_3
    //   113: iconst_0
    //   114: aaload
    //   115: checkcast [Ljava/lang/Object;
    //   118: checkcast [Ljava/lang/Object;
    //   121: putstatic android/support/v4/g/l.b : [Ljava/lang/Object;
    //   124: aload_0
    //   125: aload_3
    //   126: iconst_1
    //   127: aaload
    //   128: checkcast [I
    //   131: checkcast [I
    //   134: putfield f : [I
    //   137: aload_3
    //   138: iconst_1
    //   139: aconst_null
    //   140: aastore
    //   141: aload_3
    //   142: iconst_0
    //   143: aconst_null
    //   144: aastore
    //   145: getstatic android/support/v4/g/l.c : I
    //   148: iconst_1
    //   149: isub
    //   150: putstatic android/support/v4/g/l.c : I
    //   153: ldc android/support/v4/g/a
    //   155: monitorexit
    //   156: return
    //   157: ldc android/support/v4/g/a
    //   159: monitorexit
    //   160: goto -> 169
    //   163: astore_2
    //   164: ldc android/support/v4/g/a
    //   166: monitorexit
    //   167: aload_2
    //   168: athrow
    //   169: aload_0
    //   170: iload_1
    //   171: newarray int
    //   173: putfield f : [I
    //   176: aload_0
    //   177: iload_1
    //   178: iconst_1
    //   179: ishl
    //   180: anewarray java/lang/Object
    //   183: putfield g : [Ljava/lang/Object;
    //   186: return
    // Exception table:
    //   from	to	target	type
    //   9	74	81	finally
    //   75	78	81	finally
    //   83	86	81	finally
    //   97	156	163	finally
    //   157	160	163	finally
    //   164	167	163	finally }
  
  int a() {
    int i = this.h;
    if (i == 0)
      return -1; 
    int j = a(this.f, i, 0);
    if (j < 0)
      return j; 
    if (this.g[j << true] == null)
      return j; 
    int k;
    for (k = j + 1; k < i && this.f[k] == 0; k++) {
      if (this.g[k << true] == null)
        return k; 
    } 
    for (int m = j - 1; m >= 0 && this.f[m] == 0; m--) {
      if (this.g[m << true] == null)
        return m; 
    } 
    return k ^ 0xFFFFFFFF;
  }
  
  public int a(Object paramObject) { return (paramObject == null) ? a() : a(paramObject, paramObject.hashCode()); }
  
  int a(Object paramObject, int paramInt) {
    int i = this.h;
    if (i == 0)
      return -1; 
    int j = a(this.f, i, paramInt);
    if (j < 0)
      return j; 
    if (paramObject.equals(this.g[j << 1]))
      return j; 
    int k;
    for (k = j + 1; k < i && this.f[k] == paramInt; k++) {
      if (paramObject.equals(this.g[k << 1]))
        return k; 
    } 
    for (int m = j - 1; m >= 0 && this.f[m] == paramInt; m--) {
      if (paramObject.equals(this.g[m << 1]))
        return m; 
    } 
    return k ^ 0xFFFFFFFF;
  }
  
  public V a(int paramInt, V paramV) {
    int i = 1 + (paramInt << 1);
    Object[] arrayOfObject = this.g;
    Object object = arrayOfObject[i];
    arrayOfObject[i] = paramV;
    return (V)object;
  }
  
  public void a(int paramInt) {
    int i = this.h;
    int[] arrayOfInt = this.f;
    if (arrayOfInt.length < paramInt) {
      Object[] arrayOfObject = this.g;
      e(paramInt);
      if (this.h > 0) {
        System.arraycopy(arrayOfInt, 0, this.f, 0, i);
        System.arraycopy(arrayOfObject, 0, this.g, 0, i << 1);
      } 
      a(arrayOfInt, arrayOfObject, i);
    } 
    if (this.h == i)
      return; 
    throw new ConcurrentModificationException();
  }
  
  public void a(l<? extends K, ? extends V> paraml) {
    int i = paraml.h;
    a(i + this.h);
    int j = this.h;
    byte b1 = 0;
    if (j == 0) {
      if (i > 0) {
        System.arraycopy(paraml.f, 0, this.f, 0, i);
        System.arraycopy(paraml.g, 0, this.g, 0, i << 1);
        this.h = i;
        return;
      } 
    } else {
      while (b1 < i) {
        put(paraml.b(b1), paraml.c(b1));
        b1++;
      } 
    } 
  }
  
  int b(Object paramObject) {
    int i = 2 * this.h;
    Object[] arrayOfObject = this.g;
    if (paramObject == null) {
      for (boolean bool = true; bool < i; bool += true) {
        if (arrayOfObject[bool] == null)
          return bool >> true; 
      } 
    } else {
      for (boolean bool = true; bool < i; bool += true) {
        if (paramObject.equals(arrayOfObject[bool]))
          return bool >> true; 
      } 
    } 
    return -1;
  }
  
  public K b(int paramInt) { return (K)this.g[paramInt << 1]; }
  
  public V c(int paramInt) { return (V)this.g[1 + (paramInt << 1)]; }
  
  public void clear() {
    int i = this.h;
    if (i > 0) {
      int[] arrayOfInt = this.f;
      Object[] arrayOfObject = this.g;
      this.f = c.a;
      this.g = c.c;
      this.h = 0;
      a(arrayOfInt, arrayOfObject, i);
    } 
    if (this.h <= 0)
      return; 
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(Object paramObject) { return (a(paramObject) >= 0); }
  
  public boolean containsValue(Object paramObject) { return (b(paramObject) >= 0); }
  
  public V d(int paramInt) {
    int k;
    Object[] arrayOfObject = this.g;
    int i = paramInt << 1;
    Object object = arrayOfObject[i + 1];
    int j = this.h;
    if (j <= 1) {
      a(this.f, arrayOfObject, j);
      this.f = c.a;
      this.g = c.c;
      k = 0;
    } else {
      k = j - 1;
      int[] arrayOfInt = this.f;
      int m = arrayOfInt.length;
      int n = 8;
      if (m > n && j < arrayOfInt.length / 3) {
        if (j > n)
          n = j + (j >> 1); 
        int[] arrayOfInt1 = this.f;
        Object[] arrayOfObject1 = this.g;
        e(n);
        if (j == this.h) {
          if (paramInt > 0) {
            System.arraycopy(arrayOfInt1, 0, this.f, 0, paramInt);
            System.arraycopy(arrayOfObject1, 0, this.g, 0, i);
          } 
          if (paramInt < k) {
            int i1 = paramInt + 1;
            int[] arrayOfInt2 = this.f;
            int i2 = k - paramInt;
            System.arraycopy(arrayOfInt1, i1, arrayOfInt2, paramInt, i2);
            System.arraycopy(arrayOfObject1, i1 << 1, this.g, i, i2 << 1);
          } 
        } else {
          throw new ConcurrentModificationException();
        } 
      } else {
        if (paramInt < k) {
          int[] arrayOfInt1 = this.f;
          int i2 = paramInt + 1;
          int i3 = k - paramInt;
          System.arraycopy(arrayOfInt1, i2, arrayOfInt1, paramInt, i3);
          Object[] arrayOfObject2 = this.g;
          System.arraycopy(arrayOfObject2, i2 << 1, arrayOfObject2, i, i3 << 1);
        } 
        Object[] arrayOfObject1 = this.g;
        int i1 = k << 1;
        arrayOfObject1[i1] = null;
        arrayOfObject1[i1 + 1] = null;
      } 
    } 
    if (j == this.h) {
      this.h = k;
      return (V)object;
    } 
    throw new ConcurrentModificationException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof l) {
      l l1 = (l)paramObject;
      if (size() != l1.size())
        return false; 
      byte b1 = 0;
      try {
        while (b1 < this.h) {
          Object object1 = b(b1);
          Object object2 = c(b1);
          Object object3 = l1.get(object1);
          if (object2 == null) {
            if (object3 == null) {
              if (!l1.containsKey(object1))
                return false; 
            } else {
              return false;
            } 
          } else {
            boolean bool = object2.equals(object3);
            if (!bool)
              return false; 
          } 
          b1++;
        } 
        return true;
      } catch (NullPointerException|ClassCastException nullPointerException) {
        return false;
      } 
    } 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      if (size() != map.size())
        return false; 
      for (byte b1 = 0; b1 < this.h; b1++) {
        Object object1 = b(b1);
        Object object2 = c(b1);
        Object object3 = map.get(object1);
        if (object2 == null) {
          if (object3 == null) {
            if (!map.containsKey(object1))
              return false; 
          } else {
            return false;
          } 
        } else {
          boolean bool = object2.equals(object3);
          if (!bool)
            return false; 
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public V get(Object paramObject) {
    int i = a(paramObject);
    return (i >= 0) ? (V)this.g[1 + (i << 1)] : null;
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.f;
    Object[] arrayOfObject = this.g;
    int i = this.h;
    byte b1 = 0;
    int j = 0;
    for (boolean bool = true; b1 < i; bool += true) {
      int m;
      Object object = arrayOfObject[bool];
      int k = arrayOfInt[b1];
      if (object == null) {
        m = 0;
      } else {
        m = object.hashCode();
      } 
      j += (m ^ k);
      b1++;
    } 
    return j;
  }
  
  public boolean isEmpty() { return (this.h <= 0); }
  
  public V put(K paramK, V paramV) {
    int k;
    int j;
    int i = this.h;
    if (paramK == null) {
      k = a();
      j = 0;
    } else {
      int i1 = paramK.hashCode();
      int i2 = a(paramK, i1);
      j = i1;
      k = i2;
    } 
    if (k >= 0) {
      int i1 = 1 + (k << 1);
      Object[] arrayOfObject = this.g;
      Object object = arrayOfObject[i1];
      arrayOfObject[i1] = paramV;
      return (V)object;
    } 
    int m = k ^ 0xFFFFFFFF;
    if (i >= this.f.length) {
      int i1 = 4;
      if (i >= 8) {
        i1 = i + (i >> 1);
      } else if (i >= i1) {
        i1 = 8;
      } 
      int[] arrayOfInt = this.f;
      Object[] arrayOfObject = this.g;
      e(i1);
      if (i == this.h) {
        int[] arrayOfInt1 = this.f;
        if (arrayOfInt1.length > 0) {
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, arrayOfInt.length);
          System.arraycopy(arrayOfObject, 0, this.g, 0, arrayOfObject.length);
        } 
        a(arrayOfInt, arrayOfObject, i);
      } else {
        throw new ConcurrentModificationException();
      } 
    } 
    if (m < i) {
      int[] arrayOfInt = this.f;
      int i1 = m + 1;
      System.arraycopy(arrayOfInt, m, arrayOfInt, i1, i - m);
      Object[] arrayOfObject = this.g;
      System.arraycopy(arrayOfObject, m << 1, arrayOfObject, i1 << 1, this.h - m << 1);
    } 
    int n = this.h;
    if (i == n) {
      int[] arrayOfInt = this.f;
      if (m < arrayOfInt.length) {
        arrayOfInt[m] = j;
        Object[] arrayOfObject = this.g;
        int i1 = m << 1;
        arrayOfObject[i1] = paramK;
        arrayOfObject[i1 + 1] = paramV;
        this.h = n + 1;
        return null;
      } 
    } 
    throw new ConcurrentModificationException();
  }
  
  public V remove(Object paramObject) {
    int i = a(paramObject);
    return (i >= 0) ? (V)d(i) : null;
  }
  
  public int size() { return this.h; }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(28 * this.h);
    stringBuilder.append('{');
    for (byte b1 = 0; b1 < this.h; b1++) {
      if (b1)
        stringBuilder.append(", "); 
      Object object1 = b(b1);
      if (object1 != this) {
        stringBuilder.append(object1);
      } else {
        stringBuilder.append("(this Map)");
      } 
      stringBuilder.append('=');
      Object object2 = c(b1);
      if (object2 != this) {
        stringBuilder.append(object2);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */