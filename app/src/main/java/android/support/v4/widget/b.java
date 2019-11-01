package android.support.v4.widget;

import android.os.Build;

public interface b {
  public static final boolean a;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 27) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */