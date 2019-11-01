package android.arch.a.b;

import java.util.HashMap;
import java.util.Map;

public class a<K, V> extends b<K, V> {
  private HashMap<K, b.c<K, V>> a = new HashMap();
  
  protected b.c<K, V> a(K paramK) { return (b.c)this.a.get(paramK); }
  
  public V a(K paramK, V paramV) {
    b.c c = a(paramK);
    if (c != null)
      return (V)c.b; 
    this.a.put(paramK, b(paramK, paramV));
    return null;
  }
  
  public V b(K paramK) {
    Object object = super.b(paramK);
    this.a.remove(paramK);
    return (V)object;
  }
  
  public boolean c(K paramK) { return this.a.containsKey(paramK); }
  
  public Map.Entry<K, V> d(K paramK) { return c(paramK) ? ((b.c)this.a.get(paramK)).d : null; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */