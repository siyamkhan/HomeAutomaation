package android.support.v4.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class v {
  Runnable a = null;
  
  Runnable b = null;
  
  int c = -1;
  
  private WeakReference<View> d;
  
  v(View paramView) { this.d = new WeakReference(paramView); }
  
  private void a(View paramView, w paramw) {
    if (paramw != null) {
      paramView.animate().setListener(new AnimatorListenerAdapter(this, paramw, paramView) {
            public void onAnimationCancel(Animator param1Animator) { this.a.c(this.b); }
            
            public void onAnimationEnd(Animator param1Animator) { this.a.b(this.b); }
            
            public void onAnimationStart(Animator param1Animator) { this.a.a(this.b); }
          });
      return;
    } 
    paramView.animate().setListener(null);
  }
  
  public long a() {
    View view = (View)this.d.get();
    return (view != null) ? view.animate().getDuration() : 0L;
  }
  
  public v a(float paramFloat) {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().alpha(paramFloat); 
    return this;
  }
  
  public v a(long paramLong) {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().setDuration(paramLong); 
    return this;
  }
  
  public v a(w paramw) {
    View view = (View)this.d.get();
    if (view != null) {
      if (Build.VERSION.SDK_INT < 16) {
        view.setTag(2113929216, paramw);
        paramw = new a(this);
      } 
      a(view, paramw);
    } 
    return this;
  }
  
  public v a(y paramy) {
    View view = (View)this.d.get();
    if (view != null && Build.VERSION.SDK_INT >= 19) {
      ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
      if (paramy != null)
        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this, paramy, view) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) { this.a.a(this.b); }
          }; 
      view.animate().setUpdateListener(animatorUpdateListener);
    } 
    return this;
  }
  
  public v a(Interpolator paramInterpolator) {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().setInterpolator(paramInterpolator); 
    return this;
  }
  
  public v b(float paramFloat) {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().translationY(paramFloat); 
    return this;
  }
  
  public v b(long paramLong) {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().setStartDelay(paramLong); 
    return this;
  }
  
  public void b() {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().cancel(); 
  }
  
  public void c() {
    View view = (View)this.d.get();
    if (view != null)
      view.animate().start(); 
  }
  
  static class a implements w {
    v a;
    
    boolean b;
    
    a(v param1v) { this.a = param1v; }
    
    public void a(View param1View) {
      this.b = false;
      if (this.a.c > -1)
        param1View.setLayerType(2, null); 
      if (this.a.a != null) {
        Runnable runnable = this.a.a;
        this.a.a = null;
        runnable.run();
      } 
      Object object = param1View.getTag(2113929216);
      boolean bool = object instanceof w;
      w w1 = null;
      if (bool)
        w1 = (w)object; 
      if (w1 != null)
        w1.a(param1View); 
    }
    
    public void b(View param1View) {
      if (this.a.c > -1) {
        param1View.setLayerType(this.a.c, null);
        this.a.c = -1;
      } 
      if (Build.VERSION.SDK_INT >= 16 || !this.b) {
        if (this.a.b != null) {
          Runnable runnable = this.a.b;
          this.a.b = null;
          runnable.run();
        } 
        Object object = param1View.getTag(2113929216);
        boolean bool = object instanceof w;
        w w1 = null;
        if (bool)
          w1 = (w)object; 
        if (w1 != null)
          w1.b(param1View); 
        this.b = true;
      } 
    }
    
    public void c(View param1View) {
      Object object1;
      Object object = param1View.getTag(2113929216);
      if (object instanceof w) {
        object1 = (w)object;
      } else {
        object1 = null;
      } 
      if (object1 != null)
        object1.c(param1View); 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */