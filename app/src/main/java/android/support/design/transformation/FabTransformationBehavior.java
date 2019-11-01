package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.a.a;
import android.support.design.a.b;
import android.support.design.a.c;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.c.a;
import android.support.design.c.c;
import android.support.design.c.d;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.k;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
  private final Rect a = new Rect();
  
  private final RectF b = new RectF();
  
  private final RectF c = new RectF();
  
  private final int[] d = new int[2];
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private float a(a parama, i parami, float paramFloat1, float paramFloat2) {
    long l1 = parami.a();
    long l2 = parami.b();
    i i1 = parama.a.b("expansion");
    float f = (float)(17L + i1.a() + i1.b() - l1) / (float)l2;
    return a.a(paramFloat1, paramFloat2, parami.c().getInterpolation(f));
  }
  
  private float a(View paramView1, View paramView2, j paramj) {
    float f;
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    a(paramView1, rectF1);
    a(paramView2, rectF2);
    int i = 0x7 & paramj.a;
    if (i != 1) {
      if (i != 3) {
        if (i != 5) {
          f = 0.0F;
        } else {
          float f1 = rectF2.right;
          float f2 = rectF1.right;
          f = f1 - f2;
        } 
      } else {
        float f1 = rectF2.left;
        float f2 = rectF1.left;
        f = f1 - f2;
      } 
    } else {
      float f1 = rectF2.centerX();
      float f2 = rectF1.centerX();
      f = f1 - f2;
    } 
    return f + paramj.b;
  }
  
  private ViewGroup a(View paramView) {
    View view = paramView.findViewById(a.f.mtrl_child_content_container);
    return (view != null) ? b(view) : ((paramView instanceof b || paramView instanceof a) ? b(((ViewGroup)paramView).getChildAt(0)) : b(paramView));
  }
  
  private void a(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList) {
    if (Build.VERSION.SDK_INT >= 21 && paramLong > 0L) {
      Animator animator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      animator.setStartDelay(0L);
      animator.setDuration(paramLong);
      paramList.add(animator);
    } 
  }
  
  private void a(View paramView, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList) {
    if (Build.VERSION.SDK_INT >= 21) {
      long l = paramLong1 + paramLong2;
      if (l < paramLong3) {
        Animator animator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
        animator.setStartDelay(l);
        animator.setDuration(paramLong3 - l);
        paramList.add(animator);
      } 
    } 
  }
  
  private void a(View paramView, RectF paramRectF) {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.d;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private void a(View paramView, a parama, i parami1, i parami2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, RectF paramRectF) {
    float f1 = a(parama, parami1, paramFloat1, paramFloat3);
    float f2 = a(parama, parami2, paramFloat2, paramFloat4);
    Rect rect = this.a;
    paramView.getWindowVisibleDisplayFrame(rect);
    RectF rectF1 = this.b;
    rectF1.set(rect);
    RectF rectF2 = this.c;
    a(paramView, rectF2);
    rectF2.offset(f1, f2);
    rectF2.intersect(rectF1);
    paramRectF.set(rectF2);
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, float paramFloat1, float paramFloat2, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2) {
    Animator animator;
    if (!(paramView2 instanceof d))
      return; 
    d d1 = (d)paramView2;
    float f1 = c(paramView1, paramView2, parama.b);
    float f2 = d(paramView1, paramView2, parama.b);
    ((FloatingActionButton)paramView1).a(this.a);
    float f3 = this.a.width() / 2.0F;
    i i = parama.a.b("expansion");
    if (paramBoolean1) {
      if (!paramBoolean2)
        d1.setRevealInfo(new d.d(f1, f2, f3)); 
      if (paramBoolean2)
        f3 = (d1.getRevealInfo()).c; 
      animator = a.a(d1, f1, f2, k.a(f1, f2, 0.0F, 0.0F, paramFloat1, paramFloat2));
      animator.addListener(new AnimatorListenerAdapter(this, d1) {
            public void onAnimationEnd(Animator param1Animator) {
              d.d d1 = this.a.getRevealInfo();
              d1.c = Float.MAX_VALUE;
              this.a.setRevealInfo(d1);
            }
          });
      a(paramView2, i.a(), (int)f1, (int)f2, f3, paramList1);
    } else {
      float f = (d1.getRevealInfo()).c;
      Animator animator1 = a.a(d1, f1, f2, f3);
      long l = i.a();
      int j = (int)f1;
      int k = (int)f2;
      a(paramView2, l, j, k, f, paramList1);
      a(paramView2, i.a(), i.b(), parama.a.a(), j, k, f3, paramList1);
      animator = animator1;
    } 
    i.a(animator);
    paramList1.add(animator);
    paramList2.add(a.a(d1));
  }
  
  @TargetApi(21)
  private void a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2) {
    float[] arrayOfFloat;
    Property property;
    float f = r.m(paramView2) - r.m(paramView1);
    if (paramBoolean1) {
      if (!paramBoolean2)
        paramView2.setTranslationZ(-f); 
      property = View.TRANSLATION_Z;
      arrayOfFloat = new float[] { 0.0F };
    } else {
      property = View.TRANSLATION_Z;
      arrayOfFloat = new float[1];
      arrayOfFloat[0] = -f;
    } 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView2, property, arrayOfFloat);
    parama.a.b("elevation").a(objectAnimator);
    paramList1.add(objectAnimator);
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2, RectF paramRectF) {
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator1;
    String str;
    h h;
    i i1;
    float f1 = a(paramView1, paramView2, parama.b);
    float f2 = b(paramView1, paramView2, parama.b);
    if (f1 == 0.0F || f2 == 0.0F) {
      i1 = parama.a.b("translationXLinear");
      h = parama.a;
      str = "translationYLinear";
    } else if ((paramBoolean1 && f2 < 0.0F) || (!paramBoolean1 && f2 > 0.0F)) {
      i1 = parama.a.b("translationXCurveUpwards");
      h = parama.a;
      str = "translationYCurveUpwards";
    } else {
      i1 = parama.a.b("translationXCurveDownwards");
      h = parama.a;
      str = "translationYCurveDownwards";
    } 
    i i2 = h.b(str);
    i i3 = i1;
    if (paramBoolean1) {
      if (!paramBoolean2) {
        paramView2.setTranslationX(-f1);
        paramView2.setTranslationY(-f2);
      } 
      objectAnimator2 = (objectAnimator1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F })).ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      a(paramView2, parama, i3, i2, -f1, -f2, 0.0F, 0.0F, paramRectF);
    } else {
      Property property1 = View.TRANSLATION_X;
      float[] arrayOfFloat1 = new float[1];
      arrayOfFloat1[0] = -f1;
      objectAnimator1 = ObjectAnimator.ofFloat(paramView2, property1, arrayOfFloat1);
      Property property2 = View.TRANSLATION_Y;
      float[] arrayOfFloat2 = new float[1];
      arrayOfFloat2[0] = -f2;
      objectAnimator2 = ObjectAnimator.ofFloat(paramView2, property2, arrayOfFloat2);
    } 
    i3.a(objectAnimator1);
    i2.a(objectAnimator2);
    paramList1.add(objectAnimator1);
    paramList1.add(objectAnimator2);
  }
  
  private float b(View paramView1, View paramView2, j paramj) {
    float f;
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    a(paramView1, rectF1);
    a(paramView2, rectF2);
    int i = 0x70 & paramj.a;
    if (i != 16) {
      if (i != 48) {
        if (i != 80) {
          f = 0.0F;
        } else {
          float f1 = rectF2.bottom;
          float f2 = rectF1.bottom;
          f = f1 - f2;
        } 
      } else {
        float f1 = rectF2.top;
        float f2 = rectF1.top;
        f = f1 - f2;
      } 
    } else {
      float f1 = rectF2.centerY();
      float f2 = rectF1.centerY();
      f = f1 - f2;
    } 
    return f + paramj.c;
  }
  
  private ViewGroup b(View paramView) { return (paramView instanceof ViewGroup) ? (ViewGroup)paramView : null; }
  
  private void b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2) {
    if (paramView2 instanceof d) {
      int[] arrayOfInt;
      Property property;
      if (!(paramView1 instanceof ImageView))
        return; 
      d d1 = (d)paramView2;
      Drawable drawable = ((ImageView)paramView1).getDrawable();
      if (drawable == null)
        return; 
      drawable.mutate();
      if (paramBoolean1) {
        if (!paramBoolean2)
          drawable.setAlpha(255); 
        property = e.a;
        arrayOfInt = new int[] { 0 };
      } else {
        property = e.a;
        arrayOfInt = new int[] { 255 };
      } 
      ObjectAnimator objectAnimator = ObjectAnimator.ofInt(drawable, property, arrayOfInt);
      objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView2) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) { this.a.invalidate(); }
          });
      parama.a.b("iconFade").a(objectAnimator);
      paramList1.add(objectAnimator);
      paramList2.add(new AnimatorListenerAdapter(this, d1, drawable) {
            public void onAnimationEnd(Animator param1Animator) { this.a.setCircularRevealOverlayDrawable(null); }
            
            public void onAnimationStart(Animator param1Animator) { this.a.setCircularRevealOverlayDrawable(this.b); }
          });
    } 
  }
  
  private float c(View paramView1, View paramView2, j paramj) {
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    a(paramView1, rectF1);
    a(paramView2, rectF2);
    rectF2.offset(-a(paramView1, paramView2, paramj), 0.0F);
    return rectF1.centerX() - rectF2.left;
  }
  
  private int c(View paramView) {
    ColorStateList colorStateList = r.t(paramView);
    return (colorStateList != null) ? colorStateList.getColorForState(paramView.getDrawableState(), colorStateList.getDefaultColor()) : 0;
  }
  
  private void c(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2) {
    ObjectAnimator objectAnimator;
    if (!(paramView2 instanceof d))
      return; 
    d d1 = (d)paramView2;
    int i = c(paramView1);
    int j = 0xFFFFFF & i;
    if (paramBoolean1) {
      if (!paramBoolean2)
        d1.setCircularRevealScrimColor(i); 
      objectAnimator = ObjectAnimator.ofInt(d1, d.c.a, new int[] { j });
    } else {
      objectAnimator = ObjectAnimator.ofInt(d1, d.c.a, new int[] { i });
    } 
    objectAnimator.setEvaluator(c.a());
    parama.a.b("color").a(objectAnimator);
    paramList1.add(objectAnimator);
  }
  
  private float d(View paramView1, View paramView2, j paramj) {
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    a(paramView1, rectF1);
    a(paramView2, rectF2);
    rectF2.offset(0.0F, -b(paramView1, paramView2, paramj));
    return rectF1.centerY() - rectF2.top;
  }
  
  private void d(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList1, List<Animator.AnimatorListener> paramList2) {
    ObjectAnimator objectAnimator;
    if (!(paramView2 instanceof ViewGroup))
      return; 
    if (paramView2 instanceof d && c.a == 0)
      return; 
    ViewGroup viewGroup = a(paramView2);
    if (viewGroup == null)
      return; 
    if (paramBoolean1) {
      if (!paramBoolean2)
        d.a.set(viewGroup, Float.valueOf(0.0F)); 
      objectAnimator = ObjectAnimator.ofFloat(viewGroup, d.a, new float[] { 1.0F });
    } else {
      objectAnimator = ObjectAnimator.ofFloat(viewGroup, d.a, new float[] { 0.0F });
    } 
    parama.a.b("contentFade").a(objectAnimator);
    paramList1.add(objectAnimator);
  }
  
  protected abstract a a(Context paramContext, boolean paramBoolean);
  
  public void a(CoordinatorLayout.e parame) {
    if (parame.h == 0)
      parame.h = 80; 
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {
    if (paramView1.getVisibility() != 8) {
      boolean bool1 = paramView2 instanceof FloatingActionButton;
      boolean bool2 = false;
      if (bool1) {
        int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
        if (i != 0) {
          int j = paramView1.getId();
          bool2 = false;
          return (i == j) ? true : bool2;
        } 
      } else {
        return bool2;
      } 
    } else {
      throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    } 
    return true;
  }
  
  protected AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    a a1 = a(paramView2.getContext(), paramBoolean1);
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    if (Build.VERSION.SDK_INT >= 21)
      a(paramView1, paramView2, paramBoolean1, paramBoolean2, a1, arrayList1, arrayList2); 
    RectF rectF = this.b;
    a(paramView1, paramView2, paramBoolean1, paramBoolean2, a1, arrayList1, arrayList2, rectF);
    float f1 = rectF.width();
    float f2 = rectF.height();
    b(paramView1, paramView2, paramBoolean1, paramBoolean2, a1, arrayList1, arrayList2);
    a(paramView1, paramView2, paramBoolean1, paramBoolean2, a1, f1, f2, arrayList1, arrayList2);
    c(paramView1, paramView2, paramBoolean1, paramBoolean2, a1, arrayList1, arrayList2);
    d(paramView1, paramView2, paramBoolean1, paramBoolean2, a1, arrayList1, arrayList2);
    AnimatorSet animatorSet = new AnimatorSet();
    b.a(animatorSet, arrayList1);
    animatorSet.addListener(new AnimatorListenerAdapter(this, paramBoolean1, paramView2, paramView1) {
          public void onAnimationEnd(Animator param1Animator) {
            if (!this.a) {
              this.b.setVisibility(4);
              this.c.setAlpha(1.0F);
              this.c.setVisibility(0);
            } 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            if (this.a) {
              this.b.setVisibility(0);
              this.c.setAlpha(0.0F);
              this.c.setVisibility(4);
            } 
          }
        });
    byte b1 = 0;
    int i = arrayList2.size();
    while (b1 < i) {
      animatorSet.addListener((Animator.AnimatorListener)arrayList2.get(b1));
      b1++;
    } 
    return animatorSet;
  }
  
  protected static class a {
    public h a;
    
    public j b;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\transformation\FabTransformationBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */