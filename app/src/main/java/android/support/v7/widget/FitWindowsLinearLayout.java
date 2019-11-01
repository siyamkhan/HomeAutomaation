package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements ao {
  private ao.a a;
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    ao.a a1 = this.a;
    if (a1 != null)
      a1.a(paramRect); 
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(ao.a parama) { this.a = parama; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\FitWindowsLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */