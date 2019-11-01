package android.arch.lifecycle;

import android.arch.a.b.a;
import android.arch.a.b.b;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class f extends c {
  private a<d, a> a = new a();
  
  private c.b b;
  
  private final WeakReference<e> c;
  
  private int d = 0;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private ArrayList<c.b> g = new ArrayList();
  
  public f(e parame) {
    this.c = new WeakReference(parame);
    this.b = c.b.b;
  }
  
  static c.b a(c.b paramb1, c.b paramb2) {
    if (paramb2 != null && paramb2.compareTo(paramb1) < 0)
      paramb1 = paramb2; 
    return paramb1;
  }
  
  private void a(e parame) {
    b.d d1 = this.a.c();
    while (d1.hasNext() && !this.f) {
      Map.Entry entry = (Map.Entry)d1.next();
      a a1 = (a)entry.getValue();
      while (a1.a.compareTo(this.b) < 0 && !this.f && this.a.c(entry.getKey())) {
        c(a1.a);
        a1.a(parame, e(a1.a));
        c();
      } 
    } 
  }
  
  static c.b b(c.a parama) {
    StringBuilder stringBuilder;
    switch (null.a[parama.ordinal()]) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected event value ");
        stringBuilder.append(parama);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 6:
        return c.b.a;
      case 5:
        return c.b.e;
      case 3:
      case 4:
        return c.b.d;
      case 1:
      case 2:
        break;
    } 
    return c.b.c;
  }
  
  private void b(c.b paramb) {
    if (this.b == paramb)
      return; 
    this.b = paramb;
    if (this.e || this.d != 0) {
      this.f = true;
      return;
    } 
    this.e = true;
    d();
    this.e = false;
  }
  
  private void b(e parame) {
    Iterator iterator = this.a.b();
    while (iterator.hasNext() && !this.f) {
      Map.Entry entry = (Map.Entry)iterator.next();
      a a1 = (a)entry.getValue();
      while (a1.a.compareTo(this.b) > 0 && !this.f && this.a.c(entry.getKey())) {
        c.a a2 = d(a1.a);
        c(b(a2));
        a1.a(parame, a2);
        c();
      } 
    } 
  }
  
  private boolean b() {
    if (this.a.a() == 0)
      return true; 
    c.b b1 = ((a)this.a.d().getValue()).a;
    c.b b2 = ((a)this.a.e().getValue()).a;
    return (b1 == b2 && this.b == b2);
  }
  
  private c.b c(d paramd) {
    c.b b1;
    Map.Entry entry = this.a.d(paramd);
    if (entry != null) {
      b1 = ((a)entry.getValue()).a;
    } else {
      b1 = null;
    } 
    boolean bool = this.g.isEmpty();
    c.b b2 = null;
    if (!bool) {
      ArrayList arrayList = this.g;
      b2 = (c.b)arrayList.get(-1 + arrayList.size());
    } 
    return a(a(this.b, b1), b2);
  }
  
  private void c() {
    ArrayList arrayList = this.g;
    arrayList.remove(-1 + arrayList.size());
  }
  
  private void c(c.b paramb) { this.g.add(paramb); }
  
  private static c.a d(c.b paramb) {
    StringBuilder stringBuilder;
    switch (null.b[paramb.ordinal()]) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected state value ");
        stringBuilder.append(paramb);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 5:
        throw new IllegalArgumentException();
      case 4:
        return c.a.ON_PAUSE;
      case 3:
        return c.a.ON_STOP;
      case 2:
        return c.a.ON_DESTROY;
      case 1:
        break;
    } 
    throw new IllegalArgumentException();
  }
  
  private void d() {
    e e1 = (e)this.c.get();
    if (e1 == null) {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    } 
    while (!b()) {
      this.f = false;
      if (this.b.compareTo(((a)this.a.d().getValue()).a) < 0)
        b(e1); 
      Map.Entry entry = this.a.e();
      if (!this.f && entry != null && this.b.compareTo(((a)entry.getValue()).a) > 0)
        a(e1); 
    } 
    this.f = false;
  }
  
  private static c.a e(c.b paramb) {
    StringBuilder stringBuilder;
    switch (null.b[paramb.ordinal()]) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected state value ");
        stringBuilder.append(paramb);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 4:
        throw new IllegalArgumentException();
      case 3:
        return c.a.ON_RESUME;
      case 2:
        return c.a.ON_START;
      case 1:
      case 5:
        break;
    } 
    return c.a.ON_CREATE;
  }
  
  public c.b a() { return this.b; }
  
  public void a(c.a parama) { b(b(parama)); }
  
  public void a(c.b paramb) { b(paramb); }
  
  public void a(d paramd) {
    boolean bool;
    c.b b1;
    if (this.b == c.b.a) {
      b1 = c.b.a;
    } else {
      b1 = c.b.b;
    } 
    a a1 = new a(paramd, b1);
    if ((a)this.a.a(paramd, a1) != null)
      return; 
    e e1 = (e)this.c.get();
    if (e1 == null)
      return; 
    if (this.d != 0 || this.e) {
      bool = true;
    } else {
      bool = false;
    } 
    c.b b2 = c(paramd);
    this.d = 1 + this.d;
    while (a1.a.compareTo(b2) < 0 && this.a.c(paramd)) {
      c(a1.a);
      a1.a(e1, e(a1.a));
      c();
      b2 = c(paramd);
    } 
    if (!bool)
      d(); 
    this.d--;
  }
  
  public void b(d paramd) { this.a.b(paramd); }
  
  static class a {
    c.b a;
    
    GenericLifecycleObserver b;
    
    a(d param1d, c.b param1b) {
      this.b = h.a(param1d);
      this.a = param1b;
    }
    
    void a(e param1e, c.a param1a) {
      c.b b1 = f.b(param1a);
      this.a = f.a(this.a, b1);
      this.b.a(param1e, param1a);
      this.a = b1;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */