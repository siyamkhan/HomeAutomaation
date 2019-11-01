package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.h.r;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ak extends bf {
  private static TimeInterpolator i;
  
  ArrayList<ArrayList<RecyclerView.x>> a = new ArrayList();
  
  ArrayList<ArrayList<b>> b = new ArrayList();
  
  ArrayList<ArrayList<a>> c = new ArrayList();
  
  ArrayList<RecyclerView.x> d = new ArrayList();
  
  ArrayList<RecyclerView.x> e = new ArrayList();
  
  ArrayList<RecyclerView.x> f = new ArrayList();
  
  ArrayList<RecyclerView.x> g = new ArrayList();
  
  private ArrayList<RecyclerView.x> j = new ArrayList();
  
  private ArrayList<RecyclerView.x> k = new ArrayList();
  
  private ArrayList<b> l = new ArrayList();
  
  private ArrayList<a> m = new ArrayList();
  
  private void a(List<a> paramList, RecyclerView.x paramx) {
    for (int n = -1 + paramList.size(); n >= 0; n--) {
      a a1 = (a)paramList.get(n);
      if (a(a1, paramx) && a1.a == null && a1.b == null)
        paramList.remove(a1); 
    } 
  }
  
  private boolean a(a parama, RecyclerView.x paramx) {
    boolean bool;
    if (parama.b == paramx) {
      parama.b = null;
      bool = false;
    } else {
      if (parama.a == paramx) {
        parama.a = null;
        bool = true;
        paramx.a.setAlpha(1.0F);
        paramx.a.setTranslationX(0.0F);
        paramx.a.setTranslationY(0.0F);
        a(paramx, bool);
        return true;
      } 
      return false;
    } 
    paramx.a.setAlpha(1.0F);
    paramx.a.setTranslationX(0.0F);
    paramx.a.setTranslationY(0.0F);
    a(paramx, bool);
    return true;
  }
  
  private void b(a parama) {
    if (parama.a != null)
      a(parama, parama.a); 
    if (parama.b != null)
      a(parama, parama.b); 
  }
  
  private void u(RecyclerView.x paramx) {
    View view = paramx.a;
    ViewPropertyAnimator viewPropertyAnimator = view.animate();
    this.f.add(paramx);
    viewPropertyAnimator.setDuration(g()).alpha(0.0F).setListener(new AnimatorListenerAdapter(this, paramx, viewPropertyAnimator, view) {
          public void onAnimationEnd(Animator param1Animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0F);
            this.d.i(this.a);
            this.d.f.remove(this.a);
            this.d.c();
          }
          
          public void onAnimationStart(Animator param1Animator) { this.d.l(this.a); }
        }).start();
  }
  
  private void v(RecyclerView.x paramx) {
    if (i == null)
      i = (new ValueAnimator()).getInterpolator(); 
    paramx.a.animate().setInterpolator(i);
    d(paramx);
  }
  
  public void a() {
    boolean bool1 = true ^ this.j.isEmpty();
    boolean bool2 = true ^ this.l.isEmpty();
    boolean bool3 = true ^ this.m.isEmpty();
    boolean bool4 = true ^ this.k.isEmpty();
    if (!bool1 && !bool2 && !bool4 && !bool3)
      return; 
    Iterator iterator = this.j.iterator();
    while (iterator.hasNext())
      u((RecyclerView.x)iterator.next()); 
    this.j.clear();
    if (bool2) {
      ArrayList arrayList = new ArrayList();
      arrayList.addAll(this.l);
      this.b.add(arrayList);
      this.l.clear();
      Runnable runnable = new Runnable(this, arrayList) {
          public void run() {
            for (ak.b b1 : this.a)
              this.b.b(b1.a, b1.b, b1.c, b1.d, b1.e); 
            this.a.clear();
            this.b.b.remove(this.a);
          }
        };
      if (bool1) {
        r.a(((b)arrayList.get(0)).a.a, runnable, g());
      } else {
        runnable.run();
      } 
    } 
    if (bool3) {
      ArrayList arrayList = new ArrayList();
      arrayList.addAll(this.m);
      this.c.add(arrayList);
      this.m.clear();
      Runnable runnable = new Runnable(this, arrayList) {
          public void run() {
            for (ak.a a1 : this.a)
              this.b.a(a1); 
            this.a.clear();
            this.b.c.remove(this.a);
          }
        };
      if (bool1) {
        r.a(((a)arrayList.get(0)).a.a, runnable, g());
      } else {
        runnable.run();
      } 
    } 
    if (bool4) {
      ArrayList arrayList = new ArrayList();
      arrayList.addAll(this.k);
      this.a.add(arrayList);
      this.k.clear();
      Runnable runnable = new Runnable(this, arrayList) {
          public void run() {
            for (RecyclerView.x x : this.a)
              this.b.c(x); 
            this.a.clear();
            this.b.a.remove(this.a);
          }
        };
      if (bool1 || bool2 || bool3) {
        long l3;
        long l2;
        long l1 = 0L;
        if (bool1) {
          l2 = g();
        } else {
          l2 = l1;
        } 
        if (bool2) {
          l3 = e();
        } else {
          l3 = l1;
        } 
        if (bool3)
          l1 = h(); 
        long l4 = l2 + Math.max(l3, l1);
        r.a(((RecyclerView.x)arrayList.get(0)).a, runnable, l4);
        return;
      } 
      runnable.run();
      return;
    } 
  }
  
  void a(a parama) {
    View view1;
    RecyclerView.x x1 = parama.a;
    if (x1 == null) {
      view1 = null;
    } else {
      view1 = x1.a;
    } 
    RecyclerView.x x2 = parama.b;
    View view2 = null;
    if (x2 != null)
      view2 = x2.a; 
    if (view1 != null) {
      ViewPropertyAnimator viewPropertyAnimator = view1.animate().setDuration(h());
      this.g.add(parama.a);
      viewPropertyAnimator.translationX((parama.e - parama.c));
      viewPropertyAnimator.translationY((parama.f - parama.d));
      viewPropertyAnimator.alpha(0.0F).setListener(new AnimatorListenerAdapter(this, parama, viewPropertyAnimator, view1) {
            public void onAnimationEnd(Animator param1Animator) {
              this.b.setListener(null);
              this.c.setAlpha(1.0F);
              this.c.setTranslationX(0.0F);
              this.c.setTranslationY(0.0F);
              this.d.a(this.a.a, true);
              this.d.g.remove(this.a.a);
              this.d.c();
            }
            
            public void onAnimationStart(Animator param1Animator) { this.d.b(this.a.a, true); }
          }).start();
    } 
    if (view2 != null) {
      ViewPropertyAnimator viewPropertyAnimator = view2.animate();
      this.g.add(parama.b);
      viewPropertyAnimator.translationX(0.0F).translationY(0.0F).setDuration(h()).alpha(1.0F).setListener(new AnimatorListenerAdapter(this, parama, viewPropertyAnimator, view2) {
            public void onAnimationEnd(Animator param1Animator) {
              this.b.setListener(null);
              this.c.setAlpha(1.0F);
              this.c.setTranslationX(0.0F);
              this.c.setTranslationY(0.0F);
              this.d.a(this.a.b, false);
              this.d.g.remove(this.a.b);
              this.d.c();
            }
            
            public void onAnimationStart(Animator param1Animator) { this.d.b(this.a.b, false); }
          }).start();
    } 
  }
  
  void a(List<RecyclerView.x> paramList) {
    for (int n = -1 + paramList.size(); n >= 0; n--)
      ((RecyclerView.x)paramList.get(n)).a.animate().cancel(); 
  }
  
  public boolean a(RecyclerView.x paramx) {
    v(paramx);
    this.j.add(paramx);
    return true;
  }
  
  public boolean a(RecyclerView.x paramx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    View view = paramx.a;
    int n = paramInt1 + (int)paramx.a.getTranslationX();
    int i1 = paramInt2 + (int)paramx.a.getTranslationY();
    v(paramx);
    int i2 = paramInt3 - n;
    int i3 = paramInt4 - i1;
    if (i2 == 0 && i3 == 0) {
      j(paramx);
      return false;
    } 
    if (i2 != 0)
      view.setTranslationX(-i2); 
    if (i3 != 0)
      view.setTranslationY(-i3); 
    ArrayList arrayList = this.l;
    b b1 = new b(paramx, n, i1, paramInt3, paramInt4);
    arrayList.add(b1);
    return true;
  }
  
  public boolean a(RecyclerView.x paramx1, RecyclerView.x paramx2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramx1 == paramx2)
      return a(paramx1, paramInt1, paramInt2, paramInt3, paramInt4); 
    float f1 = paramx1.a.getTranslationX();
    float f2 = paramx1.a.getTranslationY();
    float f3 = paramx1.a.getAlpha();
    v(paramx1);
    int n = (int)((paramInt3 - paramInt1) - f1);
    int i1 = (int)((paramInt4 - paramInt2) - f2);
    paramx1.a.setTranslationX(f1);
    paramx1.a.setTranslationY(f2);
    paramx1.a.setAlpha(f3);
    if (paramx2 != null) {
      v(paramx2);
      paramx2.a.setTranslationX(-n);
      paramx2.a.setTranslationY(-i1);
      paramx2.a.setAlpha(0.0F);
    } 
    ArrayList arrayList = this.m;
    a a1 = new a(paramx1, paramx2, paramInt1, paramInt2, paramInt3, paramInt4);
    arrayList.add(a1);
    return true;
  }
  
  public boolean a(RecyclerView.x paramx, List<Object> paramList) { return (!paramList.isEmpty() || super.a(paramx, paramList)); }
  
  void b(RecyclerView.x paramx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    View view = paramx.a;
    int n = paramInt3 - paramInt1;
    int i1 = paramInt4 - paramInt2;
    if (n != 0)
      view.animate().translationX(0.0F); 
    if (i1 != 0)
      view.animate().translationY(0.0F); 
    ViewPropertyAnimator viewPropertyAnimator1 = view.animate();
    this.e.add(paramx);
    ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator1.setDuration(e());
    AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this, paramx, n, view, i1, viewPropertyAnimator1) {
        public void onAnimationCancel(Animator param1Animator) {
          if (this.b != 0)
            this.c.setTranslationX(0.0F); 
          if (this.d != 0)
            this.c.setTranslationY(0.0F); 
        }
        
        public void onAnimationEnd(Animator param1Animator) {
          this.e.setListener(null);
          this.f.j(this.a);
          this.f.e.remove(this.a);
          this.f.c();
        }
        
        public void onAnimationStart(Animator param1Animator) { this.f.m(this.a); }
      };
    viewPropertyAnimator2.setListener(animatorListenerAdapter).start();
  }
  
  public boolean b() { return (!this.k.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.j.isEmpty() || !this.e.isEmpty() || !this.f.isEmpty() || !this.d.isEmpty() || !this.g.isEmpty() || !this.b.isEmpty() || !this.a.isEmpty() || !this.c.isEmpty()); }
  
  public boolean b(RecyclerView.x paramx) {
    v(paramx);
    paramx.a.setAlpha(0.0F);
    this.k.add(paramx);
    return true;
  }
  
  void c() {
    if (!b())
      i(); 
  }
  
  void c(RecyclerView.x paramx) {
    View view = paramx.a;
    ViewPropertyAnimator viewPropertyAnimator = view.animate();
    this.d.add(paramx);
    viewPropertyAnimator.alpha(1.0F).setDuration(f()).setListener(new AnimatorListenerAdapter(this, paramx, view, viewPropertyAnimator) {
          public void onAnimationCancel(Animator param1Animator) { this.b.setAlpha(1.0F); }
          
          public void onAnimationEnd(Animator param1Animator) {
            this.c.setListener(null);
            this.d.k(this.a);
            this.d.d.remove(this.a);
            this.d.c();
          }
          
          public void onAnimationStart(Animator param1Animator) { this.d.n(this.a); }
        }).start();
  }
  
  public void d() {
    for (int n = -1 + this.l.size(); n >= 0; n--) {
      b b1 = (b)this.l.get(n);
      View view = b1.a.a;
      view.setTranslationY(0.0F);
      view.setTranslationX(0.0F);
      j(b1.a);
      this.l.remove(n);
    } 
    for (int i1 = -1 + this.j.size(); i1 >= 0; i1--) {
      i((RecyclerView.x)this.j.get(i1));
      this.j.remove(i1);
    } 
    for (int i2 = -1 + this.k.size(); i2 >= 0; i2--) {
      RecyclerView.x x = (RecyclerView.x)this.k.get(i2);
      x.a.setAlpha(1.0F);
      k(x);
      this.k.remove(i2);
    } 
    for (int i3 = -1 + this.m.size(); i3 >= 0; i3--)
      b((a)this.m.get(i3)); 
    this.m.clear();
    if (!b())
      return; 
    for (int i4 = -1 + this.b.size(); i4 >= 0; i4--) {
      ArrayList arrayList = (ArrayList)this.b.get(i4);
      for (int i7 = -1 + arrayList.size(); i7 >= 0; i7--) {
        b b1 = (b)arrayList.get(i7);
        View view = b1.a.a;
        view.setTranslationY(0.0F);
        view.setTranslationX(0.0F);
        j(b1.a);
        arrayList.remove(i7);
        if (arrayList.isEmpty())
          this.b.remove(arrayList); 
      } 
    } 
    for (int i5 = -1 + this.a.size(); i5 >= 0; i5--) {
      ArrayList arrayList = (ArrayList)this.a.get(i5);
      for (int i7 = -1 + arrayList.size(); i7 >= 0; i7--) {
        RecyclerView.x x = (RecyclerView.x)arrayList.get(i7);
        x.a.setAlpha(1.0F);
        k(x);
        arrayList.remove(i7);
        if (arrayList.isEmpty())
          this.a.remove(arrayList); 
      } 
    } 
    for (int i6 = -1 + this.c.size(); i6 >= 0; i6--) {
      ArrayList arrayList = (ArrayList)this.c.get(i6);
      for (int i7 = -1 + arrayList.size(); i7 >= 0; i7--) {
        b((a)arrayList.get(i7));
        if (arrayList.isEmpty())
          this.c.remove(arrayList); 
      } 
    } 
    a(this.f);
    a(this.e);
    a(this.d);
    a(this.g);
    i();
  }
  
  public void d(RecyclerView.x paramx) {
    View view = paramx.a;
    view.animate().cancel();
    for (int n = -1 + this.l.size(); n >= 0; n--) {
      if (((b)this.l.get(n)).a == paramx) {
        view.setTranslationY(0.0F);
        view.setTranslationX(0.0F);
        j(paramx);
        this.l.remove(n);
      } 
    } 
    a(this.m, paramx);
    if (this.j.remove(paramx)) {
      view.setAlpha(1.0F);
      i(paramx);
    } 
    if (this.k.remove(paramx)) {
      view.setAlpha(1.0F);
      k(paramx);
    } 
    for (int i1 = -1 + this.c.size(); i1 >= 0; i1--) {
      ArrayList arrayList = (ArrayList)this.c.get(i1);
      a(arrayList, paramx);
      if (arrayList.isEmpty())
        this.c.remove(i1); 
    } 
    for (int i2 = -1 + this.b.size(); i2 >= 0; i2--) {
      ArrayList arrayList = (ArrayList)this.b.get(i2);
      for (int i4 = -1 + arrayList.size(); i4 >= 0; i4--) {
        if (((b)arrayList.get(i4)).a == paramx) {
          view.setTranslationY(0.0F);
          view.setTranslationX(0.0F);
          j(paramx);
          arrayList.remove(i4);
          if (arrayList.isEmpty())
            this.b.remove(i2); 
          break;
        } 
      } 
    } 
    for (int i3 = -1 + this.a.size(); i3 >= 0; i3--) {
      ArrayList arrayList = (ArrayList)this.a.get(i3);
      if (arrayList.remove(paramx)) {
        view.setAlpha(1.0F);
        k(paramx);
        if (arrayList.isEmpty())
          this.a.remove(i3); 
      } 
    } 
    this.f.remove(paramx);
    this.d.remove(paramx);
    this.g.remove(paramx);
    this.e.remove(paramx);
    c();
  }
  
  private static class a {
    public RecyclerView.x a;
    
    public RecyclerView.x b;
    
    public int c;
    
    public int d;
    
    public int e;
    
    public int f;
    
    private a(RecyclerView.x param1x1, RecyclerView.x param1x2) {
      this.a = param1x1;
      this.b = param1x2;
    }
    
    a(RecyclerView.x param1x1, RecyclerView.x param1x2, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this(param1x1, param1x2);
      this.c = param1Int1;
      this.d = param1Int2;
      this.e = param1Int3;
      this.f = param1Int4;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ChangeInfo{oldHolder=");
      stringBuilder.append(this.a);
      stringBuilder.append(", newHolder=");
      stringBuilder.append(this.b);
      stringBuilder.append(", fromX=");
      stringBuilder.append(this.c);
      stringBuilder.append(", fromY=");
      stringBuilder.append(this.d);
      stringBuilder.append(", toX=");
      stringBuilder.append(this.e);
      stringBuilder.append(", toY=");
      stringBuilder.append(this.f);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  private static class b {
    public RecyclerView.x a;
    
    public int b;
    
    public int c;
    
    public int d;
    
    public int e;
    
    b(RecyclerView.x param1x, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.a = param1x;
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Int3;
      this.e = param1Int4;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */