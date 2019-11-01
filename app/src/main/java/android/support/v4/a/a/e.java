package android.support.v4.a.a;

import java.lang.reflect.Array;

final class e {
  public static int a(int paramInt) { return (paramInt <= 4) ? 8 : (paramInt * 2); }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
    if (a || paramInt1 <= paramArrayOfInt.length) {
      if (paramInt1 + 1 > paramArrayOfInt.length) {
        int[] arrayOfInt = new int[a(paramInt1)];
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
        paramArrayOfInt = arrayOfInt;
      } 
      paramArrayOfInt[paramInt1] = paramInt2;
      return paramArrayOfInt;
    } 
    throw new AssertionError();
  }
  
  public static <T> T[] a(T[] paramArrayOfT, int paramInt, T paramT) {
    if (a || paramInt <= paramArrayOfT.length) {
      if (paramInt + 1 > paramArrayOfT.length) {
        Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), a(paramInt));
        System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramInt);
        paramArrayOfT = (T[])arrayOfObject;
      } 
      paramArrayOfT[paramInt] = paramT;
      return paramArrayOfT;
    } 
    throw new AssertionError();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */