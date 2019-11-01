package android.support.design.widget;

import android.content.Context;
import android.support.design.a;
import android.util.AttributeSet;
import android.view.View;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
  private static final int[] d;
  
  static  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = a.b.snackbarButtonStyle;
    d = arrayOfInt;
  }
  
  public static final class SnackbarLayout extends BaseTransientBottomBar.e {
    public SnackbarLayout(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, param1Int2);
      int i = getChildCount();
      int j = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
      for (byte b = 0; b < i; b++) {
        View view = getChildAt(b);
        if ((view.getLayoutParams()).width == -1)
          view.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824)); 
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */