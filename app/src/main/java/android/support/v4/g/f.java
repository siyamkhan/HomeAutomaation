package android.support.v4.g;

public class f<E> extends Object implements Cloneable {
  private static final Object a = new Object();
  
  private boolean b = false;
  
  private long[] c;
  
  private Object[] d;
  
  private int e;
  
  public f() { this(10); }
  
  public f(int paramInt) {
    if (paramInt == 0) {
      this.c = c.b;
      arrayOfObject = c.c;
    } else {
      int i = c.b(paramInt);
      this.c = new long[i];
      arrayOfObject = new Object[i];
    } 
    this.d = arrayOfObject;
    this.e = 0;
  }
  
  private void d() {
    int i = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < i) {
      Object object = arrayOfObject[b1];
      if (object != a) {
        if (b1 != b2) {
          arrayOfLong[b2] = arrayOfLong[b1];
          arrayOfObject[b2] = object;
          arrayOfObject[b1] = null;
        } 
        b2++;
      } 
      b1++;
    } 
    this.b = false;
    this.e = b2;
  }
  
  public f<E> a() {
    try {
      f f1 = (f)super.clone();
      f1.c = (long[])this.c.clone();
      f1.d = (Object[])this.d.clone();
      return f1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public E a(long paramLong) { return (E)a(paramLong, null); }
  
  public E a(long paramLong, E paramE) {
    int i = c.a(this.c, this.e, paramLong);
    if (i >= 0) {
      Object[] arrayOfObject = this.d;
      return (arrayOfObject[i] == a) ? paramE : (E)arrayOfObject[i];
    } 
    return paramE;
  }
  
  public void a(int paramInt) {
    Object[] arrayOfObject = this.d;
    Object object1 = arrayOfObject[paramInt];
    Object object2 = a;
    if (object1 != object2) {
      arrayOfObject[paramInt] = object2;
      this.b = true;
    } 
  }
  
  public int b() {
    if (this.b)
      d(); 
    return this.e;
  }
  
  public long b(int paramInt) {
    if (this.b)
      d(); 
    return this.c[paramInt];
  }
  
  public void b(long paramLong) {
    int i = c.a(this.c, this.e, paramLong);
    if (i >= 0) {
      Object[] arrayOfObject = this.d;
      Object object1 = arrayOfObject[i];
      Object object2 = a;
      if (object1 != object2) {
        arrayOfObject[i] = object2;
        this.b = true;
      } 
    } 
  }
  
  public void b(long paramLong, E paramE) {
    int i = c.a(this.c, this.e, paramLong);
    if (i >= 0) {
      this.d[i] = paramE;
      return;
    } 
    int j = i ^ 0xFFFFFFFF;
    if (j < this.e) {
      Object[] arrayOfObject = this.d;
      if (arrayOfObject[j] == a) {
        this.c[j] = paramLong;
        arrayOfObject[j] = paramE;
        return;
      } 
    } 
    if (this.b && this.e >= this.c.length) {
      d();
      j = 0xFFFFFFFF ^ c.a(this.c, this.e, paramLong);
    } 
    int k = this.e;
    if (k >= this.c.length) {
      int n = c.b(k + 1);
      long[] arrayOfLong1 = new long[n];
      Object[] arrayOfObject1 = new Object[n];
      long[] arrayOfLong2 = this.c;
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, arrayOfLong2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfLong1;
      this.d = arrayOfObject1;
    } 
    int m = this.e;
    if (m - j != 0) {
      long[] arrayOfLong = this.c;
      int n = j + 1;
      System.arraycopy(arrayOfLong, j, arrayOfLong, n, m - j);
      Object[] arrayOfObject = this.d;
      System.arraycopy(arrayOfObject, j, arrayOfObject, n, this.e - j);
    } 
    this.c[j] = paramLong;
    this.d[j] = paramE;
    this.e = 1 + this.e;
  }
  
  public int c(long paramLong) {
    if (this.b)
      d(); 
    return c.a(this.c, this.e, paramLong);
  }
  
  public E c(int paramInt) {
    if (this.b)
      d(); 
    return (E)this.d[paramInt];
  }
  
  public void c() {
    int i = this.e;
    Object[] arrayOfObject = this.d;
    for (byte b1 = 0; b1 < i; b1++)
      arrayOfObject[b1] = null; 
    this.e = 0;
    this.b = false;
  }
  
  public void c(long paramLong, E paramE) {
    int i = this.e;
    if (i != 0 && paramLong <= this.c[i - 1]) {
      b(paramLong, paramE);
      return;
    } 
    if (this.b && this.e >= this.c.length)
      d(); 
    int j = this.e;
    if (j >= this.c.length) {
      int k = c.b(j + 1);
      long[] arrayOfLong1 = new long[k];
      Object[] arrayOfObject1 = new Object[k];
      long[] arrayOfLong2 = this.c;
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, arrayOfLong2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfLong1;
      this.d = arrayOfObject1;
    } 
    this.c[j] = paramLong;
    this.d[j] = paramE;
    this.e = j + 1;
  }
  
  public String toString() {
    if (b() <= 0)
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(28 * this.e);
    stringBuilder.append('{');
    for (byte b1 = 0; b1 < this.e; b1++) {
      if (b1)
        stringBuilder.append(", "); 
      stringBuilder.append(b(b1));
      stringBuilder.append('=');
      Object object = c(b1);
      if (object != this) {
        stringBuilder.append(object);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */