package a.a.a.a.a.b;

import a.a.a.a.c;
import android.content.Context;
import java.lang.reflect.Method;

class d implements f {
  private final Context a;
  
  public d(Context paramContext) { this.a = paramContext.getApplicationContext(); }
  
  private String b() {
    try {
      return (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(d(), new Object[0]);
    } catch (Exception exception) {
      c.g().d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
      return null;
    } 
  }
  
  private boolean c() {
    try {
      return ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(d(), new Object[0])).booleanValue();
    } catch (Exception exception) {
      c.g().d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
      return false;
    } 
  }
  
  private Object d() {
    try {
      Method method = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.a;
      return method.invoke(null, arrayOfObject);
    } catch (Exception exception) {
      c.g().d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
      return null;
    } 
  }
  
  public b a() { return a(this.a) ? new b(b(), c()) : null; }
  
  boolean a(Context paramContext) { // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 'com.google.android.gms.common.GooglePlayServicesUtil'
    //   4: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   7: ldc 'isGooglePlayServicesAvailable'
    //   9: iconst_1
    //   10: anewarray java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc android/content/Context
    //   17: aastore
    //   18: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: aconst_null
    //   22: iconst_1
    //   23: anewarray java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast java/lang/Integer
    //   36: invokevirtual intValue : ()I
    //   39: istore #4
    //   41: iload #4
    //   43: ifne -> 51
    //   46: iconst_1
    //   47: istore_2
    //   48: goto -> 52
    //   51: pop
    //   52: iload_2
    //   53: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	41	51	java/lang/Exception }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */