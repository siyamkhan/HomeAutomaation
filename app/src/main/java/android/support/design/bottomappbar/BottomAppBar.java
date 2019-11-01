package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a.a;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.g.c;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.a;
import android.support.v4.h.r;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
  AnimatorListenerAdapter a;
  
  private final int f;
  
  private final c g;
  
  private final a h;
  
  private Animator i;
  
  private Animator j;
  
  private Animator k;
  
  private int l;
  
  private boolean m;
  
  private boolean n;
  
  private float a(boolean paramBoolean) {
    FloatingActionButton floatingActionButton = m();
    if (floatingActionButton == null)
      return 0.0F; 
    Rect rect = new Rect();
    floatingActionButton.a(rect);
    float f1 = rect.height();
    if (f1 == 0.0F)
      f1 = floatingActionButton.getMeasuredHeight(); 
    float f2 = (floatingActionButton.getHeight() - rect.bottom);
    float f3 = (floatingActionButton.getHeight() - rect.height());
    float f4 = f2 + -getCradleVerticalOffset() + f1 / 2.0F;
    float f5 = f3 - floatingActionButton.getPaddingBottom();
    float f6 = -getMeasuredHeight();
    if (paramBoolean)
      f5 = f4; 
    return f6 + f5;
  }
  
  private void a(int paramInt) {
    if (this.l != paramInt) {
      if (!r.x(this))
        return; 
      Animator animator = this.j;
      if (animator != null)
        animator.cancel(); 
      ArrayList arrayList = new ArrayList();
      a(paramInt, arrayList);
      b(paramInt, arrayList);
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.playTogether(arrayList);
      this.j = animatorSet;
      this.j.addListener(new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator param1Animator) { BottomAppBar.a(this.a, null); }
          });
      this.j.start();
    } 
  }
  
  private void a(int paramInt, List<Animator> paramList) {
    if (!this.n)
      return; 
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.h.a();
    arrayOfFloat[1] = b(paramInt);
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(arrayOfFloat);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            BottomAppBar.a(this.a).a(((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
            BottomAppBar.b(this.a).invalidateSelf();
          }
        });
    valueAnimator.setDuration(300L);
    paramList.add(valueAnimator);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (!r.x(this))
      return; 
    Animator animator = this.k;
    if (animator != null)
      animator.cancel(); 
    ArrayList arrayList = new ArrayList();
    if (!n()) {
      paramInt = 0;
      paramBoolean = false;
    } 
    a(paramInt, paramBoolean, arrayList);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(arrayList);
    this.k = animatorSet;
    this.k.addListener(new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) { BottomAppBar.b(this.a, null); }
        });
    this.k.start();
  }
  
  private void a(int paramInt, boolean paramBoolean, List<Animator> paramList) {
    ActionMenuView actionMenuView = getActionMenuView();
    if (actionMenuView == null)
      return; 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[] { 1.0F });
    if ((this.n || (paramBoolean && n())) && (this.l == 1 || paramInt == 1)) {
      ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[] { 0.0F });
      objectAnimator1.addListener(new AnimatorListenerAdapter(this, actionMenuView, paramInt, paramBoolean) {
            public boolean a;
            
            public void onAnimationCancel(Animator param1Animator) { this.a = true; }
            
            public void onAnimationEnd(Animator param1Animator) {
              if (!this.a)
                BottomAppBar.a(this.e, this.b, this.c, this.d); 
            }
          });
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.setDuration(150L);
      animatorSet.playSequentially(new Animator[] { objectAnimator1, objectAnimator });
      paramList.add(animatorSet);
      return;
    } 
    if (actionMenuView.getAlpha() < 1.0F) {
      paramList.add(objectAnimator);
      return;
    } 
  }
  
  private void a(FloatingActionButton paramFloatingActionButton) {
    b(paramFloatingActionButton);
    paramFloatingActionButton.c(this.a);
    paramFloatingActionButton.a(this.a);
  }
  
  private void a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {
    float f1;
    int i2;
    boolean bool;
    if (r.f(this) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    byte b = 0;
    int i1 = 0;
    while (b < getChildCount()) {
      boolean bool1;
      View view = getChildAt(b);
      if (view.getLayoutParams() instanceof Toolbar.b && (0x800007 & ((Toolbar.b)view.getLayoutParams()).a) == 8388611) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1) {
        int i4;
        if (bool) {
          i4 = view.getLeft();
        } else {
          i4 = view.getRight();
        } 
        i1 = Math.max(i1, i4);
      } 
      b++;
    } 
    if (bool) {
      i2 = paramActionMenuView.getRight();
    } else {
      i2 = paramActionMenuView.getLeft();
    } 
    int i3 = i1 - i2;
    if (paramInt == 1 && paramBoolean) {
      f1 = i3;
    } else {
      f1 = 0.0F;
    } 
    paramActionMenuView.setTranslationX(f1);
  }
  
  private int b(int paramInt) {
    boolean bool;
    int i1 = r.f(this);
    int i2 = 1;
    if (i1 == i2) {
      bool = true;
    } else {
      bool = false;
    } 
    int i3 = 0;
    if (paramInt == i2) {
      int i4 = getMeasuredWidth() / 2 - this.f;
      if (bool)
        i2 = -1; 
      i3 = i4 * i2;
    } 
    return i3;
  }
  
  private void b(int paramInt, List<Animator> paramList) {
    FloatingActionButton floatingActionButton = m();
    float[] arrayOfFloat = new float[1];
    arrayOfFloat[0] = b(paramInt);
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton, "translationX", arrayOfFloat);
    objectAnimator.setDuration(300L);
    paramList.add(objectAnimator);
  }
  
  private void b(FloatingActionButton paramFloatingActionButton) {
    paramFloatingActionButton.d(this.a);
    paramFloatingActionButton.b(this.a);
  }
  
  private ActionMenuView getActionMenuView() {
    for (byte b = 0; b < getChildCount(); b++) {
      View view = getChildAt(b);
      if (view instanceof ActionMenuView)
        return (ActionMenuView)view; 
    } 
    return null;
  }
  
  private float getFabTranslationX() { return b(this.l); }
  
  private float getFabTranslationY() { return a(this.n); }
  
  private FloatingActionButton m() {
    if (!(getParent() instanceof CoordinatorLayout))
      return null; 
    for (View view : ((CoordinatorLayout)getParent()).d(this)) {
      if (view instanceof FloatingActionButton)
        return (FloatingActionButton)view; 
    } 
    return null;
  }
  
  private boolean n() {
    FloatingActionButton floatingActionButton = m();
    return (floatingActionButton != null && floatingActionButton.b());
  }
  
  private void o() {
    Animator animator1 = this.i;
    if (animator1 != null)
      animator1.cancel(); 
    Animator animator2 = this.k;
    if (animator2 != null)
      animator2.cancel(); 
    Animator animator3 = this.j;
    if (animator3 != null)
      animator3.cancel(); 
  }
  
  private boolean p() {
    Animator animator = this.i;
    if (animator == null || !animator.isRunning()) {
      Animator animator1 = this.k;
      if (animator1 == null || !animator1.isRunning()) {
        Animator animator2 = this.j;
        if (animator2 == null || !animator2.isRunning())
          return false; 
      } 
    } 
    return true;
  }
  
  private void q() {
    float f1;
    this.h.a(getFabTranslationX());
    FloatingActionButton floatingActionButton = m();
    c c1 = this.g;
    if (this.n && n()) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    } 
    c1.a(f1);
    if (floatingActionButton != null) {
      floatingActionButton.setTranslationY(getFabTranslationY());
      floatingActionButton.setTranslationX(getFabTranslationX());
    } 
    ActionMenuView actionMenuView = getActionMenuView();
    if (actionMenuView != null) {
      actionMenuView.setAlpha(1.0F);
      if (!n()) {
        a(actionMenuView, 0, false);
        return;
      } 
      a(actionMenuView, this.l, this.n);
    } 
  }
  
  public ColorStateList getBackgroundTint() { return this.g.a(); }
  
  public CoordinatorLayout.b<BottomAppBar> getBehavior() { return new Behavior(); }
  
  public float getCradleVerticalOffset() { return this.h.b(); }
  
  public int getFabAlignmentMode() { return this.l; }
  
  public float getFabCradleMargin() { return this.h.d(); }
  
  public float getFabCradleRoundedCornerRadius() { return this.h.e(); }
  
  public boolean getHideOnScroll() { return this.m; }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    o();
    q();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof a)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    a a1 = (a)paramParcelable;
    super.onRestoreInstanceState(a1.a());
    this.l = a1.a;
    this.n = a1.b;
  }
  
  protected Parcelable onSaveInstanceState() {
    a a1 = new a(super.onSaveInstanceState());
    a1.a = this.l;
    a1.b = this.n;
    return a1;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList) { a.a(this.g, paramColorStateList); }
  
  public void setCradleVerticalOffset(float paramFloat) {
    if (paramFloat != getCradleVerticalOffset()) {
      this.h.b(paramFloat);
      this.g.invalidateSelf();
    } 
  }
  
  public void setFabAlignmentMode(int paramInt) {
    a(paramInt);
    a(paramInt, this.n);
    this.l = paramInt;
  }
  
  public void setFabCradleMargin(float paramFloat) {
    if (paramFloat != getFabCradleMargin()) {
      this.h.d(paramFloat);
      this.g.invalidateSelf();
    } 
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat) {
    if (paramFloat != getFabCradleRoundedCornerRadius()) {
      this.h.e(paramFloat);
      this.g.invalidateSelf();
    } 
  }
  
  void setFabDiameter(int paramInt) {
    float f1 = paramInt;
    if (f1 != this.h.c()) {
      this.h.c(f1);
      this.g.invalidateSelf();
    } 
  }
  
  public void setHideOnScroll(boolean paramBoolean) { this.m = paramBoolean; }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
    private final Rect a = new Rect();
    
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    private boolean a(FloatingActionButton param1FloatingActionButton, BottomAppBar param1BottomAppBar) {
      ((CoordinatorLayout.e)param1FloatingActionButton.getLayoutParams()).d = 17;
      BottomAppBar.a(param1BottomAppBar, param1FloatingActionButton);
      return true;
    }
    
    protected void a(BottomAppBar param1BottomAppBar) {
      super.a(param1BottomAppBar);
      FloatingActionButton floatingActionButton = BottomAppBar.c(param1BottomAppBar);
      if (floatingActionButton != null) {
        floatingActionButton.clearAnimation();
        floatingActionButton.animate().translationY(BottomAppBar.f(param1BottomAppBar)).setInterpolator(a.d).setDuration(225L);
      } 
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, BottomAppBar param1BottomAppBar, int param1Int) {
      FloatingActionButton floatingActionButton = BottomAppBar.c(param1BottomAppBar);
      if (floatingActionButton != null) {
        a(floatingActionButton, param1BottomAppBar);
        floatingActionButton.b(this.a);
        param1BottomAppBar.setFabDiameter(this.a.height());
      } 
      if (!BottomAppBar.d(param1BottomAppBar))
        BottomAppBar.e(param1BottomAppBar); 
      param1CoordinatorLayout.a(param1BottomAppBar, param1Int);
      return super.a(param1CoordinatorLayout, param1BottomAppBar, param1Int);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, BottomAppBar param1BottomAppBar, View param1View1, View param1View2, int param1Int1, int param1Int2) { return (param1BottomAppBar.getHideOnScroll() && super.a(param1CoordinatorLayout, param1BottomAppBar, param1View1, param1View2, param1Int1, param1Int2)); }
    
    protected void b(BottomAppBar param1BottomAppBar) {
      super.b(param1BottomAppBar);
      FloatingActionButton floatingActionButton = BottomAppBar.c(param1BottomAppBar);
      if (floatingActionButton != null) {
        floatingActionButton.a(this.a);
        float f = (floatingActionButton.getMeasuredHeight() - this.a.height());
        floatingActionButton.clearAnimation();
        floatingActionButton.animate().translationY(f + -floatingActionButton.getPaddingBottom()).setInterpolator(a.c).setDuration(175L);
      } 
    }
  }
  
  static class a extends a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() {
        public BottomAppBar.a a(Parcel param2Parcel) { return new BottomAppBar.a(param2Parcel, null); }
        
        public BottomAppBar.a a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new BottomAppBar.a(param2Parcel, param2ClassLoader); }
        
        public BottomAppBar.a[] a(int param2Int) { return new BottomAppBar.a[param2Int]; }
      };
    
    int a;
    
    boolean b;
    
    public a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readInt();
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = bool;
    }
    
    public a(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<a> {
    public BottomAppBar.a a(Parcel param1Parcel) { return new BottomAppBar.a(param1Parcel, null); }
    
    public BottomAppBar.a a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new BottomAppBar.a(param1Parcel, param1ClassLoader); }
    
    public BottomAppBar.a[] a(int param1Int) { return new BottomAppBar.a[param1Int]; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\bottomappbar\BottomAppBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */