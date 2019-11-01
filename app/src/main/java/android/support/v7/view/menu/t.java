package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.widget.av;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

final class t extends m implements o, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
  private static final int e = a.g.abc_popup_menu_item_layout;
  
  final av a;
  
  final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener(this) {
      public void onGlobalLayout() {
        if (this.a.d() && !this.a.a.g()) {
          View view = this.a.c;
          if (view == null || !view.isShown()) {
            this.a.c();
            return;
          } 
          this.a.a.a();
          return;
        } 
      }
    };
  
  View c;
  
  ViewTreeObserver d;
  
  private final Context f;
  
  private final h g;
  
  private final g h;
  
  private final boolean i;
  
  private final int j;
  
  private final int k;
  
  private final int l;
  
  private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener(this) {
      public void onViewAttachedToWindow(View param1View) {}
      
      public void onViewDetachedFromWindow(View param1View) {
        if (this.a.d != null) {
          if (!this.a.d.isAlive())
            this.a.d = param1View.getViewTreeObserver(); 
          this.a.d.removeGlobalOnLayoutListener(this.a.b);
        } 
        param1View.removeOnAttachStateChangeListener(this);
      }
    };
  
  private PopupWindow.OnDismissListener n;
  
  private View o;
  
  private o.a p;
  
  private boolean q;
  
  private boolean r;
  
  private int s;
  
  private int t = 0;
  
  private boolean u;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.f = paramContext;
    this.g = paramh;
    this.i = paramBoolean;
    this.h = new g(paramh, LayoutInflater.from(paramContext), this.i, e);
    this.k = paramInt1;
    this.l = paramInt2;
    Resources resources = paramContext.getResources();
    this.j = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.o = paramView;
    this.a = new av(this.f, null, this.k, this.l);
    paramh.a(this, paramContext);
  }
  
  private boolean h() {
    if (d())
      return true; 
    if (!this.q) {
      boolean bool;
      View view1 = this.o;
      if (view1 == null)
        return false; 
      this.c = view1;
      this.a.a(this);
      this.a.a(this);
      this.a.a(true);
      View view2 = this.c;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.d = view2.getViewTreeObserver();
      if (bool)
        this.d.addOnGlobalLayoutListener(this.b); 
      view2.addOnAttachStateChangeListener(this.m);
      this.a.b(view2);
      this.a.e(this.t);
      if (!this.r) {
        this.s = a(this.h, null, this.f, this.j);
        this.r = true;
      } 
      this.a.g(this.s);
      this.a.h(2);
      this.a.a(g());
      this.a.a();
      ListView listView = this.a.e();
      listView.setOnKeyListener(this);
      if (this.u && this.g.n() != null) {
        FrameLayout frameLayout = (FrameLayout)LayoutInflater.from(this.f).inflate(a.g.abc_popup_menu_header_item_layout, listView, false);
        TextView textView = (TextView)frameLayout.findViewById(16908310);
        if (textView != null)
          textView.setText(this.g.n()); 
        frameLayout.setEnabled(false);
        listView.addHeaderView(frameLayout, null, false);
      } 
      this.a.a(this.h);
      this.a.a();
      return true;
    } 
    return false;
  }
  
  public void a() {
    if (h())
      return; 
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void a(int paramInt) { this.t = paramInt; }
  
  public void a(h paramh) {}
  
  public void a(h paramh, boolean paramBoolean) {
    if (paramh != this.g)
      return; 
    c();
    o.a a1 = this.p;
    if (a1 != null)
      a1.a(paramh, paramBoolean); 
  }
  
  public void a(o.a parama) { this.p = parama; }
  
  public void a(View paramView) { this.o = paramView; }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener) { this.n = paramOnDismissListener; }
  
  public void a(boolean paramBoolean) { this.h.a(paramBoolean); }
  
  public boolean a(u paramu) {
    if (paramu.hasVisibleItems()) {
      n n1 = new n(this.f, paramu, this.c, this.i, this.k, this.l);
      n1.a(this.p);
      n1.a(m.b(paramu));
      n1.a(this.n);
      this.n = null;
      this.g.a(false);
      int i1 = this.a.j();
      int i2 = this.a.k();
      if ((0x7 & Gravity.getAbsoluteGravity(this.t, r.f(this.o))) == 5)
        i1 += this.o.getWidth(); 
      if (n1.a(i1, i2)) {
        o.a a1 = this.p;
        if (a1 != null)
          a1.a(paramu); 
        return true;
      } 
    } 
    return false;
  }
  
  public void b(int paramInt) { this.a.c(paramInt); }
  
  public void b(boolean paramBoolean) {
    this.r = false;
    g g1 = this.h;
    if (g1 != null)
      g1.notifyDataSetChanged(); 
  }
  
  public boolean b() { return false; }
  
  public void c() {
    if (d())
      this.a.c(); 
  }
  
  public void c(int paramInt) { this.a.d(paramInt); }
  
  public void c(boolean paramBoolean) { this.u = paramBoolean; }
  
  public boolean d() { return (!this.q && this.a.d()); }
  
  public ListView e() { return this.a.e(); }
  
  public void onDismiss() {
    this.q = true;
    this.g.close();
    ViewTreeObserver viewTreeObserver = this.d;
    if (viewTreeObserver != null) {
      if (!viewTreeObserver.isAlive())
        this.d = this.c.getViewTreeObserver(); 
      this.d.removeGlobalOnLayoutListener(this.b);
      this.d = null;
    } 
    this.c.removeOnAttachStateChangeListener(this.m);
    PopupWindow.OnDismissListener onDismissListener = this.n;
    if (onDismissListener != null)
      onDismissListener.onDismiss(); 
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramInt == 82) {
      c();
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */