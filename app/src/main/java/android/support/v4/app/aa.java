package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

class aa implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
  private final View a;
  
  private ViewTreeObserver b;
  
  private final Runnable c;
  
  private aa(View paramView, Runnable paramRunnable) {
    this.a = paramView;
    this.b = paramView.getViewTreeObserver();
    this.c = paramRunnable;
  }
  
  public static aa a(View paramView, Runnable paramRunnable) {
    aa aa1 = new aa(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(aa1);
    paramView.addOnAttachStateChangeListener(aa1);
    return aa1;
  }
  
  public void a() {
    ViewTreeObserver viewTreeObserver;
    if (this.b.isAlive()) {
      viewTreeObserver = this.b;
    } else {
      viewTreeObserver = this.a.getViewTreeObserver();
    } 
    viewTreeObserver.removeOnPreDrawListener(this);
    this.a.removeOnAttachStateChangeListener(this);
  }
  
  public boolean onPreDraw() {
    a();
    this.c.run();
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) { this.b = paramView.getViewTreeObserver(); }
  
  public void onViewDetachedFromWindow(View paramView) { a(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */