package android.support.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

class a {
  static void a(Animator paramAnimator) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramAnimator.pause();
      return;
    } 
    ArrayList arrayList = paramAnimator.getListeners();
    if (arrayList != null) {
      byte b = 0;
      int i = arrayList.size();
      while (b < i) {
        Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)arrayList.get(b);
        if (animatorListener instanceof a)
          ((a)animatorListener).onAnimationPause(paramAnimator); 
        b++;
      } 
    } 
  }
  
  static void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter) {
    if (Build.VERSION.SDK_INT >= 19)
      paramAnimator.addPauseListener(paramAnimatorListenerAdapter); 
  }
  
  static void b(Animator paramAnimator) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramAnimator.resume();
      return;
    } 
    ArrayList arrayList = paramAnimator.getListeners();
    if (arrayList != null) {
      byte b = 0;
      int i = arrayList.size();
      while (b < i) {
        Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)arrayList.get(b);
        if (animatorListener instanceof a)
          ((a)animatorListener).onAnimationResume(paramAnimator); 
        b++;
      } 
    } 
  }
  
  static interface a {
    void onAnimationPause(Animator param1Animator);
    
    void onAnimationResume(Animator param1Animator);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */