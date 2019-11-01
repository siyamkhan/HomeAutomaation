package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

public class p {
  private final HashMap<String, n> a = new HashMap();
  
  final n a(String paramString) { return (n)this.a.get(paramString); }
  
  public final void a() {
    Iterator iterator = this.a.values().iterator();
    while (iterator.hasNext())
      ((n)iterator.next()).a(); 
    this.a.clear();
  }
  
  final void a(String paramString, n paramn) {
    n n1 = (n)this.a.put(paramString, paramn);
    if (n1 != null)
      n1.a(); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */