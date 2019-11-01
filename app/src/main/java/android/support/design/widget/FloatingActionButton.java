package android.support.design.widget;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.a.h;
import android.support.design.d.a;
import android.support.design.d.c;
import android.support.design.i.a;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.q;
import android.support.v4.h.r;
import android.support.v4.widget.p;
import android.support.v7.widget.l;
import android.support.v7.widget.p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

@c(a = "Landroid/support/design/widget/FloatingActionButton$Behavior;")
public class FloatingActionButton extends t implements a, q, p {
  boolean a;
  
  final Rect b;
  
  private ColorStateList c;
  
  private PorterDuff.Mode d;
  
  private ColorStateList e;
  
  private PorterDuff.Mode f;
  
  private ColorStateList g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private final Rect l;
  
  private final p m;
  
  private final c n;
  
  private f o;
  
  private int a(int paramInt) {
    int i1 = this.i;
    if (i1 != 0)
      return i1; 
    Resources resources = getResources();
    if (paramInt != -1) {
      if (paramInt != 1) {
        int i3 = a.d.design_fab_size_normal;
        return resources.getDimensionPixelSize(i3);
      } 
      int i2 = a.d.design_fab_size_mini;
      return resources.getDimensionPixelSize(i2);
    } 
    return (Math.max((resources.getConfiguration()).screenWidthDp, (resources.getConfiguration()).screenHeightDp) < 470) ? a(1) : a(0);
  }
  
  private static int a(int paramInt1, int paramInt2) {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 != Integer.MIN_VALUE) {
      if (i1 != 0) {
        if (i1 == 1073741824)
          return i2; 
        throw new IllegalArgumentException();
      } 
    } else {
      paramInt1 = Math.min(paramInt1, i2);
    } 
    return paramInt1;
  }
  
  private f.d a(a parama) { return (parama == null) ? null : new f.d(this, parama) {
        public void a() { this.a.a(this.b); }
        
        public void b() { this.a.b(this.b); }
      }; }
  
  private void c() {
    Drawable drawable = getDrawable();
    if (drawable == null)
      return; 
    ColorStateList colorStateList = this.e;
    if (colorStateList == null) {
      a.f(drawable);
      return;
    } 
    int i1 = colorStateList.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode mode = this.f;
    if (mode == null)
      mode = PorterDuff.Mode.SRC_IN; 
    drawable.mutate().setColorFilter(l.a(i1, mode));
  }
  
  private void c(Rect paramRect) {
    paramRect.left += this.b.left;
    paramRect.top += this.b.top;
    paramRect.right -= this.b.right;
    paramRect.bottom -= this.b.bottom;
  }
  
  private f d() { return (Build.VERSION.SDK_INT >= 21) ? new g(this, new b(this)) : new f(this, new b(this)); }
  
  private f getImpl() {
    if (this.o == null)
      this.o = d(); 
    return this.o;
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener) { getImpl().a(paramAnimatorListener); }
  
  void a(a parama, boolean paramBoolean) { getImpl().b(a(parama), paramBoolean); }
  
  public boolean a() { return this.n.a(); }
  
  @Deprecated
  public boolean a(Rect paramRect) {
    if (r.x(this)) {
      paramRect.set(0, 0, getWidth(), getHeight());
      c(paramRect);
      return true;
    } 
    return false;
  }
  
  public void b(Animator.AnimatorListener paramAnimatorListener) { getImpl().b(paramAnimatorListener); }
  
  public void b(Rect paramRect) {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    c(paramRect);
  }
  
  void b(a parama, boolean paramBoolean) { getImpl().a(a(parama), paramBoolean); }
  
  public boolean b() { return getImpl().o(); }
  
  public void c(Animator.AnimatorListener paramAnimatorListener) { getImpl().c(paramAnimatorListener); }
  
  public void d(Animator.AnimatorListener paramAnimatorListener) { getImpl().d(paramAnimatorListener); }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    getImpl().a(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList() { return this.c; }
  
  public PorterDuff.Mode getBackgroundTintMode() { return this.d; }
  
  public float getCompatElevation() { return getImpl().a(); }
  
  public float getCompatHoveredFocusedTranslationZ() { return getImpl().b(); }
  
  public float getCompatPressedTranslationZ() { return getImpl().c(); }
  
  public Drawable getContentBackground() { return getImpl().h(); }
  
  public int getCustomSize() { return this.i; }
  
  public int getExpandedComponentIdHint() { return this.n.c(); }
  
  public h getHideMotionSpec() { return getImpl().f(); }
  
  @Deprecated
  public int getRippleColor() {
    ColorStateList colorStateList = this.g;
    return (colorStateList != null) ? colorStateList.getDefaultColor() : 0;
  }
  
  public ColorStateList getRippleColorStateList() { return this.g; }
  
  public h getShowMotionSpec() { return getImpl().e(); }
  
  public int getSize() { return this.h; }
  
  int getSizeDimension() { return a(this.h); }
  
  public ColorStateList getSupportBackgroundTintList() { return getBackgroundTintList(); }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() { return getBackgroundTintMode(); }
  
  public ColorStateList getSupportImageTintList() { return this.e; }
  
  public PorterDuff.Mode getSupportImageTintMode() { return this.f; }
  
  public boolean getUseCompatPadding() { return this.a; }
  
  public void jumpDrawablesToCurrentState() {
    super.jumpDrawablesToCurrentState();
    getImpl().g();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    getImpl().k();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    getImpl().l();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i1 = getSizeDimension();
    this.j = (i1 - this.k) / 2;
    getImpl().j();
    int i2 = Math.min(a(i1, paramInt1), a(i1, paramInt2));
    setMeasuredDimension(i2 + this.b.left + this.b.right, i2 + this.b.top + this.b.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof a)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    a a1 = (a)paramParcelable;
    super.onRestoreInstanceState(a1.a());
    this.n.a((Bundle)a1.a.get("expandableWidgetHelper"));
  }
  
  protected Parcelable onSaveInstanceState() {
    a a1 = new a(super.onSaveInstanceState());
    a1.a.put("expandableWidgetHelper", this.n.b());
    return a1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) { return (paramMotionEvent.getAction() == 0 && a(this.l) && !this.l.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) ? false : super.onTouchEvent(paramMotionEvent); }
  
  public void setBackgroundColor(int paramInt) { Log.i("FloatingActionButton", "Setting a custom background is not supported."); }
  
  public void setBackgroundDrawable(Drawable paramDrawable) { Log.i("FloatingActionButton", "Setting a custom background is not supported."); }
  
  public void setBackgroundResource(int paramInt) { Log.i("FloatingActionButton", "Setting a custom background is not supported."); }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList) {
    if (this.c != paramColorStateList) {
      this.c = paramColorStateList;
      getImpl().a(paramColorStateList);
    } 
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (this.d != paramMode) {
      this.d = paramMode;
      getImpl().a(paramMode);
    } 
  }
  
  public void setCompatElevation(float paramFloat) { getImpl().a(paramFloat); }
  
  public void setCompatElevationResource(int paramInt) { setCompatElevation(getResources().getDimension(paramInt)); }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat) { getImpl().b(paramFloat); }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt) { setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt)); }
  
  public void setCompatPressedTranslationZ(float paramFloat) { getImpl().c(paramFloat); }
  
  public void setCompatPressedTranslationZResource(int paramInt) { setCompatPressedTranslationZ(getResources().getDimension(paramInt)); }
  
  public void setCustomSize(int paramInt) {
    if (paramInt >= 0) {
      this.i = paramInt;
      return;
    } 
    throw new IllegalArgumentException("Custom size must be non-negative");
  }
  
  public void setExpandedComponentIdHint(int paramInt) { this.n.a(paramInt); }
  
  public void setHideMotionSpec(h paramh) { getImpl().b(paramh); }
  
  public void setHideMotionSpecResource(int paramInt) { setHideMotionSpec(h.a(getContext(), paramInt)); }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    getImpl().d();
  }
  
  public void setImageResource(int paramInt) { this.m.a(paramInt); }
  
  public void setRippleColor(int paramInt) { setRippleColor(ColorStateList.valueOf(paramInt)); }
  
  public void setRippleColor(ColorStateList paramColorStateList) {
    if (this.g != paramColorStateList) {
      this.g = paramColorStateList;
      getImpl().b(this.g);
    } 
  }
  
  public void setShowMotionSpec(h paramh) { getImpl().a(paramh); }
  
  public void setShowMotionSpecResource(int paramInt) { setShowMotionSpec(h.a(getContext(), paramInt)); }
  
  public void setSize(int paramInt) {
    this.i = 0;
    if (paramInt != this.h) {
      this.h = paramInt;
      requestLayout();
    } 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) { setBackgroundTintList(paramColorStateList); }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) { setBackgroundTintMode(paramMode); }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList) {
    if (this.e != paramColorStateList) {
      this.e = paramColorStateList;
      c();
    } 
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode) {
    if (this.f != paramMode) {
      this.f = paramMode;
      c();
    } 
  }
  
  public void setUseCompatPadding(boolean paramBoolean) {
    if (this.a != paramBoolean) {
      this.a = paramBoolean;
      getImpl().i();
    } 
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.b<T> {
    private Rect a;
    
    private FloatingActionButton.a b;
    
    private boolean c;
    
    public BaseBehavior() { this.c = true; }
    
    public BaseBehavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.k.FloatingActionButton_Behavior_Layout);
      this.c = typedArray.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      typedArray.recycle();
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton) {
      Rect rect = param1FloatingActionButton.b;
      if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
        int i;
        byte b1;
        CoordinatorLayout.e e = (CoordinatorLayout.e)param1FloatingActionButton.getLayoutParams();
        if (param1FloatingActionButton.getRight() >= param1CoordinatorLayout.getWidth() - e.rightMargin) {
          b1 = rect.right;
        } else if (param1FloatingActionButton.getLeft() <= e.leftMargin) {
          b1 = -rect.left;
        } else {
          b1 = 0;
        } 
        if (param1FloatingActionButton.getBottom() >= param1CoordinatorLayout.getHeight() - e.bottomMargin) {
          i = rect.bottom;
        } else {
          int j = param1FloatingActionButton.getTop();
          int k = e.topMargin;
          i = 0;
          if (j <= k)
            i = -rect.top; 
        } 
        if (i != 0)
          r.e(param1FloatingActionButton, i); 
        if (b1)
          r.f(param1FloatingActionButton, b1); 
      } 
    }
    
    private boolean a(CoordinatorLayout param1CoordinatorLayout, AppBarLayout param1AppBarLayout, FloatingActionButton param1FloatingActionButton) {
      if (!a(param1AppBarLayout, param1FloatingActionButton))
        return false; 
      if (this.a == null)
        this.a = new Rect(); 
      Rect rect = this.a;
      d.b(param1CoordinatorLayout, param1AppBarLayout, rect);
      if (rect.bottom <= param1AppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        param1FloatingActionButton.b(this.b, false);
      } else {
        param1FloatingActionButton.a(this.b, false);
      } 
      return true;
    }
    
    private static boolean a(View param1View) {
      ViewGroup.LayoutParams layoutParams = param1View.getLayoutParams();
      return (layoutParams instanceof CoordinatorLayout.e) ? (((CoordinatorLayout.e)layoutParams).b() instanceof BottomSheetBehavior) : 0;
    }
    
    private boolean a(View param1View, FloatingActionButton param1FloatingActionButton) {
      CoordinatorLayout.e e = (CoordinatorLayout.e)param1FloatingActionButton.getLayoutParams();
      return !this.c ? false : ((e.a() != param1View.getId()) ? false : (!(param1FloatingActionButton.getUserSetVisibility() != 0)));
    }
    
    private boolean b(View param1View, FloatingActionButton param1FloatingActionButton) {
      if (!a(param1View, param1FloatingActionButton))
        return false; 
      CoordinatorLayout.e e = (CoordinatorLayout.e)param1FloatingActionButton.getLayoutParams();
      if (param1View.getTop() < param1FloatingActionButton.getHeight() / 2 + e.topMargin) {
        param1FloatingActionButton.b(this.b, false);
      } else {
        param1FloatingActionButton.a(this.b, false);
      } 
      return true;
    }
    
    public void a(CoordinatorLayout.e param1e) {
      if (param1e.h == 0)
        param1e.h = 80; 
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton, int param1Int) {
      List list = param1CoordinatorLayout.c(param1FloatingActionButton);
      int i = list.size();
      for (byte b1 = 0; b1 < i; b1++) {
        View view = (View)list.get(b1);
        if ((view instanceof AppBarLayout) ? a(param1CoordinatorLayout, (AppBarLayout)view, param1FloatingActionButton) : (a(view) && b(view, param1FloatingActionButton)))
          break; 
      } 
      param1CoordinatorLayout.a(param1FloatingActionButton, param1Int);
      a(param1CoordinatorLayout, param1FloatingActionButton);
      return true;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton, Rect param1Rect) {
      Rect rect = param1FloatingActionButton.b;
      param1Rect.set(param1FloatingActionButton.getLeft() + rect.left, param1FloatingActionButton.getTop() + rect.top, param1FloatingActionButton.getRight() - rect.right, param1FloatingActionButton.getBottom() - rect.bottom);
      return true;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, FloatingActionButton param1FloatingActionButton, View param1View) {
      if (param1View instanceof AppBarLayout) {
        a(param1CoordinatorLayout, (AppBarLayout)param1View, param1FloatingActionButton);
      } else if (a(param1View)) {
        b(param1View, param1FloatingActionButton);
      } 
      return false;
    }
  }
  
  public static class Behavior extends BaseBehavior<FloatingActionButton> {
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
  }
  
  public static abstract class a {
    public void a(FloatingActionButton param1FloatingActionButton) {}
    
    public void b(FloatingActionButton param1FloatingActionButton) {}
  }
  
  private class b implements m {
    b(FloatingActionButton this$0) {}
    
    public float a() { return this.a.getSizeDimension() / 2.0F; }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.a.b.set(param1Int1, param1Int2, param1Int3, param1Int4);
      FloatingActionButton floatingActionButton;
      floatingActionButton.setPadding(param1Int1 + (floatingActionButton = this.a).a(floatingActionButton), param1Int2 + FloatingActionButton.a(this.a), param1Int3 + FloatingActionButton.a(this.a), param1Int4 + FloatingActionButton.a(this.a));
    }
    
    public void a(Drawable param1Drawable) { FloatingActionButton.a(this.a, param1Drawable); }
    
    public boolean b() { return this.a.a; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */