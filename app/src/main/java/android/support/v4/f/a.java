package android.support.v4.f;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a {
  private static Method a;
  
  private static Method b;
  
  static  {
    if (Build.VERSION.SDK_INT >= 21)
      try {
        b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
        return;
      } catch (Exception exception) {
        throw new IllegalStateException(exception);
      }  
    try {
      Class clazz = Class.forName("libcore.icu.ICU");
      if (clazz != null) {
        a = clazz.getMethod("getScript", new Class[] { String.class });
        b = clazz.getMethod("addLikelySubtags", new Class[] { String.class });
        return;
      } 
    } catch (Exception exception) {
      a = null;
      b = null;
      Log.w("ICUCompat", exception);
    } 
  }
  
  private static String a(String paramString) {
    try {
      if (a != null) {
        Object[] arrayOfObject = { paramString };
        return (String)a.invoke(null, arrayOfObject);
      } 
    } catch (IllegalAccessException illegalAccessException) {
      Log.w("ICUCompat", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {}
    return null;
  }
  
  public static String a(Locale paramLocale) {
    if (Build.VERSION.SDK_INT >= 21) {
      try {
        Object[] arrayOfObject = { paramLocale };
        return ((Locale)b.invoke(null, arrayOfObject)).getScript();
      } catch (InvocationTargetException null) {
      
      } catch (IllegalAccessException illegalAccessException) {}
      Log.w("ICUCompat", illegalAccessException);
      return paramLocale.getScript();
    } 
    String str = b(paramLocale);
    return (str != null) ? a(str) : null;
  }
  
  private static String b(Locale paramLocale) {
    String str = paramLocale.toString();
    try {
      if (b != null) {
        Object[] arrayOfObject = { str };
        return (String)b.invoke(null, arrayOfObject);
      } 
    } catch (IllegalAccessException illegalAccessException) {
      Log.w("ICUCompat", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {}
    return str;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */