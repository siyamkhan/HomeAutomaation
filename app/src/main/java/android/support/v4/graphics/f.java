package android.support.v4.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.a.a.c;
import android.support.v4.e.b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import org.jd.gui.api.API;

public class f extends d {
  protected final Class a;
  
  protected final Constructor b;
  
  protected final Method c;
  
  protected final Method d;
  
  protected final Method e;
  
  protected final Method f;
  
  protected final Method g;
  
  public f() {
    Class clazz = null;
    try {
      Class clazz1 = a();
      object2 = a(clazz1);
      object3 = b(clazz1);
      object4 = c(clazz1);
      object5 = d(clazz1);
      object6 = e(clazz1);
      Method method = f(clazz1);
      object1 = method;
      clazz = clazz1;
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to collect necessary methods for class ");
      stringBuilder.append(classNotFoundException.getClass().getName());
      Log.e("TypefaceCompatApi26Impl", stringBuilder.toString(), classNotFoundException);
      object1 = null;
      object2 = null;
      object3 = null;
      object4 = null;
      object5 = null;
      object6 = null;
    } catch (NoSuchMethodException noSuchMethodException) {}
    this.a = clazz;
    this.b = object2;
    this.c = object3;
    this.d = object4;
    this.e = object5;
    this.f = object6;
    this.g = object1;
  }
  
  private boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis) {
    try {
      Method method = this.c;
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = paramContext.getAssets();
      arrayOfObject[1] = paramString;
      arrayOfObject[2] = Integer.valueOf(0);
      arrayOfObject[3] = Boolean.valueOf(false);
      arrayOfObject[4] = Integer.valueOf(paramInt1);
      arrayOfObject[5] = Integer.valueOf(paramInt2);
      arrayOfObject[6] = Integer.valueOf(paramInt3);
      arrayOfObject[7] = paramArrayOfFontVariationAxis;
      return ((Boolean)method.invoke(paramObject, arrayOfObject)).booleanValue();
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  private boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
    try {
      Method method = this.d;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramByteBuffer;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = null;
      arrayOfObject[3] = Integer.valueOf(paramInt2);
      arrayOfObject[4] = Integer.valueOf(paramInt3);
      return ((Boolean)method.invoke(paramObject, arrayOfObject)).booleanValue();
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  private boolean b() {
    if (this.c == null)
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation."); 
    return (this.c != null);
  }
  
  private boolean b(Object paramObject) {
    try {
      return ((Boolean)this.e.invoke(paramObject, new Object[0])).booleanValue();
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  private Object c() {
    try {
      return this.b.newInstance(new Object[0]);
    } catch (IllegalAccessException null) {
    
    } catch (InstantiationException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  private void c(Object paramObject) {
    try {
      this.f.invoke(paramObject, new Object[0]);
      return;
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    if (!b())
      return super.a(paramContext, paramResources, paramInt1, paramString, paramInt2); 
    Object object = c();
    if (!a(paramContext, object, paramString, 0, -1, -1, null)) {
      c(object);
      return null;
    } 
    return !b(object) ? null : a(object);
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.b[] paramArrayOfb, int paramInt) {
    if (paramArrayOfb.length < 1)
      return null; 
    if (!b()) {
      b.b b2 = a(paramArrayOfb, paramInt);
      ContentResolver contentResolver = paramContext.getContentResolver();
      try {
        API aPI;
        Object object1;
        parcelFileDescriptor = contentResolver.openFileDescriptor(b2.a(), "r", paramCancellationSignal);
        if (parcelFileDescriptor == null) {
          if (parcelFileDescriptor != null)
            parcelFileDescriptor.close(); 
          return null;
        } 
        try {
          return (new Typeface.Builder(parcelFileDescriptor.getFileDescriptor())).setWeight(b2.c()).setItalic(b2.d()).build();
        } catch (Throwable throwable) {
          try {
            throw throwable;
          } finally {
            API aPI1 = null;
            object1 = throwable;
          } 
        } finally {
          aPI = null;
        } 
        if (parcelFileDescriptor != null)
          if (object1 != null) {
            try {
              parcelFileDescriptor.close();
            } catch (Throwable throwable) {
              object1.addSuppressed(throwable);
            } 
          } else {
            parcelFileDescriptor.close();
          }  
        throw aPI;
      } catch (IOException iOException) {
        return null;
      } 
    } 
    Map map = b.a(paramContext, paramArrayOfb, paramCancellationSignal);
    Object object = c();
    int i = paramArrayOfb.length;
    boolean bool = false;
    for (byte b1 = 0; b1 < i; b1++) {
      b.b b2 = paramArrayOfb[b1];
      ByteBuffer byteBuffer = (ByteBuffer)map.get(b2.a());
      if (byteBuffer != null) {
        if (!a(object, byteBuffer, b2.b(), b2.c(), b2.d())) {
          c(object);
          return null;
        } 
        bool = true;
      } 
    } 
    if (!bool) {
      c(object);
      return null;
    } 
    return !b(object) ? null : Typeface.create(a(object), paramInt);
  }
  
  public Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt) {
    if (!b())
      return super.a(paramContext, paramb, paramResources, paramInt); 
    Object object = c();
    for (c.c c1 : paramb.a()) {
      if (!a(paramContext, object, c1.a(), c1.e(), c1.b(), c1.c(), FontVariationAxis.fromFontVariationSettings(c1.d()))) {
        c(object);
        return null;
      } 
    } 
    return !b(object) ? null : a(object);
  }
  
  protected Typeface a(Object paramObject) {
    try {
      Object object = Array.newInstance(this.a, 1);
      Array.set(object, 0, paramObject);
      Method method = this.g;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = object;
      arrayOfObject[1] = Integer.valueOf(-1);
      arrayOfObject[2] = Integer.valueOf(-1);
      return (Typeface)method.invoke(null, arrayOfObject);
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  protected Class a() { return Class.forName("android.graphics.FontFamily"); }
  
  protected Constructor a(Class paramClass) { return paramClass.getConstructor(new Class[0]); }
  
  protected Method b(Class paramClass) {
    Class[] arrayOfClass = new Class[8];
    arrayOfClass[0] = android.content.res.AssetManager.class;
    arrayOfClass[1] = String.class;
    arrayOfClass[2] = int.class;
    arrayOfClass[3] = boolean.class;
    arrayOfClass[4] = int.class;
    arrayOfClass[5] = int.class;
    arrayOfClass[6] = int.class;
    arrayOfClass[7] = FontVariationAxis[].class;
    return paramClass.getMethod("addFontFromAssetManager", arrayOfClass);
  }
  
  protected Method c(Class paramClass) {
    Class[] arrayOfClass = new Class[5];
    arrayOfClass[0] = ByteBuffer.class;
    arrayOfClass[1] = int.class;
    arrayOfClass[2] = FontVariationAxis[].class;
    arrayOfClass[3] = int.class;
    arrayOfClass[4] = int.class;
    return paramClass.getMethod("addFontFromBuffer", arrayOfClass);
  }
  
  protected Method d(Class paramClass) { return paramClass.getMethod("freeze", new Class[0]); }
  
  protected Method e(Class paramClass) { return paramClass.getMethod("abortCreation", new Class[0]); }
  
  protected Method f(Class paramClass) {
    Object object = Array.newInstance(paramClass, 1);
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = object.getClass();
    arrayOfClass[1] = int.class;
    arrayOfClass[2] = int.class;
    Method method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arrayOfClass);
    method.setAccessible(true);
    return method;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */