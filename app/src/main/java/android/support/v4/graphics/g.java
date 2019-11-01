package android.support.v4.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class g extends f {
  protected Typeface a(Object paramObject) {
    try {
      Object object = Array.newInstance(this.a, 1);
      Array.set(object, 0, paramObject);
      Method method = this.g;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = object;
      arrayOfObject[1] = "sans-serif";
      arrayOfObject[2] = Integer.valueOf(-1);
      arrayOfObject[3] = Integer.valueOf(-1);
      return (Typeface)method.invoke(null, arrayOfObject);
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  protected Method f(Class paramClass) {
    Object object = Array.newInstance(paramClass, 1);
    Class[] arrayOfClass = new Class[4];
    arrayOfClass[0] = object.getClass();
    arrayOfClass[1] = String.class;
    arrayOfClass[2] = int.class;
    arrayOfClass[3] = int.class;
    Method method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arrayOfClass);
    method.setAccessible(true);
    return method;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */