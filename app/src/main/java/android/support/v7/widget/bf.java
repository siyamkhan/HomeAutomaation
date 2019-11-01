package android.support.v7.widget;

import android.view.View;

public abstract class bf extends RecyclerView.f {
  boolean h = true;
  
  public final void a(RecyclerView.x paramx, boolean paramBoolean) {
    d(paramx, paramBoolean);
    f(paramx);
  }
  
  public abstract boolean a(RecyclerView.x paramx);
  
  public abstract boolean a(RecyclerView.x paramx, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean a(RecyclerView.x paramx, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2) {
    int n;
    int k;
    int i = paramc1.a;
    int j = paramc1.b;
    View view = paramx.a;
    if (paramc2 == null) {
      k = view.getLeft();
    } else {
      k = paramc2.a;
    } 
    int m = k;
    if (paramc2 == null) {
      n = view.getTop();
    } else {
      n = paramc2.b;
    } 
    int i1 = n;
    if (!paramx.q() && (i != m || j != i1)) {
      view.layout(m, i1, m + view.getWidth(), i1 + view.getHeight());
      return a(paramx, i, j, m, i1);
    } 
    return a(paramx);
  }
  
  public abstract boolean a(RecyclerView.x paramx1, RecyclerView.x paramx2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean a(RecyclerView.x paramx1, RecyclerView.x paramx2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2) {
    int m;
    int k;
    int i = paramc1.a;
    int j = paramc1.b;
    if (paramx2.c()) {
      int n = paramc1.a;
      m = paramc1.b;
      k = n;
    } else {
      int n = paramc2.a;
      int i1 = paramc2.b;
      k = n;
      m = i1;
    } 
    return a(paramx1, paramx2, i, j, k, m);
  }
  
  public final void b(RecyclerView.x paramx, boolean paramBoolean) { c(paramx, paramBoolean); }
  
  public abstract boolean b(RecyclerView.x paramx);
  
  public boolean b(RecyclerView.x paramx, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2) { return (paramc1 != null && (paramc1.a != paramc2.a || paramc1.b != paramc2.b)) ? a(paramx, paramc1.a, paramc1.b, paramc2.a, paramc2.b) : b(paramx); }
  
  public void c(RecyclerView.x paramx, boolean paramBoolean) {}
  
  public boolean c(RecyclerView.x paramx, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2) {
    if (paramc1.a != paramc2.a || paramc1.b != paramc2.b)
      return a(paramx, paramc1.a, paramc1.b, paramc2.a, paramc2.b); 
    j(paramx);
    return false;
  }
  
  public void d(RecyclerView.x paramx, boolean paramBoolean) {}
  
  public boolean h(RecyclerView.x paramx) { return (!this.h || paramx.n()); }
  
  public final void i(RecyclerView.x paramx) {
    p(paramx);
    f(paramx);
  }
  
  public final void j(RecyclerView.x paramx) {
    t(paramx);
    f(paramx);
  }
  
  public final void k(RecyclerView.x paramx) {
    r(paramx);
    f(paramx);
  }
  
  public final void l(RecyclerView.x paramx) { o(paramx); }
  
  public final void m(RecyclerView.x paramx) { s(paramx); }
  
  public final void n(RecyclerView.x paramx) { q(paramx); }
  
  public void o(RecyclerView.x paramx) {}
  
  public void p(RecyclerView.x paramx) {}
  
  public void q(RecyclerView.x paramx) {}
  
  public void r(RecyclerView.x paramx) {}
  
  public void s(RecyclerView.x paramx) {}
  
  public void t(RecyclerView.x paramx) {}
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */