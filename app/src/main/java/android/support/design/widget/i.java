package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.c.a;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v4.h.z;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

abstract class i extends q<View> {
  final Rect a = new Rect();
  
  final Rect b = new Rect();
  
  private int c = 0;
  
  private int d;
  
  public i() {}
  
  public i(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private static int c(int paramInt) {
    if (paramInt == 0)
      paramInt = 8388659; 
    return paramInt;
  }
  
  float a(View paramView) { return 1.0F; }
  
  final int a() { return this.c; }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j = (paramView.getLayoutParams()).height;
    if (j == -1 || j == -2) {
      View view = b(paramCoordinatorLayout.c(paramView));
      if (view != null) {
        int n;
        if (r.q(view) && !r.q(paramView)) {
          r.b(paramView, true);
          if (r.q(paramView)) {
            paramView.requestLayout();
            return true;
          } 
        } 
        int k = View.MeasureSpec.getSize(paramInt3);
        if (k == 0)
          k = paramCoordinatorLayout.getHeight(); 
        int m = k - view.getMeasuredHeight() + b(view);
        if (j == -1) {
          n = 1073741824;
        } else {
          n = Integer.MIN_VALUE;
        } 
        paramCoordinatorLayout.a(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(m, n), paramInt4);
        return true;
      } 
    } 
    return false;
  }
  
  int b(View paramView) { return paramView.getMeasuredHeight(); }
  
  abstract View b(List<View> paramList);
  
  public final void b(int paramInt) { this.d = paramInt; }
  
  protected void b(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt) {
    boolean bool;
    View view = b(paramCoordinatorLayout.c(paramView));
    if (view != null) {
      CoordinatorLayout.e e = (CoordinatorLayout.e)paramView.getLayoutParams();
      Rect rect1 = this.a;
      rect1.set(paramCoordinatorLayout.getPaddingLeft() + e.leftMargin, view.getBottom() + e.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - e.rightMargin, paramCoordinatorLayout.getHeight() + view.getBottom() - paramCoordinatorLayout.getPaddingBottom() - e.bottomMargin);
      z z = paramCoordinatorLayout.getLastWindowInsets();
      if (z != null && r.q(paramCoordinatorLayout) && !r.q(paramView)) {
        rect1.left += z.a();
        rect1.right -= z.c();
      } 
      Rect rect2 = this.b;
      d.a(c(e.c), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), rect1, rect2, paramInt);
      int j = c(view);
      paramView.layout(rect2.left, rect2.top - j, rect2.right, rect2.bottom - j);
      bool = rect2.top - view.getBottom();
    } else {
      super.b(paramCoordinatorLayout, paramView, paramInt);
      bool = false;
    } 
    this.c = bool;
  }
  
  final int c(View paramView) {
    if (this.d == 0)
      return 0; 
    float f = a(paramView);
    int j = this.d;
    return a.a((int)(f * j), 0, j);
  }
  
  public final int d() { return this.d; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */