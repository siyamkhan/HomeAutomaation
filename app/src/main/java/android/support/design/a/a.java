package android.support.design.a;

import android.animation.TimeInterpolator;
import android.support.v4.h.b.a;
import android.support.v4.h.b.b;
import android.support.v4.h.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class a {
  public static final TimeInterpolator a = new LinearInterpolator();
  
  public static final TimeInterpolator b = new b();
  
  public static final TimeInterpolator c = new a();
  
  public static final TimeInterpolator d = new c();
  
  public static final TimeInterpolator e = new DecelerateInterpolator();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3) { return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */