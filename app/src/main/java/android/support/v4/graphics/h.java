package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.a.a.c;
import android.support.v4.e.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.jd.gui.api.API;

class h {
  private c.c a(c.b paramb, int paramInt) { return (c.c)a(paramb.a(), paramInt, new a<c.c>(this) {
          public int a(c.c param1c) { return param1c.b(); }
          
          public boolean b(c.c param1c) { return param1c.c(); }
        }); }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, a<T> parama) {
    T t;
    boolean bool;
    int i;
    if ((paramInt & true) == 0) {
      i = 400;
    } else {
      i = 700;
    } 
    if ((paramInt & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    int j = paramArrayOfT.length;
    Object object = null;
    byte b = 0;
    int k = Integer.MAX_VALUE;
    while (b < j) {
      int n;
      T t1 = paramArrayOfT[b];
      int m = 2 * Math.abs(parama.b(t1) - i);
      if (parama.a(t1) == bool) {
        n = 0;
      } else {
        n = 1;
      } 
      int i1 = m + n;
      if (object == null || k > i1) {
        t = t1;
        k = i1;
      } 
      b++;
    } 
    return t;
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    file = i.a(paramContext);
    if (file == null)
      return null; 
    try {
      boolean bool = i.a(file, paramResources, paramInt1);
      if (!bool)
        return null; 
      return Typeface.createFromFile(file.getPath());
    } catch (RuntimeException runtimeException) {
      return null;
    } finally {
      file.delete();
    } 
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.b[] paramArrayOfb, int paramInt) {
    int i = paramArrayOfb.length;
    InputStream inputStream = null;
    if (i < 1)
      return null; 
    b.b b1 = a(paramArrayOfb, paramInt);
    try {
      API aPI;
      closeable = paramContext.getContentResolver().openInputStream(b1.a());
      try {
        return typeface;
      } catch (IOException iOException) {
      
      } finally {
        aPI = null;
      } 
      i.a(inputStream);
      throw aPI;
    } catch (IOException iOException) {
    
    } finally {
      i.a(inputStream);
    } 
    i.a(closeable);
    return null;
  }
  
  public Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt) {
    c.c c = a(paramb, paramInt);
    return (c == null) ? null : c.a(paramContext, paramResources, c.f(), c.a(), paramInt);
  }
  
  protected Typeface a(Context paramContext, InputStream paramInputStream) {
    file = i.a(paramContext);
    if (file == null)
      return null; 
    try {
      boolean bool = i.a(file, paramInputStream);
      if (!bool)
        return null; 
      return Typeface.createFromFile(file.getPath());
    } catch (RuntimeException runtimeException) {
      return null;
    } finally {
      file.delete();
    } 
  }
  
  protected b.b a(b.b[] paramArrayOfb, int paramInt) { return (b.b)a(paramArrayOfb, paramInt, new a<b.b>(this) {
          public int a(b.b param1b) { return param1b.c(); }
          
          public boolean b(b.b param1b) { return param1b.d(); }
        }); }
  
  private static interface a<T> {
    boolean a(T param1T);
    
    int b(T param1T);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */