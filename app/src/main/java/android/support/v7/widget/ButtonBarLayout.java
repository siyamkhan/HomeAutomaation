package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ButtonBarLayout extends LinearLayout {
  private boolean a;
  
  private int b = -1;
  
  private int c = 0;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ButtonBarLayout);
    this.a = typedArray.getBoolean(a.j.ButtonBarLayout_allowStacking, true);
    typedArray.recycle();
  }
  
  private int a(int paramInt) {
    int i = getChildCount();
    while (paramInt < i) {
      if (getChildAt(paramInt).getVisibility() == 0)
        return paramInt; 
      paramInt++;
    } 
    return -1;
  }
  
  private boolean a() { return (getOrientation() == 1); }
  
  private void setStacked(boolean paramBoolean) {
    byte b1;
    setOrientation(paramBoolean);
    if (paramBoolean != 0) {
      b1 = 5;
    } else {
      b1 = 80;
    } 
    setGravity(b1);
    View view = findViewById(a.f.spacer);
    if (view != null) {
      byte b2;
      if (paramBoolean != 0) {
        b2 = 8;
      } else {
        b2 = 4;
      } 
      view.setVisibility(b2);
    } 
    for (int i = -2 + getChildCount(); i >= 0; i--)
      bringChildToFront(getChildAt(i)); 
  }
  
  public int getMinimumHeight() { return Math.max(this.c, super.getMinimumHeight()); }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool;
    int j;
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.a) {
      if (i > this.b && a())
        setStacked(false); 
      this.b = i;
    } 
    if (!a() && View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      j = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
      bool = true;
    } else {
      j = paramInt1;
      bool = false;
    } 
    super.onMeasure(j, paramInt2);
    if (this.a && !a()) {
      boolean bool1;
      if ((0xFF000000 & getMeasuredWidthAndState()) == 16777216) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1) {
        setStacked(true);
        bool = true;
      } 
    } 
    if (bool)
      super.onMeasure(paramInt1, paramInt2); 
    int k = a(0);
    int m = 0;
    if (k >= 0) {
      View view = getChildAt(k);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
      int n = 0 + getPaddingTop() + view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      if (a()) {
        int i1 = a(k + 1);
        if (i1 >= 0)
          n += getChildAt(i1).getPaddingTop() + (int)(16.0F * (getResources().getDisplayMetrics()).density); 
        m = n;
      } else {
        m = n + getPaddingBottom();
      } 
    } 
    if (r.k(this) != m)
      setMinimumHeight(m); 
  }
  
  public void setAllowStacking(boolean paramBoolean) {
    if (this.a != paramBoolean) {
      this.a = paramBoolean;
      if (!this.a && getOrientation() == 1)
        setStacked(false); 
      requestLayout();
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ButtonBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */