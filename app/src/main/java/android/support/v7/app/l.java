package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v4.h.w;
import android.support.v4.h.x;
import android.support.v4.h.y;
import android.support.v7.a.a;
import android.support.v7.view.a;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aj;
import android.support.v7.widget.be;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l extends a implements ActionBarOverlayLayout.a {
  private static final Interpolator t = new AccelerateInterpolator();
  
  private static final Interpolator u = new DecelerateInterpolator();
  
  private boolean A;
  
  private boolean B;
  
  private ArrayList<a.b> C = new ArrayList();
  
  private boolean D;
  
  private int E = 0;
  
  private boolean F;
  
  private boolean G = true;
  
  private boolean H;
  
  Context a;
  
  ActionBarOverlayLayout b;
  
  ActionBarContainer c;
  
  aj d;
  
  ActionBarContextView e;
  
  View f;
  
  be g;
  
  a h;
  
  b i;
  
  b.a j;
  
  boolean k = true;
  
  boolean l;
  
  boolean m;
  
  h n;
  
  boolean o;
  
  final w p = new x(this) {
      public void b(View param1View) {
        if (this.a.k && this.a.f != null) {
          this.a.f.setTranslationY(0.0F);
          this.a.c.setTranslationY(0.0F);
        } 
        this.a.c.setVisibility(8);
        this.a.c.setTransitioning(false);
        l l1 = this.a;
        l1.n = null;
        l1.h();
        if (this.a.b != null)
          r.p(this.a.b); 
      }
    };
  
  final w q = new x(this) {
      public void b(View param1View) {
        l l1 = this.a;
        l1.n = null;
        l1.c.requestLayout();
      }
    };
  
  final y r = new y(this) {
      public void a(View param1View) { ((View)this.a.c.getParent()).invalidate(); }
    };
  
  private Context v;
  
  private Activity w;
  
  private Dialog x;
  
  private ArrayList<Object> y = new ArrayList();
  
  private int z = -1;
  
  public l(Activity paramActivity, boolean paramBoolean) {
    this.w = paramActivity;
    View view = paramActivity.getWindow().getDecorView();
    a(view);
    if (!paramBoolean)
      this.f = view.findViewById(16908290); 
  }
  
  public l(Dialog paramDialog) {
    this.x = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  private void a(View paramView) {
    this.b = (ActionBarOverlayLayout)paramView.findViewById(a.f.decor_content_parent);
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    if (actionBarOverlayLayout != null)
      actionBarOverlayLayout.setActionBarVisibilityCallback(this); 
    this.d = b(paramView.findViewById(a.f.action_bar));
    this.e = (ActionBarContextView)paramView.findViewById(a.f.action_context_bar);
    this.c = (ActionBarContainer)paramView.findViewById(a.f.action_bar_container);
    aj aj1 = this.d;
    if (aj1 != null && this.e != null && this.c != null) {
      boolean bool1;
      boolean bool;
      this.a = aj1.b();
      if ((0x4 & this.d.o()) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        this.A = true; 
      a a1 = a.a(this.a);
      if (a1.f() || bool) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      c(bool1);
      l(a1.d());
      TypedArray typedArray = this.a.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      if (typedArray.getBoolean(a.j.ActionBar_hideOnContentScroll, false))
        d(true); 
      int i1 = typedArray.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
      if (i1 != 0)
        a(i1); 
      typedArray.recycle();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" can only be used ");
    stringBuilder.append("with a compatible window decor layout");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) { return paramBoolean3 ? true : (!(paramBoolean1 || paramBoolean2)); }
  
  private aj b(View paramView) {
    String str;
    if (paramView instanceof aj)
      return (aj)paramView; 
    if (paramView instanceof Toolbar)
      return ((Toolbar)paramView).getWrapper(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't make a decor toolbar out of ");
    if (paramView != null) {
      str = paramView.getClass().getSimpleName();
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void l(boolean paramBoolean) {
    boolean bool2;
    boolean bool;
    this.D = paramBoolean;
    if (!this.D) {
      this.d.a(null);
      this.c.setTabContainer(this.g);
    } else {
      this.c.setTabContainer(null);
      this.d.a(this.g);
    } 
    int i1 = i();
    boolean bool1 = true;
    if (i1 == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    be be1 = this.g;
    if (be1 != null)
      if (bool) {
        be1.setVisibility(0);
        ActionBarOverlayLayout actionBarOverlayLayout1 = this.b;
        if (actionBarOverlayLayout1 != null)
          r.p(actionBarOverlayLayout1); 
      } else {
        be1.setVisibility(8);
      }  
    aj aj1 = this.d;
    if (!this.D && bool) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    aj1.a(bool2);
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    if (this.D || !bool)
      bool1 = false; 
    actionBarOverlayLayout.setHasNonEmbeddedTabs(bool1);
  }
  
  private void m(boolean paramBoolean) {
    if (a(this.l, this.m, this.F)) {
      if (!this.G) {
        this.G = true;
        i(paramBoolean);
        return;
      } 
    } else if (this.G) {
      this.G = false;
      j(paramBoolean);
    } 
  }
  
  private void n() {
    if (!this.F) {
      this.F = true;
      ActionBarOverlayLayout actionBarOverlayLayout = this.b;
      if (actionBarOverlayLayout != null)
        actionBarOverlayLayout.setShowingForActionMode(true); 
      m(false);
    } 
  }
  
  private void o() {
    if (this.F) {
      this.F = false;
      ActionBarOverlayLayout actionBarOverlayLayout = this.b;
      if (actionBarOverlayLayout != null)
        actionBarOverlayLayout.setShowingForActionMode(false); 
      m(false);
    } 
  }
  
  private boolean p() { return r.x(this.c); }
  
  public int a() { return this.d.o(); }
  
  public b a(b.a parama) {
    a a1 = this.h;
    if (a1 != null)
      a1.c(); 
    this.b.setHideOnContentScrollEnabled(false);
    this.e.c();
    a a2 = new a(this, this.e.getContext(), parama);
    if (a2.e()) {
      this.h = a2;
      a2.d();
      this.e.a(a2);
      k(true);
      this.e.sendAccessibilityEvent(32);
      return a2;
    } 
    return null;
  }
  
  public void a(float paramFloat) { r.a(this.c, paramFloat); }
  
  public void a(int paramInt) { this.E = paramInt; }
  
  public void a(int paramInt1, int paramInt2) {
    int i1 = this.d.o();
    if ((paramInt2 & 0x4) != 0)
      this.A = true; 
    this.d.c(paramInt1 & paramInt2 | i1 & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public void a(Configuration paramConfiguration) { l(a.a(this.a).d()); }
  
  public void a(CharSequence paramCharSequence) { this.d.a(paramCharSequence); }
  
  public void a(boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 2;
    } else {
      b1 = 0;
    } 
    a(b1, 2);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    a a1 = this.h;
    if (a1 == null)
      return false; 
    Menu menu = a1.b();
    if (menu != null) {
      byte b1;
      if (paramKeyEvent != null) {
        b1 = paramKeyEvent.getDeviceId();
      } else {
        b1 = -1;
      } 
      int i1 = KeyCharacterMap.load(b1).getKeyboardType();
      boolean bool = true;
      if (i1 == bool)
        bool = false; 
      menu.setQwertyMode(bool);
      return menu.performShortcut(paramInt, paramKeyEvent, 0);
    } 
    return false;
  }
  
  public Context b() {
    if (this.v == null) {
      TypedValue typedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
      int i1 = typedValue.resourceId;
      if (i1 != 0) {
        this.v = new ContextThemeWrapper(this.a, i1);
      } else {
        this.v = this.a;
      } 
    } 
    return this.v;
  }
  
  public void b(boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 4;
    } else {
      b1 = 0;
    } 
    a(b1, 4);
  }
  
  public void c(boolean paramBoolean) { this.d.b(paramBoolean); }
  
  public void d(boolean paramBoolean) {
    if (!paramBoolean || this.b.a()) {
      this.o = paramBoolean;
      this.b.setHideOnContentScrollEnabled(paramBoolean);
      return;
    } 
    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
  }
  
  public void e(boolean paramBoolean) {
    if (!this.A)
      b(paramBoolean); 
  }
  
  public void f(boolean paramBoolean) {
    this.H = paramBoolean;
    if (!paramBoolean) {
      h h1 = this.n;
      if (h1 != null)
        h1.c(); 
    } 
  }
  
  public boolean f() {
    aj aj1 = this.d;
    if (aj1 != null && aj1.c()) {
      this.d.d();
      return true;
    } 
    return false;
  }
  
  public void g(boolean paramBoolean) {
    if (paramBoolean == this.B)
      return; 
    this.B = paramBoolean;
    int i1 = this.C.size();
    for (byte b1 = 0; b1 < i1; b1++)
      ((a.b)this.C.get(b1)).a(paramBoolean); 
  }
  
  void h() {
    b.a a1 = this.j;
    if (a1 != null) {
      a1.a(this.i);
      this.i = null;
      this.j = null;
    } 
  }
  
  public void h(boolean paramBoolean) { this.k = paramBoolean; }
  
  public int i() { return this.d.p(); }
  
  public void i(boolean paramBoolean) {
    h h1 = this.n;
    if (h1 != null)
      h1.c(); 
    this.c.setVisibility(0);
    if (this.E == 0 && (this.H || paramBoolean)) {
      this.c.setTranslationY(0.0F);
      float f1 = -this.c.getHeight();
      if (paramBoolean) {
        int[] arrayOfInt = { 0, 0 };
        this.c.getLocationInWindow(arrayOfInt);
        f1 -= arrayOfInt[1];
      } 
      this.c.setTranslationY(f1);
      h h2 = new h();
      v v1 = r.l(this.c).b(0.0F);
      v1.a(this.r);
      h2.a(v1);
      if (this.k) {
        View view = this.f;
        if (view != null) {
          view.setTranslationY(f1);
          h2.a(r.l(this.f).b(0.0F));
        } 
      } 
      h2.a(u);
      h2.a(250L);
      h2.a(this.q);
      this.n = h2;
      h2.a();
    } else {
      this.c.setAlpha(1.0F);
      this.c.setTranslationY(0.0F);
      if (this.k) {
        View view = this.f;
        if (view != null)
          view.setTranslationY(0.0F); 
      } 
      this.q.b(null);
    } 
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    if (actionBarOverlayLayout != null)
      r.p(actionBarOverlayLayout); 
  }
  
  public void j() {
    if (this.m) {
      this.m = false;
      m(true);
    } 
  }
  
  public void j(boolean paramBoolean) {
    h h1 = this.n;
    if (h1 != null)
      h1.c(); 
    if (this.E == 0 && (this.H || paramBoolean)) {
      this.c.setAlpha(1.0F);
      this.c.setTransitioning(true);
      h h2 = new h();
      float f1 = -this.c.getHeight();
      if (paramBoolean) {
        int[] arrayOfInt = { 0, 0 };
        this.c.getLocationInWindow(arrayOfInt);
        f1 -= arrayOfInt[1];
      } 
      v v1 = r.l(this.c).b(f1);
      v1.a(this.r);
      h2.a(v1);
      if (this.k) {
        View view = this.f;
        if (view != null)
          h2.a(r.l(view).b(f1)); 
      } 
      h2.a(t);
      h2.a(250L);
      h2.a(this.p);
      this.n = h2;
      h2.a();
      return;
    } 
    this.p.b(null);
  }
  
  public void k() {
    if (!this.m) {
      this.m = true;
      m(true);
    } 
  }
  
  public void k(boolean paramBoolean) {
    if (paramBoolean) {
      n();
    } else {
      o();
    } 
    if (p()) {
      v v2;
      v v1;
      if (paramBoolean) {
        v2 = this.d.a(4, 100L);
        v1 = this.e.a(0, 200L);
      } else {
        v1 = this.d.a(0, 200L);
        v2 = this.e.a(8, 100L);
      } 
      h h1 = new h();
      h1.a(v2, v1);
      h1.a();
      return;
    } 
    if (paramBoolean) {
      this.d.d(4);
      this.e.setVisibility(0);
      return;
    } 
    this.d.d(0);
    this.e.setVisibility(8);
  }
  
  public void l() {
    h h1 = this.n;
    if (h1 != null) {
      h1.c();
      this.n = null;
    } 
  }
  
  public void m() {}
  
  public class a extends b implements h.a {
    private final Context b;
    
    private final h c;
    
    private b.a d;
    
    private WeakReference<View> e;
    
    public a(l this$0, Context param1Context, b.a param1a) {
      this.b = param1Context;
      this.d = param1a;
      this.c = (new h(param1Context)).a(1);
      this.c.a(this);
    }
    
    public MenuInflater a() { return new g(this.b); }
    
    public void a(int param1Int) { b(this.a.a.getResources().getString(param1Int)); }
    
    public void a(h param1h) {
      if (this.d == null)
        return; 
      d();
      this.a.e.a();
    }
    
    public void a(View param1View) {
      this.a.e.setCustomView(param1View);
      this.e = new WeakReference(param1View);
    }
    
    public void a(CharSequence param1CharSequence) { this.a.e.setSubtitle(param1CharSequence); }
    
    public void a(boolean param1Boolean) {
      super.a(param1Boolean);
      this.a.e.setTitleOptional(param1Boolean);
    }
    
    public boolean a(h param1h, MenuItem param1MenuItem) {
      b.a a1 = this.d;
      return (a1 != null) ? a1.a(this, param1MenuItem) : 0;
    }
    
    public Menu b() { return this.c; }
    
    public void b(int param1Int) { a(this.a.a.getResources().getString(param1Int)); }
    
    public void b(CharSequence param1CharSequence) { this.a.e.setTitle(param1CharSequence); }
    
    public void c() {
      if (this.a.h != this)
        return; 
      if (!l.a(this.a.l, this.a.m, false)) {
        l l1 = this.a;
        l1.i = this;
        l1.j = this.d;
      } else {
        this.d.a(this);
      } 
      this.d = null;
      this.a.k(false);
      this.a.e.b();
      this.a.d.a().sendAccessibilityEvent(32);
      this.a.b.setHideOnContentScrollEnabled(this.a.o);
      this.a.h = null;
    }
    
    public void d() {
      if (this.a.h != this)
        return; 
      this.c.h();
      try {
        this.d.b(this, this.c);
        return;
      } finally {
        this.c.i();
      } 
    }
    
    public boolean e() {
      this.c.h();
      try {
        return this.d.a(this, this.c);
      } finally {
        this.c.i();
      } 
    }
    
    public CharSequence f() { return this.a.e.getTitle(); }
    
    public CharSequence g() { return this.a.e.getSubtitle(); }
    
    public boolean h() { return this.a.e.d(); }
    
    public View i() {
      WeakReference weakReference = this.e;
      return (weakReference != null) ? (View)weakReference.get() : null;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */