package android.support.v4.g;

public class k {
  public static int a(int paramInt) {
    if (paramInt >= 0)
      return paramInt; 
    throw new IllegalArgumentException();
  }
  
  public static <T> T a(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  public static <T> T a(T paramT, Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */