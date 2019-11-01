package android.support.v4.graphics;

import android.graphics.Color;

public final class a {
  private static final ThreadLocal<double[]> a = new ThreadLocal();
  
  public static int a(int paramInt1, int paramInt2) {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = c(j, i);
    return Color.argb(k, a(Color.red(paramInt1), j, Color.red(paramInt2), i, k), a(Color.green(paramInt1), j, Color.green(paramInt2), i, k), a(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) { return (paramInt5 == 0) ? 0 : ((paramInt2 * paramInt1 * 255 + paramInt3 * paramInt4 * (255 - paramInt2)) / paramInt5 * 255); }
  
  public static int b(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0 && paramInt2 <= 255)
      return paramInt1 & 0xFFFFFF | paramInt2 << 24; 
    throw new IllegalArgumentException("alpha must be between 0 and 255.");
  }
  
  private static int c(int paramInt1, int paramInt2) { return 255 - (255 - paramInt2) * (255 - paramInt1) / 255; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */