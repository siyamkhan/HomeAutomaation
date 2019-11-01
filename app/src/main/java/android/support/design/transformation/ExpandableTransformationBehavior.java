package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
  private AnimatorSet a;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  protected boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool;
    if (this.a != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      this.a.cancel(); 
    this.a = b(paramView1, paramView2, paramBoolean1, bool);
    this.a.addListener(new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) { ExpandableTransformationBehavior.a(this.a, null); }
        });
    this.a.start();
    if (!paramBoolean2)
      this.a.end(); 
    return true;
  }
  
  protected abstract AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\transformation\ExpandableTransformationBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */