package android.support.e;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class q extends m {
  int h;
  
  boolean i = false;
  
  private ArrayList<m> j = new ArrayList();
  
  private boolean k = true;
  
  private int l = 0;
  
  private void r() {
    a a = new a(this);
    Iterator iterator = this.j.iterator();
    while (iterator.hasNext())
      ((m)iterator.next()).a(a); 
    this.h = this.j.size();
  }
  
  public q a(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
        stringBuilder.append(paramInt);
        throw new AndroidRuntimeException(stringBuilder.toString());
      case 1:
        bool = false;
        this.k = bool;
        return this;
      case 0:
        break;
    } 
    boolean bool = true;
    this.k = bool;
    return this;
  }
  
  public q a(m paramm) {
    this.j.add(paramm);
    paramm.d = this;
    if (this.a >= 0L)
      paramm.a(this.a); 
    if ((true & this.l) != 0)
      paramm.a(d()); 
    if ((0x2 & this.l) != 0)
      paramm.a(n()); 
    if ((0x4 & this.l) != 0)
      paramm.a(l()); 
    if ((0x8 & this.l) != 0)
      paramm.a(m()); 
    return this;
  }
  
  String a(String paramString) {
    String str = super.a(paramString);
    for (byte b = 0; b < this.j.size(); b++) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("\n");
      m m1 = (m)this.j.get(b);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString);
      stringBuilder2.append("  ");
      stringBuilder1.append(m1.a(stringBuilder2.toString()));
      str = stringBuilder1.toString();
    } 
    return str;
  }
  
  public void a(g paramg) {
    super.a(paramg);
    this.l = 0x4 | this.l;
    for (byte b = 0; b < this.j.size(); b++)
      ((m)this.j.get(b)).a(paramg); 
  }
  
  public void a(m.b paramb) {
    super.a(paramb);
    this.l = 0x8 | this.l;
    int n = this.j.size();
    for (byte b1 = 0; b1 < n; b1++)
      ((m)this.j.get(b1)).a(paramb); 
  }
  
  public void a(p paramp) {
    super.a(paramp);
    this.l = 0x2 | this.l;
    int n = this.j.size();
    for (byte b = 0; b < n; b++)
      ((m)this.j.get(b)).a(paramp); 
  }
  
  public void a(s params) {
    if (a(params.b))
      for (m m1 : this.j) {
        if (m1.a(params.b)) {
          m1.a(params);
          params.c.add(m1);
        } 
      }  
  }
  
  protected void a(ViewGroup paramViewGroup, t paramt1, t paramt2, ArrayList<s> paramArrayList1, ArrayList<s> paramArrayList2) {
    long l1 = c();
    int n = this.j.size();
    for (byte b = 0; b < n; b++) {
      m m1 = (m)this.j.get(b);
      if (l1 > 0L && (this.k || b == 0)) {
        long l2 = m1.c();
        if (l2 > 0L) {
          m1.b(l2 + l1);
        } else {
          m1.b(l1);
        } 
      } 
      m1.a(paramViewGroup, paramt1, paramt2, paramArrayList1, paramArrayList2);
    } 
  }
  
  public m b(int paramInt) { return (paramInt < 0 || paramInt >= this.j.size()) ? null : (m)this.j.get(paramInt); }
  
  public q b(TimeInterpolator paramTimeInterpolator) {
    this.l = true | this.l;
    ArrayList arrayList = this.j;
    if (arrayList != null) {
      int n = arrayList.size();
      for (byte b = 0; b < n; b++)
        ((m)this.j.get(b)).a(paramTimeInterpolator); 
    } 
    return (q)super.a(paramTimeInterpolator);
  }
  
  public void b(s params) {
    if (a(params.b))
      for (m m1 : this.j) {
        if (m1.a(params.b)) {
          m1.b(params);
          params.c.add(m1);
        } 
      }  
  }
  
  public q c(long paramLong) {
    super.a(paramLong);
    if (this.a >= 0L) {
      int n = this.j.size();
      for (byte b = 0; b < n; b++)
        ((m)this.j.get(b)).a(paramLong); 
    } 
    return this;
  }
  
  public q c(m.c paramc) { return (q)super.a(paramc); }
  
  void c(s params) {
    super.c(params);
    int n = this.j.size();
    for (byte b = 0; b < n; b++)
      ((m)this.j.get(b)).c(params); 
  }
  
  public q d(long paramLong) { return (q)super.b(paramLong); }
  
  public q d(m.c paramc) { return (q)super.b(paramc); }
  
  public void d(View paramView) {
    super.d(paramView);
    int n = this.j.size();
    for (byte b = 0; b < n; b++)
      ((m)this.j.get(b)).d(paramView); 
  }
  
  protected void e() {
    if (this.j.isEmpty()) {
      j();
      k();
      return;
    } 
    r();
    if (!this.k) {
      for (byte b = 1; b < this.j.size(); b++) {
        ((m)this.j.get(b - true)).a(new n(this, (m)this.j.get(b)) {
              public void a(m param1m) {
                this.a.e();
                param1m.b(this);
              }
            });
      } 
      m m1 = (m)this.j.get(0);
      if (m1 != null) {
        m1.e();
        return;
      } 
    } else {
      Iterator iterator = this.j.iterator();
      while (iterator.hasNext())
        ((m)iterator.next()).e(); 
    } 
  }
  
  public void e(View paramView) {
    super.e(paramView);
    int n = this.j.size();
    for (byte b = 0; b < n; b++)
      ((m)this.j.get(b)).e(paramView); 
  }
  
  public q f(View paramView) {
    for (byte b = 0; b < this.j.size(); b++)
      ((m)this.j.get(b)).b(paramView); 
    return (q)super.b(paramView);
  }
  
  public q g(View paramView) {
    for (byte b = 0; b < this.j.size(); b++)
      ((m)this.j.get(b)).c(paramView); 
    return (q)super.c(paramView);
  }
  
  public m o() {
    q q1 = (q)super.o();
    q1.j = new ArrayList();
    int n = this.j.size();
    for (byte b = 0; b < n; b++)
      q1.a(((m)this.j.get(b)).o()); 
    return q1;
  }
  
  public int q() { return this.j.size(); }
  
  static class a extends n {
    q a;
    
    a(q param1q) { this.a = param1q; }
    
    public void a(m param1m) {
      q q1 = this.a;
      q1.h = -1 + q1.h;
      if (this.a.h == 0) {
        q q2 = this.a;
        q2.i = false;
        q2.k();
      } 
      param1m.b(this);
    }
    
    public void d(m param1m) {
      if (!this.a.i) {
        this.a.j();
        this.a.i = true;
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */