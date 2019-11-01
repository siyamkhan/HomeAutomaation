package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> extends Object implements Collection<E>, Set<E> {
  private static final int[] c = new int[0];
  
  private static final Object[] d = new Object[0];
  
  private static Object[] e;
  
  private static int f;
  
  private static Object[] g;
  
  private static int h;
  
  Object[] a;
  
  int b;
  
  private int[] i;
  
  private h<E, E> j;
  
  public b() { this(0); }
  
  public b(int paramInt) {
    if (paramInt == 0) {
      this.i = c;
      this.a = d;
    } else {
      d(paramInt);
    } 
    this.b = 0;
  }
  
  private int a() {
    int k = this.b;
    if (k == 0)
      return -1; 
    int m = c.a(this.i, k, 0);
    if (m < 0)
      return m; 
    if (this.a[m] == null)
      return m; 
    int n;
    for (n = m + 1; n < k && this.i[n] == 0; n++) {
      if (this.a[n] == null)
        return n; 
    } 
    for (int i1 = m - 1; i1 >= 0 && this.i[i1] == 0; i1--) {
      if (this.a[i1] == null)
        return i1; 
    } 
    return n ^ 0xFFFFFFFF;
  }
  
  private int a(Object paramObject, int paramInt) {
    int k = this.b;
    if (k == 0)
      return -1; 
    int m = c.a(this.i, k, paramInt);
    if (m < 0)
      return m; 
    if (paramObject.equals(this.a[m]))
      return m; 
    int n;
    for (n = m + 1; n < k && this.i[n] == paramInt; n++) {
      if (paramObject.equals(this.a[n]))
        return n; 
    } 
    for (int i1 = m - 1; i1 >= 0 && this.i[i1] == paramInt; i1--) {
      if (paramObject.equals(this.a[i1]))
        return i1; 
    } 
    return n ^ 0xFFFFFFFF;
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 74
    //   7: ldc android/support/v4/g/b
    //   9: monitorenter
    //   10: getstatic android/support/v4/g/b.h : I
    //   13: bipush #10
    //   15: if_icmpge -> 62
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/g/b.g : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: isub
    //   31: istore #6
    //   33: iload #6
    //   35: iconst_2
    //   36: if_icmplt -> 50
    //   39: aload_1
    //   40: iload #6
    //   42: aconst_null
    //   43: aastore
    //   44: iinc #6, -1
    //   47: goto -> 33
    //   50: aload_1
    //   51: putstatic android/support/v4/g/b.g : [Ljava/lang/Object;
    //   54: iconst_1
    //   55: getstatic android/support/v4/g/b.h : I
    //   58: iadd
    //   59: putstatic android/support/v4/g/b.h : I
    //   62: ldc android/support/v4/g/b
    //   64: monitorexit
    //   65: return
    //   66: astore #5
    //   68: ldc android/support/v4/g/b
    //   70: monitorexit
    //   71: aload #5
    //   73: athrow
    //   74: aload_0
    //   75: arraylength
    //   76: iconst_4
    //   77: if_icmpne -> 145
    //   80: ldc android/support/v4/g/b
    //   82: monitorenter
    //   83: getstatic android/support/v4/g/b.f : I
    //   86: bipush #10
    //   88: if_icmpge -> 135
    //   91: aload_1
    //   92: iconst_0
    //   93: getstatic android/support/v4/g/b.e : [Ljava/lang/Object;
    //   96: aastore
    //   97: aload_1
    //   98: iconst_1
    //   99: aload_0
    //   100: aastore
    //   101: iload_2
    //   102: iconst_1
    //   103: isub
    //   104: istore #4
    //   106: iload #4
    //   108: iconst_2
    //   109: if_icmplt -> 123
    //   112: aload_1
    //   113: iload #4
    //   115: aconst_null
    //   116: aastore
    //   117: iinc #4, -1
    //   120: goto -> 106
    //   123: aload_1
    //   124: putstatic android/support/v4/g/b.e : [Ljava/lang/Object;
    //   127: iconst_1
    //   128: getstatic android/support/v4/g/b.f : I
    //   131: iadd
    //   132: putstatic android/support/v4/g/b.f : I
    //   135: ldc android/support/v4/g/b
    //   137: monitorexit
    //   138: return
    //   139: astore_3
    //   140: ldc android/support/v4/g/b
    //   142: monitorexit
    //   143: aload_3
    //   144: athrow
    //   145: return
    // Exception table:
    //   from	to	target	type
    //   10	28	66	finally
    //   39	44	66	finally
    //   50	62	66	finally
    //   62	65	66	finally
    //   68	71	66	finally
    //   83	101	139	finally
    //   112	117	139	finally
    //   123	135	139	finally
    //   135	138	139	finally
    //   140	143	139	finally }
  
  private h<E, E> b() {
    if (this.j == null)
      this.j = new h<E, E>(this) {
          protected int a() { return this.a.b; }
          
          protected int a(Object param1Object) { return this.a.a(param1Object); }
          
          protected Object a(int param1Int1, int param1Int2) { return this.a.a[param1Int1]; }
          
          protected E a(int param1Int, E param1E) { throw new UnsupportedOperationException("not a map"); }
          
          protected void a(int param1Int) { this.a.c(param1Int); }
          
          protected void a(E param1E1, E param1E2) { this.a.add(param1E1); }
          
          protected int b(Object param1Object) { return this.a.a(param1Object); }
          
          protected Map<E, E> b() { throw new UnsupportedOperationException("not a map"); }
          
          protected void c() { this.a.clear(); }
        }; 
    return this.j;
  }
  
  private void d(int paramInt) { // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 89
    //   6: ldc android/support/v4/g/b
    //   8: monitorenter
    //   9: getstatic android/support/v4/g/b.g : [Ljava/lang/Object;
    //   12: ifnull -> 75
    //   15: getstatic android/support/v4/g/b.g : [Ljava/lang/Object;
    //   18: astore #5
    //   20: aload_0
    //   21: aload #5
    //   23: putfield a : [Ljava/lang/Object;
    //   26: aload #5
    //   28: iconst_0
    //   29: aaload
    //   30: checkcast [Ljava/lang/Object;
    //   33: checkcast [Ljava/lang/Object;
    //   36: putstatic android/support/v4/g/b.g : [Ljava/lang/Object;
    //   39: aload_0
    //   40: aload #5
    //   42: iconst_1
    //   43: aaload
    //   44: checkcast [I
    //   47: checkcast [I
    //   50: putfield i : [I
    //   53: aload #5
    //   55: iconst_1
    //   56: aconst_null
    //   57: aastore
    //   58: aload #5
    //   60: iconst_0
    //   61: aconst_null
    //   62: aastore
    //   63: getstatic android/support/v4/g/b.h : I
    //   66: iconst_1
    //   67: isub
    //   68: putstatic android/support/v4/g/b.h : I
    //   71: ldc android/support/v4/g/b
    //   73: monitorexit
    //   74: return
    //   75: ldc android/support/v4/g/b
    //   77: monitorexit
    //   78: goto -> 169
    //   81: astore #4
    //   83: ldc android/support/v4/g/b
    //   85: monitorexit
    //   86: aload #4
    //   88: athrow
    //   89: iload_1
    //   90: iconst_4
    //   91: if_icmpne -> 169
    //   94: ldc android/support/v4/g/b
    //   96: monitorenter
    //   97: getstatic android/support/v4/g/b.e : [Ljava/lang/Object;
    //   100: ifnull -> 157
    //   103: getstatic android/support/v4/g/b.e : [Ljava/lang/Object;
    //   106: astore_3
    //   107: aload_0
    //   108: aload_3
    //   109: putfield a : [Ljava/lang/Object;
    //   112: aload_3
    //   113: iconst_0
    //   114: aaload
    //   115: checkcast [Ljava/lang/Object;
    //   118: checkcast [Ljava/lang/Object;
    //   121: putstatic android/support/v4/g/b.e : [Ljava/lang/Object;
    //   124: aload_0
    //   125: aload_3
    //   126: iconst_1
    //   127: aaload
    //   128: checkcast [I
    //   131: checkcast [I
    //   134: putfield i : [I
    //   137: aload_3
    //   138: iconst_1
    //   139: aconst_null
    //   140: aastore
    //   141: aload_3
    //   142: iconst_0
    //   143: aconst_null
    //   144: aastore
    //   145: getstatic android/support/v4/g/b.f : I
    //   148: iconst_1
    //   149: isub
    //   150: putstatic android/support/v4/g/b.f : I
    //   153: ldc android/support/v4/g/b
    //   155: monitorexit
    //   156: return
    //   157: ldc android/support/v4/g/b
    //   159: monitorexit
    //   160: goto -> 169
    //   163: astore_2
    //   164: ldc android/support/v4/g/b
    //   166: monitorexit
    //   167: aload_2
    //   168: athrow
    //   169: aload_0
    //   170: iload_1
    //   171: newarray int
    //   173: putfield i : [I
    //   176: aload_0
    //   177: iload_1
    //   178: anewarray java/lang/Object
    //   181: putfield a : [Ljava/lang/Object;
    //   184: return
    // Exception table:
    //   from	to	target	type
    //   9	74	81	finally
    //   75	78	81	finally
    //   83	86	81	finally
    //   97	156	163	finally
    //   157	160	163	finally
    //   164	167	163	finally }
  
  public int a(Object paramObject) { return (paramObject == null) ? a() : a(paramObject, paramObject.hashCode()); }
  
  public void a(int paramInt) {
    int[] arrayOfInt = this.i;
    if (arrayOfInt.length < paramInt) {
      Object[] arrayOfObject = this.a;
      d(paramInt);
      int k = this.b;
      if (k > 0) {
        System.arraycopy(arrayOfInt, 0, this.i, 0, k);
        System.arraycopy(arrayOfObject, 0, this.a, 0, this.b);
      } 
      a(arrayOfInt, arrayOfObject, this.b);
    } 
  }
  
  public boolean add(E paramE) {
    int m;
    int k;
    if (paramE == null) {
      m = a();
      k = 0;
    } else {
      int i3 = paramE.hashCode();
      int i4 = a(paramE, i3);
      k = i3;
      m = i4;
    } 
    if (m >= 0)
      return false; 
    int n = m ^ 0xFFFFFFFF;
    int i1 = this.b;
    if (i1 >= this.i.length) {
      int i3 = 4;
      if (i1 >= 8) {
        i3 = i1 + (i1 >> 1);
      } else if (i1 >= i3) {
        i3 = 8;
      } 
      int[] arrayOfInt1 = this.i;
      Object[] arrayOfObject = this.a;
      d(i3);
      int[] arrayOfInt2 = this.i;
      if (arrayOfInt2.length > 0) {
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        System.arraycopy(arrayOfObject, 0, this.a, 0, arrayOfObject.length);
      } 
      a(arrayOfInt1, arrayOfObject, this.b);
    } 
    int i2 = this.b;
    if (n < i2) {
      int[] arrayOfInt = this.i;
      int i3 = n + 1;
      System.arraycopy(arrayOfInt, n, arrayOfInt, i3, i2 - n);
      Object[] arrayOfObject = this.a;
      System.arraycopy(arrayOfObject, n, arrayOfObject, i3, this.b - n);
    } 
    this.i[n] = k;
    this.a[n] = paramE;
    this.b = 1 + this.b;
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    a(this.b + paramCollection.size());
    Iterator iterator = paramCollection.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= add(iterator.next()));
    return bool;
  }
  
  public E b(int paramInt) { return (E)this.a[paramInt]; }
  
  public E c(int paramInt) {
    Object[] arrayOfObject = this.a;
    Object object = arrayOfObject[paramInt];
    int k = this.b;
    if (k <= 1) {
      a(this.i, arrayOfObject, k);
      this.i = c;
      this.a = d;
      this.b = 0;
      return (E)object;
    } 
    int[] arrayOfInt = this.i;
    int m = arrayOfInt.length;
    int n = 8;
    if (m > n && k < arrayOfInt.length / 3) {
      if (k > n)
        n = k + (k >> 1); 
      int[] arrayOfInt1 = this.i;
      Object[] arrayOfObject1 = this.a;
      d(n);
      this.b--;
      if (paramInt > 0) {
        System.arraycopy(arrayOfInt1, 0, this.i, 0, paramInt);
        System.arraycopy(arrayOfObject1, 0, this.a, 0, paramInt);
      } 
      int i1 = this.b;
      if (paramInt < i1) {
        int i2 = paramInt + 1;
        System.arraycopy(arrayOfInt1, i2, this.i, paramInt, i1 - paramInt);
        System.arraycopy(arrayOfObject1, i2, this.a, paramInt, this.b - paramInt);
        return (E)object;
      } 
    } else {
      int i1 = --this.b;
      if (paramInt < i1) {
        int[] arrayOfInt1 = this.i;
        int i2 = paramInt + 1;
        System.arraycopy(arrayOfInt1, i2, arrayOfInt1, paramInt, i1 - paramInt);
        Object[] arrayOfObject1 = this.a;
        System.arraycopy(arrayOfObject1, i2, arrayOfObject1, paramInt, this.b - paramInt);
      } 
      this.a[this.b] = null;
    } 
    return (E)object;
  }
  
  public void clear() {
    int k = this.b;
    if (k != 0) {
      a(this.i, this.a, k);
      this.i = c;
      this.a = d;
      this.b = 0;
    } 
  }
  
  public boolean contains(Object paramObject) { return (a(paramObject) >= 0); }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      Set set = (Set)paramObject;
      if (size() != set.size())
        return false; 
      for (byte b1 = 0; b1 < this.b; b1++) {
        boolean bool = set.contains(b(b1));
        if (!bool)
          return false; 
      } 
      return true;
    } 
    return false;
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.i;
    int k = this.b;
    byte b1 = 0;
    int m = 0;
    while (b1 < k) {
      m += arrayOfInt[b1];
      b1++;
    } 
    return m;
  }
  
  public boolean isEmpty() { return (this.b <= 0); }
  
  public Iterator<E> iterator() { return b().e().iterator(); }
  
  public boolean remove(Object paramObject) {
    int k = a(paramObject);
    if (k >= 0) {
      c(k);
      return true;
    } 
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= remove(iterator.next()));
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    int k = this.b - 1;
    boolean bool = false;
    while (k >= 0) {
      if (!paramCollection.contains(this.a[k])) {
        c(k);
        bool = true;
      } 
      k--;
    } 
    return bool;
  }
  
  public int size() { return this.b; }
  
  public Object[] toArray() {
    int k = this.b;
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(this.a, 0, arrayOfObject, 0, k);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    if (paramArrayOfT.length < this.b)
      paramArrayOfT = (T[])(Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.b); 
    System.arraycopy(this.a, 0, paramArrayOfT, 0, this.b);
    int k = paramArrayOfT.length;
    int m = this.b;
    if (k > m)
      paramArrayOfT[m] = null; 
    return paramArrayOfT;
  }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(14 * this.b);
    stringBuilder.append('{');
    for (byte b1 = 0; b1 < this.b; b1++) {
      if (b1)
        stringBuilder.append(", "); 
      Object object = b(b1);
      if (object != this) {
        stringBuilder.append(object);
      } else {
        stringBuilder.append("(this Set)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */