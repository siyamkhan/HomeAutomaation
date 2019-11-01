package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

public final class g {
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return;
    } 
    paramEdgeEffect.onPull(paramFloat1);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */