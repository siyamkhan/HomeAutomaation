package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ap implements View.OnAttachStateChangeListener, View.OnTouchListener {
  private final float a;
  
  private final int b;
  
  final View c;
  
  private final int d;
  
  private Runnable e;
  
  private Runnable f;
  
  private boolean g;
  
  private int h;
  
  private final int[] i = new int[2];
  
  public ap(View paramView) {
    this.c = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.b = ViewConfiguration.getTapTimeout();
    this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int j;
    View view = this.c;
    if (!view.isEnabled())
      return false; 
    switch (paramMotionEvent.getActionMasked()) {
      default:
        return false;
      case 2:
        j = paramMotionEvent.findPointerIndex(this.h);
        if (j >= 0 && !a(view, paramMotionEvent.getX(j), paramMotionEvent.getY(j), this.a)) {
          e();
          view.getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        } 
        return false;
      case 1:
      case 3:
        e();
        return false;
      case 0:
        break;
    } 
    this.h = paramMotionEvent.getPointerId(0);
    if (this.e == null)
      this.e = new a(this); 
    view.postDelayed(this.e, this.b);
    if (this.f == null)
      this.f = new b(this); 
    view.postDelayed(this.f, this.d);
    return false;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3) {
    float f1 = -paramFloat3;
    return (paramFloat1 >= f1 && paramFloat2 >= f1 && paramFloat1 < paramFloat3 + (paramView.getRight() - paramView.getLeft()) && paramFloat2 < paramFloat3 + (paramView.getBottom() - paramView.getTop()));
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent) {
    View view = this.c;
    s s = a();
    if (s != null) {
      if (!s.d())
        return false; 
      am am = (am)s.e();
      if (am != null) {
        boolean bool1;
        if (!am.isShown())
          return false; 
        MotionEvent motionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        b(view, motionEvent);
        a(am, motionEvent);
        boolean bool = am.a(motionEvent, this.h);
        motionEvent.recycle();
        int j = paramMotionEvent.getActionMasked();
        if (j != 1 && j != 3) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        return (bool && bool1);
      } 
    } 
    return false;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private void e() {
    Runnable runnable1 = this.f;
    if (runnable1 != null)
      this.c.removeCallbacks(runnable1); 
    Runnable runnable2 = this.e;
    if (runnable2 != null)
      this.c.removeCallbacks(runnable2); 
  }
  
  public abstract s a();
  
  protected boolean b() {
    s s = a();
    if (s != null && !s.d())
      s.a(); 
    return true;
  }
  
  protected boolean c() {
    s s = a();
    if (s != null && s.d())
      s.c(); 
    return true;
  }
  
  void d() {
    e();
    View view = this.c;
    if (view.isEnabled()) {
      if (view.isLongClickable())
        return; 
      if (!b())
        return; 
      view.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      view.onTouchEvent(motionEvent);
      motionEvent.recycle();
      this.g = true;
    } 
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    boolean bool;
    boolean bool1 = this.g;
    boolean bool2 = true;
    if (bool1) {
      if (b(paramMotionEvent) || !c()) {
        bool = true;
      } else {
        bool = false;
      } 
    } else {
      if (a(paramMotionEvent) && b()) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.c.onTouchEvent(motionEvent);
        motionEvent.recycle();
      } 
    } 
    this.g = bool;
    if (!bool) {
      if (bool1)
        return bool2; 
      bool2 = false;
    } 
    return bool2;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView) {
    this.g = false;
    this.h = -1;
    Runnable runnable = this.e;
    if (runnable != null)
      this.c.removeCallbacks(runnable); 
  }
  
  private class a implements Runnable {
    a(ap this$0) {}
    
    public void run() {
      ViewParent viewParent = this.a.c.getParent();
      if (viewParent != null)
        viewParent.requestDisallowInterceptTouchEvent(true); 
    }
  }
  
  private class b implements Runnable {
    b(ap this$0) {}
    
    public void run() { this.a.d(); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */