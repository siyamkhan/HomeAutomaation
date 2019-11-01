package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class n {
  private final Context a;
  
  private final h b;
  
  private final boolean c;
  
  private final int d;
  
  private final int e;
  
  private View f;
  
  private int g = 8388611;
  
  private boolean h;
  
  private o.a i;
  
  private m j;
  
  private PopupWindow.OnDismissListener k;
  
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener(this) {
      public void onDismiss() { this.a.e(); }
    };
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt) { this(paramContext, paramh, paramView, paramBoolean, paramInt, 0); }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2) {
    this.a = paramContext;
    this.b = paramh;
    this.f = paramView;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    m m1 = b();
    m1.c(paramBoolean2);
    if (paramBoolean1) {
      if ((0x7 & d.a(this.g, r.f(this.f))) == 5)
        paramInt1 -= this.f.getWidth(); 
      m1.b(paramInt1);
      m1.c(paramInt2);
      int i1 = (int)(48.0F * (this.a.getResources().getDisplayMetrics()).density / 2.0F);
      m1.a(new Rect(paramInt1 - i1, paramInt2 - i1, paramInt1 + i1, paramInt2 + i1));
    } 
    m1.a();
  }
  
  private m g() {
    t t;
    boolean bool;
    Display display = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    Point point = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealSize(point);
    } else {
      display.getSize(point);
    } 
    if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      Context context = this.a;
      View view = this.f;
      int i1 = this.d;
      int i2 = this.e;
      boolean bool1 = this.c;
      t = new e(context, view, i1, i2, bool1);
    } else {
      Context context = this.a;
      h h1 = this.b;
      View view = this.f;
      int i1 = this.d;
      int i2 = this.e;
      boolean bool1 = this.c;
      t = new t(context, h1, view, i1, i2, bool1);
    } 
    t.a(this.b);
    t.a(this.l);
    t.a(this.f);
    t.a(this.i);
    t.a(this.h);
    t.a(this.g);
    return t;
  }
  
  public void a() {
    if (c())
      return; 
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public void a(int paramInt) { this.g = paramInt; }
  
  public void a(o.a parama) {
    this.i = parama;
    m m1 = this.j;
    if (m1 != null)
      m1.a(parama); 
  }
  
  public void a(View paramView) { this.f = paramView; }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener) { this.k = paramOnDismissListener; }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
    m m1 = this.j;
    if (m1 != null)
      m1.a(paramBoolean); 
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    if (f())
      return true; 
    if (this.f == null)
      return false; 
    a(paramInt1, paramInt2, true, true);
    return true;
  }
  
  public m b() {
    if (this.j == null)
      this.j = g(); 
    return this.j;
  }
  
  public boolean c() {
    if (f())
      return true; 
    if (this.f == null)
      return false; 
    a(0, 0, false, false);
    return true;
  }
  
  public void d() {
    if (f())
      this.j.c(); 
  }
  
  protected void e() {
    this.j = null;
    PopupWindow.OnDismissListener onDismissListener = this.k;
    if (onDismissListener != null)
      onDismissListener.onDismiss(); 
  }
  
  public boolean f() {
    m m1 = this.j;
    return (m1 != null && m1.d());
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */