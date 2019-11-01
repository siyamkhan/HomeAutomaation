package android.support.v4.h;

import android.os.Build;
import android.view.WindowInsets;

public class z {
  private final Object a;
  
  private z(Object paramObject) { this.a = paramObject; }
  
  static z a(Object paramObject) { return (paramObject == null) ? null : new z(paramObject); }
  
  static Object a(z paramz) { return (paramz == null) ? null : paramz.a; }
  
  public int a() { return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetLeft() : 0; }
  
  public z a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return (Build.VERSION.SDK_INT >= 20) ? new z(((WindowInsets)this.a).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4)) : null; }
  
  public int b() { return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetTop() : 0; }
  
  public int c() { return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetRight() : 0; }
  
  public int d() { return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetBottom() : 0; }
  
  public boolean e() { return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).isConsumed() : 0; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      z z1 = (z)paramObject;
      Object object = this.a;
      return (object == null) ? ((z1.a == null)) : object.equals(z1.a);
    } 
    return false;
  }
  
  public int hashCode() {
    Object object = this.a;
    return (object == null) ? 0 : object.hashCode();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */