package android.support.v4.h;

import android.os.Build;
import android.support.a.a;
import android.view.ViewGroup;

public final class t {
  public static boolean a(ViewGroup paramViewGroup) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramViewGroup.isTransitionGroup(); 
    Boolean bool = (Boolean)paramViewGroup.getTag(a.b.tag_transition_group);
    return ((bool != null && bool.booleanValue()) || paramViewGroup.getBackground() != null || r.n(paramViewGroup) != null);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */