package android.support.e;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ae extends ah {
  private static Method a;
  
  private static boolean b;
  
  private static Method c;
  
  private static boolean d;
  
  private void a() {
    if (!b) {
      try {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = float.class;
        a = View.class.getDeclaredMethod("setTransitionAlpha", arrayOfClass);
        a.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", noSuchMethodException);
      } 
      b = true;
    } 
  }
  
  private void b() {
    if (!d) {
      try {
        c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
        c.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", noSuchMethodException);
      } 
      d = true;
    } 
  }
  
  public float a(View paramView) {
    b();
    Method method = c;
    if (method != null)
      try {
        return ((Float)method.invoke(paramView, new Object[0])).floatValue();
      } catch (IllegalAccessException illegalAccessException) {
        return super.a(paramView);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      }  
    return super.a(paramView);
  }
  
  public void a(View paramView, float paramFloat) {
    a();
    Method method = a;
    if (method != null) {
      try {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(paramFloat);
        method.invoke(paramView, arrayOfObject);
        return;
      } catch (IllegalAccessException illegalAccessException) {
      
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    } else {
      paramView.setAlpha(paramFloat);
    } 
  }
  
  public void b(View paramView) {}
  
  public void c(View paramView) {}
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */