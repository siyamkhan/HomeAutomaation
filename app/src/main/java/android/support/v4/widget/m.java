package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public class m extends View {
  @Deprecated
  public m(Context paramContext) { this(paramContext, null); }
  
  @Deprecated
  public m(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  @Deprecated
  public m(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (getVisibility() == 0)
      setVisibility(4); 
  }
  
  private static int a(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE) {
      if (i != 0)
        return (i != 1073741824) ? paramInt1 : j; 
    } else {
      paramInt1 = Math.min(paramInt1, j);
    } 
    return paramInt1;
  }
  
  @Deprecated
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  @Deprecated
  protected void onMeasure(int paramInt1, int paramInt2) { setMeasuredDimension(a(getSuggestedMinimumWidth(), paramInt1), a(getSuggestedMinimumHeight(), paramInt2)); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */