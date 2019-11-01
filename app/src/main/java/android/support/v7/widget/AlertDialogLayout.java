package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class AlertDialogLayout extends as {
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2); }
  
  private static int c(View paramView) {
    int i = r.k(paramView);
    if (i > 0)
      return i; 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      if (viewGroup.getChildCount() == 1)
        return c(viewGroup.getChildAt(0)); 
    } 
    return 0;
  }
  
  private boolean c(int paramInt1, int paramInt2) {
    int i3;
    byte b2;
    int i2;
    int i1;
    int i = getChildCount();
    View view1 = null;
    View view2 = null;
    View view3 = null;
    for (byte b1 = 0; b1 < i; b1++) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        int i6 = view.getId();
        if (i6 == a.f.topPanel) {
          view1 = view;
        } else if (i6 == a.f.buttonPanel) {
          view2 = view;
        } else if (i6 == a.f.contentPanel || i6 == a.f.customPanel) {
          if (view3 != null)
            return false; 
          view3 = view;
        } else {
          return false;
        } 
      } 
    } 
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = getPaddingTop() + getPaddingBottom();
    if (view1 != null) {
      view1.measure(paramInt1, 0);
      n += view1.getMeasuredHeight();
      i1 = View.combineMeasuredStates(0, view1.getMeasuredState());
    } else {
      i1 = 0;
    } 
    if (view2 != null) {
      view2.measure(paramInt1, 0);
      i2 = c(view2);
      b2 = view2.getMeasuredHeight() - i2;
      n += i2;
      i1 = View.combineMeasuredStates(i1, view2.getMeasuredState());
    } else {
      i2 = 0;
      b2 = 0;
    } 
    if (view3 != null) {
      int i6;
      if (j == 0) {
        i6 = 0;
      } else {
        i6 = View.MeasureSpec.makeMeasureSpec(Math.max(0, k - n), j);
      } 
      view3.measure(paramInt1, i6);
      i3 = view3.getMeasuredHeight();
      n += i3;
      i1 = View.combineMeasuredStates(i1, view3.getMeasuredState());
    } else {
      i3 = 0;
    } 
    int i4 = k - n;
    if (view2 != null) {
      int i6 = n - i2;
      int i7 = Math.min(i4, b2);
      if (i7 > 0) {
        i4 -= i7;
        i2 += i7;
      } 
      view2.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
      n = i6 + view2.getMeasuredHeight();
      i1 = View.combineMeasuredStates(i1, view2.getMeasuredState());
    } 
    if (view3 != null && i4 > 0) {
      int i6 = n - i3;
      view3.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i3 + i4, j));
      n = i6 + view3.getMeasuredHeight();
      i1 = View.combineMeasuredStates(i1, view3.getMeasuredState());
    } 
    byte b3 = 0;
    int i5 = 0;
    while (b3 < i) {
      View view = getChildAt(b3);
      if (view.getVisibility() != 8)
        i5 = Math.max(i5, view.getMeasuredWidth()); 
      b3++;
    } 
    setMeasuredDimension(View.resolveSizeAndState(i5 + getPaddingLeft() + getPaddingRight(), paramInt1, i1), View.resolveSizeAndState(n, paramInt2, 0));
    if (m != 1073741824)
      d(i, paramInt2); 
    return true;
  }
  
  private void d(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (byte b = 0; b < paramInt1; b++) {
      View view = getChildAt(b);
      if (view.getVisibility() != 8) {
        as.a a = (as.a)view.getLayoutParams();
        if (a.width == -1) {
          int j = a.height;
          a.height = view.getMeasuredHeight();
          measureChildWithMargins(view, i, 0, paramInt2, 0);
          a.height = j;
        } 
      } 
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i6;
    int i5;
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = j - getPaddingRight();
    int m = j - i - getPaddingRight();
    int n = getMeasuredHeight();
    int i1 = getChildCount();
    int i2 = getGravity();
    int i3 = i2 & 0x70;
    int i4 = i2 & 0x800007;
    if (i3 != 16) {
      if (i3 != 80) {
        i5 = getPaddingTop();
      } else {
        i5 = paramInt4 + getPaddingTop() - paramInt2 - n;
      } 
    } else {
      i5 = getPaddingTop() + (paramInt4 - paramInt2 - n) / 2;
    } 
    Drawable drawable = getDividerDrawable();
    if (drawable == null) {
      i6 = 0;
    } else {
      i6 = drawable.getIntrinsicHeight();
    } 
    for (byte b = 0; b < i1; b++) {
      View view = getChildAt(b);
      if (view != null && view.getVisibility() != 8) {
        int i11;
        int i7 = view.getMeasuredWidth();
        int i8 = view.getMeasuredHeight();
        as.a a = (as.a)view.getLayoutParams();
        int i9 = a.h;
        if (i9 < 0)
          i9 = i4; 
        int i10 = 0x7 & d.a(i9, r.f(this));
        if (i10 != 1) {
          if (i10 != 5) {
            i11 = i + a.leftMargin;
          } else {
            int i13 = k - i7;
            i11 = i13 - a.rightMargin;
          } 
        } else {
          int i13 = i + (m - i7) / 2 + a.leftMargin;
          i11 = i13 - a.rightMargin;
        } 
        if (c(b))
          i5 += i6; 
        int i12 = i5 + a.topMargin;
        a(view, i11, i12, i7, i8);
        i5 = i12 + i8 + a.bottomMargin;
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (!c(paramInt1, paramInt2))
      super.onMeasure(paramInt1, paramInt2); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\AlertDialogLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */