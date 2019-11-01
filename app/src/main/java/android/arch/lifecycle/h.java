package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h {
  private static Map<Class, Integer> a = new HashMap();
  
  private static Map<Class, List<Constructor<? extends b>>> b = new HashMap();
  
  static GenericLifecycleObserver a(Object paramObject) {
    if (paramObject instanceof FullLifecycleObserver)
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject); 
    if (paramObject instanceof GenericLifecycleObserver)
      return (GenericLifecycleObserver)paramObject; 
    Class clazz = paramObject.getClass();
    if (b(clazz) == 2) {
      List list = (List)b.get(clazz);
      int i = list.size();
      byte b1 = 0;
      if (i == 1)
        return new SingleGeneratedAdapterObserver(a((Constructor)list.get(0), paramObject)); 
      b[] arrayOfb = new b[list.size()];
      while (b1 < list.size()) {
        arrayOfb[b1] = a((Constructor)list.get(b1), paramObject);
        b1++;
      } 
      return new CompositeGeneratedAdaptersObserver(arrayOfb);
    } 
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static b a(Constructor<? extends b> paramConstructor, Object paramObject) {
    try {
      return (b)paramConstructor.newInstance(new Object[] { paramObject });
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InstantiationException instantiationException) {
      throw new RuntimeException(instantiationException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException(invocationTargetException);
    } 
  }
  
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString.replace(".", "_"));
    stringBuilder.append("_LifecycleAdapter");
    return stringBuilder.toString();
  }
  
  private static Constructor<? extends b> a(Class<?> paramClass) {
    try {
      String str2;
      Package package = paramClass.getPackage();
      String str1 = paramClass.getCanonicalName();
      if (package != null) {
        str2 = package.getName();
      } else {
        str2 = "";
      } 
      if (!str2.isEmpty())
        str1 = str1.substring(1 + str2.length()); 
      String str3 = a(str1);
      if (!str2.isEmpty()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".");
        stringBuilder.append(str3);
        str3 = stringBuilder.toString();
      } 
      Constructor constructor = Class.forName(str3).getDeclaredConstructor(new Class[] { paramClass });
      if (!constructor.isAccessible())
        constructor.setAccessible(true); 
      return constructor;
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException(noSuchMethodException);
    } 
  }
  
  private static int b(Class<?> paramClass) {
    if (a.containsKey(paramClass))
      return ((Integer)a.get(paramClass)).intValue(); 
    int i = c(paramClass);
    a.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static int c(Class<?> paramClass) {
    if (paramClass.getCanonicalName() == null)
      return 1; 
    Constructor constructor = a(paramClass);
    if (constructor != null) {
      b.put(paramClass, Collections.singletonList(constructor));
      return 2;
    } 
    if (a.a.a(paramClass))
      return 1; 
    Class clazz = paramClass.getSuperclass();
    boolean bool = d(clazz);
    ArrayList arrayList = null;
    if (bool) {
      if (b(clazz) == 1)
        return 1; 
      arrayList = new ArrayList((Collection)b.get(clazz));
    } 
    for (Class clazz1 : paramClass.getInterfaces()) {
      if (d(clazz1)) {
        if (b(clazz1) == 1)
          return 1; 
        if (arrayList == null)
          arrayList = new ArrayList(); 
        arrayList.addAll((Collection)b.get(clazz1));
      } 
    } 
    if (arrayList != null) {
      b.put(paramClass, arrayList);
      return 2;
    } 
    return 1;
  }
  
  private static boolean d(Class<?> paramClass) { return (paramClass != null && d.class.isAssignableFrom(paramClass)); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */