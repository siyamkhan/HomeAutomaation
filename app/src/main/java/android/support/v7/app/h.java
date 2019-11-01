package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class h {
  private static Field a;
  
  private static boolean b;
  
  private static Class c;
  
  private static boolean d;
  
  private static Field e;
  
  private static boolean f;
  
  private static Field g;
  
  private static boolean h;
  
  static void a(Resources paramResources) {
    if (Build.VERSION.SDK_INT >= 28)
      return; 
    if (Build.VERSION.SDK_INT >= 24) {
      d(paramResources);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      c(paramResources);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21)
      b(paramResources); 
  }
  
  private static void a(Object paramObject) {
    Object object;
    if (!d) {
      try {
        c = Class.forName("android.content.res.ThemedResourceCache");
      } catch (ClassNotFoundException classNotFoundException) {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", classNotFoundException);
      } 
      d = true;
    } 
    Class clazz = c;
    if (clazz == null)
      return; 
    if (!f) {
      try {
        e = clazz.getDeclaredField("mUnthemedEntries");
        e.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", noSuchFieldException);
      } 
      f = true;
    } 
    Field field = e;
    if (field == null)
      return; 
    try {
      object = (LongSparseArray)field.get(paramObject);
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", illegalAccessException);
      object = null;
    } 
    if (object != null)
      object.clear(); 
  }
  
  private static void b(Resources paramResources) {
    if (!b) {
      try {
        a = Resources.class.getDeclaredField("mDrawableCache");
        a.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", noSuchFieldException);
      } 
      b = true;
    } 
    Field field = a;
    if (field != null) {
      Object object;
      try {
        object = (Map)field.get(paramResources);
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", illegalAccessException);
        object = null;
      } 
      if (object != null)
        object.clear(); 
    } 
  }
  
  private static void c(Resources paramResources) {
    if (!b) {
      try {
        a = Resources.class.getDeclaredField("mDrawableCache");
        a.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", noSuchFieldException);
      } 
      b = true;
    } 
    Field field = a;
    Object object = null;
    if (field != null)
      try {
        object = field.get(paramResources);
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", illegalAccessException);
      }  
    if (object == null)
      return; 
    a(object);
  }
  
  private static void d(Resources paramResources) {
    Object object;
    if (!h) {
      try {
        g = Resources.class.getDeclaredField("mResourcesImpl");
        g.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", noSuchFieldException);
      } 
      h = true;
    } 
    Field field1 = g;
    if (field1 == null)
      return; 
    try {
      object = field1.get(paramResources);
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", illegalAccessException);
      object = null;
    } 
    if (object == null)
      return; 
    if (!b) {
      try {
        a = object.getClass().getDeclaredField("mDrawableCache");
        a.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", noSuchFieldException);
      } 
      b = true;
    } 
    Field field2 = a;
    Object object1 = null;
    if (field2 != null)
      try {
        object1 = field2.get(object);
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", illegalAccessException);
      }  
    if (object1 != null)
      a(object1); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */