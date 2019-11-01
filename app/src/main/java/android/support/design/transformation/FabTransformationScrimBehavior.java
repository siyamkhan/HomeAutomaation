package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.a.b;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
  private final i a = new i(75L, 150L);
  
  private final i b = new i(0L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2) {
    float[] arrayOfFloat;
    Property property;
    i i1;
    if (paramBoolean1) {
      i1 = this.a;
    } else {
      i1 = this.b;
    } 
    if (paramBoolean1) {
      if (!paramBoolean2)
        paramView.setAlpha(0.0F); 
      property = View.ALPHA;
      arrayOfFloat = new float[] { 1.0F };
    } else {
      property = View.ALPHA;
      arrayOfFloat = new float[] { 0.0F };
    } 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, property, arrayOfFloat);
    i1.a(objectAnimator);
    paramList1.add(objectAnimator);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent) { return super.a(paramCoordinatorLayout, paramView, paramMotionEvent); }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) { return paramView2 instanceof android.support.design.widget.FloatingActionButton; }
  
  protected AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    ArrayList arrayList = new ArrayList();
    a(paramView2, paramBoolean1, paramBoolean2, arrayList, new ArrayList());
    AnimatorSet animatorSet = new AnimatorSet();
    b.a(animatorSet, arrayList);
    animatorSet.addListener(new AnimatorListenerAdapter(this, paramBoolean1, paramView2) {
          public void onAnimationEnd(Animator param1Animator) {
            if (!this.a)
              this.b.setVisibility(4); 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            if (this.a)
              this.b.setVisibility(0); 
          }
        });
    return animatorSet;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\transformation\FabTransformationScrimBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */