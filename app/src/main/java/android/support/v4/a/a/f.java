package android.support.v4.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.graphics.c;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class f {
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, a parama) { return paramContext.isRestricted() ? null : a(paramContext, paramInt1, paramTypedValue, paramInt2, parama, null, true); }
  
  private static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, a parama, Handler paramHandler, boolean paramBoolean) {
    Resources resources = paramContext.getResources();
    resources.getValue(paramInt1, paramTypedValue, true);
    Typeface typeface = a(paramContext, resources, paramTypedValue, paramInt1, paramInt2, parama, paramHandler, paramBoolean);
    if (typeface == null) {
      if (parama != null)
        return typeface; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Font resource ID #0x");
      stringBuilder.append(Integer.toHexString(paramInt1));
      stringBuilder.append(" could not be retrieved.");
      throw new Resources.NotFoundException(stringBuilder.toString());
    } 
    return typeface;
  }
  
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, a parama, Handler paramHandler, boolean paramBoolean) {
    if (paramTypedValue.string != null) {
      String str = paramTypedValue.string.toString();
      if (!str.startsWith("res/")) {
        if (parama != null)
          parama.a(-3, paramHandler); 
        return null;
      } 
      Typeface typeface = c.a(paramResources, paramInt1, paramInt2);
      if (typeface != null) {
        if (parama != null)
          parama.a(typeface, paramHandler); 
        return typeface;
      } 
      try {
        if (str.toLowerCase().endsWith(".xml")) {
          c.a a1 = c.a(paramResources.getXml(paramInt1), paramResources);
          if (a1 == null) {
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (parama != null) {
              parama.a(-3, paramHandler);
              return null;
            } 
          } else {
            return c.a(paramContext, a1, paramResources, paramInt1, paramInt2, parama, paramHandler, paramBoolean);
          } 
        } else {
          Typeface typeface1 = c.a(paramContext, paramResources, paramInt1, str, paramInt2);
          if (parama != null) {
            if (typeface1 != null) {
              parama.a(typeface1, paramHandler);
              return typeface1;
            } 
            parama.a(-3, paramHandler);
          } 
          return typeface1;
        } 
      } catch (XmlPullParserException xmlPullParserException) {
        String str1 = "ResourcesCompat";
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Failed to parse xml resource ";
        stringBuilder.append(str2);
        stringBuilder.append(str);
        Log.e(str1, stringBuilder.toString(), xmlPullParserException);
        if (parama != null)
          parama.a(-3, paramHandler); 
        return null;
      } catch (IOException iOException) {
        String str1 = "ResourcesCompat";
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Failed to read xml resource ";
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Resource \"");
      stringBuilder.append(paramResources.getResourceName(paramInt1));
      stringBuilder.append("\" (");
      stringBuilder.append(Integer.toHexString(paramInt1));
      stringBuilder.append(") is not a Font: ");
      stringBuilder.append(paramTypedValue);
      throw new Resources.NotFoundException(stringBuilder.toString());
    } 
    return null;
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Resources.Theme paramTheme) { return (Build.VERSION.SDK_INT >= 21) ? paramResources.getDrawable(paramInt, paramTheme) : paramResources.getDrawable(paramInt); }
  
  public static abstract class a {
    public abstract void a(int param1Int);
    
    public final void a(int param1Int, Handler param1Handler) {
      if (param1Handler == null)
        param1Handler = new Handler(Looper.getMainLooper()); 
      param1Handler.post(new Runnable(this, param1Int) {
            public void run() { this.b.a(this.a); }
          });
    }
    
    public abstract void a(Typeface param1Typeface);
    
    public final void a(Typeface param1Typeface, Handler param1Handler) {
      if (param1Handler == null)
        param1Handler = new Handler(Looper.getMainLooper()); 
      param1Handler.post(new Runnable(this, param1Typeface) {
            public void run() { this.b.a(this.a); }
          });
    }
  }
  
  class null implements Runnable {
    null(f this$0, Typeface param1Typeface) {}
    
    public void run() { this.b.a(this.a); }
  }
  
  class null implements Runnable {
    null(f this$0, int param1Int) {}
    
    public void run() { this.b.a(this.a); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */