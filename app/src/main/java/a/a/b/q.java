package a.a.a.a.a.b;

import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import java.lang.reflect.Method;

final class q implements p {
  private final Method a;
  
  private final Object b;
  
  private q(Class paramClass, Object paramObject) {
    this.b = paramObject;
    this.a = paramClass.getDeclaredMethod("isDataCollectionDefaultEnabled", new Class[0]);
  }
  
  public static p a(Context paramContext) {
    try {
      Class clazz = paramContext.getClassLoader().loadClass("com.google.firebase.FirebaseApp");
      return new q(clazz, clazz.getDeclaredMethod("getInstance", new Class[0]).invoke(clazz, new Object[0]));
    } catch (ClassNotFoundException classNotFoundException) {
      c.g().a("Fabric", "Could not find class: com.google.firebase.FirebaseApp");
    } catch (NoSuchMethodException noSuchMethodException) {
      l l = c.g();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not find method: ");
      stringBuilder.append(noSuchMethodException.getMessage());
      l.a("Fabric", stringBuilder.toString());
    } catch (Exception exception) {
      c.g().a("Fabric", "Unexpected error loading FirebaseApp instance.", exception);
    } 
    return null;
  }
  
  public boolean a() {
    try {
      return ((Boolean)this.a.invoke(this.b, new Object[0])).booleanValue();
    } catch (Exception exception) {
      c.g().a("Fabric", "Cannot check isDataCollectionDefaultEnabled on FirebaseApp.", exception);
      return false;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */