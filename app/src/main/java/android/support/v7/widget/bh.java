package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.a;
import android.util.TypedValue;

class bh {
  static final int[] a;
  
  static final int[] b;
  
  static final int[] c;
  
  static final int[] d;
  
  static final int[] e;
  
  static final int[] f;
  
  static final int[] g;
  
  static final int[] h;
  
  private static final ThreadLocal<TypedValue> i = new ThreadLocal();
  
  private static final int[] j;
  
  static  {
    a = new int[] { -16842910 };
    b = new int[] { 16842908 };
    c = new int[] { 16843518 };
    d = new int[] { 16842919 };
    e = new int[] { 16842912 };
    f = new int[] { 16842913 };
    g = new int[] { -16842919, -16842908 };
    h = new int[0];
    j = new int[1];
  }
  
  public static int a(Context paramContext, int paramInt) {
    int[] arrayOfInt = j;
    arrayOfInt[0] = paramInt;
    bm = bm.a(paramContext, null, arrayOfInt);
    try {
      return bm.b(0, 0);
    } finally {
      bm.a();
    } 
  }
  
  static int a(Context paramContext, int paramInt, float paramFloat) {
    int k = a(paramContext, paramInt);
    return a.b(k, Math.round(paramFloat * Color.alpha(k)));
  }
  
  private static TypedValue a() {
    TypedValue typedValue = (TypedValue)i.get();
    if (typedValue == null) {
      typedValue = new TypedValue();
      i.set(typedValue);
    } 
    return typedValue;
  }
  
  public static ColorStateList b(Context paramContext, int paramInt) {
    int[] arrayOfInt = j;
    arrayOfInt[0] = paramInt;
    bm = bm.a(paramContext, null, arrayOfInt);
    try {
      return bm.e(0);
    } finally {
      bm.a();
    } 
  }
  
  public static int c(Context paramContext, int paramInt) {
    ColorStateList colorStateList = b(paramContext, paramInt);
    if (colorStateList != null && colorStateList.isStateful())
      return colorStateList.getColorForState(a, colorStateList.getDefaultColor()); 
    TypedValue typedValue = a();
    paramContext.getTheme().resolveAttribute(16842803, typedValue, true);
    return a(paramContext, paramInt, typedValue.getFloat());
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */