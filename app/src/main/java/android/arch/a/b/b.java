package android.arch.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> extends Object implements Iterable<Map.Entry<K, V>> {
  private c<K, V> a;
  
  private c<K, V> b;
  
  private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
  
  private int d = 0;
  
  public int a() { return this.d; }
  
  protected c<K, V> a(K paramK) {
    c c1;
    for (c1 = this.a; c1 != null; c1 = c1.c) {
      if (c1.a.equals(paramK))
        return c1; 
    } 
    return c1;
  }
  
  public V a(K paramK, V paramV) {
    c c1 = a(paramK);
    if (c1 != null)
      return (V)c1.b; 
    b(paramK, paramV);
    return null;
  }
  
  protected c<K, V> b(K paramK, V paramV) {
    c c1 = new c(paramK, paramV);
    this.d = 1 + this.d;
    c c2 = this.b;
    if (c2 == null) {
      this.a = c1;
      this.b = this.a;
      return c1;
    } 
    c2.c = c1;
    c1.d = c2;
    this.b = c1;
    return c1;
  }
  
  public V b(K paramK) {
    c c1 = a(paramK);
    if (c1 == null)
      return null; 
    this.d = -1 + this.d;
    if (!this.c.isEmpty()) {
      Iterator iterator = this.c.keySet().iterator();
      while (iterator.hasNext())
        ((f)iterator.next()).a_(c1); 
    } 
    if (c1.d != null) {
      c1.d.c = c1.c;
    } else {
      this.a = c1.c;
    } 
    if (c1.c != null) {
      c1.c.d = c1.d;
    } else {
      this.b = c1.d;
    } 
    c1.c = null;
    c1.d = null;
    return (V)c1.b;
  }
  
  public Iterator<Map.Entry<K, V>> b() {
    b b1 = new b(this.b, this.a);
    this.c.put(b1, Boolean.valueOf(false));
    return b1;
  }
  
  public d c() {
    d d1 = new d(this, null);
    this.c.put(d1, Boolean.valueOf(false));
    return d1;
  }
  
  public Map.Entry<K, V> d() { return this.a; }
  
  public Map.Entry<K, V> e() { return this.b; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof b))
      return false; 
    b b1 = (b)paramObject;
    if (a() != b1.a())
      return false; 
    Iterator iterator1 = iterator();
    Iterator iterator2 = b1.iterator();
    while (iterator1.hasNext() && iterator2.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator1.next();
      Object object = iterator2.next();
      if ((entry == null && object != null) || (entry != null && !entry.equals(object)))
        return false; 
    } 
    return (!iterator1.hasNext() && !iterator2.hasNext());
  }
  
  public Iterator<Map.Entry<K, V>> iterator() {
    a a1 = new a(this.a, this.b);
    this.c.put(a1, Boolean.valueOf(false));
    return a1;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    Iterator iterator = iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(((Map.Entry)iterator.next()).toString());
      if (iterator.hasNext())
        stringBuilder.append(", "); 
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  static class a<K, V> extends e<K, V> {
    a(b.c<K, V> param1c1, b.c<K, V> param1c2) { super(param1c1, param1c2); }
    
    b.c<K, V> a(b.c<K, V> param1c) { return param1c.c; }
    
    b.c<K, V> b(b.c<K, V> param1c) { return param1c.d; }
  }
  
  private static class b<K, V> extends e<K, V> {
    b(b.c<K, V> param1c1, b.c<K, V> param1c2) { super(param1c1, param1c2); }
    
    b.c<K, V> a(b.c<K, V> param1c) { return param1c.d; }
    
    b.c<K, V> b(b.c<K, V> param1c) { return param1c.c; }
  }
  
  static class c<K, V> extends Object implements Map.Entry<K, V> {
    final K a;
    
    final V b;
    
    c<K, V> c;
    
    c<K, V> d;
    
    c(K param1K, V param1V) {
      this.a = param1K;
      this.b = param1V;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof c))
        return false; 
      c c1 = (c)param1Object;
      return (this.a.equals(c1.a) && this.b.equals(c1.b));
    }
    
    public K getKey() { return (K)this.a; }
    
    public V getValue() { return (V)this.b; }
    
    public V setValue(V param1V) { throw new UnsupportedOperationException("An entry modification is not supported"); }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append("=");
      stringBuilder.append(this.b);
      return stringBuilder.toString();
    }
  }
  
  private class d extends Object implements f<K, V>, Iterator<Map.Entry<K, V>> {
    private b.c<K, V> b;
    
    private boolean c = true;
    
    private d(b this$0) {}
    
    public Map.Entry<K, V> a() {
      Object object;
      if (this.c) {
        this.c = false;
        object = b.a(this.a);
      } else {
        b.c c1 = this.b;
        if (c1 != null) {
          object = c1.c;
        } else {
          object = null;
        } 
      } 
      this.b = object;
      return this.b;
    }
    
    public void a_(b.c<K, V> param1c) {
      b.c c1 = this.b;
      if (param1c == c1) {
        boolean bool;
        this.b = c1.d;
        if (this.b == null) {
          bool = true;
        } else {
          bool = false;
        } 
        this.c = bool;
      } 
    }
    
    public boolean hasNext() {
      if (this.c)
        return (b.a(this.a) != null); 
      b.c c1 = this.b;
      return (c1 != null && c1.c != null);
    }
  }
  
  private static abstract class e<K, V> extends Object implements f<K, V>, Iterator<Map.Entry<K, V>> {
    b.c<K, V> a;
    
    b.c<K, V> b;
    
    e(b.c<K, V> param1c1, b.c<K, V> param1c2) {
      this.a = param1c2;
      this.b = param1c1;
    }
    
    private b.c<K, V> b() {
      b.c c1 = this.b;
      b.c c2 = this.a;
      return (c1 == c2 || c2 == null) ? null : a(c1);
    }
    
    abstract b.c<K, V> a(b.c<K, V> param1c);
    
    public Map.Entry<K, V> a() {
      b.c c1 = this.b;
      this.b = b();
      return c1;
    }
    
    public void a_(b.c<K, V> param1c) {
      if (this.a == param1c && param1c == this.b) {
        this.b = null;
        this.a = null;
      } 
      b.c c1 = this.a;
      if (c1 == param1c)
        this.a = b(c1); 
      if (this.b == param1c)
        this.b = b(); 
    }
    
    abstract b.c<K, V> b(b.c<K, V> param1c);
    
    public boolean hasNext() { return (this.b != null); }
  }
  
  static interface f<K, V> {
    void a_(b.c<K, V> param1c);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */