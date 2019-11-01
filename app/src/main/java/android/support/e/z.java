package android.support.e;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class z {
  private static Method a;
  
  private static boolean b;
  
  private static void a() {
    if (!b) {
      try {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = boolean.class;
        a = ViewGroup.class.getDeclaredMethod("suppressLayout", arrayOfClass);
        a.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", noSuchMethodException);
      } 
      b = true;
    } 
  }
  
  static void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    a();
    Method method = a;
    if (method != null) {
      String str2;
      String str1;
      try {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(paramBoolean);
        method.invoke(paramViewGroup, arrayOfObject);
        return;
      } catch (IllegalAccessException null) {
        str1 = "ViewUtilsApi18";
        str2 = "Failed to invoke suppressLayout method";
      } catch (InvocationTargetException invocationTargetException) {
        str1 = "ViewUtilsApi18";
        str2 = "Error invoking suppressLayout method";
      } 
      Log.i(str1, str2, invocationTargetException);
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */