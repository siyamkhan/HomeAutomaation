package android.support.design.widget;

public final class k {
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3) { return paramFloat1 * (1.0F - paramFloat3) + paramFloat3 * paramFloat2; }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    return (float)Math.hypot(f1, f2);
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) { return b(a(paramFloat1, paramFloat2, paramFloat3, paramFloat4), a(paramFloat1, paramFloat2, paramFloat5, paramFloat4), a(paramFloat1, paramFloat2, paramFloat5, paramFloat6), a(paramFloat1, paramFloat2, paramFloat3, paramFloat6)); }
  
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return (paramFloat1 > paramFloat2 && paramFloat1 > paramFloat3 && paramFloat1 > paramFloat4) ? paramFloat1 : ((paramFloat2 > paramFloat3 && paramFloat2 > paramFloat4) ? paramFloat2 : ((paramFloat3 > paramFloat4) ? paramFloat3 : paramFloat4)); }
  
  public static boolean b(float paramFloat1, float paramFloat2, float paramFloat3) { return (paramFloat1 + paramFloat3 >= paramFloat2); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */