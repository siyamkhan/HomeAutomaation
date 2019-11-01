package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v4.h.w;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
  protected final a a = new a(this);
  
  protected final Context b;
  
  protected ActionMenuView c;
  
  protected c d;
  
  protected int e;
  
  protected v f;
  
  private boolean g;
  
  private boolean h;
  
  a(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedValue typedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(a.a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
      this.b = new ContextThemeWrapper(paramContext, typedValue.resourceId);
      return;
    } 
    this.b = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean) { return paramBoolean ? (paramInt1 - paramInt2) : (paramInt1 + paramInt2); }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    int k = paramInt2 + (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, k, paramInt1, j + k);
    } else {
      paramView.layout(paramInt1, k, paramInt1 + i, j + k);
    } 
    if (paramBoolean)
      i = -i; 
    return i;
  }
  
  public v a(int paramInt, long paramLong) {
    v v1 = this.f;
    if (v1 != null)
      v1.b(); 
    if (paramInt == 0) {
      if (getVisibility() != 0)
        setAlpha(0.0F); 
      v v3 = r.l(this).a(1.0F);
      v3.a(paramLong);
      v3.a(this.a.a(v3, paramInt));
      return v3;
    } 
    v v2 = r.l(this).a(0.0F);
    v2.a(paramLong);
    v2.a(this.a.a(v2, paramInt));
    return v2;
  }
  
  public boolean a() {
    c c1 = this.d;
    return (c1 != null) ? c1.d() : 0;
  }
  
  public int getAnimatedVisibility() { return (this.f != null) ? this.a.a : getVisibility(); }
  
  public int getContentHeight() { return this.e; }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    TypedArray typedArray = getContext().obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
    setContentHeight(typedArray.getLayoutDimension(a.j.ActionBar_height, 0));
    typedArray.recycle();
    c c1 = this.d;
    if (c1 != null)
      c1.a(paramConfiguration); 
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9)
      this.h = false; 
    if (!this.h) {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if (i == 9 && !bool)
        this.h = true; 
    } 
    if (i == 10 || i == 3)
      this.h = false; 
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      this.g = false; 
    if (!this.g) {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (i == 0 && !bool)
        this.g = true; 
    } 
    if (i == 1 || i == 3)
      this.g = false; 
    return true;
  }
  
  public void setContentHeight(int paramInt) {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt) {
    if (paramInt != getVisibility()) {
      v v1 = this.f;
      if (v1 != null)
        v1.b(); 
      super.setVisibility(paramInt);
    } 
  }
  
  protected class a implements w {
    int a;
    
    private boolean c = false;
    
    protected a(a this$0) {}
    
    public a a(v param1v, int param1Int) {
      this.b.f = param1v;
      this.a = param1Int;
      return this;
    }
    
    public void a(View param1View) {
      a.a(this.b, 0);
      this.c = false;
    }
    
    public void b(View param1View) {
      if (this.c)
        return; 
      a a1 = this.b;
      a1.f = null;
      a.b(a1, this.a);
    }
    
    public void c(View param1View) { this.c = true; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */