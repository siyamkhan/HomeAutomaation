package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.c;
import android.support.v7.a.a;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class c extends b implements c.a {
  private b A;
  
  d g;
  
  e h;
  
  a i;
  
  c j;
  
  final f k = new f(this);
  
  int l;
  
  private Drawable m;
  
  private boolean n;
  
  private boolean o;
  
  private boolean p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private boolean w;
  
  private int x;
  
  private final SparseBooleanArray y = new SparseBooleanArray();
  
  private View z;
  
  public c(Context paramContext) { super(paramContext, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout); }
  
  private View a(MenuItem paramMenuItem) {
    ViewGroup viewGroup = (ViewGroup)this.f;
    if (viewGroup == null)
      return null; 
    int i1 = viewGroup.getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = viewGroup.getChildAt(b1);
      if (view instanceof p.a && ((p.a)view).getItemData() == paramMenuItem)
        return view; 
    } 
    return null;
  }
  
  public p a(ViewGroup paramViewGroup) {
    p p1 = this.f;
    p p2 = super.a(paramViewGroup);
    if (p1 != p2)
      ((ActionMenuView)p2).setPresenter(this); 
    return p2;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup) {
    byte b1;
    View view = paramj.getActionView();
    if (view == null || paramj.n())
      view = super.a(paramj, paramView, paramViewGroup); 
    if (paramj.isActionViewExpanded()) {
      b1 = 8;
    } else {
      b1 = 0;
    } 
    view.setVisibility(b1);
    ActionMenuView actionMenuView = (ActionMenuView)paramViewGroup;
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (!actionMenuView.checkLayoutParams(layoutParams))
      view.setLayoutParams(actionMenuView.a(layoutParams)); 
    return view;
  }
  
  public void a(Context paramContext, h paramh) {
    super.a(paramContext, paramh);
    Resources resources = paramContext.getResources();
    a a1 = a.a(paramContext);
    if (!this.p)
      this.o = a1.b(); 
    if (!this.v)
      this.q = a1.c(); 
    if (!this.t)
      this.s = a1.a(); 
    int i1 = this.q;
    if (this.o) {
      if (this.g == null) {
        this.g = new d(this, this.a);
        if (this.n) {
          this.g.setImageDrawable(this.m);
          this.m = null;
          this.n = false;
        } 
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.g.measure(i2, i2);
      } 
      i1 -= this.g.getMeasuredWidth();
    } else {
      this.g = null;
    } 
    this.r = i1;
    this.x = (int)(56.0F * (resources.getDisplayMetrics()).density);
    this.z = null;
  }
  
  public void a(Configuration paramConfiguration) {
    if (!this.t)
      this.s = a.a(this.b).a(); 
    if (this.c != null)
      this.c.b(true); 
  }
  
  public void a(Drawable paramDrawable) {
    d d1 = this.g;
    if (d1 != null) {
      d1.setImageDrawable(paramDrawable);
      return;
    } 
    this.n = true;
    this.m = paramDrawable;
  }
  
  public void a(h paramh, boolean paramBoolean) {
    f();
    super.a(paramh, paramBoolean);
  }
  
  public void a(j paramj, p.a parama) {
    parama.a(paramj, 0);
    ActionMenuView actionMenuView = (ActionMenuView)this.f;
    ActionMenuItemView actionMenuItemView = (ActionMenuItemView)parama;
    actionMenuItemView.setItemInvoker(actionMenuView);
    if (this.A == null)
      this.A = new b(this); 
    actionMenuItemView.setPopupCallback(this.A);
  }
  
  public void a(ActionMenuView paramActionMenuView) {
    this.f = paramActionMenuView;
    paramActionMenuView.a(this.c);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      super.a(null);
      return;
    } 
    if (this.c != null)
      this.c.a(false); 
  }
  
  public boolean a(int paramInt, j paramj) { return paramj.j(); }
  
  public boolean a(u paramu) {
    boolean bool;
    if (!paramu.hasVisibleItems())
      return false; 
    u u1;
    for (u1 = paramu; u1.t() != this.c; u1 = (u)u1.t());
    View view = a(u1.getItem());
    if (view == null)
      return false; 
    this.l = paramu.getItem().getItemId();
    int i1 = paramu.size();
    byte b1 = 0;
    while (true) {
      bool = false;
      if (b1 < i1) {
        MenuItem menuItem = paramu.getItem(b1);
        if (menuItem.isVisible() && menuItem.getIcon() != null) {
          bool = true;
          break;
        } 
        b1++;
        continue;
      } 
      break;
    } 
    this.i = new a(this, this.b, paramu, view);
    this.i.a(bool);
    this.i.a();
    super.a(paramu);
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, int paramInt) { return (paramViewGroup.getChildAt(paramInt) == this.g) ? false : super.a(paramViewGroup, paramInt); }
  
  public void b(boolean paramBoolean) {
    Object object;
    super.b(paramBoolean);
    ((View)this.f).requestLayout();
    if (this.c != null) {
      ArrayList arrayList = this.c.l();
      int i1 = arrayList.size();
      for (byte b1 = 0; b1 < i1; b1++) {
        c c1 = ((j)arrayList.get(b1)).a();
        if (c1 != null)
          c1.a(this); 
      } 
    } 
    if (this.c != null) {
      object = this.c.m();
    } else {
      object = null;
    } 
    boolean bool1 = this.o;
    boolean bool2 = false;
    if (bool1) {
      bool2 = false;
      if (object != null) {
        int i1 = object.size();
        if (i1 == 1) {
          bool2 = true ^ ((j)object.get(0)).isActionViewExpanded();
        } else {
          bool2 = false;
          if (i1 > 0)
            bool2 = true; 
        } 
      } 
    } 
    if (bool2) {
      if (this.g == null)
        this.g = new d(this, this.a); 
      ViewGroup viewGroup = (ViewGroup)this.g.getParent();
      if (viewGroup != this.f) {
        if (viewGroup != null)
          viewGroup.removeView(this.g); 
        ActionMenuView actionMenuView = (ActionMenuView)this.f;
        actionMenuView.addView(this.g, actionMenuView.c());
      } 
    } else {
      d d1 = this.g;
      if (d1 != null && d1.getParent() == this.f)
        ((ViewGroup)this.f).removeView(this.g); 
    } 
    ((ActionMenuView)this.f).setOverflowReserved(this.o);
  }
  
  public boolean b() {
    int i7;
    byte b4;
    byte b1;
    Object object;
    c c1 = this;
    if (c1.c != null) {
      object = c1.c.j();
      b1 = object.size();
    } else {
      object = null;
      b1 = 0;
    } 
    int i1 = c1.s;
    int i2 = c1.r;
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup viewGroup = (ViewGroup)c1.f;
    int i4 = i1;
    byte b2 = 0;
    boolean bool = false;
    int i5 = 0;
    byte b3 = 0;
    while (b2 < b1) {
      j j1 = (j)object.get(b2);
      if (j1.l()) {
        i5++;
      } else if (j1.k()) {
        b3++;
      } else {
        bool = true;
      } 
      if (c1.w && j1.isActionViewExpanded())
        i4 = 0; 
      b2++;
    } 
    if (c1.o && (bool || b3 + i5 > i4))
      i4--; 
    int i6 = i4 - i5;
    SparseBooleanArray sparseBooleanArray = c1.y;
    sparseBooleanArray.clear();
    if (c1.u) {
      int i10 = c1.x;
      i7 = i2 / i10;
      b4 = i10 + i2 % i10 / i7;
    } else {
      b4 = 0;
      i7 = 0;
    } 
    int i8 = i2;
    byte b5 = 0;
    int i9 = 0;
    while (b5 < b1) {
      byte b6;
      j j1 = (j)object.get(b5);
      if (j1.l()) {
        boolean bool1;
        View view = c1.a(j1, c1.z, viewGroup);
        if (c1.z == null)
          c1.z = view; 
        if (c1.u) {
          i7 -= ActionMenuView.a(view, b4, i7, i3, 0);
        } else {
          view.measure(i3, i3);
        } 
        int i10 = view.getMeasuredWidth();
        i8 -= i10;
        if (i9)
          i10 = i9; 
        int i11 = j1.getGroupId();
        if (i11 != 0) {
          bool1 = true;
          sparseBooleanArray.put(i11, bool1);
        } else {
          bool1 = true;
        } 
        j1.d(bool1);
        b6 = b1;
        i9 = i10;
      } else if (j1.k()) {
        boolean bool2;
        int i10 = j1.getGroupId();
        boolean bool1 = sparseBooleanArray.get(i10);
        if ((i6 > 0 || bool1) && i8 > 0 && (!c1.u || i7 > 0)) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (bool2) {
          byte b8;
          byte b7 = bool2;
          View view = c1.a(j1, c1.z, viewGroup);
          b6 = b1;
          if (c1.z == null)
            c1.z = view; 
          if (c1.u) {
            int i12 = ActionMenuView.a(view, b4, i7, i3, 0);
            i7 -= i12;
            if (i12 == 0)
              b7 = 0; 
          } else {
            view.measure(i3, i3);
          } 
          int i11 = view.getMeasuredWidth();
          i8 -= i11;
          if (i9 == 0)
            i9 = i11; 
          if (c1.u ? (i8 >= 0) : (i8 + i9 > 0)) {
            b8 = 1;
          } else {
            b8 = 0;
          } 
          bool2 = b7 & b8;
        } else {
          bool2;
          b6 = b1;
        } 
        if (bool2 && i10 != 0) {
          sparseBooleanArray.put(i10, true);
        } else if (bool1) {
          sparseBooleanArray.put(i10, false);
          for (byte b7 = 0; b7 < b5; b7++) {
            j j2 = (j)object.get(b7);
            if (j2.getGroupId() == i10) {
              if (j2.j())
                i6++; 
              j2.d(false);
            } 
          } 
        } 
        if (bool2)
          i6--; 
        j1.d(bool2);
      } else {
        b6 = b1;
        j1.d(false);
      } 
      b5++;
      b1 = b6;
      c1 = this;
    } 
    return true;
  }
  
  public Drawable c() {
    d d1 = this.g;
    return (d1 != null) ? d1.getDrawable() : (this.n ? this.m : null);
  }
  
  public void c(boolean paramBoolean) {
    this.o = paramBoolean;
    this.p = true;
  }
  
  public void d(boolean paramBoolean) { this.w = paramBoolean; }
  
  public boolean d() {
    if (this.o && !h() && this.c != null && this.f != null && this.j == null && !this.c.m().isEmpty()) {
      e e1 = new e(this, this.b, this.c, this.g, true);
      this.j = new c(this, e1);
      ((View)this.f).post(this.j);
      super.a(null);
      return true;
    } 
    return false;
  }
  
  public boolean e() {
    if (this.j != null && this.f != null) {
      ((View)this.f).removeCallbacks(this.j);
      this.j = null;
      return true;
    } 
    e e1 = this.h;
    if (e1 != null) {
      e1.d();
      return true;
    } 
    return false;
  }
  
  public boolean f() { return e() | g(); }
  
  public boolean g() {
    a a1 = this.i;
    if (a1 != null) {
      a1.d();
      return true;
    } 
    return false;
  }
  
  public boolean h() {
    e e1 = this.h;
    return (e1 != null && e1.f());
  }
  
  public boolean i() { return (this.j != null || h()); }
  
  private class a extends n {
    public a(c this$0, Context param1Context, u param1u, View param1View) {
      super(param1Context, param1u, param1View, false, a.a.actionOverflowMenuStyle);
      if (!((j)param1u.getItem()).j()) {
        c.d d;
        if (this$0.g == null) {
          d = (View)c.c(this$0);
        } else {
          d = this$0.g;
        } 
        a(d);
      } 
      a(this$0.k);
    }
    
    protected void e() {
      c c1 = this.a;
      c1.i = null;
      c1.l = 0;
      super.e();
    }
  }
  
  private class b extends ActionMenuItemView.b {
    b(c this$0) {}
    
    public s a() { return (this.a.i != null) ? this.a.i.b() : null; }
  }
  
  private class c implements Runnable {
    private c.e b;
    
    public c(c this$0, c.e param1e) { this.b = param1e; }
    
    public void run() {
      if (c.d(this.a) != null)
        c.e(this.a).g(); 
      View view = (View)c.f(this.a);
      if (view != null && view.getWindowToken() != null && this.b.c())
        this.a.h = this.b; 
      this.a.j = null;
    }
  }
  
  private class d extends q implements ActionMenuView.a {
    private final float[] b = new float[2];
    
    public d(c this$0, Context param1Context) {
      super(param1Context, null, a.a.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      bo.a(this, getContentDescription());
      setOnTouchListener(new ap(this, this, this$0) {
            public s a() { return (this.b.a.h == null) ? null : this.b.a.h.b(); }
            
            public boolean b() {
              this.b.a.d();
              return true;
            }
            
            public boolean c() {
              if (this.b.a.j != null)
                return false; 
              this.b.a.e();
              return true;
            }
          });
    }
    
    public boolean c() { return false; }
    
    public boolean d() { return false; }
    
    public boolean performClick() {
      if (super.performClick())
        return true; 
      playSoundEffect(0);
      this.a.d();
      return true;
    }
    
    protected boolean setFrame(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      boolean bool = super.setFrame(param1Int1, param1Int2, param1Int3, param1Int4);
      Drawable drawable1 = getDrawable();
      Drawable drawable2 = getBackground();
      if (drawable1 != null && drawable2 != null) {
        int i = getWidth();
        int j = getHeight();
        int k = Math.max(i, j) / 2;
        int m = getPaddingLeft() - getPaddingRight();
        int n = getPaddingTop() - getPaddingBottom();
        int i1 = (i + m) / 2;
        int i2 = (j + n) / 2;
        a.a(drawable2, i1 - k, i2 - k, i1 + k, i2 + k);
      } 
      return bool;
    }
  }
  
  class null extends ap {
    null(c this$0, View param1View, c param1c) { super(param1View); }
    
    public s a() { return (this.b.a.h == null) ? null : this.b.a.h.b(); }
    
    public boolean b() {
      this.b.a.d();
      return true;
    }
    
    public boolean c() {
      if (this.b.a.j != null)
        return false; 
      this.b.a.e();
      return true;
    }
  }
  
  private class e extends n {
    public e(c this$0, Context param1Context, h param1h, View param1View, boolean param1Boolean) {
      super(param1Context, param1h, param1View, param1Boolean, a.a.actionOverflowMenuStyle);
      a(8388613);
      a(this$0.k);
    }
    
    protected void e() {
      if (c.a(this.a) != null)
        c.b(this.a).close(); 
      this.a.h = null;
      super.e();
    }
  }
  
  private class f implements o.a {
    f(c this$0) {}
    
    public void a(h param1h, boolean param1Boolean) {
      if (param1h instanceof u)
        param1h.q().a(false); 
      o.a a1 = this.a.a();
      if (a1 != null)
        a1.a(param1h, param1Boolean); 
    }
    
    public boolean a(h param1h) {
      if (param1h == null)
        return false; 
      this.a.l = ((u)param1h).getItem().getItemId();
      o.a a1 = this.a.a();
      boolean bool = false;
      if (a1 != null)
        bool = a1.a(param1h); 
      return bool;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */