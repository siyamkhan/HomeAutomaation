package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b<V> {
  private int a = 0;
  
  private int b = 2;
  
  private ViewPropertyAnimator c;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private void a(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator) { this.c = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) { HideBottomViewOnScrollBehavior.a(this.a, null); }
        }); }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.b != 1 && paramInt2 > 0) {
      b(paramV);
      return;
    } 
    if (this.b != 2 && paramInt2 < 0)
      a(paramV); 
  }
  
  protected void a(V paramV) {
    ViewPropertyAnimator viewPropertyAnimator = this.c;
    if (viewPropertyAnimator != null) {
      viewPropertyAnimator.cancel();
      paramV.clearAnimation();
    } 
    this.b = 2;
    a(paramV, 0, 225L, a.d);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    this.a = paramV.getMeasuredHeight();
    return super.a(paramCoordinatorLayout, paramV, paramInt);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt) { return (paramInt == 2); }
  
  protected void b(V paramV) {
    ViewPropertyAnimator viewPropertyAnimator = this.c;
    if (viewPropertyAnimator != null) {
      viewPropertyAnimator.cancel();
      paramV.clearAnimation();
    } 
    this.b = 1;
    a(paramV, this.a, 175L, a.c);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\behavior\HideBottomViewOnScrollBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */