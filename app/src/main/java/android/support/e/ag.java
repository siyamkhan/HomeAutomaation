package android.support.e;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ag extends af {
  private static Method a;
  
  private static boolean b;
  
  @SuppressLint({"PrivateApi"})
  private void a() {
    if (!b) {
      try {
        Class[] arrayOfClass = new Class[4];
        arrayOfClass[0] = int.class;
        arrayOfClass[1] = int.class;
        arrayOfClass[2] = int.class;
        arrayOfClass[3] = int.class;
        a = View.class.getDeclaredMethod("setLeftTopRightBottom", arrayOfClass);
        a.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", noSuchMethodException);
      } 
      b = true;
    } 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a();
    Method method = a;
    if (method != null)
      try {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        arrayOfObject[2] = Integer.valueOf(paramInt3);
        arrayOfObject[3] = Integer.valueOf(paramInt4);
        method.invoke(paramView, arrayOfObject);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        return;
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      }  
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */