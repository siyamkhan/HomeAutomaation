package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v4.h.x;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

public class bn implements aj {
  Toolbar a;
  
  CharSequence b;
  
  Window.Callback c;
  
  boolean d;
  
  private int e;
  
  private View f;
  
  private View g;
  
  private Drawable h;
  
  private Drawable i;
  
  private Drawable j;
  
  private boolean k;
  
  private CharSequence l;
  
  private CharSequence m;
  
  private c n;
  
  private int o = 0;
  
  private int p = 0;
  
  private Drawable q;
  
  public bn(Toolbar paramToolbar, boolean paramBoolean) { this(paramToolbar, paramBoolean, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material); }
  
  public bn(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2) {
    this.a = paramToolbar;
    this.b = paramToolbar.getTitle();
    this.l = paramToolbar.getSubtitle();
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.k = bool;
    this.j = paramToolbar.getNavigationIcon();
    bm bm = bm.a(paramToolbar.getContext(), null, a.j.ActionBar, a.a.actionBarStyle, 0);
    this.q = bm.a(a.j.ActionBar_homeAsUpIndicator);
    if (paramBoolean) {
      CharSequence charSequence1 = bm.c(a.j.ActionBar_title);
      if (!TextUtils.isEmpty(charSequence1))
        b(charSequence1); 
      CharSequence charSequence2 = bm.c(a.j.ActionBar_subtitle);
      if (!TextUtils.isEmpty(charSequence2))
        c(charSequence2); 
      Drawable drawable1 = bm.a(a.j.ActionBar_logo);
      if (drawable1 != null)
        b(drawable1); 
      Drawable drawable2 = bm.a(a.j.ActionBar_icon);
      if (drawable2 != null)
        a(drawable2); 
      if (this.j == null) {
        Drawable drawable = this.q;
        if (drawable != null)
          c(drawable); 
      } 
      c(bm.a(a.j.ActionBar_displayOptions, 0));
      int i1 = bm.g(a.j.ActionBar_customNavigationLayout, 0);
      if (i1 != 0) {
        a(LayoutInflater.from(this.a.getContext()).inflate(i1, this.a, false));
        c(0x10 | this.e);
      } 
      int i2 = bm.f(a.j.ActionBar_height, 0);
      if (i2 > 0) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.height = i2;
        this.a.setLayoutParams(layoutParams);
      } 
      int i3 = bm.d(a.j.ActionBar_contentInsetStart, -1);
      int i4 = bm.d(a.j.ActionBar_contentInsetEnd, -1);
      if (i3 >= 0 || i4 >= 0)
        this.a.a(Math.max(i3, 0), Math.max(i4, 0)); 
      int i5 = bm.g(a.j.ActionBar_titleTextStyle, 0);
      if (i5 != 0) {
        Toolbar toolbar = this.a;
        toolbar.a(toolbar.getContext(), i5);
      } 
      int i6 = bm.g(a.j.ActionBar_subtitleTextStyle, 0);
      if (i6 != 0) {
        Toolbar toolbar = this.a;
        toolbar.b(toolbar.getContext(), i6);
      } 
      int i7 = bm.g(a.j.ActionBar_popupTheme, 0);
      if (i7 != 0)
        this.a.setPopupTheme(i7); 
    } else {
      this.e = r();
    } 
    bm.a();
    e(paramInt1);
    this.m = this.a.getNavigationContentDescription();
    this.a.setNavigationOnClickListener(new View.OnClickListener(this) {
          final a a;
          
          public void onClick(View param1View) {
            if (this.b.c != null && this.b.d)
              this.b.c.onMenuItemSelected(0, this.a); 
          }
        });
  }
  
  private void e(CharSequence paramCharSequence) {
    this.b = paramCharSequence;
    if ((0x8 & this.e) != 0)
      this.a.setTitle(paramCharSequence); 
  }
  
  private int r() {
    if (this.a.getNavigationIcon() != null) {
      this.q = this.a.getNavigationIcon();
      return 15;
    } 
    return 11;
  }
  
  private void s() {
    Drawable drawable;
    int i1 = this.e;
    if ((i1 & 0x2) != 0) {
      if ((i1 & true) != 0) {
        Drawable drawable1 = this.i;
        if (drawable1 != null) {
          this.a.setLogo(drawable1);
          return;
        } 
      } 
      drawable = this.h;
    } else {
      drawable = null;
    } 
    this.a.setLogo(drawable);
  }
  
  private void t() {
    Drawable drawable;
    Toolbar toolbar;
    if ((0x4 & this.e) != 0) {
      toolbar = this.a;
      drawable = this.j;
      if (drawable == null)
        drawable = this.q; 
    } else {
      toolbar = this.a;
      drawable = null;
    } 
    toolbar.setNavigationIcon(drawable);
  }
  
  private void u() {
    if ((0x4 & this.e) != 0) {
      if (TextUtils.isEmpty(this.m)) {
        this.a.setNavigationContentDescription(this.p);
        return;
      } 
      this.a.setNavigationContentDescription(this.m);
    } 
  }
  
  public v a(int paramInt, long paramLong) {
    float f1;
    v v = r.l(this.a);
    if (paramInt == 0) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    } 
    return v.a(f1).a(paramLong).a(new x(this, paramInt) {
          private boolean c = false;
          
          public void a(View param1View) { this.b.a.setVisibility(0); }
          
          public void b(View param1View) {
            if (!this.c)
              this.b.a.setVisibility(this.a); 
          }
          
          public void c(View param1View) { this.c = true; }
        });
  }
  
  public ViewGroup a() { return this.a; }
  
  public void a(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = a.b(b(), paramInt);
    } else {
      drawable = null;
    } 
    a(drawable);
  }
  
  public void a(Drawable paramDrawable) {
    this.h = paramDrawable;
    s();
  }
  
  public void a(o.a parama, h.a parama1) { this.a.a(parama, parama1); }
  
  public void a(be parambe) {
    View view = this.f;
    if (view != null) {
      ViewParent viewParent = view.getParent();
      Toolbar toolbar = this.a;
      if (viewParent == toolbar)
        toolbar.removeView(this.f); 
    } 
    this.f = parambe;
    if (parambe != null && this.o == 2) {
      this.a.addView(this.f, 0);
      Toolbar.b b1 = (Toolbar.b)this.f.getLayoutParams();
      b1.width = -2;
      b1.height = -2;
      b1.a = 8388691;
      parambe.setAllowCollapse(true);
    } 
  }
  
  public void a(Menu paramMenu, o.a parama) {
    if (this.n == null) {
      this.n = new c(this.a.getContext());
      this.n.a(a.f.action_menu_presenter);
    } 
    this.n.a(parama);
    this.a.a((h)paramMenu, this.n);
  }
  
  public void a(View paramView) {
    View view = this.g;
    if (view != null && (0x10 & this.e) != 0)
      this.a.removeView(view); 
    this.g = paramView;
    if (paramView != null && (0x10 & this.e) != 0)
      this.a.addView(this.g); 
  }
  
  public void a(Window.Callback paramCallback) { this.c = paramCallback; }
  
  public void a(CharSequence paramCharSequence) {
    if (!this.k)
      e(paramCharSequence); 
  }
  
  public void a(boolean paramBoolean) { this.a.setCollapsible(paramBoolean); }
  
  public Context b() { return this.a.getContext(); }
  
  public void b(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = a.b(b(), paramInt);
    } else {
      drawable = null;
    } 
    b(drawable);
  }
  
  public void b(Drawable paramDrawable) {
    this.i = paramDrawable;
    s();
  }
  
  public void b(CharSequence paramCharSequence) {
    this.k = true;
    e(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt) {
    int i1 = paramInt ^ this.e;
    this.e = paramInt;
    if (i1 != 0) {
      if ((i1 & 0x4) != 0) {
        if ((paramInt & 0x4) != 0)
          u(); 
        t();
      } 
      if ((i1 & 0x3) != 0)
        s(); 
      if ((i1 & 0x8) != 0) {
        Toolbar toolbar;
        CharSequence charSequence;
        if ((paramInt & 0x8) != 0) {
          this.a.setTitle(this.b);
          toolbar = this.a;
          charSequence = this.l;
        } else {
          Toolbar toolbar1 = this.a;
          charSequence = null;
          toolbar1.setTitle(null);
          toolbar = this.a;
        } 
        toolbar.setSubtitle(charSequence);
      } 
      if ((i1 & 0x10) != 0) {
        View view = this.g;
        if (view != null) {
          if ((paramInt & 0x10) != 0) {
            this.a.addView(view);
            return;
          } 
          this.a.removeView(view);
        } 
      } 
    } 
  }
  
  public void c(Drawable paramDrawable) {
    this.j = paramDrawable;
    t();
  }
  
  public void c(CharSequence paramCharSequence) {
    this.l = paramCharSequence;
    if ((0x8 & this.e) != 0)
      this.a.setSubtitle(paramCharSequence); 
  }
  
  public boolean c() { return this.a.g(); }
  
  public void d() { this.a.h(); }
  
  public void d(int paramInt) { this.a.setVisibility(paramInt); }
  
  public void d(CharSequence paramCharSequence) {
    this.m = paramCharSequence;
    u();
  }
  
  public CharSequence e() { return this.a.getTitle(); }
  
  public void e(int paramInt) {
    if (paramInt == this.p)
      return; 
    this.p = paramInt;
    if (TextUtils.isEmpty(this.a.getNavigationContentDescription()))
      f(this.p); 
  }
  
  public void f() { Log.i("ToolbarWidgetWrapper", "Progress display unsupported"); }
  
  public void f(int paramInt) {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = b().getString(paramInt);
    } 
    d(str);
  }
  
  public void g() { Log.i("ToolbarWidgetWrapper", "Progress display unsupported"); }
  
  public boolean h() { return this.a.a(); }
  
  public boolean i() { return this.a.b(); }
  
  public boolean j() { return this.a.c(); }
  
  public boolean k() { return this.a.d(); }
  
  public boolean l() { return this.a.e(); }
  
  public void m() { this.d = true; }
  
  public void n() { this.a.f(); }
  
  public int o() { return this.e; }
  
  public int p() { return this.o; }
  
  public Menu q() { return this.a.getMenu(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */