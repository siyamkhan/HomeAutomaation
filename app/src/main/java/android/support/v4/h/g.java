package android.support.v4.h;

import android.os.Build;
import android.view.ViewGroup;

public final class g {
  public static int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams) { return (Build.VERSION.SDK_INT >= 17) ? paramMarginLayoutParams.getMarginStart() : paramMarginLayoutParams.leftMargin; }
  
  public static int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams) { return (Build.VERSION.SDK_INT >= 17) ? paramMarginLayoutParams.getMarginEnd() : paramMarginLayoutParams.rightMargin; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */