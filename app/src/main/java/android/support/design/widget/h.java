package android.support.design.widget;

import android.content.Context;
import android.support.v4.c.a;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class h<V extends View> extends q<V> {
  OverScroller a;
  
  private Runnable b;
  
  private boolean c;
  
  private int d = -1;
  
  private int e;
  
  private int f = -1;
  
  private VelocityTracker g;
  
  public h() {}
  
  public h(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private void d() {
    if (this.g == null)
      this.g = VelocityTracker.obtain(); 
  }
  
  int a() { return b(); }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3) {
    int i = b();
    if (paramInt2 != 0 && i >= paramInt2 && i <= paramInt3) {
      int j = a.a(paramInt1, paramInt2, paramInt3);
      if (i != j) {
        a(j);
        return i - j;
      } 
    } 
    return 0;
  }
  
  int a(V paramV) { return paramV.getHeight(); }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat) {
    Runnable runnable = this.b;
    if (runnable != null) {
      paramV.removeCallbacks(runnable);
      this.b = null;
    } 
    if (this.a == null)
      this.a = new OverScroller(paramV.getContext()); 
    this.a.fling(0, b(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.a.computeScrollOffset()) {
      this.b = new a(this, paramCoordinatorLayout, paramV);
      r.a(paramV, this.b);
      return true;
    } 
    a(paramCoordinatorLayout, paramV);
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    int i1;
    int n;
    int m;
    int k;
    VelocityTracker velocityTracker3;
    VelocityTracker velocityTracker2;
    int j;
    int i;
    if (this.f < 0)
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop(); 
    switch (paramMotionEvent.getActionMasked()) {
      case 2:
        k = paramMotionEvent.findPointerIndex(this.d);
        if (k == -1)
          return false; 
        m = (int)paramMotionEvent.getY(k);
        n = this.e - m;
        if (!this.c) {
          int i2 = Math.abs(n);
          int i3 = this.f;
          if (i2 > i3) {
            this.c = true;
            if (n > 0) {
              n -= i3;
            } else {
              n += i3;
            } 
          } 
        } 
        i1 = n;
        if (this.c) {
          this.e = m;
          b(paramCoordinatorLayout, paramV, i1, b(paramV), 0);
        } 
        break;
      case 1:
        velocityTracker3 = this.g;
        if (velocityTracker3 != null) {
          velocityTracker3.addMovement(paramMotionEvent);
          this.g.computeCurrentVelocity(1000);
          float f1 = this.g.getYVelocity(this.d);
          a(paramCoordinatorLayout, paramV, -a(paramV), 0, f1);
        } 
      case 3:
        this.c = false;
        this.d = -1;
        velocityTracker2 = this.g;
        if (velocityTracker2 != null) {
          velocityTracker2.recycle();
          this.g = null;
        } 
        break;
      case 0:
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (paramCoordinatorLayout.a(paramV, i, j) && c(paramV)) {
          this.e = j;
          this.d = paramMotionEvent.getPointerId(0);
          d();
          break;
        } 
        return false;
    } 
    VelocityTracker velocityTracker1 = this.g;
    if (velocityTracker1 != null)
      velocityTracker1.addMovement(paramMotionEvent); 
    return true;
  }
  
  int a_(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) { return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647); }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3) { return a(paramCoordinatorLayout, paramV, a() - paramInt1, paramInt2, paramInt3); }
  
  int b(V paramV) { return -paramV.getHeight(); }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    int n;
    int m;
    int k;
    VelocityTracker velocityTracker2;
    int j;
    int i;
    if (this.f < 0)
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop(); 
    if (paramMotionEvent.getAction() == 2 && this.c)
      return true; 
    switch (paramMotionEvent.getActionMasked()) {
      case 2:
        k = this.d;
        if (k == -1)
          break; 
        m = paramMotionEvent.findPointerIndex(k);
        if (m == -1)
          break; 
        n = (int)paramMotionEvent.getY(m);
        if (Math.abs(n - this.e) > this.f) {
          this.c = true;
          this.e = n;
        } 
        break;
      case 1:
      case 3:
        this.c = false;
        this.d = -1;
        velocityTracker2 = this.g;
        if (velocityTracker2 != null) {
          velocityTracker2.recycle();
          this.g = null;
        } 
        break;
      case 0:
        this.c = false;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (c(paramV) && paramCoordinatorLayout.a(paramV, i, j)) {
          this.e = j;
          this.d = paramMotionEvent.getPointerId(0);
          d();
        } 
        break;
    } 
    VelocityTracker velocityTracker1 = this.g;
    if (velocityTracker1 != null)
      velocityTracker1.addMovement(paramMotionEvent); 
    return this.c;
  }
  
  boolean c(V paramV) { return false; }
  
  private class a implements Runnable {
    private final CoordinatorLayout b;
    
    private final V c;
    
    a(h this$0, CoordinatorLayout param1CoordinatorLayout, V param1V) {
      this.b = param1CoordinatorLayout;
      this.c = param1V;
    }
    
    public void run() {
      if (this.c != null && this.a.a != null) {
        if (this.a.a.computeScrollOffset()) {
          h h1 = this.a;
          h1.a_(this.b, this.c, h1.a.getCurrY());
          r.a(this.c, this);
          return;
        } 
        this.a.a(this.b, this.c);
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */