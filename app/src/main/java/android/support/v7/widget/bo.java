package android.support.v7.widget;

import android.os.Build;
import android.view.View;

public class bo {
  public static void a(View paramView, CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setTooltipText(paramCharSequence);
      return;
    } 
    bp.a(paramView, paramCharSequence);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */