package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.design.h.a;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements a {
  private TextView a;
  
  private Button b;
  
  private int c;
  
  private int d;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    this.c = typedArray.getDimensionPixelSize(a.k.SnackbarLayout_android_maxWidth, -1);
    this.d = typedArray.getDimensionPixelSize(a.k.SnackbarLayout_maxActionInlineWidth, -1);
    typedArray.recycle();
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2) {
    if (r.s(paramView)) {
      r.a(paramView, r.h(paramView), paramInt1, r.i(paramView), paramInt2);
      return;
    } 
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt1 != getOrientation()) {
      setOrientation(paramInt1);
      bool = true;
    } else {
      bool = false;
    } 
    if (this.a.getPaddingTop() != paramInt2 || this.a.getPaddingBottom() != paramInt3) {
      a(this.a, paramInt2, paramInt3);
      bool = true;
    } 
    return bool;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a.setAlpha(0.0F);
    ViewPropertyAnimator viewPropertyAnimator1 = this.a.animate().alpha(1.0F);
    long l1 = paramInt2;
    ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator1.setDuration(l1);
    long l2 = paramInt1;
    viewPropertyAnimator2.setStartDelay(l2).start();
    if (this.b.getVisibility() == 0) {
      this.b.setAlpha(0.0F);
      this.b.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    } 
  }
  
  public void b(int paramInt1, int paramInt2) {
    this.a.setAlpha(1.0F);
    ViewPropertyAnimator viewPropertyAnimator1 = this.a.animate().alpha(0.0F);
    long l1 = paramInt2;
    ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator1.setDuration(l1);
    long l2 = paramInt1;
    viewPropertyAnimator2.setStartDelay(l2).start();
    if (this.b.getVisibility() == 0) {
      this.b.setAlpha(1.0F);
      this.b.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    } 
  }
  
  public Button getActionView() { return this.b; }
  
  public TextView getMessageView() { return this.a; }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.a = (TextView)findViewById(a.f.snackbar_text);
    this.b = (Button)findViewById(a.f.snackbar_action);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool;
    super.onMeasure(paramInt1, paramInt2);
    if (this.c > 0) {
      int m = getMeasuredWidth();
      int n = this.c;
      if (m > n) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
        super.onMeasure(paramInt1, paramInt2);
      } 
    } 
    int i = getResources().getDimensionPixelSize(a.d.design_snackbar_padding_vertical_2lines);
    int j = getResources().getDimensionPixelSize(a.d.design_snackbar_padding_vertical);
    int k = this.a.getLayout().getLineCount();
    byte b1 = 1;
    if (k > b1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && this.d > 0 && this.b.getMeasuredWidth() > this.d) {
      if (a(b1, i, i - j)) {
        if (b1 != 0)
          super.onMeasure(paramInt1, paramInt2); 
        return;
      } 
    } else {
      if (!bool)
        i = j; 
      if (a(0, i, i)) {
        if (b1 != 0)
          super.onMeasure(paramInt1, paramInt2); 
        return;
      } 
    } 
    b1 = 0;
    if (b1 != 0)
      super.onMeasure(paramInt1, paramInt2); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\SnackbarContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */