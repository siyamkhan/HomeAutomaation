package android.support.v4.g;

public class m<E> extends Object implements Cloneable {
  private static final Object a = new Object();
  
  private boolean b = false;
  
  private int[] c;
  
  private Object[] d;
  
  private int e;
  
  public m() { this(10); }
  
  public m(int paramInt) {
    if (paramInt == 0) {
      this.c = c.a;
      arrayOfObject = c.c;
    } else {
      int i = c.a(paramInt);
      this.c = new int[i];
      arrayOfObject = new Object[i];
    } 
    this.d = arrayOfObject;
    this.e = 0;
  }
  
  private void d() {
    int i = this.e;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.d;
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < i) {
      Object object = arrayOfObject[b1];
      if (object != a) {
        if (b1 != b2) {
          arrayOfInt[b2] = arrayOfInt[b1];
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
  
  public m<E> a() {
    try {
      m m1 = (m)super.clone();
      m1.c = (int[])this.c.clone();
      m1.d = (Object[])this.d.clone();
      return m1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public E a(int paramInt) { return (E)a(paramInt, null); }
  
  public E a(int paramInt, E paramE) {
    int i = c.a(this.c, this.e, paramInt);
    if (i >= 0) {
      Object[] arrayOfObject = this.d;
      return (arrayOfObject[i] == a) ? paramE : (E)arrayOfObject[i];
    } 
    return paramE;
  }
  
  public int b() {
    if (this.b)
      d(); 
    return this.e;
  }
  
  public void b(int paramInt) {
    int i = c.a(this.c, this.e, paramInt);
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
  
  public void b(int paramInt, E paramE) {
    int i = c.a(this.c, this.e, paramInt);
    if (i >= 0) {
      this.d[i] = paramE;
      return;
    } 
    int j = i ^ 0xFFFFFFFF;
    if (j < this.e) {
      Object[] arrayOfObject = this.d;
      if (arrayOfObject[j] == a) {
        this.c[j] = paramInt;
        arrayOfObject[j] = paramE;
        return;
      } 
    } 
    if (this.b && this.e >= this.c.length) {
      d();
      j = 0xFFFFFFFF ^ c.a(this.c, this.e, paramInt);
    } 
    int k = this.e;
    if (k >= this.c.length) {
      int i1 = c.a(k + 1);
      int[] arrayOfInt1 = new int[i1];
      Object[] arrayOfObject1 = new Object[i1];
      int[] arrayOfInt2 = this.c;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfInt1;
      this.d = arrayOfObject1;
    } 
    int n = this.e;
    if (n - j != 0) {
      int[] arrayOfInt = this.c;
      int i1 = j + 1;
      System.arraycopy(arrayOfInt, j, arrayOfInt, i1, n - j);
      Object[] arrayOfObject = this.d;
      System.arraycopy(arrayOfObject, j, arrayOfObject, i1, this.e - j);
    } 
    this.c[j] = paramInt;
    this.d[j] = paramE;
    this.e = 1 + this.e;
  }
  
  public void c() {
    int i = this.e;
    Object[] arrayOfObject = this.d;
    for (byte b1 = 0; b1 < i; b1++)
      arrayOfObject[b1] = null; 
    this.e = 0;
    this.b = false;
  }
  
  public void c(int paramInt) { b(paramInt); }
  
  public void c(int paramInt, E paramE) {
    int i = this.e;
    if (i != 0 && paramInt <= this.c[i - 1]) {
      b(paramInt, paramE);
      return;
    } 
    if (this.b && this.e >= this.c.length)
      d(); 
    int j = this.e;
    if (j >= this.c.length) {
      int k = c.a(j + 1);
      int[] arrayOfInt1 = new int[k];
      Object[] arrayOfObject1 = new Object[k];
      int[] arrayOfInt2 = this.c;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfInt1;
      this.d = arrayOfObject1;
    } 
    this.c[j] = paramInt;
    this.d[j] = paramE;
    this.e = j + 1;
  }
  
  public int d(int paramInt) {
    if (this.b)
      d(); 
    return this.c[paramInt];
  }
  
  public E e(int paramInt) {
    if (this.b)
      d(); 
    return (E)this.d[paramInt];
  }
  
  public int f(int paramInt) {
    if (this.b)
      d(); 
    return c.a(this.c, this.e, paramInt);
  }
  
  public String toString() {
    if (b() <= 0)
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(28 * this.e);
    stringBuilder.append('{');
    for (byte b1 = 0; b1 < this.e; b1++) {
      if (b1)
        stringBuilder.append(", "); 
      stringBuilder.append(d(b1));
      stringBuilder.append('=');
      Object object = e(b1);
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


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */