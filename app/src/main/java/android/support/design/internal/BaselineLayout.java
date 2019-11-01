package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
  private int a = -1;
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet, 0); }
  
  public int getBaseline() { return this.a; }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getChildCount();
    int j = getPaddingLeft();
    int k = paramInt3 - paramInt1 - getPaddingRight() - j;
    int m = getPaddingTop();
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      if (view.getVisibility() != 8) {
        int i3;
        int n = view.getMeasuredWidth();
        int i1 = view.getMeasuredHeight();
        int i2 = j + (k - n) / 2;
        if (this.a != -1 && view.getBaseline() != -1) {
          i3 = m + this.a - view.getBaseline();
        } else {
          i3 = m;
        } 
        view.layout(i2, i3, n + i2, i1 + i3);
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = getChildCount();
    byte b = 0;
    int j = -1;
    int k = -1;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (b < i) {
      View view = getChildAt(b);
      if (view.getVisibility() != 8) {
        measureChild(view, paramInt1, paramInt2);
        int i3 = view.getBaseline();
        if (i3 != -1) {
          j = Math.max(j, i3);
          k = Math.max(k, view.getMeasuredHeight() - i3);
        } 
        n = Math.max(n, view.getMeasuredWidth());
        m = Math.max(m, view.getMeasuredHeight());
        i1 = View.combineMeasuredStates(i1, view.getMeasuredState());
      } 
      b++;
    } 
    if (j != -1) {
      m = Math.max(m, j + Math.max(k, getPaddingBottom()));
      this.a = j;
    } 
    int i2 = Math.max(m, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(n, getSuggestedMinimumWidth()), paramInt1, i1), View.resolveSizeAndState(i2, paramInt2, i1 << 16));
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\internal\BaselineLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */