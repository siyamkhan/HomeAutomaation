package android.support.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v4.h.r;
import android.view.View;
import android.view.ViewGroup;

public class d extends ai {
  public d() {}
  
  public d(int paramInt) { a(paramInt); }
  
  private static float a(s params, float paramFloat) {
    if (params != null) {
      Float float = (Float)params.a.get("android:fade:transitionAlpha");
      if (float != null)
        paramFloat = float.floatValue(); 
    } 
    return paramFloat;
  }
  
  private Animator a(View paramView, float paramFloat1, float paramFloat2) {
    if (paramFloat1 == paramFloat2)
      return null; 
    ad.a(paramView, paramFloat1);
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, ad.a, new float[] { paramFloat2 });
    objectAnimator.addListener(new a(paramView));
    a(new n(this, paramView) {
          public void a(m param1m) {
            ad.a(this.a, 1.0F);
            ad.e(this.a);
            param1m.b(this);
          }
        });
    return objectAnimator;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, s params1, s params2) {
    float f2;
    float f1 = a(params1, 0.0F);
    if (f1 == 1.0F) {
      f2 = 0.0F;
    } else {
      f2 = f1;
    } 
    return a(paramView, f2, 1.0F);
  }
  
  public void a(s params) {
    super.a(params);
    params.a.put("android:fade:transitionAlpha", Float.valueOf(ad.c(params.b)));
  }
  
  public Animator b(ViewGroup paramViewGroup, View paramView, s params1, s params2) {
    ad.d(paramView);
    return a(paramView, a(params1, 1.0F), 0.0F);
  }
  
  private static class a extends AnimatorListenerAdapter {
    private final View a;
    
    private boolean b = false;
    
    a(View param1View) { this.a = param1View; }
    
    public void onAnimationEnd(Animator param1Animator) {
      ad.a(this.a, 1.0F);
      if (this.b)
        this.a.setLayerType(0, null); 
    }
    
    public void onAnimationStart(Animator param1Animator) {
      if (r.r(this.a) && this.a.getLayerType() == 0) {
        this.b = true;
        this.a.setLayerType(2, null);
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */