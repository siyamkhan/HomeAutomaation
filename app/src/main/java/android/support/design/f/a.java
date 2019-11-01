package android.support.design.f;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.graphics.a;
import android.util.StateSet;

public class a {
  public static final boolean a;
  
  private static final int[] b;
  
  private static final int[] c;
  
  private static final int[] d;
  
  private static final int[] e;
  
  private static final int[] f;
  
  private static final int[] g;
  
  private static final int[] h;
  
  private static final int[] i;
  
  private static final int[] j;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
    b = new int[] { 16842919 };
    c = new int[] { 16843623, 16842908 };
    d = new int[] { 16842908 };
    e = new int[] { 16843623 };
    f = new int[] { 16842913, 16842919 };
    g = new int[] { 16842913, 16843623, 16842908 };
    h = new int[] { 16842913, 16842908 };
    i = new int[] { 16842913, 16843623 };
    j = new int[] { 16842913 };
  }
  
  @TargetApi(21)
  private static int a(int paramInt) { return a.b(paramInt, Math.min(2 * Color.alpha(paramInt), 255)); }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt) {
    int k;
    if (paramColorStateList != null) {
      k = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      k = 0;
    } 
    if (a)
      k = a(k); 
    return k;
  }
  
  public static ColorStateList a(ColorStateList paramColorStateList) {
    if (a) {
      int[][] arrayOfInt10 = new int[2][];
      int[] arrayOfInt11 = new int[2];
      arrayOfInt10[0] = j;
      arrayOfInt11[0] = a(paramColorStateList, f);
      arrayOfInt10[1] = StateSet.NOTHING;
      arrayOfInt11[1] = a(paramColorStateList, b);
      return new ColorStateList(arrayOfInt10, arrayOfInt11);
    } 
    int[][] arrayOfInt = new int[10][];
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = f;
    arrayOfInt[0] = arrayOfInt2;
    arrayOfInt1[0] = a(paramColorStateList, arrayOfInt2);
    int[] arrayOfInt3 = g;
    arrayOfInt[1] = arrayOfInt3;
    arrayOfInt1[1] = a(paramColorStateList, arrayOfInt3);
    int[] arrayOfInt4 = h;
    arrayOfInt[2] = arrayOfInt4;
    arrayOfInt1[2] = a(paramColorStateList, arrayOfInt4);
    int[] arrayOfInt5 = i;
    arrayOfInt[3] = arrayOfInt5;
    arrayOfInt1[3] = a(paramColorStateList, arrayOfInt5);
    arrayOfInt[4] = j;
    arrayOfInt1[4] = 0;
    int[] arrayOfInt6 = b;
    arrayOfInt[5] = arrayOfInt6;
    arrayOfInt1[5] = a(paramColorStateList, arrayOfInt6);
    int[] arrayOfInt7 = c;
    arrayOfInt[6] = arrayOfInt7;
    arrayOfInt1[6] = a(paramColorStateList, arrayOfInt7);
    int[] arrayOfInt8 = d;
    arrayOfInt[7] = arrayOfInt8;
    arrayOfInt1[7] = a(paramColorStateList, arrayOfInt8);
    int[] arrayOfInt9 = e;
    arrayOfInt[8] = arrayOfInt9;
    arrayOfInt1[8] = a(paramColorStateList, arrayOfInt9);
    arrayOfInt[9] = StateSet.NOTHING;
    arrayOfInt1[9] = 0;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */