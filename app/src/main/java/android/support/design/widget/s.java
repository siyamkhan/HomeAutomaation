package android.support.design.widget;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.support.design.a;
import android.view.View;

class s {
  private static final int[] a = { 16843848 };
  
  static void a(View paramView, float paramFloat) {
    int i = paramView.getResources().getInteger(a.g.app_bar_elevation_anim_duration);
    StateListAnimator stateListAnimator = new StateListAnimator();
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 16842766;
    arrayOfInt[1] = a.b.state_liftable;
    arrayOfInt[2] = -a.b.state_lifted;
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F });
    long l = i;
    stateListAnimator.addState(arrayOfInt, objectAnimator.setDuration(l));
    stateListAnimator.addState(new int[] { 16842766 }, ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(l));
    stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L));
    paramView.setStateListAnimator(stateListAnimator);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */