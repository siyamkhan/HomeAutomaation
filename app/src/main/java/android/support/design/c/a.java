package android.support.design.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class a {
  public static Animator.AnimatorListener a(d paramd) { return new AnimatorListenerAdapter(paramd) {
        public void onAnimationEnd(Animator param1Animator) { this.a.b(); }
        
        public void onAnimationStart(Animator param1Animator) { this.a.a(); }
      }; }
  
  public static Animator a(d paramd, float paramFloat1, float paramFloat2, float paramFloat3) {
    Property property = d.b.a;
    TypeEvaluator typeEvaluator = d.a.a;
    d.d[] arrayOfd = new d.d[1];
    arrayOfd[0] = new d.d(paramFloat1, paramFloat2, paramFloat3);
    ObjectAnimator objectAnimator = ObjectAnimator.ofObject(paramd, property, typeEvaluator, arrayOfd);
    if (Build.VERSION.SDK_INT >= 21) {
      d.d d1 = paramd.getRevealInfo();
      if (d1 != null) {
        float f = d1.c;
        Animator animator = ViewAnimationUtils.createCircularReveal((View)paramd, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[] { objectAnimator, animator });
        return animatorSet;
      } 
      throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    } 
    return objectAnimator;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */