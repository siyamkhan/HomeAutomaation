package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.a.a.c;
import android.support.v4.e.b;
import android.support.v4.g.l;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

class e extends h {
  private static final Class a;
  
  private static final Constructor b;
  
  private static final Method c;
  
  private static final Method d;
  
  static  {
    Object object3;
    Object object2;
    Object object1;
    Constructor constructor = null;
    try {
      object1 = Class.forName("android.graphics.FontFamily");
      Constructor constructor1 = object1.getConstructor(new Class[0]);
      Class[] arrayOfClass1 = new Class[5];
      arrayOfClass1[0] = ByteBuffer.class;
      arrayOfClass1[1] = int.class;
      arrayOfClass1[2] = java.util.List.class;
      arrayOfClass1[3] = int.class;
      arrayOfClass1[4] = boolean.class;
      object3 = object1.getMethod("addFontWeightStyle", arrayOfClass1);
      Object object = Array.newInstance(object1, 1);
      Class[] arrayOfClass2 = new Class[1];
      arrayOfClass2[0] = object.getClass();
      Method method = Typeface.class.getMethod("createFromFamiliesWithDefault", arrayOfClass2);
      object2 = method;
      constructor = constructor1;
    } catch (ClassNotFoundException classNotFoundException) {
      Log.e("TypefaceCompatApi24Impl", classNotFoundException.getClass().getName(), classNotFoundException);
      object1 = null;
      object2 = null;
      object3 = null;
    } catch (NoSuchMethodException noSuchMethodException) {}
    b = constructor;
    a = object1;
    c = object3;
    d = object2;
  }
  
  private static Typeface a(Object paramObject) {
    try {
      Object object = Array.newInstance(a, 1);
      Array.set(object, 0, paramObject);
      return (Typeface)d.invoke(null, new Object[] { object });
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  public static boolean a() {
    if (c == null)
      Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation."); 
    return (c != null);
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean) {
    try {
      Method method = c;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramByteBuffer;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = null;
      arrayOfObject[3] = Integer.valueOf(paramInt2);
      arrayOfObject[4] = Boolean.valueOf(paramBoolean);
      return ((Boolean)method.invoke(paramObject, arrayOfObject)).booleanValue();
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  private static Object b() {
    try {
      return b.newInstance(new Object[0]);
    } catch (IllegalAccessException null) {
    
    } catch (InstantiationException null) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new RuntimeException(invocationTargetException);
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.b[] paramArrayOfb, int paramInt) {
    Object object = b();
    l l = new l();
    int i = paramArrayOfb.length;
    for (byte b1 = 0; b1 < i; b1++) {
      b.b b2 = paramArrayOfb[b1];
      Uri uri = b2.a();
      ByteBuffer byteBuffer = (ByteBuffer)l.get(uri);
      if (byteBuffer == null) {
        byteBuffer = i.a(paramContext, paramCancellationSignal, uri);
        l.put(uri, byteBuffer);
      } 
      if (!a(object, byteBuffer, b2.b(), b2.c(), b2.d()))
        return null; 
    } 
    return Typeface.create(a(object), paramInt);
  }
  
  public Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt) {
    Object object = b();
    for (c.c c1 : paramb.a()) {
      ByteBuffer byteBuffer = i.a(paramContext, paramResources, c1.f());
      if (byteBuffer == null)
        return null; 
      if (!a(object, byteBuffer, c1.e(), c1.b(), c1.c()))
        return null; 
    } 
    return a(object);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */