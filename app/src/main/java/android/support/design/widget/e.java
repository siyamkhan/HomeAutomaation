package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

public class e {
  private static Method a;
  
  private static boolean b;
  
  public static boolean a(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState) { return b(paramDrawableContainer, paramConstantState); }
  
  private static boolean b(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState) {
    if (!b) {
      try {
        a = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
        a.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
      } 
      b = true;
    } 
    Method method = a;
    if (method != null)
      try {
        method.invoke(paramDrawableContainer, new Object[] { paramConstantState });
        return true;
      } catch (Exception exception) {
        Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
      }  
    return false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */