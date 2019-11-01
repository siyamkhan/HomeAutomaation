package android.support.v4.g;

class c {
  static final int[] a = new int[0];
  
  static final long[] b = new long[0];
  
  static final Object[] c = new Object[0];
  
  public static int a(int paramInt) { return c(paramInt * 4) / 4; }
  
  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
    int i = paramInt1 - 1;
    int j = 0;
    while (j <= i) {
      int k = j + i >>> 1;
      int m = paramArrayOfInt[k];
      if (m < paramInt2) {
        j = k + 1;
        continue;
      } 
      if (m > paramInt2) {
        i = k - 1;
        continue;
      } 
      return k;
    } 
    return j ^ 0xFFFFFFFF;
  }
  
  static int a(long[] paramArrayOfLong, int paramInt, long paramLong) {
    int i = paramInt - 1;
    int j = 0;
    while (j <= i) {
      int k = j + i >>> 1;
      long l = paramArrayOfLong[k];
      if (l < paramLong) {
        j = k + 1;
        continue;
      } 
      if (l > paramLong) {
        i = k - 1;
        continue;
      } 
      return k;
    } 
    return j ^ 0xFFFFFFFF;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) { return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2))); }
  
  public static int b(int paramInt) { return c(paramInt * 8) / 8; }
  
  public static int c(int paramInt) {
    for (byte b1 = 4; b1 < 32; b1++) {
      byte b2 = -12 + (1 << b1);
      if (paramInt <= b2)
        return b2; 
    } 
    return paramInt;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */