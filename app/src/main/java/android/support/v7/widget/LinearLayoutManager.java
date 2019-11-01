package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.t.b {
  private c a;
  
  private boolean b;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private boolean e = true;
  
  private boolean f;
  
  private final b g = new b();
  
  private int h = 2;
  
  int i = 1;
  
  ax j;
  
  boolean k = false;
  
  int l = -1;
  
  int m = Integer.MIN_VALUE;
  
  d n = null;
  
  final a o = new a();
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean) {
    b(paramInt);
    b(paramBoolean);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    RecyclerView.i.b b1 = a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(b1.a);
    b(b1.c);
    a(b1.d);
  }
  
  private void K() {
    boolean bool;
    if (this.i == 1 || !h()) {
      bool = this.c;
    } else {
      bool = true ^ this.c;
    } 
    this.k = bool;
  }
  
  private View L() {
    byte b1;
    if (this.k) {
      b1 = -1 + v();
    } else {
      b1 = 0;
    } 
    return i(b1);
  }
  
  private View M() {
    int i1;
    if (this.k) {
      i1 = 0;
    } else {
      i1 = -1 + v();
    } 
    return i(i1);
  }
  
  private int a(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu, boolean paramBoolean) {
    int i1 = this.j.d() - paramInt;
    if (i1 > 0) {
      int i2 = -c(-i1, paramp, paramu);
      int i3 = paramInt + i2;
      if (paramBoolean) {
        int i4 = this.j.d() - i3;
        if (i4 > 0) {
          this.j.a(i4);
          return i4 + i2;
        } 
      } 
      return i2;
    } 
    return 0;
  }
  
  private View a(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.k) {
      int i2 = -1 + v();
      byte b2 = -1;
      return a(i2, b2, paramBoolean1, paramBoolean2);
    } 
    int i1 = v();
    byte b1 = 0;
    return a(b1, i1, paramBoolean1, paramBoolean2);
  }
  
  private void a(int paramInt1, int paramInt2) {
    boolean bool;
    this.a.c = this.j.d() - paramInt2;
    c c1 = this.a;
    if (this.k) {
      bool = true;
    } else {
      bool = true;
    } 
    c1.e = bool;
    c c2 = this.a;
    c2.d = paramInt1;
    c2.f = 1;
    c2.b = paramInt2;
    c2.g = Integer.MIN_VALUE;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.u paramu) {
    int i1;
    this.a.l = k();
    this.a.h = b(paramu);
    c c1 = this.a;
    c1.f = paramInt1;
    byte b1 = -1;
    if (paramInt1 == 1) {
      c1.h += this.j.g();
      View view = M();
      c c3 = this.a;
      if (!this.k)
        b1 = 1; 
      c3.e = b1;
      this.a.d = d(view) + this.a.e;
      this.a.b = this.j.b(view);
      i1 = this.j.b(view) - this.j.d();
    } else {
      View view = L();
      c c3 = this.a;
      c3.h += this.j.c();
      c c4 = this.a;
      if (this.k)
        b1 = 1; 
      c4.e = b1;
      this.a.d = d(view) + this.a.e;
      this.a.b = this.j.a(view);
      i1 = -this.j.a(view) + this.j.c();
    } 
    c c2 = this.a;
    c2.c = paramInt2;
    if (paramBoolean)
      c2.c -= i1; 
    this.a.g = i1;
  }
  
  private void a(a parama) { a(parama.b, parama.c); }
  
  private void a(RecyclerView.p paramp, int paramInt) {
    if (paramInt < 0)
      return; 
    int i1 = v();
    if (this.k) {
      int i2 = i1 - 1;
      for (int i3 = i2; i3 >= 0; i3--) {
        View view = i(i3);
        if (this.j.b(view) > paramInt || this.j.c(view) > paramInt) {
          a(paramp, i2, i3);
          return;
        } 
      } 
    } else {
      for (byte b1 = 0; b1 < i1; b1++) {
        View view = i(b1);
        if (this.j.b(view) > paramInt || this.j.c(view) > paramInt) {
          a(paramp, 0, b1);
          break;
        } 
      } 
    } 
  }
  
  private void a(RecyclerView.p paramp, int paramInt1, int paramInt2) {
    if (paramInt1 == paramInt2)
      return; 
    if (paramInt2 > paramInt1) {
      for (int i1 = paramInt2 - 1; i1 >= paramInt1; i1--)
        a(i1, paramp); 
    } else {
      while (paramInt1 > paramInt2) {
        a(paramInt1, paramp);
        paramInt1--;
      } 
    } 
  }
  
  private void a(RecyclerView.p paramp, c paramc) {
    if (paramc.a) {
      if (paramc.l)
        return; 
      if (paramc.f == -1) {
        b(paramp, paramc.g);
        return;
      } 
      a(paramp, paramc.g);
    } 
  }
  
  private void a(RecyclerView.p paramp, RecyclerView.u paramu, a parama) {
    boolean bool;
    if (a(paramu, parama))
      return; 
    if (b(paramp, paramu, parama))
      return; 
    parama.b();
    if (this.d) {
      bool = -1 + paramu.e();
    } else {
      bool = false;
    } 
    parama.b = bool;
  }
  
  private boolean a(RecyclerView.u paramu, a parama) {
    if (!paramu.a()) {
      int i2;
      int i1 = this.l;
      if (i1 == -1)
        return false; 
      if (i1 < 0 || i1 >= paramu.e()) {
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        return false;
      } 
      parama.b = this.l;
      d d1 = this.n;
      if (d1 != null && d1.a()) {
        int i3;
        parama.d = this.n.c;
        if (parama.d) {
          i3 = this.j.d() - this.n.b;
        } else {
          i3 = this.j.c() + this.n.b;
        } 
        parama.c = i3;
        return true;
      } 
      if (this.m == Integer.MIN_VALUE) {
        View view = c(this.l);
        if (view != null) {
          int i3;
          if (this.j.e(view) > this.j.f()) {
            parama.b();
            return true;
          } 
          if (this.j.a(view) - this.j.c() < 0) {
            parama.c = this.j.c();
            parama.d = false;
            return true;
          } 
          if (this.j.d() - this.j.b(view) < 0) {
            parama.c = this.j.d();
            parama.d = true;
            return true;
          } 
          if (parama.d) {
            i3 = this.j.b(view) + this.j.b();
          } else {
            i3 = this.j.a(view);
          } 
          parama.c = i3;
          return true;
        } 
        if (v() > 0) {
          boolean bool1;
          int i3 = d(i(0));
          if (this.l < i3) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          boolean bool2 = this.k;
          boolean bool3 = false;
          if (bool1 == bool2)
            bool3 = true; 
          parama.d = bool3;
        } 
        parama.b();
        return true;
      } 
      boolean bool = this.k;
      parama.d = bool;
      if (bool) {
        i2 = this.j.d() - this.m;
      } else {
        i2 = this.j.c() + this.m;
      } 
      parama.c = i2;
      return true;
    } 
    return false;
  }
  
  private int b(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu, boolean paramBoolean) {
    int i1 = paramInt - this.j.c();
    if (i1 > 0) {
      int i2 = -c(i1, paramp, paramu);
      int i3 = paramInt + i2;
      if (paramBoolean) {
        int i4 = i3 - this.j.c();
        if (i4 > 0) {
          this.j.a(-i4);
          i2 -= i4;
        } 
      } 
      return i2;
    } 
    return 0;
  }
  
  private View b(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.k) {
      byte b2 = 0;
      int i2 = v();
      return a(b2, i2, paramBoolean1, paramBoolean2);
    } 
    int i1 = -1 + v();
    byte b1 = -1;
    return a(i1, b1, paramBoolean1, paramBoolean2);
  }
  
  private void b(a parama) { g(parama.b, parama.c); }
  
  private void b(RecyclerView.p paramp, int paramInt) {
    int i1 = v();
    if (paramInt < 0)
      return; 
    int i2 = this.j.e() - paramInt;
    if (this.k) {
      for (byte b1 = 0; b1 < i1; b1++) {
        View view = i(b1);
        if (this.j.a(view) < i2 || this.j.d(view) < i2) {
          a(paramp, 0, b1);
          return;
        } 
      } 
    } else {
      int i3 = i1 - 1;
      for (int i4 = i3; i4 >= 0; i4--) {
        View view = i(i4);
        if (this.j.a(view) < i2 || this.j.d(view) < i2) {
          a(paramp, i3, i4);
          break;
        } 
      } 
    } 
  }
  
  private void b(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt1, int paramInt2) {
    if (paramu.b() && v() != 0 && !paramu.a()) {
      if (!b())
        return; 
      List list = paramp.c();
      int i1 = list.size();
      int i2 = d(i(0));
      byte b1 = 0;
      int i3 = 0;
      int i4 = 0;
      while (b1 < i1) {
        RecyclerView.x x = (RecyclerView.x)list.get(b1);
        if (!x.q()) {
          boolean bool;
          int i5 = x.d();
          byte b2 = 1;
          if (i5 < i2) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool != this.k)
            b2 = -1; 
          if (b2 == -1) {
            i3 += this.j.e(x.a);
          } else {
            i4 += this.j.e(x.a);
          } 
        } 
        b1++;
      } 
      this.a.k = list;
      if (i3 > 0) {
        g(d(L()), paramInt1);
        c c1 = this.a;
        c1.h = i3;
        c1.c = 0;
        c1.a();
        a(paramp, this.a, paramu, false);
      } 
      if (i4 > 0) {
        a(d(M()), paramInt2);
        c c1 = this.a;
        c1.h = i4;
        c1.c = 0;
        c1.a();
        a(paramp, this.a, paramu, false);
      } 
      this.a.k = null;
    } 
  }
  
  private boolean b(RecyclerView.p paramp, RecyclerView.u paramu, a parama) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual v : ()I
    //   4: ifne -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: invokevirtual E : ()Landroid/view/View;
    //   13: astore #4
    //   15: aload #4
    //   17: ifnull -> 44
    //   20: aload_3
    //   21: aload #4
    //   23: aload_2
    //   24: invokevirtual a : (Landroid/view/View;Landroid/support/v7/widget/RecyclerView$u;)Z
    //   27: ifeq -> 44
    //   30: aload_3
    //   31: aload #4
    //   33: aload_0
    //   34: aload #4
    //   36: invokevirtual d : (Landroid/view/View;)I
    //   39: invokevirtual a : (Landroid/view/View;I)V
    //   42: iconst_1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield b : Z
    //   48: aload_0
    //   49: getfield d : Z
    //   52: if_icmpeq -> 57
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_3
    //   58: getfield d : Z
    //   61: ifeq -> 75
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial f : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;)Landroid/view/View;
    //   70: astore #5
    //   72: goto -> 83
    //   75: aload_0
    //   76: aload_1
    //   77: aload_2
    //   78: invokespecial g : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;)Landroid/view/View;
    //   81: astore #5
    //   83: aload #5
    //   85: ifnull -> 207
    //   88: aload_3
    //   89: aload #5
    //   91: aload_0
    //   92: aload #5
    //   94: invokevirtual d : (Landroid/view/View;)I
    //   97: invokevirtual b : (Landroid/view/View;I)V
    //   100: aload_2
    //   101: invokevirtual a : ()Z
    //   104: ifne -> 205
    //   107: aload_0
    //   108: invokevirtual b : ()Z
    //   111: ifeq -> 205
    //   114: aload_0
    //   115: getfield j : Landroid/support/v7/widget/ax;
    //   118: aload #5
    //   120: invokevirtual a : (Landroid/view/View;)I
    //   123: aload_0
    //   124: getfield j : Landroid/support/v7/widget/ax;
    //   127: invokevirtual d : ()I
    //   130: if_icmpge -> 163
    //   133: aload_0
    //   134: getfield j : Landroid/support/v7/widget/ax;
    //   137: aload #5
    //   139: invokevirtual b : (Landroid/view/View;)I
    //   142: istore #8
    //   144: aload_0
    //   145: getfield j : Landroid/support/v7/widget/ax;
    //   148: invokevirtual c : ()I
    //   151: istore #9
    //   153: iconst_0
    //   154: istore #6
    //   156: iload #8
    //   158: iload #9
    //   160: if_icmpge -> 166
    //   163: iconst_1
    //   164: istore #6
    //   166: iload #6
    //   168: ifeq -> 205
    //   171: aload_3
    //   172: getfield d : Z
    //   175: ifeq -> 190
    //   178: aload_0
    //   179: getfield j : Landroid/support/v7/widget/ax;
    //   182: invokevirtual d : ()I
    //   185: istore #7
    //   187: goto -> 199
    //   190: aload_0
    //   191: getfield j : Landroid/support/v7/widget/ax;
    //   194: invokevirtual c : ()I
    //   197: istore #7
    //   199: aload_3
    //   200: iload #7
    //   202: putfield c : I
    //   205: iconst_1
    //   206: ireturn
    //   207: iconst_0
    //   208: ireturn }
  
  private View f(RecyclerView.p paramp, RecyclerView.u paramu) { return this.k ? h(paramp, paramu) : i(paramp, paramu); }
  
  private View g(RecyclerView.p paramp, RecyclerView.u paramu) { return this.k ? i(paramp, paramu) : h(paramp, paramu); }
  
  private void g(int paramInt1, int paramInt2) {
    byte b1;
    this.a.c = paramInt2 - this.j.c();
    c c1 = this.a;
    c1.d = paramInt1;
    if (this.k) {
      b1 = 1;
    } else {
      b1 = -1;
    } 
    c1.e = b1;
    c c2 = this.a;
    c2.f = -1;
    c2.b = paramInt2;
    c2.g = Integer.MIN_VALUE;
  }
  
  private View h(RecyclerView.p paramp, RecyclerView.u paramu) { return a(paramp, paramu, 0, v(), paramu.e()); }
  
  private int i(RecyclerView.u paramu) {
    if (v() == 0)
      return 0; 
    i();
    return bd.a(paramu, this.j, a(true ^ this.e, true), b(true ^ this.e, true), this, this.e, this.k);
  }
  
  private View i(RecyclerView.p paramp, RecyclerView.u paramu) { return a(paramp, paramu, -1 + v(), -1, paramu.e()); }
  
  private int j(RecyclerView.u paramu) {
    if (v() == 0)
      return 0; 
    i();
    return bd.a(paramu, this.j, a(true ^ this.e, true), b(true ^ this.e, true), this, this.e);
  }
  
  private View j(RecyclerView.p paramp, RecyclerView.u paramu) { return this.k ? l(paramp, paramu) : m(paramp, paramu); }
  
  private int k(RecyclerView.u paramu) {
    if (v() == 0)
      return 0; 
    i();
    return bd.b(paramu, this.j, a(true ^ this.e, true), b(true ^ this.e, true), this, this.e);
  }
  
  private View k(RecyclerView.p paramp, RecyclerView.u paramu) { return this.k ? m(paramp, paramu) : l(paramp, paramu); }
  
  private View l(RecyclerView.p paramp, RecyclerView.u paramu) { return b(0, v()); }
  
  private View m(RecyclerView.p paramp, RecyclerView.u paramu) { return b(-1 + v(), -1); }
  
  public int a(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) { return (this.i == 1) ? 0 : c(paramInt, paramp, paramu); }
  
  int a(RecyclerView.p paramp, c paramc, RecyclerView.u paramu, boolean paramBoolean) {
    int i1 = paramc.c;
    if (paramc.g != Integer.MIN_VALUE) {
      if (paramc.c < 0)
        paramc.g += paramc.c; 
      a(paramp, paramc);
    } 
    int i2 = paramc.c + paramc.h;
    b b1 = this.g;
    while ((paramc.l || i2 > 0) && paramc.a(paramu)) {
      b1.a();
      a(paramp, paramu, paramc, b1);
      if (b1.b)
        break; 
      paramc.b += b1.a * paramc.f;
      if (!b1.c || this.a.k != null || !paramu.a()) {
        paramc.c -= b1.a;
        i2 -= b1.a;
      } 
      if (paramc.g != Integer.MIN_VALUE) {
        paramc.g += b1.a;
        if (paramc.c < 0)
          paramc.g += paramc.c; 
        a(paramp, paramc);
      } 
      if (paramBoolean && b1.d)
        break; 
    } 
    return i1 - paramc.c;
  }
  
  public RecyclerView.j a() { return new RecyclerView.j(-2, -2); }
  
  View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    bs bs;
    char c2;
    i();
    char c1 = 'ŀ';
    if (paramBoolean1) {
      c2 = '怃';
    } else {
      c2 = 'ŀ';
    } 
    if (!paramBoolean2)
      c1 = Character.MIN_VALUE; 
    if (this.i == 0) {
      bs = this.r;
    } else {
      bs = this.s;
    } 
    return bs.a(paramInt1, paramInt2, c2, c1);
  }
  
  View a(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt1, int paramInt2, int paramInt3) {
    int i3;
    i();
    int i1 = this.j.c();
    int i2 = this.j.d();
    if (paramInt2 > paramInt1) {
      i3 = 1;
    } else {
      i3 = -1;
    } 
    View view1 = null;
    View view2 = null;
    while (paramInt1 != paramInt2) {
      View view = i(paramInt1);
      int i4 = d(view);
      if (i4 >= 0 && i4 < paramInt3)
        if (((RecyclerView.j)view.getLayoutParams()).d()) {
          if (view2 == null)
            view2 = view; 
        } else if (this.j.a(view) >= i2 || this.j.b(view) < i1) {
          if (view1 == null)
            view1 = view; 
        } else {
          return view;
        }  
      paramInt1 += i3;
    } 
    return (view1 != null) ? view1 : view2;
  }
  
  public View a(View paramView, int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) {
    View view2;
    View view1;
    K();
    if (v() == 0)
      return null; 
    int i1 = f(paramInt);
    if (i1 == Integer.MIN_VALUE)
      return null; 
    i();
    i();
    a(i1, (int)(0.33333334F * this.j.f()), false, paramu);
    c c1 = this.a;
    c1.g = Integer.MIN_VALUE;
    c1.a = false;
    a(paramp, c1, paramu, true);
    if (i1 == -1) {
      view1 = k(paramp, paramu);
    } else {
      view1 = j(paramp, paramu);
    } 
    if (i1 == -1) {
      view2 = L();
    } else {
      view2 = M();
    } 
    return view2.hasFocusable() ? ((view1 == null) ? null : view2) : view1;
  }
  
  public void a(int paramInt1, int paramInt2, RecyclerView.u paramu, RecyclerView.i.a parama) {
    if (this.i != 0)
      paramInt1 = paramInt2; 
    if (v() != 0) {
      byte b1;
      if (paramInt1 == 0)
        return; 
      i();
      if (paramInt1 > 0) {
        b1 = 1;
      } else {
        b1 = -1;
      } 
      a(b1, Math.abs(paramInt1), true, paramu);
      a(paramu, this.a, parama);
    } 
  }
  
  public void a(int paramInt, RecyclerView.i.a parama) {
    int i2;
    boolean bool;
    d d1 = this.n;
    int i1 = -1;
    if (d1 != null && d1.a()) {
      bool = this.n.c;
      i2 = this.n.a;
    } else {
      K();
      bool = this.k;
      i2 = this.l;
      if (i2 == i1)
        if (bool) {
          i2 = paramInt - 1;
        } else {
          i2 = 0;
        }  
    } 
    if (!bool)
      i1 = 1; 
    for (byte b1 = 0; b1 < this.h && i2 >= 0 && i2 < paramInt; b1++) {
      parama.b(i2, 0);
      i2 += i1;
    } 
  }
  
  public void a(Parcelable paramParcelable) {
    if (paramParcelable instanceof d) {
      this.n = (d)paramParcelable;
      o();
    } 
  }
  
  void a(RecyclerView.p paramp, RecyclerView.u paramu, a parama, int paramInt) {}
  
  void a(RecyclerView.p paramp, RecyclerView.u paramu, c paramc, b paramb) {
    int i4;
    int i3;
    int i2;
    int i1;
    View view = paramc.a(paramp);
    if (view == null) {
      paramb.b = true;
      return;
    } 
    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
    if (paramc.k == null) {
      boolean bool1;
      boolean bool = this.k;
      if (paramc.f == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool == bool1) {
        b(view);
      } else {
        b(view, 0);
      } 
    } else {
      boolean bool1;
      boolean bool = this.k;
      if (paramc.f == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool == bool1) {
        a(view);
      } else {
        a(view, 0);
      } 
    } 
    a(view, 0, 0);
    paramb.a = this.j.e(view);
    if (this.i == 1) {
      int i5;
      if (h()) {
        i5 = y() - C();
        i4 = i5 - this.j.f(view);
      } else {
        i4 = A();
        i5 = i4 + this.j.f(view);
      } 
      if (paramc.f == -1) {
        int i6 = paramc.b;
        i2 = paramc.b - paramb.a;
        i1 = i5;
        i3 = i6;
      } else {
        int i6 = paramc.b;
        i3 = paramc.b + paramb.a;
        i1 = i5;
        i2 = i6;
      } 
    } else {
      int i5 = B();
      int i6 = i5 + this.j.f(view);
      if (paramc.f == -1) {
        int i7 = paramc.b;
        int i8 = paramc.b - paramb.a;
        i2 = i5;
        i1 = i7;
        i3 = i6;
        i4 = i8;
      } else {
        int i7 = paramc.b;
        i1 = paramc.b + paramb.a;
        i2 = i5;
        i3 = i6;
        i4 = i7;
      } 
    } 
    a(view, i4, i2, i1, i3);
    if (j1.d() || j1.e())
      paramb.c = true; 
    paramb.d = view.hasFocusable();
  }
  
  public void a(RecyclerView.u paramu) {
    super.a(paramu);
    this.n = null;
    this.l = -1;
    this.m = Integer.MIN_VALUE;
    this.o.a();
  }
  
  void a(RecyclerView.u paramu, c paramc, RecyclerView.i.a parama) {
    int i1 = paramc.d;
    if (i1 >= 0 && i1 < paramu.e())
      parama.b(i1, Math.max(0, paramc.g)); 
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.p paramp) {
    super.a(paramRecyclerView, paramp);
    if (this.f) {
      c(paramp);
      paramp.a();
    } 
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent) {
    super.a(paramAccessibilityEvent);
    if (v() > 0) {
      paramAccessibilityEvent.setFromIndex(m());
      paramAccessibilityEvent.setToIndex(n());
    } 
  }
  
  public void a(String paramString) {
    if (this.n == null)
      super.a(paramString); 
  }
  
  public void a(boolean paramBoolean) {
    a(null);
    if (this.d == paramBoolean)
      return; 
    this.d = paramBoolean;
    o();
  }
  
  public int b(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) { return (this.i == 0) ? 0 : c(paramInt, paramp, paramu); }
  
  protected int b(RecyclerView.u paramu) { return paramu.d() ? this.j.f() : 0; }
  
  View b(int paramInt1, int paramInt2) {
    bs bs;
    char c2;
    char c1;
    boolean bool;
    i();
    if (paramInt2 > paramInt1) {
      bool = true;
    } else if (paramInt2 < paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool)
      return i(paramInt1); 
    if (this.j.a(i(paramInt1)) < this.j.c()) {
      c1 = '䄄';
      c2 = '䀄';
    } else {
      c1 = '၁';
      c2 = 'ခ';
    } 
    if (this.i == 0) {
      bs = this.r;
    } else {
      bs = this.s;
    } 
    return bs.a(paramInt1, paramInt2, c1, c2);
  }
  
  public void b(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      a(null);
      if (paramInt != this.i || this.j == null) {
        this.j = ax.a(this, paramInt);
        this.o.a = this.j;
        this.i = paramInt;
        o();
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("invalid orientation:");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void b(boolean paramBoolean) {
    a(null);
    if (paramBoolean == this.c)
      return; 
    this.c = paramBoolean;
    o();
  }
  
  public boolean b() { return (this.n == null && this.b == this.d); }
  
  int c(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) {
    if (v() != 0) {
      int i1;
      if (paramInt == 0)
        return 0; 
      this.a.a = true;
      i();
      if (paramInt > 0) {
        i1 = 1;
      } else {
        i1 = -1;
      } 
      int i2 = Math.abs(paramInt);
      a(i1, i2, true, paramu);
      int i3 = this.a.g + a(paramp, this.a, paramu, false);
      if (i3 < 0)
        return 0; 
      if (i2 > i3)
        paramInt = i1 * i3; 
      this.j.a(-paramInt);
      this.a.j = paramInt;
      return paramInt;
    } 
    return 0;
  }
  
  public int c(RecyclerView.u paramu) { return i(paramu); }
  
  public View c(int paramInt) {
    int i1 = v();
    if (i1 == 0)
      return null; 
    int i2 = paramInt - d(i(0));
    if (i2 >= 0 && i2 < i1) {
      View view = i(i2);
      if (d(view) == paramInt)
        return view; 
    } 
    return super.c(paramInt);
  }
  
  public void c(RecyclerView.p paramp, RecyclerView.u paramu) {
    int i6;
    int i5;
    int i2;
    d d1 = this.n;
    byte b1 = -1;
    if ((d1 != null || this.l != b1) && paramu.e() == 0) {
      c(paramp);
      return;
    } 
    d d2 = this.n;
    if (d2 != null && d2.a())
      this.l = this.n.a; 
    i();
    this.a.a = false;
    K();
    View view = E();
    if (!this.o.e || this.l != b1 || this.n != null) {
      this.o.a();
      a a1 = this.o;
      a1.d = this.k ^ this.d;
      a(paramp, paramu, a1);
      this.o.e = true;
    } else if (view != null && (this.j.a(view) >= this.j.d() || this.j.b(view) <= this.j.c())) {
      this.o.a(view, d(view));
    } 
    int i1 = b(paramu);
    if (this.a.j >= 0) {
      i2 = i1;
      i1 = 0;
    } else {
      i2 = 0;
    } 
    int i3 = i1 + this.j.c();
    int i4 = i2 + this.j.g();
    if (paramu.a()) {
      int i7 = this.l;
      if (i7 != b1 && this.m != Integer.MIN_VALUE) {
        View view1 = c(i7);
        if (view1 != null) {
          int i9;
          int i8;
          if (this.k) {
            i9 = this.j.d() - this.j.b(view1);
            i8 = this.m;
          } else {
            i8 = this.j.a(view1) - this.j.c();
            i9 = this.m;
          } 
          int i10 = i9 - i8;
          if (i10 > 0) {
            i3 += i10;
          } else {
            i4 -= i10;
          } 
        } 
      } 
    } 
    if (this.o.d ? this.k : !this.k)
      b1 = 1; 
    a(paramp, paramu, this.o, b1);
    a(paramp);
    this.a.l = k();
    this.a.i = paramu.a();
    if (this.o.d) {
      b(this.o);
      c c1 = this.a;
      c1.h = i3;
      a(paramp, c1, paramu, false);
      i6 = this.a.b;
      int i7 = this.a.d;
      if (this.a.c > 0)
        i4 += this.a.c; 
      a(this.o);
      c c2 = this.a;
      c2.h = i4;
      c2.d += this.a.e;
      a(paramp, this.a, paramu, false);
      i5 = this.a.b;
      if (this.a.c > 0) {
        int i8 = this.a.c;
        g(i7, i6);
        c c3 = this.a;
        c3.h = i8;
        a(paramp, c3, paramu, false);
        i6 = this.a.b;
      } 
    } else {
      a(this.o);
      c c1 = this.a;
      c1.h = i4;
      a(paramp, c1, paramu, false);
      i5 = this.a.b;
      int i7 = this.a.d;
      if (this.a.c > 0)
        i3 += this.a.c; 
      b(this.o);
      c c2 = this.a;
      c2.h = i3;
      c2.d += this.a.e;
      a(paramp, this.a, paramu, false);
      i6 = this.a.b;
      if (this.a.c > 0) {
        int i8 = this.a.c;
        a(i7, i5);
        c c3 = this.a;
        c3.h = i8;
        a(paramp, c3, paramu, false);
        i5 = this.a.b;
      } 
    } 
    if (v() > 0) {
      int i9;
      int i8;
      int i7;
      if (this.k ^ this.d) {
        int i10 = a(i5, paramp, paramu, true);
        i7 = i6 + i10;
        i8 = i5 + i10;
        i9 = b(i7, paramp, paramu, false);
      } else {
        int i10 = b(i6, paramp, paramu, true);
        i7 = i6 + i10;
        i8 = i5 + i10;
        i9 = a(i8, paramp, paramu, false);
      } 
      i6 = i7 + i9;
      i5 = i8 + i9;
    } 
    b(paramp, paramu, i6, i5);
    if (!paramu.a()) {
      this.j.a();
    } else {
      this.o.a();
    } 
    this.b = this.d;
  }
  
  public boolean c() { return true; }
  
  public int d(RecyclerView.u paramu) { return i(paramu); }
  
  public PointF d(int paramInt) {
    if (v() == 0)
      return null; 
    int i1 = d(i(0));
    byte b1 = 1;
    boolean bool = false;
    if (paramInt < i1)
      bool = true; 
    if (bool != this.k)
      b1 = -1; 
    return (this.i == 0) ? new PointF(b1, 0.0F) : new PointF(0.0F, b1);
  }
  
  public Parcelable d() {
    d d1 = this.n;
    if (d1 != null)
      return new d(d1); 
    d d2 = new d();
    if (v() > 0) {
      i();
      boolean bool = this.b ^ this.k;
      d2.c = bool;
      if (bool) {
        View view1 = M();
        d2.b = this.j.d() - this.j.b(view1);
        d2.a = d(view1);
        return d2;
      } 
      View view = L();
      d2.a = d(view);
      d2.b = this.j.a(view) - this.j.c();
      return d2;
    } 
    d2.b();
    return d2;
  }
  
  public int e(RecyclerView.u paramu) { return j(paramu); }
  
  public void e(int paramInt) {
    this.l = paramInt;
    this.m = Integer.MIN_VALUE;
    d d1 = this.n;
    if (d1 != null)
      d1.b(); 
    o();
  }
  
  public boolean e() { return (this.i == 0); }
  
  int f(int paramInt) {
    int i1 = Integer.MIN_VALUE;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt != 130) {
            switch (paramInt) {
              default:
                return i1;
              case 2:
                return (this.i == 1) ? 1 : (h() ? -1 : 1);
              case 1:
                break;
            } 
            return (this.i == 1) ? -1 : (h() ? 1 : -1);
          } 
          if (this.i == 1)
            i1 = 1; 
          return i1;
        } 
        if (this.i == 0)
          i1 = 1; 
        return i1;
      } 
      return (this.i == 1) ? -1 : Integer.MIN_VALUE;
    } 
    return (this.i == 0) ? -1 : Integer.MIN_VALUE;
  }
  
  public int f(RecyclerView.u paramu) { return j(paramu); }
  
  public boolean f() { return (this.i == 1); }
  
  public int g() { return this.i; }
  
  public int g(RecyclerView.u paramu) { return k(paramu); }
  
  public int h(RecyclerView.u paramu) { return k(paramu); }
  
  protected boolean h() { return (t() == 1); }
  
  void i() {
    if (this.a == null)
      this.a = j(); 
  }
  
  c j() { return new c(); }
  
  boolean k() { return (this.j.h() == 0 && this.j.e() == 0); }
  
  boolean l() { return (x() != 1073741824 && w() != 1073741824 && J()); }
  
  public int m() {
    View view = a(0, v(), false, true);
    return (view == null) ? -1 : d(view);
  }
  
  public int n() {
    View view = a(v() - 1, -1, false, true);
    return (view == null) ? -1 : d(view);
  }
  
  static class a {
    ax a;
    
    int b;
    
    int c;
    
    boolean d;
    
    boolean e;
    
    a() { a(); }
    
    void a() {
      this.b = -1;
      this.c = Integer.MIN_VALUE;
      this.d = false;
      this.e = false;
    }
    
    public void a(View param1View, int param1Int) {
      int i = this.a.b();
      if (i >= 0) {
        b(param1View, param1Int);
        return;
      } 
      this.b = param1Int;
      if (this.d) {
        int j = this.a.d() - i - this.a.b(param1View);
        this.c = this.a.d() - j;
        if (j > 0) {
          int k = this.a.e(param1View);
          int m = this.c - k;
          int n = this.a.c();
          int i1 = m - n + Math.min(this.a.a(param1View) - n, 0);
          if (i1 < 0) {
            this.c += Math.min(j, -i1);
            return;
          } 
        } 
      } else {
        int j = this.a.a(param1View);
        int k = j - this.a.c();
        this.c = j;
        if (k > 0) {
          int m = j + this.a.e(param1View);
          int n = this.a.d() - i - this.a.b(param1View);
          int i1 = this.a.d() - Math.min(0, n) - m;
          if (i1 < 0)
            this.c -= Math.min(k, -i1); 
        } 
      } 
    }
    
    boolean a(View param1View, RecyclerView.u param1u) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      return (!j.d() && j.f() >= 0 && j.f() < param1u.e());
    }
    
    void b() {
      int i;
      if (this.d) {
        i = this.a.d();
      } else {
        i = this.a.c();
      } 
      this.c = i;
    }
    
    public void b(View param1View, int param1Int) {
      int i;
      if (this.d) {
        i = this.a.b(param1View) + this.a.b();
      } else {
        i = this.a.a(param1View);
      } 
      this.c = i;
      this.b = param1Int;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AnchorInfo{mPosition=");
      stringBuilder.append(this.b);
      stringBuilder.append(", mCoordinate=");
      stringBuilder.append(this.c);
      stringBuilder.append(", mLayoutFromEnd=");
      stringBuilder.append(this.d);
      stringBuilder.append(", mValid=");
      stringBuilder.append(this.e);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  protected static class b {
    public int a;
    
    public boolean b;
    
    public boolean c;
    
    public boolean d;
    
    void a() {
      this.a = 0;
      this.b = false;
      this.c = false;
      this.d = false;
    }
  }
  
  static class c {
    boolean a = true;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    int g;
    
    int h = 0;
    
    boolean i = false;
    
    int j;
    
    List<RecyclerView.x> k = null;
    
    boolean l;
    
    private View b() {
      int m = this.k.size();
      for (byte b1 = 0; b1 < m; b1++) {
        View view = ((RecyclerView.x)this.k.get(b1)).a;
        RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
        if (!j1.d() && this.d == j1.f()) {
          a(view);
          return view;
        } 
      } 
      return null;
    }
    
    View a(RecyclerView.p param1p) {
      if (this.k != null)
        return b(); 
      View view = param1p.c(this.d);
      this.d += this.e;
      return view;
    }
    
    public void a() { a(null); }
    
    public void a(View param1View) {
      int m;
      View view = b(param1View);
      if (view == null) {
        m = -1;
      } else {
        m = ((RecyclerView.j)view.getLayoutParams()).f();
      } 
      this.d = m;
    }
    
    boolean a(RecyclerView.u param1u) {
      int m = this.d;
      return (m >= 0 && m < param1u.e());
    }
    
    public View b(View param1View) {
      int m = this.k.size();
      View view = null;
      int n = Integer.MAX_VALUE;
      for (byte b1 = 0; b1 < m; b1++) {
        View view1 = ((RecyclerView.x)this.k.get(b1)).a;
        RecyclerView.j j1 = (RecyclerView.j)view1.getLayoutParams();
        if (view1 != param1View && !j1.d()) {
          int i1 = (j1.f() - this.d) * this.e;
          if (i1 >= 0 && i1 < n) {
            if (i1 == 0)
              return view1; 
            view = view1;
            n = i1;
          } 
        } 
      } 
      return view;
    }
  }
  
  public static class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        public LinearLayoutManager.d a(Parcel param2Parcel) { return new LinearLayoutManager.d(param2Parcel); }
        
        public LinearLayoutManager.d[] a(int param2Int) { return new LinearLayoutManager.d[param2Int]; }
      };
    
    int a;
    
    int b;
    
    boolean c;
    
    public d() {}
    
    d(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != bool)
        bool = false; 
      this.c = bool;
    }
    
    public d(d param1d) {
      this.a = param1d.a;
      this.b = param1d.b;
      this.c = param1d.c;
    }
    
    boolean a() { return (this.a >= 0); }
    
    void b() { this.a = -1; }
    
    public int describeContents() { return 0; }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeInt(this.c);
    }
  }
  
  static final class null extends Object implements Parcelable.Creator<d> {
    public LinearLayoutManager.d a(Parcel param1Parcel) { return new LinearLayoutManager.d(param1Parcel); }
    
    public LinearLayoutManager.d[] a(int param1Int) { return new LinearLayoutManager.d[param1Int]; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */