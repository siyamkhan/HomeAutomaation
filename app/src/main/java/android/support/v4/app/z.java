package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class z {
  private static final Object a = new Object();
  
  private static Field b;
  
  private static boolean c;
  
  private static final Object d = new Object();
  
  public static Bundle a(Notification.Builder paramBuilder, x.a parama) {
    paramBuilder.addAction(parama.a(), parama.b(), parama.c());
    Bundle bundle = new Bundle(parama.d());
    if (parama.f() != null)
      bundle.putParcelableArray("android.support.remoteInputs", a(parama.f())); 
    if (parama.h() != null)
      bundle.putParcelableArray("android.support.dataRemoteInputs", a(parama.h())); 
    bundle.putBoolean("android.support.allowGeneratedReplies", parama.e());
    return bundle;
  }
  
  public static Bundle a(Notification paramNotification) {
    synchronized (a) {
      String str2;
      String str1;
      if (c)
        return null; 
      try {
        if (b == null) {
          Field field = Notification.class.getDeclaredField("extras");
          if (!Bundle.class.isAssignableFrom(field.getType())) {
            Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
            c = true;
            return null;
          } 
          field.setAccessible(true);
          b = field;
        } 
        Bundle bundle = (Bundle)b.get(paramNotification);
        if (bundle == null) {
          bundle = new Bundle();
          b.set(paramNotification, bundle);
        } 
        return bundle;
      } catch (IllegalAccessException null) {
        str1 = "NotificationCompat";
        str2 = "Unable to access notification extras";
      } catch (NoSuchFieldException noSuchFieldException) {
        str1 = "NotificationCompat";
        str2 = "Unable to access notification extras";
      } 
      Log.e(str1, str2, noSuchFieldException);
      c = true;
      return null;
    } 
  }
  
  private static Bundle a(ab paramab) {
    Bundle bundle = new Bundle();
    bundle.putString("resultKey", paramab.a());
    bundle.putCharSequence("label", paramab.b());
    bundle.putCharSequenceArray("choices", paramab.c());
    bundle.putBoolean("allowFreeFormInput", paramab.e());
    bundle.putBundle("extras", paramab.f());
    Set set = paramab.d();
    if (set != null && !set.isEmpty()) {
      ArrayList arrayList = new ArrayList(set.size());
      Iterator iterator = set.iterator();
      while (iterator.hasNext())
        arrayList.add((String)iterator.next()); 
      bundle.putStringArrayList("allowedDataTypes", arrayList);
    } 
    return bundle;
  }
  
  static Bundle a(x.a parama) {
    Bundle bundle2;
    Bundle bundle1 = new Bundle();
    bundle1.putInt("icon", parama.a());
    bundle1.putCharSequence("title", parama.b());
    bundle1.putParcelable("actionIntent", parama.c());
    if (parama.d() != null) {
      bundle2 = new Bundle(parama.d());
    } else {
      bundle2 = new Bundle();
    } 
    bundle2.putBoolean("android.support.allowGeneratedReplies", parama.e());
    bundle1.putBundle("extras", bundle2);
    bundle1.putParcelableArray("remoteInputs", a(parama.f()));
    bundle1.putBoolean("showsUserInterface", parama.i());
    bundle1.putInt("semanticAction", parama.g());
    return bundle1;
  }
  
  public static SparseArray<Bundle> a(List<Bundle> paramList) {
    int i = paramList.size();
    SparseArray sparseArray = null;
    for (byte b1 = 0; b1 < i; b1++) {
      Bundle bundle = (Bundle)paramList.get(b1);
      if (bundle != null) {
        if (sparseArray == null)
          sparseArray = new SparseArray(); 
        sparseArray.put(b1, bundle);
      } 
    } 
    return sparseArray;
  }
  
  private static Bundle[] a(ab[] paramArrayOfab) {
    if (paramArrayOfab == null)
      return null; 
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfab.length];
    for (byte b1 = 0; b1 < paramArrayOfab.length; b1++)
      arrayOfBundle[b1] = a(paramArrayOfab[b1]); 
    return arrayOfBundle;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */