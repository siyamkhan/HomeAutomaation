package android.support.e;

import android.os.Build;
import android.view.ViewGroup;

class x {
  static w a(ViewGroup paramViewGroup) { return (Build.VERSION.SDK_INT >= 18) ? new v(paramViewGroup) : u.a(paramViewGroup); }
  
  static void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 18) {
      z.a(paramViewGroup, paramBoolean);
      return;
    } 
    y.a(paramViewGroup, paramBoolean);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */