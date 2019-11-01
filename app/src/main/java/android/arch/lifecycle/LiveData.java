package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.b.b;
import java.util.Map;

public abstract class LiveData<T> extends Object {
  private static final Object b = new Object();
  
  private final Object a = new Object();
  
  private b<k<T>, a> c = new b();
  
  private int d = 0;
  
  private int g;
  
  private boolean h;
  
  private boolean i;
  
  private final Runnable j;
  
  public LiveData() {
    Object object = b;
    this.e = object;
    this.f = object;
    this.g = -1;
    this.j = new Runnable(this) {
        public void run() {
          synchronized (LiveData.a(this.a)) {
            Object object = LiveData.b(this.a);
            LiveData.a(this.a, LiveData.e());
            this.a.a(object);
            return;
          } 
        }
      };
  }
  
  private void a(a parama) {
    if (!parama.d)
      return; 
    if (!parama.a()) {
      parama.a(false);
      return;
    } 
    int k = parama.e;
    int m = this.g;
    if (k >= m)
      return; 
    parama.e = m;
    parama.c.a(this.e);
  }
  
  private static void a(String paramString) {
    if (a.a().b())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot invoke ");
    stringBuilder.append(paramString);
    stringBuilder.append(" on a background");
    stringBuilder.append(" thread");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void b(a parama) {
    if (this.h) {
      this.i = true;
      return;
    } 
    this.h = true;
    do {
      this.i = false;
      if (parama != null) {
        a(parama);
        parama = null;
      } else {
        b.d d1 = this.c.c();
        while (d1.hasNext()) {
          a((a)((Map.Entry)d1.next()).getValue());
          if (this.i)
            break; 
        } 
      } 
    } while (this.i);
    this.h = false;
  }
  
  public T a() {
    Object object = this.e;
    return (object != b) ? (T)object : null;
  }
  
  public void a(e parame, k<T> paramk) {
    if (parame.a().a() == c.b.a)
      return; 
    LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(this, parame, paramk);
    a a1 = (a)this.c.a(paramk, lifecycleBoundObserver);
    if (a1 == null || a1.a(parame)) {
      if (a1 != null)
        return; 
      parame.a().a(lifecycleBoundObserver);
      return;
    } 
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  public void a(k<T> paramk) {
    a("removeObserver");
    a a1 = (a)this.c.b(paramk);
    if (a1 == null)
      return; 
    a1.b();
    a1.a(false);
  }
  
  protected void a(T paramT) {
    a("setValue");
    this.g = 1 + this.g;
    this.e = paramT;
    b(null);
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public boolean d() { return (this.d > 0); }
  
  class LifecycleBoundObserver extends a implements GenericLifecycleObserver {
    final e a;
    
    LifecycleBoundObserver(LiveData this$0, e param1e, k<T> param1k) {
      super(this$0, param1k);
      this.a = param1e;
    }
    
    public void a(e param1e, c.a param1a) {
      if (this.a.a().a() == c.b.a) {
        this.b.a(this.c);
        return;
      } 
      a(a());
    }
    
    boolean a() { return this.a.a().a().a(c.b.d); }
    
    boolean a(e param1e) { return (this.a == param1e); }
    
    void b() { this.a.a().b(this); }
  }
  
  private abstract class a {
    final k<T> c;
    
    boolean d;
    
    int e = -1;
    
    a(LiveData this$0, k<T> param1k) { this.c = param1k; }
    
    void a(boolean param1Boolean) {
      boolean bool;
      if (param1Boolean == this.d)
        return; 
      this.d = param1Boolean;
      int i = LiveData.c(this.f);
      int j = 1;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      LiveData liveData;
      int m = (liveData = this.f).c(liveData);
      if (!this.d)
        j = -1; 
      LiveData.a(liveData, m + j);
      if (bool && this.d)
        this.f.b(); 
      if (LiveData.c(this.f) == 0 && !this.d)
        this.f.c(); 
      if (this.d)
        LiveData.a(this.f, this); 
    }
    
    abstract boolean a();
    
    boolean a(e param1e) { return false; }
    
    void b() {}
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\LiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */