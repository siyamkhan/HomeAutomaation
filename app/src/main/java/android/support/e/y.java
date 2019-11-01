package android.support.e;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class y {
  private static LayoutTransition a;
  
  private static Field b;
  
  private static boolean c;
  
  private static Method d;
  
  private static boolean e;
  
  private static void a(LayoutTransition paramLayoutTransition) {
    if (!e) {
      try {
        d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
        d.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
      } 
      e = true;
    } 
    Method method = d;
    if (method != null) {
      String str2;
      String str1;
      try {
        method.invoke(paramLayoutTransition, new Object[0]);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        str1 = "ViewGroupUtilsApi14";
        str2 = "Failed to access cancel method by reflection";
      } catch (InvocationTargetException invocationTargetException) {
        str1 = "ViewGroupUtilsApi14";
        str2 = "Failed to invoke cancel method by reflection";
      } 
      Log.i(str1, str2);
    } 
  }
  
  static void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    LayoutTransition layoutTransition;
    if (a == null) {
      a = new LayoutTransition() {
          public boolean isChangingLayout() { return true; }
        };
      a.setAnimator(2, null);
      a.setAnimator(0, null);
      a.setAnimator(1, null);
      a.setAnimator(3, null);
      a.setAnimator(4, null);
    } 
    if (paramBoolean) {
      LayoutTransition layoutTransition1 = paramViewGroup.getLayoutTransition();
      if (layoutTransition1 != null) {
        if (layoutTransition1.isRunning())
          a(layoutTransition1); 
        if (layoutTransition1 != a)
          paramViewGroup.setTag(j.a.transition_layout_save, layoutTransition1); 
      } 
      layoutTransition = a;
    } else {
      paramViewGroup.setLayoutTransition(null);
      if (!c) {
        try {
          b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
          b.setAccessible(true);
        } catch (NoSuchFieldException noSuchFieldException) {
          Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
        } 
        c = true;
      } 
      Field field = b;
      boolean bool = false;
      if (field != null)
        try {
          boolean bool1 = field.getBoolean(paramViewGroup);
          if (bool1)
            try {
              b.setBoolean(paramViewGroup, false);
            } catch (IllegalAccessException illegalAccessException) {
              bool = bool1;
            }  
          bool = bool1;
        } catch (IllegalAccessException illegalAccessException) {
          Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
        }  
      if (bool)
        paramViewGroup.requestLayout(); 
      layoutTransition = (LayoutTransition)paramViewGroup.getTag(j.a.transition_layout_save);
      if (layoutTransition != null) {
        paramViewGroup.setTag(j.a.transition_layout_save, null);
      } else {
        return;
      } 
    } 
    paramViewGroup.setLayoutTransition(layoutTransition);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */