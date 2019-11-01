package android.support.v7.widget;

import android.support.v4.h.r;
import android.support.v4.h.s;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class bp implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
  private static bp j;
  
  private static bp k;
  
  private final View a;
  
  private final CharSequence b;
  
  private final int c;
  
  private final Runnable d = new Runnable(this) {
      public void run() { this.a.a(false); }
    };
  
  private final Runnable e = new Runnable(this) {
      public void run() { this.a.a(); }
    };
  
  private int f;
  
  private int g;
  
  private bq h;
  
  private boolean i;
  
  private bp(View paramView, CharSequence paramCharSequence) {
    this.a = paramView;
    this.b = paramCharSequence;
    this.c = s.a(ViewConfiguration.get(this.a.getContext()));
    d();
    this.a.setOnLongClickListener(this);
    this.a.setOnHoverListener(this);
  }
  
  private static void a(bp parambp) {
    bp bp1 = j;
    if (bp1 != null)
      bp1.c(); 
    j = parambp;
    bp bp2 = j;
    if (bp2 != null)
      bp2.b(); 
  }
  
  public static void a(View paramView, CharSequence paramCharSequence) {
    bp bp1 = j;
    if (bp1 != null && bp1.a == paramView)
      a(null); 
    if (TextUtils.isEmpty(paramCharSequence)) {
      bp bp2 = k;
      if (bp2 != null && bp2.a == paramView)
        bp2.a(); 
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    } 
    new bp(paramView, paramCharSequence);
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    if (Math.abs(m - this.f) <= this.c && Math.abs(n - this.g) <= this.c)
      return false; 
    this.f = m;
    this.g = n;
    return true;
  }
  
  private void b() { this.a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout()); }
  
  private void c() { this.a.removeCallbacks(this.d); }
  
  private void d() {
    this.f = Integer.MAX_VALUE;
    this.g = Integer.MAX_VALUE;
  }
  
  void a() {
    if (k == this) {
      k = null;
      bq bq1 = this.h;
      if (bq1 != null) {
        bq1.a();
        this.h = null;
        d();
        this.a.removeOnAttachStateChangeListener(this);
      } else {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      } 
    } 
    if (j == this)
      a(null); 
    this.a.removeCallbacks(this.e);
  }
  
  void a(boolean paramBoolean) {
    long l;
    if (!r.A(this.a))
      return; 
    a(null);
    bp bp1 = k;
    if (bp1 != null)
      bp1.a(); 
    k = this;
    this.i = paramBoolean;
    this.h = new bq(this.a.getContext());
    this.h.a(this.a, this.f, this.g, this.i, this.b);
    this.a.addOnAttachStateChangeListener(this);
    if (this.i) {
      l = 2500L;
    } else {
      long l1;
      if ((true & r.o(this.a)) == 1) {
        l1 = 3000L;
      } else {
        l1 = 15000L;
      } 
      l = l1 - ViewConfiguration.getLongPressTimeout();
    } 
    this.a.removeCallbacks(this.e);
    this.a.postDelayed(this.e, l);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent) {
    if (this.h != null && this.i)
      return false; 
    AccessibilityManager accessibilityManager = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
    if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())
      return false; 
    int m = paramMotionEvent.getAction();
    if (m != 7) {
      if (m != 10)
        return false; 
      d();
      a();
      return false;
    } 
    if (this.a.isEnabled() && this.h == null && a(paramMotionEvent))
      a(this); 
    return false;
  }
  
  public boolean onLongClick(View paramView) {
    this.f = paramView.getWidth() / 2;
    this.g = paramView.getHeight() / 2;
    a(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView) { a(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */