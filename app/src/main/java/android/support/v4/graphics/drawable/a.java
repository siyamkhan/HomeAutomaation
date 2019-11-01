package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
  private static Method a;
  
  private static boolean b;
  
  private static Method c;
  
  private static boolean d;
  
  @Deprecated
  public static void a(Drawable paramDrawable) { paramDrawable.jumpToCurrentState(); }
  
  public static void a(Drawable paramDrawable, float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setHotspot(paramFloat1, paramFloat2); 
  }
  
  public static void a(Drawable paramDrawable, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTint(paramInt);
      return;
    } 
    if (paramDrawable instanceof b)
      ((b)paramDrawable).setTint(paramInt); 
  }
  
  public static void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintList(paramColorStateList);
      return;
    } 
    if (paramDrawable instanceof b)
      ((b)paramDrawable).setTintList(paramColorStateList); 
  }
  
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.applyTheme(paramTheme); 
  }
  
  public static void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintMode(paramMode);
      return;
    } 
    if (paramDrawable instanceof b)
      ((b)paramDrawable).setTintMode(paramMode); 
  }
  
  public static void a(Drawable paramDrawable, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      paramDrawable.setAutoMirrored(paramBoolean); 
  }
  
  public static boolean b(Drawable paramDrawable) { return (Build.VERSION.SDK_INT >= 19) ? paramDrawable.isAutoMirrored() : 0; }
  
  public static boolean b(Drawable paramDrawable, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramDrawable.setLayoutDirection(paramInt); 
    if (Build.VERSION.SDK_INT >= 17) {
      if (!b) {
        try {
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = int.class;
          a = Drawable.class.getDeclaredMethod("setLayoutDirection", arrayOfClass);
          a.setAccessible(true);
        } catch (NoSuchMethodException noSuchMethodException) {
          Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", noSuchMethodException);
        } 
        b = true;
      } 
      Method method = a;
      if (method != null)
        try {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramInt);
          method.invoke(paramDrawable, arrayOfObject);
          return true;
        } catch (Exception exception) {
          Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", exception);
          a = null;
        }  
    } 
    return false;
  }
  
  public static int c(Drawable paramDrawable) { return (Build.VERSION.SDK_INT >= 19) ? paramDrawable.getAlpha() : 0; }
  
  public static boolean d(Drawable paramDrawable) { return (Build.VERSION.SDK_INT >= 21) ? paramDrawable.canApplyTheme() : 0; }
  
  public static ColorFilter e(Drawable paramDrawable) { return (Build.VERSION.SDK_INT >= 21) ? paramDrawable.getColorFilter() : null; }
  
  public static void f(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT < 23 && Build.VERSION.SDK_INT >= 21) {
      Drawable drawable;
      paramDrawable.clearColorFilter();
      if (paramDrawable instanceof InsetDrawable) {
        drawable = ((InsetDrawable)paramDrawable).getDrawable();
      } else if (paramDrawable instanceof c) {
        drawable = ((c)paramDrawable).a();
      } else {
        if (paramDrawable instanceof DrawableContainer) {
          DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
          if (drawableContainerState != null) {
            byte b1 = 0;
            int i = drawableContainerState.getChildCount();
            while (b1 < i) {
              Drawable drawable1 = drawableContainerState.getChild(b1);
              if (drawable1 != null)
                f(drawable1); 
              b1++;
            } 
          } 
        } 
        return;
      } 
      f(drawable);
      return;
    } 
    paramDrawable.clearColorFilter();
  }
  
  public static Drawable g(Drawable paramDrawable) { return (Build.VERSION.SDK_INT >= 23) ? paramDrawable : ((Build.VERSION.SDK_INT >= 21) ? (!(paramDrawable instanceof b) ? new e(paramDrawable) : paramDrawable) : (!(paramDrawable instanceof b) ? new d(paramDrawable) : paramDrawable)); }
  
  public static int h(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramDrawable.getLayoutDirection(); 
    if (Build.VERSION.SDK_INT >= 17) {
      if (!d) {
        try {
          c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
          c.setAccessible(true);
        } catch (NoSuchMethodException noSuchMethodException) {
          Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", noSuchMethodException);
        } 
        d = true;
      } 
      Method method = c;
      if (method != null)
        try {
          return ((Integer)method.invoke(paramDrawable, new Object[0])).intValue();
        } catch (Exception exception) {
          Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", exception);
          c = null;
        }  
    } 
    return 0;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\drawable\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */