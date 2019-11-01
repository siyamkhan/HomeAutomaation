package android.support.v4.g;

public final class j {
  public static interface a<T> {
    T a();
    
    boolean a(T param1T);
  }
  
  public static class b<T> extends Object implements a<T> {
    private final Object[] a;
    
    private int b;
    
    public b(int param1Int) {
      if (param1Int > 0) {
        this.a = new Object[param1Int];
        return;
      } 
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    
    private boolean b(T param1T) {
      for (byte b1 = 0; b1 < this.b; b1++) {
        if (this.a[b1] == param1T)
          return true; 
      } 
      return false;
    }
    
    public T a() {
      int i = this.b;
      if (i > 0) {
        int j = i - 1;
        Object[] arrayOfObject = this.a;
        Object object = arrayOfObject[j];
        arrayOfObject[j] = null;
        this.b = i - 1;
        return (T)object;
      } 
      return null;
    }
    
    public boolean a(T param1T) {
      if (!b(param1T)) {
        int i = this.b;
        Object[] arrayOfObject = this.a;
        if (i < arrayOfObject.length) {
          arrayOfObject[i] = param1T;
          this.b = i + 1;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException("Already in the pool!");
    }
  }
  
  public static class c<T> extends b<T> {
    private final Object a = new Object();
    
    public c(int param1Int) { super(param1Int); }
    
    public T a() {
      synchronized (this.a) {
        Object object = super.a();
        return (T)object;
      } 
    }
    
    public boolean a(T param1T) {
      synchronized (this.a) {
        return super.a(param1T);
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */