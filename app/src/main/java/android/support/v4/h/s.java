package android.support.v4.h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class s {
  private static Method a;
  
  static  {
    if (Build.VERSION.SDK_INT == 25)
      try {
        a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
        return;
      } catch (Exception exception) {
        Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
      }  
  }
  
  public static float a(ViewConfiguration paramViewConfiguration, Context paramContext) { return (Build.VERSION.SDK_INT >= 26) ? paramViewConfiguration.getScaledHorizontalScrollFactor() : d(paramViewConfiguration, paramContext); }
  
  public static int a(ViewConfiguration paramViewConfiguration) { return (Build.VERSION.SDK_INT >= 28) ? paramViewConfiguration.getScaledHoverSlop() : (paramViewConfiguration.getScaledTouchSlop() / 2); }
  
  public static float b(ViewConfiguration paramViewConfiguration, Context paramContext) { return (Build.VERSION.SDK_INT >= 26) ? paramViewConfiguration.getScaledVerticalScrollFactor() : d(paramViewConfiguration, paramContext); }
  
  public static boolean c(ViewConfiguration paramViewConfiguration, Context paramContext) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent(); 
    Resources resources = paramContext.getResources();
    int i = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    return (i != 0 && resources.getBoolean(i));
  }
  
  private static float d(ViewConfiguration paramViewConfiguration, Context paramContext) {
    if (Build.VERSION.SDK_INT >= 25) {
      Method method = a;
      if (method != null)
        try {
          int i = ((Integer)method.invoke(paramViewConfiguration, new Object[0])).intValue();
          return i;
        } catch (Exception exception) {
          Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
        }  
    } 
    TypedValue typedValue = new TypedValue();
    return paramContext.getTheme().resolveAttribute(16842829, typedValue, true) ? typedValue.getDimension(paramContext.getResources().getDisplayMetrics()) : 0.0F;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */