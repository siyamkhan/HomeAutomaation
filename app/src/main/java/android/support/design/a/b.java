package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public class b {
  public static void a(AnimatorSet paramAnimatorSet, List<Animator> paramList) {
    int i = paramList.size();
    long l = 0L;
    for (byte b1 = 0; b1 < i; b1++) {
      Animator animator = (Animator)paramList.get(b1);
      l = Math.max(l, animator.getStartDelay() + animator.getDuration());
    } 
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { 0, 0 });
    valueAnimator.setDuration(l);
    paramList.add(0, valueAnimator);
    paramAnimatorSet.playTogether(paramList);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */