package android.support.v7.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a;
import android.support.v4.a.a.a;
import android.support.v7.widget.l;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class a {
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  
  private static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap(0);
  
  private static final Object c = new Object();
  
  public static ColorStateList a(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getColorStateList(paramInt); 
    ColorStateList colorStateList1 = d(paramContext, paramInt);
    if (colorStateList1 != null)
      return colorStateList1; 
    ColorStateList colorStateList2 = c(paramContext, paramInt);
    if (colorStateList2 != null) {
      a(paramContext, paramInt, colorStateList2);
      return colorStateList2;
    } 
    return a.b(paramContext, paramInt);
  }
  
  private static TypedValue a() {
    TypedValue typedValue = (TypedValue)a.get();
    if (typedValue == null) {
      typedValue = new TypedValue();
      a.set(typedValue);
    } 
    return typedValue;
  }
  
  private static void a(Context paramContext, int paramInt, ColorStateList paramColorStateList) {
    synchronized (c) {
      SparseArray sparseArray = (SparseArray)b.get(paramContext);
      if (sparseArray == null) {
        sparseArray = new SparseArray();
        b.put(paramContext, sparseArray);
      } 
      sparseArray.append(paramInt, new a(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    } 
  }
  
  public static Drawable b(Context paramContext, int paramInt) { return l.a().a(paramContext, paramInt); }
  
  private static ColorStateList c(Context paramContext, int paramInt) {
    if (e(paramContext, paramInt))
      return null; 
    Resources resources = paramContext.getResources();
    XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
    try {
      return a.a(resources, xmlResourceParser, paramContext.getTheme());
    } catch (Exception exception) {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", exception);
      return null;
    } 
  }
  
  private static ColorStateList d(Context paramContext, int paramInt) {
    synchronized (c) {
      SparseArray sparseArray = (SparseArray)b.get(paramContext);
      if (sparseArray != null && sparseArray.size() > 0) {
        a a1 = (a)sparseArray.get(paramInt);
        if (a1 != null) {
          if (a1.b.equals(paramContext.getResources().getConfiguration()))
            return a1.a; 
          sparseArray.remove(paramInt);
        } 
      } 
      return null;
    } 
  }
  
  private static boolean e(Context paramContext, int paramInt) {
    Resources resources = paramContext.getResources();
    TypedValue typedValue = a();
    resources.getValue(paramInt, typedValue, true);
    return (typedValue.type >= 28 && typedValue.type <= 31);
  }
  
  private static class a {
    final ColorStateList a;
    
    final Configuration b;
    
    a(ColorStateList param1ColorStateList, Configuration param1Configuration) {
      this.a = param1ColorStateList;
      this.b = param1Configuration;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */