package android.support.v4.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class a {
  public static int a(AccessibilityEvent paramAccessibilityEvent) { return (Build.VERSION.SDK_INT >= 19) ? paramAccessibilityEvent.getContentChangeTypes() : 0; }
  
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt) {
    if (Build.VERSION.SDK_INT >= 19)
      paramAccessibilityEvent.setContentChangeTypes(paramInt); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */